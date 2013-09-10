package org.emftext.language.BON.codegenerator;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.FacadeHelper;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Cluster;
import org.emftext.language.BON.Cluster_chart;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Informal_charts;
import org.emftext.language.BON.System_chart;

public class GenerateJavaCode
{

	private Informal_charts informalCharts;
	private static GenerateJavaCode generateJavaCode;
	private IFile file;
	private JETEmitter emitter;
	private Class_chart helperClassChart;
	private String projectname;
	private IProject project;
	private Cluster_chart argumentClusterChart;
	private String systemName;
	private final String javaJetClassUri = "templates/informalBON.javajet";
	private final String javaJetClusterUri = "templates/clusterBON.javajet";
	private final String javaJetSystemUri = "templates/systemBON.htmljet";
	private final String mergerUri = "templates/merge.xml";
	private final String clusterInfoFilename = "package-info.java";
	private final String systemInfoFilename = "overview.html";
	private final String documentFolder="doc";
	private boolean generatingJava2Bon;

	public void generateCode() throws CoreException {		
		Job job = new Job("Creating Java project and packages for the informal BON model: ") {						

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {	
					project=null;
					IJavaProject javaProject=null;
					IPackageFragmentRoot rootsrc=null;
					IFolder src=null;
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IProject[] projects = root.getProjects();					
					boolean projectFound=findProject(projects);					
					//Create project using system chart name if not found															
					project = root.getProject(projectname);			
					if(!projectFound) {
						project.create(monitor);
					}
					project.open(monitor);
					IProjectDescription description = project.getDescription();
					String[] natures = description.getNatureIds();
					String[] newNatures = new String[natures.length + 1];
					System.arraycopy(natures, 0, newNatures, 0, natures.length);
					newNatures[natures.length] = JavaCore.NATURE_ID;
					description.setNatureIds(newNatures);
					project.setDescription(description, monitor);
					if (project.isNatureEnabled(JavaCore.NATURE_ID)) {
						javaProject = JavaCore.create(project);
					}
					//Create bin folder
					IFolder binFolder = project.getFolder("bin");
					if (!binFolder.exists()) {
						binFolder.create(false, true, null);
						javaProject.setOutputLocation(binFolder.getFullPath(), null);
					}										
					// Get default JRE container, create src folder and add to classpath						
					src = project.getFolder("src");
					if (!src.exists()) {
						rootsrc = javaProject.getPackageFragmentRoot(src);					
						src.create(false, true, monitor);
						IClasspathEntry[] defaults = new IClasspathEntry[] { JavaRuntime.getDefaultJREContainerEntry(),
								JavaCore.newSourceEntry(rootsrc.getPath()) };
						javaProject.setRawClasspath(defaults, null);	
					}
					setParents();							
					createPackages(javaProject, monitor, informalCharts.getSystem_chart().getCluster_entries(), src);
					createClusterInfo(src, informalCharts.getCluster_charts());
					createClasses(src, informalCharts.getClass_charts());
					createOverview(informalCharts.getSystem_chart());
				} catch (CoreException e) {
					e.printStackTrace();
				}
				monitor.worked(1);
				return new Status(Status.OK,Activator.PLUGIN_ID ,"Code successfully generated");
			}			
		};
		job.setUser(true);
		job.schedule();

	}
	private void createOverview(System_chart systemChart) {
		IFolder docFolder = project.getFolder(documentFolder);
		try {
			if(!docFolder.exists()) {
				docFolder.create(false, true, null);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (systemChart.getExplanation()!=null) {
			systemName=systemChart.getExplanation().getName();
		}
		else {
			systemName="";
		}
		String base = Activator.getDefault().getBundle().getEntry("/").toString();				
		emitter = new JETEmitter(base + javaJetSystemUri, getClass().getClassLoader());						
		String fileName = systemInfoFilename ;
		file = docFolder.getFile(new Path(fileName));
		Job generateclassjob = new Job("Generating system information for the informal BON model: ") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					emitter.addVariable("INFORMALBONMODEL", Activator.PLUGIN_ID);
					emitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
					emitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");							
					String result = emitter.generate(monitor, new Object[] { systemName });		

					InputStream newContents = new ByteArrayInputStream(result.getBytes());
					if (!file.exists()) {
						file.create(newContents, true, new SubProgressMonitor(monitor, 1));
					}
					else {
						file.setContents(newContents, true, false, monitor);
					}
					try {
						newContents.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (JETException e) {
					e.printStackTrace();						
				} catch (CoreException e) {
					e.printStackTrace();
				}
				monitor.worked(1);
				return new Status(Status.OK, Activator.PLUGIN_ID, "Code successfully generated");
			}								
		};
		generateclassjob.setUser(true);
		generateclassjob.schedule();
		try {
			generateclassjob.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private boolean findProject(IProject[] projects) {
		projectname = informalCharts.getSystem_chart().getName().substring(0,1).toUpperCase()+
				informalCharts.getSystem_chart().getName().substring(1,informalCharts.
						getSystem_chart().getName().length()).toLowerCase();
		for (IProject runtimeproject : projects) {
			if (runtimeproject.getName().equals(projectname)) {
				project=runtimeproject;
				return true;
			}
		}
		return false;
	}
	/**
	 * This method creates the Java packages
	 */
	private void createPackages(IJavaProject javaProject, IProgressMonitor monitor, EList<Cluster> clusters, IFolder src) {
		for (Cluster cluster : clusters) {			
			String name=cluster.getName().toLowerCase();
			try {
				javaProject.getPackageFragmentRoot(src).createPackageFragment(name, false, monitor);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			for (Cluster_chart clusterChart : informalCharts.getCluster_charts()) {
				if (clusterChart.getCluster().equals(cluster)) {
					createPackages(javaProject, monitor, clusterChart.getClusterchart_entries(), src.getFolder(name));
					break;							
				}
			}
		}
	}
	/**
	 * This method creates package-info.java which contains information about the cluster
	 * @param src
	 * @param clusterCharts
	 */
	private void createClusterInfo(IFolder src, EList<Cluster_chart> clusterCharts) {
		for (Cluster_chart clusterChart : clusterCharts) {
			if (clusterChart!=null) {
				argumentClusterChart=clusterChart;				
				String base = Activator.getDefault().getBundle().getEntry("/").toString();				
				emitter = new JETEmitter(base + javaJetClusterUri, getClass().getClassLoader());
				IFolder folder=getFolderForClass(src, new ArrayList<String>(), clusterChart.getCluster());				
				String fileName = clusterInfoFilename ;
				file = folder.getFile(new Path(fileName));
				Job generateclassjob = new Job("Generating package information for the informal BON model: ") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						try {
							emitter.addVariable("INFORMALBONMODEL", Activator.PLUGIN_ID);
							emitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
							emitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");							
							String result = emitter.generate(monitor, new Object[] { argumentClusterChart });		

							InputStream newContents = new ByteArrayInputStream(result.getBytes());
							if (!file.exists()) {
								file.create(newContents, true, new SubProgressMonitor(monitor, 1));
							}
							else {
								file.setContents(newContents, true, false, monitor);
							}
							try {
								newContents.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						} catch (JETException e) {
							e.printStackTrace();						
						} catch (CoreException e) {
							e.printStackTrace();
						}
						monitor.worked(1);
						return new Status(Status.OK, Activator.PLUGIN_ID, "Code successfully generated");
					}								
				};
				generateclassjob.setUser(true);
				generateclassjob.schedule();
				try {
					generateclassjob.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void createClasses(IFolder src, EList<Class_chart> classCharts) {
		for (Class_chart classChart : classCharts) {		
			if (classChart!=null) {
				String base = Activator.getDefault().getBundle().getEntry("/").toString();				
				emitter = new JETEmitter(base + javaJetClassUri, getClass().getClassLoader());

				helperClassChart=classChart;
				IFolder folder=getFolderForClass(src, new ArrayList<String>(), classChart.getClass_().getParent());
				String className = classChart.getClass_().getName().substring(0,1).toUpperCase()+classChart.getClass_().
						getName().substring(1,classChart.getClass_().getName().length()).toLowerCase();
				String fileName = className + ".java";
				file = folder.getFile(new Path(fileName));
				Job generateclassjob = new Job("Generating Java classes for the informal BON model: ") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						try {
							emitter.addVariable("INFORMALBONMODEL", Activator.PLUGIN_ID);
							emitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
							emitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");
							if (helperClassChart!=null)
							{								
								String result = emitter.generate(monitor, new Object[] { setupHelper() });		

								InputStream newContents = new ByteArrayInputStream(result.getBytes());
								if (!file.exists()) {
									file.create(newContents, true, new SubProgressMonitor(monitor, 1));
								}
								//Setup the JMerger
								JMerger merger = getJMerger();
								merger.setSourceCompilationUnit(merger.createCompilationUnitForContents(result));
								try {
									merger.setTargetCompilationUnit(
											merger.createCompilationUnitForInputStream(
													new FileInputStream(file.getLocation().toFile())));
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
								merger.merge();
								InputStream mergedContents = new ByteArrayInputStream(
										merger.getTargetCompilationUnit().getContents().getBytes());
								//Merge content
								file.setContents(mergedContents, true, false, monitor);															
								try {
									newContents.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						} catch (JETException e) {
							e.printStackTrace();						
						} catch (CoreException e) {
							e.printStackTrace();
						}
						monitor.worked(1);
						return new Status(Status.OK, Activator.PLUGIN_ID, "Code successfully generated");
					}								
				};
				generateclassjob.setUser(true);
				generateclassjob.schedule();
				try {
					generateclassjob.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private ArgumentHelper setupHelper() {
		ArgumentHelper helper = new ArgumentHelper();
		helper.setClassBON(helperClassChart.getClass_());
		helper.setClassChart(helperClassChart);
		helper.setClusterChart(getClusterChartFromCluster(helperClassChart.getClass_().getParent()));
		List<Event_chart> eventCharts = new ArrayList<Event_chart>();
		for (Event_chart eventChart : informalCharts.getEvent_charts()) {
			eventCharts.add(eventChart);
		}
		helper.setEventCharts(eventCharts);	
		List<Creation_chart> creationCharts = new ArrayList<Creation_chart>();
		for (Creation_chart creationChart : informalCharts.getCreation_charts()) {
			creationCharts.add(creationChart);
		}
		helper.setCreationCharts(creationCharts);
		helper.setClassCharts(informalCharts.getClass_charts());
		return helper;
	}
	private JMerger getJMerger() {
		String uri = Platform.getBundle(Activator.PLUGIN_ID).getEntry("/").toString();
		uri += mergerUri;

		JControlModel controlModel = new JControlModel();
		FacadeHelper facadeHelper = new ASTFacadeHelper();
		controlModel.initialize(facadeHelper, uri);
		JMerger jmerger = new JMerger(controlModel);
		return jmerger;
	}

	private IFolder getFolderForClass(IFolder src, List<String> packages, Cluster cluster) {
		if (cluster!=null) {
			packages.add(0, cluster.getName().toLowerCase());
			getFolderForClass(src, packages, cluster.getParent());
		}
		for (String string : packages) {
			src=src.getFolder(string);
		}
		return src;
	}

	private void setParents() {
		setParentsOnClusters();
		setParentsOnClasses();
	}

	private void setParentsOnClasses() {
		for (int i = 0; i < informalCharts.getClass_charts().size(); i++) {
			for (int j = 0; j < informalCharts.getCluster_charts().size(); j++) {
				for (int k = 0; k < informalCharts.getCluster_charts().get(j).getClass_entries().size(); k++) {
					if (informalCharts.getCluster_charts().get(j).getClass_entries().get(k).
							equals(informalCharts.getClass_charts().get(i).getClass_())) {
						informalCharts.getClass_charts().get(i).getClass_().
						setParent(informalCharts.getCluster_charts().get(j).getCluster());
					}
				}
			}
		}
	}

	private void setParentsOnClusters() {
		for (int i = 0; i < informalCharts.getCluster_charts().size(); i++) {
			for (int j = 0; j < informalCharts.getCluster_charts().get(i).getClusterchart_entries().size(); j++) {
				informalCharts.getCluster_charts().get(i).getClusterchart_entries().get(j).
				setParent(informalCharts.getCluster_charts().get(i).getCluster());
			}
		} 
	}
	private Cluster_chart getClusterChartFromCluster(Cluster cluster) {
		for (Cluster_chart clusterChart : informalCharts.getCluster_charts()) {
			if (clusterChart.getCluster().equals(cluster)) {
				return clusterChart;
			}
		}
		return null;
	}

	public void setInformalCharts(Informal_charts informalCharts) {
		this.informalCharts = informalCharts;
	}
	public static GenerateJavaCode getGenerateJavaCode() {
		if (generateJavaCode==null) {
			generateJavaCode=new GenerateJavaCode();
		}
		return generateJavaCode;
	}
	public Informal_charts getInformalCharts() {
		return informalCharts;
	}
	public boolean isGeneratingJava2Bon() {
		return generatingJava2Bon;
	}
	public void setGeneratingJava2Bon(boolean generatingJava2Bon) {
		this.generatingJava2Bon = generatingJava2Bon;
	}
}
