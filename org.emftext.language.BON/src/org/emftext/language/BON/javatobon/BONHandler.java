package org.emftext.language.BON.javatobon;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.emftext.language.BON.BONFactory;
import org.emftext.language.BON.ClassBON;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Cluster;
import org.emftext.language.BON.Cluster_chart;
import org.emftext.language.BON.Command;
import org.emftext.language.BON.Commands;
import org.emftext.language.BON.Constraint;
import org.emftext.language.BON.Constraints;
import org.emftext.language.BON.Creation;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.Event;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Event_type;
import org.emftext.language.BON.Explanation;
import org.emftext.language.BON.Index_Identifier;
import org.emftext.language.BON.Indexing;
import org.emftext.language.BON.Informal_charts;
import org.emftext.language.BON.Queries;
import org.emftext.language.BON.Query;
import org.emftext.language.BON.codegenerator.Activator;
import org.emftext.language.BON.codegenerator.GenerateJavaCode;

public class BONHandler extends AbstractHandler{
	private final String javaJetSystemUri = "templates/Java2BON.bonjet";
	private JETEmitter emitter;
	private Informal_charts informalCharts;
	private IProject selectedProject;
	private IFile file;
	private List<Event> incomingEvents;
	private List<Event> outgoingEvents;
	private List<Creation> creations;
	private List<String> creates;
	private final String overview="overview.html";
	private final String documentFolder="doc";


	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage activePage = window.getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof IJavaProject) {
					IJavaProject project = ((IJavaProject)structuredSelection.getFirstElement());
					GenerateJavaCode.getGenerateJavaCode().setGeneratingJava2Bon(true);		
					informalCharts=BONFactory.eINSTANCE.createInformal_charts();
					informalCharts.setSystem_chart(BONFactory.eINSTANCE.createSystem_chart());
					incomingEvents = new ArrayList<Event>();
					outgoingEvents = new ArrayList<Event>();
					creations = new ArrayList<Creation>();
					creates = new ArrayList<String>();					
					if (project.isOpen()) {								
						selectedProject=project.getProject();
						String systemName = selectedProject.getName();
						informalCharts.getSystem_chart().setName(systemName);
						try {
							analysePackages(selectedProject);
						} catch (JavaModelException e) {
							e.printStackTrace();
						}
						createEventCharts();
						createCreationChart();
						setSystemExplanation();
						
						String fileName = systemName+".bon";
						//Create bon folder
						IFolder bonFolder = selectedProject.getFolder("bon");
						if (!bonFolder.exists()) {
							try {
								bonFolder.create(false, true, null);
							} catch (CoreException e) {
								e.printStackTrace();
							}
						}
						file = bonFolder.getFile(new Path(fileName));
						String base = Activator.getDefault().getBundle().getEntry("/").toString();				
						emitter = new JETEmitter(base + javaJetSystemUri, getClass().getClassLoader());		
						Job generatebonjob = new Job("Generating the informal BON model from Java: ") {
							@Override
							protected IStatus run(IProgressMonitor monitor) {
								try {
									emitter.addVariable("JAVA2BONMODEL", Activator.PLUGIN_ID);
									emitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
									emitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");							
									String result = emitter.generate(monitor, new Object[] { informalCharts });		

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
						generatebonjob.setUser(true);
						generatebonjob.schedule();
						try {
							generatebonjob.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else {
						errorOpenProjectMessage();
					}
					GenerateJavaCode.getGenerateJavaCode().setGeneratingJava2Bon(false);
				} else {
					errorMessage();
				}
			} else {
				errorMessage();
			}
		} else {
			errorMessage();
		}
		return null;
	}

	private void errorOpenProjectMessage() {
		System.err.println("Please open the Java project and try again");
	}

	private void errorMessage() {
		System.err.println("Please select a Java project and try again");
	}

	private void setSystemExplanation() {
		IFolder bonFolder = selectedProject.getFolder(documentFolder);		
		file = bonFolder.getFile(new Path(overview));	
		if (file.exists()) {
			InputStreamReader is = null;
			try {
				is = new InputStreamReader(file.getContents());
			} catch (CoreException e) {
				e.printStackTrace();
			}
			BufferedReader reader = new BufferedReader(is);
			String line="";
			String html="";
			try {
				while ((line = reader.readLine()) != null) {
					html+=line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			html=html.replace("<HTML>", "");
			html=html.replace("</HTML>", "");
			html=html.replace("<BODY>", "");
			html=html.replace("</BODY>", "");
			if (!html.equals("")) {
				Explanation explanation = BONFactory.eINSTANCE.createExplanation();
				explanation.setName(html);
				informalCharts.getSystem_chart().setExplanation(explanation);
			}
		}
	}

	private void analysePackages(IProject project) throws JavaModelException {
		IPackageFragment[] packages = JavaCore.create(project)
				.getPackageFragments();
		for (IPackageFragment javapackage : packages) {
			if (javapackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
				createAST(javapackage);
			}

		}		
	}

	private void createCreationChart() {	
		if (creations.size()>0) {
			Creation_chart creationChart = BONFactory.eINSTANCE.createCreation_chart();
			creationChart.setSystem_name(informalCharts.getSystem_chart());
			for (int i = 0; i < creates.size(); i++) {
				creations.get(i).getCreates().add(getClassFromString(creates.get(i)));
			}
			for (Creation creation : creations) {
				creationChart.getCreation_entries().add(creation);	
			}
			informalCharts.getCreation_charts().add(creationChart);
		}
	}

	private void createEventCharts() {
		//Create Event charts
		if (incomingEvents.size()>0) {
			Event_chart incomingEventchart = BONFactory.eINSTANCE.createEvent_chart();
			incomingEventchart.setEvent_type(Event_type.INCOMING);
			incomingEventchart.setSystem_name(informalCharts.getSystem_chart());
			for (Event event : incomingEvents) {
				incomingEventchart.getEvent_entries().add(event);
			}
			informalCharts.getEvent_charts().add(incomingEventchart);
		}
		if (outgoingEvents.size()>0) {
			Event_chart outgoingEventchart = BONFactory.eINSTANCE.createEvent_chart();
			outgoingEventchart.setEvent_type(Event_type.OUTGOING);
			outgoingEventchart.setSystem_name(informalCharts.getSystem_chart());
			for (Event event : outgoingEvents) {
				outgoingEventchart.getEvent_entries().add(event);
			}
			informalCharts.getEvent_charts().add(outgoingEventchart);
		}
	}

	//TODO Split conditions up in methods
	@SuppressWarnings("unchecked")
	private void createAST(IPackageFragment mypackage)
			throws JavaModelException {
		for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
			//Create the AST for the ICompilationUnits
			CompilationUnit parse = parse(unit);	
			ExtendVisitor visitor = new ExtendVisitor();			
			boolean systemCluster=false;
			String explanationName="";
			String descriptionName="";
			String indexingName="";
			String queryName="";
			String commandName="";
			String constraintName="";
			String eventtypeName="";
			String creatorName="";
			Cluster_chart clusterChart = BONFactory.eINSTANCE.createCluster_chart();
			Cluster cluster = BONFactory.eINSTANCE.createCluster();
			clusterChart.setCluster(cluster);
			Class_chart classChart = BONFactory.eINSTANCE.createClass_chart();
			ClassBON classBon = BONFactory.eINSTANCE.createClassBON();
			classChart.setClass(classBon);
			Indexing indexing = BONFactory.eINSTANCE.createIndexing();
			Queries queries = BONFactory.eINSTANCE.createQueries();
			Query query;
			Commands commands = BONFactory.eINSTANCE.createCommands();
			Command command;
			Constraints constraints = BONFactory.eINSTANCE.createConstraints();
			Constraint constraint;	
			//Look at clusters
			if (unit.getElementName().equals("package-info.java")) {							
				if (!mypackage.getElementName().contains(".")) {
					systemCluster=true;
					clusterChart.getCluster().setName(mypackage.getElementName());
				}	
				boolean hasIndexing=false;
				for (Javadoc javadoc : (List<Javadoc>)parse.getCommentList()) {										
					for (Object object : javadoc.tags()) {
						if (javadoc.tags().indexOf(object)==0) {
							descriptionName=object.toString().replace("*", "");
							descriptionName=descriptionName.replace("/", "");
							descriptionName=descriptionName.replace("\n", "");
							descriptionName=descriptionName.replace("\t", "");
							descriptionName=descriptionName.replace("\r", "");					
							clusterChart.getCluster().setDescription(descriptionName);
						}
						if (object.toString().contains("bon.explanation")) {
							Explanation explanation = BONFactory.eINSTANCE.createExplanation();
							explanationName=object.toString().replace("*", "");
							explanationName=explanationName.replace("@bon.explanation", "");
							explanationName=explanationName.replace("/", "");
							explanationName=explanationName.replace("\n", "");
							explanationName=explanationName.replace("\t", "");
							explanationName=explanationName.replace("\r", "");
							explanation.setName(explanationName);
							clusterChart.setExplanation(explanation);
						}
						if (object.toString().contains("bon.indexing") ) {													
							indexingName=object.toString().replace("*", "");
							indexingName=indexingName.replace("@bon.indexing", "");
							indexingName=indexingName.replace("<li>", "");
							indexingName=indexingName.replace("</li>", "");
							indexingName=indexingName.replace("/", "");							
							indexingName=indexingName.replace("\t", "");
							indexingName=indexingName.replace("\r", "");	
							String[] splitNewline = indexingName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {	
								if (splitNewline[i].contains(":")) {
									Index_Identifier indexIdent = BONFactory.eINSTANCE.createIndex_Identifier();
									indexIdent.setName(splitNewline[i].substring(0, splitNewline[i].indexOf(":")));
									String[] indexString = splitNewline[i].substring(splitNewline[i].indexOf(":")+2,splitNewline[i].length()).split(",");
									for (String string : indexString) {
										indexIdent.getIndex_string().add(string);
									}
									indexing.getIndex_term_list().add(indexIdent);
								}
							}						
							hasIndexing=true;
						}
						if (object.toString().contains("@author") ) {							
							indexingName=object.toString().replace("*", "");
							indexingName=indexingName.replace("@author", "author:");
							indexingName=indexingName.replace("/", "");							
							indexingName=indexingName.replace("\t", "");
							indexingName=indexingName.replace("\r", "");	
							indexingName=indexingName.replace("\n", "");	
							if (indexingName.contains(":")) {
								Index_Identifier indexIdent = BONFactory.eINSTANCE.createIndex_Identifier();
								indexIdent.setName(indexingName.substring(0, indexingName.indexOf(":")));
								String[] indexString = indexingName.substring(indexingName.indexOf(":")+2,indexingName.length()).split(",");
								for (String string : indexString) {
									indexIdent.getIndex_string().add(string);
								}
								indexing.getIndex_term_list().add(indexIdent);
							}						
							hasIndexing=true;
						}
					}					
				}
				if (systemCluster) {					
					informalCharts.getSystem_chart().getCluster_entries().add(clusterChart.getCluster());
				}
				else {
					String[] name=mypackage.getElementName().split("\\.");
					clusterChart.getCluster().setName(name[name.length-1]);
					for (int i = 0; i < informalCharts.getCluster_charts().size(); i++) {						
						if (informalCharts.getCluster_charts().get(i).getCluster().getName().equals(name[name.length-2])) {
							informalCharts.getCluster_charts().get(i).getClusterchart_entries().add(clusterChart.getCluster());
							break;
						}
					}					
				}
				if(hasIndexing) {
					clusterChart.setChart_indexing(indexing);	
				}
				informalCharts.getCluster_charts().add(clusterChart);
			}
			//Look at classes
			else {								
				classChart.getClass_().setName(unit.getElementName().substring(0, unit.getElementName().indexOf(".")));
				boolean hasIndexing=false;
				boolean hasQuery=false;
				boolean hasCommand=false;
				boolean hasConstraint=false;
				for (Javadoc javadoc : (List<Javadoc>)parse.getCommentList()) {										
					for (Object object : javadoc.tags()) {
						if (javadoc.tags().indexOf(object)==0 && !object.toString().contains("@generated")) {
							descriptionName=object.toString().replace("*", "");
							descriptionName=descriptionName.replace("/", "");
							descriptionName=descriptionName.replace("\n", "");
							descriptionName=descriptionName.replace("\t", "");
							descriptionName=descriptionName.replace("\r", "");					
							classChart.getClass_().setDescription(descriptionName);
						}
						if (object.toString().contains("bon.explanation")) {
							Explanation explanation = BONFactory.eINSTANCE.createExplanation();
							explanationName=object.toString().replace("*", "");
							explanationName=explanationName.replace("@bon.explanation", "");
							explanationName=explanationName.replace("/", "");
							explanationName=explanationName.replace("\n", "");
							explanationName=explanationName.replace("\t", "");
							explanationName=explanationName.replace("\r", "");
							explanation.setName(explanationName);
							classChart.setExplanation(explanation);
						}
						if (object.toString().contains("bon.indexing") ) {													
							indexingName=object.toString().replace("*", "");
							indexingName=indexingName.replace("@bon.indexing", "");
							indexingName=indexingName.replace("<li>", "");
							indexingName=indexingName.replace("</li>", "");
							indexingName=indexingName.replace("/", "");							
							indexingName=indexingName.replace("\t", "");
							indexingName=indexingName.replace("\r", "");	
							String[] splitNewline = indexingName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {	
								if (splitNewline[i].contains(":")) {
									Index_Identifier indexIdent = BONFactory.eINSTANCE.createIndex_Identifier();
									indexIdent.setName(splitNewline[i].substring(0, splitNewline[i].indexOf(":")));
									String[] indexString = splitNewline[i].substring(splitNewline[i].indexOf(":")+2,splitNewline[i].length()).split(",");
									for (String string : indexString) {
										indexIdent.getIndex_string().add(string);
									}
									indexing.getIndex_term_list().add(indexIdent);
								}
							}						
							hasIndexing=true;
						}
						if (object.toString().contains("@author") ) {							
							indexingName=object.toString().replace("*", "");
							indexingName=indexingName.replace("@author", "author:");
							indexingName=indexingName.replace("/", "");							
							indexingName=indexingName.replace("\t", "");
							indexingName=indexingName.replace("\r", "");	
							indexingName=indexingName.replace("\n", "");	
							if (indexingName.contains(":")) {
								Index_Identifier indexIdent = BONFactory.eINSTANCE.createIndex_Identifier();
								indexIdent.setName(indexingName.substring(0, indexingName.indexOf(":")));
								String[] indexString = indexingName.substring(indexingName.indexOf(":")+2,indexingName.length()).split(",");
								for (String string : indexString) {
									indexIdent.getIndex_string().add(string);
								}
								indexing.getIndex_term_list().add(indexIdent);
							}						
							hasIndexing=true;
						}	
						if (object.toString().contains("bon.query") ) {	
							hasQuery=true;							
							queryName=object.toString().replace("*", "");
							queryName=queryName.replace("@bon.query", "");
							queryName=queryName.replace("<li>", "");
							queryName=queryName.replace("</li>", "");
							queryName=queryName.replace("/", "");							
							queryName=queryName.replace("\t", "");
							queryName=queryName.replace("\r", "");
							String[] splitNewline = queryName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {
								if (i!=0 && i!=1) {
									query=BONFactory.eINSTANCE.createQuery();
									query.setName(splitNewline[i]);
									queries.getQuery().add(query);
								}
							}						
						}
						if (object.toString().contains("bon.command") ) {	
							hasCommand=true;							
							commandName=object.toString().replace("*", "");
							commandName=commandName.replace("@bon.command", "");
							commandName=commandName.replace("<li>", "");
							commandName=commandName.replace("</li>", "");
							commandName=commandName.replace("/", "");							
							commandName=commandName.replace("\t", "");
							commandName=commandName.replace("\r", "");
							String[] splitNewline = commandName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {
								if (i!=0 && i!=1) {
									command=BONFactory.eINSTANCE.createCommand();
									command.setName(splitNewline[i]);
									commands.getCommand().add(command);
								}
							}								
						}
						if (object.toString().contains("bon.constraint") ) {	
							hasConstraint=true;							
							constraintName=object.toString().replace("*", "");
							constraintName=constraintName.replace("@bon.constraint", "");
							constraintName=constraintName.replace("<li>", "");
							constraintName=constraintName.replace("</li>", "");
							constraintName=constraintName.replace("/", "");							
							constraintName=constraintName.replace("\t", "");
							constraintName=constraintName.replace("\r", "");
							String[] splitNewline = constraintName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {
								if (i!=0 && i!=1) {
									constraint=BONFactory.eINSTANCE.createConstraint();
									constraint.setName(splitNewline[i]);
									constraints.getConstraint().add(constraint);
								}
							}						
						}
						//Create event charts
						if (object.toString().contains("bon.event") ) {					
							eventtypeName=object.toString().replace("*", "");
							eventtypeName=eventtypeName.replace("@bon.event", "");
							eventtypeName=eventtypeName.replace("<li>", "");
							eventtypeName=eventtypeName.replace("</li>", "");							
							eventtypeName=eventtypeName.replace("\t", "");
							String[] splitNewline = eventtypeName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {	
								if (splitNewline[i].contains(":")) {
									if (splitNewline[i].substring(0, splitNewline[i].indexOf(":")).contains("incoming")) {
										Event event = BONFactory.eINSTANCE.createEvent();
										event.setName(splitNewline[i].substring(splitNewline[i].indexOf(":")+2,splitNewline[i].length()));
										event.getInvolves().add(classChart.getClass_());
										incomingEvents.add(event);
									}
									else if (splitNewline[i].substring(0, splitNewline[i].indexOf(":")).contains("outgoing")) {
										Event event = BONFactory.eINSTANCE.createEvent();
										event.setName(splitNewline[i].substring(splitNewline[i].indexOf(":")+2,splitNewline[i].length()));
										event.getInvolves().add(classChart.getClass_());
										outgoingEvents.add(event);
									}
								}
							}						
						}
						//Creation charts
						if (object.toString().contains("bon.creator") ) {							
							creatorName=object.toString().replace("*", "");
							creatorName=creatorName.replace("@bon.creator", "");
							creatorName=creatorName.replace("<li>", "");
							creatorName=creatorName.replace("</li>", "");
							creatorName=creatorName.replace("/", "");							
							creatorName=creatorName.replace("\t", "");
							creatorName=creatorName.replace("\r", "");
							creatorName=creatorName.replace(classChart.getClass_().getName()+" creates ", "");
							creatorName=creatorName.replace(" ", "");
							String[] splitNewline = creatorName.split("\n");
							for (int i = 0; i < splitNewline.length; i++) {
								if (i!=0 && i!=1) {
									Creation creation=BONFactory.eINSTANCE.createCreation();
									creation.setCreator(classChart.getClass_());
									creates.add(splitNewline[i]);	
									creations.add(creation);
								}
							}						
						}
					}
				}
				//Add inheritance to class chart
				parse.accept(visitor);
				if (visitor.getType()!=null) {
					classChart.getInherit().add(getClassFromString(visitor.getType().toString()));
				}
				//Add class to cluster chart
				String[] name=mypackage.getElementName().split("\\.");				
				for (int i = 0; i < informalCharts.getCluster_charts().size(); i++) {					
					int size = name.length>1 ? name.length-2 : 0;
					if (informalCharts.getCluster_charts().get(i).getCluster().getName().equals(name[size])) {
						informalCharts.getCluster_charts().get(i).getClass_entries().add(classChart.getClass_());
						break;
					}
				}
				if(hasIndexing) {
					classChart.setChart_indexing(indexing);	
				}
				if (hasQuery) {
					classChart.setQueries(queries);
				}
				if (hasCommand) {
					classChart.setCommands(commands);
				}
				if (hasConstraint) {
					classChart.setConstraints(constraints);
				}				
				informalCharts.getClass_charts().add(classChart);
			}
		}		
	}


	private ClassBON getClassFromString(String string) {
		for (Class_chart classChart : informalCharts.getClass_charts()) {
			if (classChart.getClass_().getName().equals(string)) {
				return classChart.getClass_();
			}
		}
		return null;
	}

	//Reads an ICompilationUnit and creates the AST for manipulating the Java source file
	private CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null);
	}
}