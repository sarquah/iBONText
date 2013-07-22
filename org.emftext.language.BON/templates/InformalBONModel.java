package templates;

import org.emftext.language.BON.*;
import org.emftext.language.BON.codegenerator.*;
import java.util.List;

public class InformalBONModel
{
  protected static String nl;
  public static synchronized InformalBONModel create(String lineSeparator)
  {
    nl = lineSeparator;
    InformalBONModel result = new InformalBONModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = "import ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = NL + " * @bon.indexing ";
  protected final String TEXT_8 = NL + " *     <li>";
  protected final String TEXT_9 = ": ";
  protected final String TEXT_10 = "</li>";
  protected final String TEXT_11 = " " + NL + " * @bon.explanation ";
  protected final String TEXT_12 = NL + " * @author ";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = NL + " * @bon.query ";
  protected final String TEXT_15 = NL + " *\t   <li>";
  protected final String TEXT_16 = "</li>";
  protected final String TEXT_17 = NL + " * @bon.command ";
  protected final String TEXT_18 = NL + " *\t   <li>";
  protected final String TEXT_19 = "</li>";
  protected final String TEXT_20 = NL + " * @bon.constraint ";
  protected final String TEXT_21 = NL + " *     <li>";
  protected final String TEXT_22 = "</li>";
  protected final String TEXT_23 = NL + " * @bon.event";
  protected final String TEXT_24 = NL + " *     <li>";
  protected final String TEXT_25 = ": ";
  protected final String TEXT_26 = "</li>";
  protected final String TEXT_27 = NL + " * @bon.creator";
  protected final String TEXT_28 = " " + NL + " *     <li>";
  protected final String TEXT_29 = " creates ";
  protected final String TEXT_30 = "</li>";
  protected final String TEXT_31 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = "extends ";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_36 = " () {" + NL + "\t\t";
  protected final String TEXT_37 = "super();";
  protected final String TEXT_38 = NL + "\t}   " + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
	ArgumentHelper helper = (ArgumentHelper) argument;
	ClassBON bonclass = helper.getClassBON();
	Class_chart classChart = helper.getClassChart();
	Cluster_chart clusterChart = helper.getClusterChart();
	List<Event_chart> eventCharts = helper.getEventCharts();
	List<Creation_chart> creationCharts = helper.getCreationCharts();
	List<Class_chart> classCharts = helper.getClassCharts();
	
	boolean isEvent=true;
	boolean isCreator=true;
	boolean inherits=false;
	boolean inheritFromOtherClass=false;
	String description=bonclass.getDescription();
	String[] copyArray=description.split("\\\\");
	String copyName="";
	for (String string : copyArray) {
		copyName+=string;
	}
	description=copyName;
	description=description.substring(1,description.length()-1);
	String explanation="";
	if (classChart.getExplanation()!=null) { 
		explanation=classChart.getExplanation().getName();	
	   copyArray=explanation.split("\\\\");
		copyName="";
		for (String string : copyArray) {
			copyName+=string;
		}
		explanation=copyName;
	}
	String packagename="";
	String inheritedClass="";
	Cluster cluster=clusterChart.getCluster();
	while (cluster!=null) {
		packagename=cluster.getName().toLowerCase()+"."+packagename;
		cluster=cluster.getParent();
	}
	packagename=packagename.substring(0,packagename.length()-1);
	if (!classChart.getInherit().isEmpty()) {	
		inherits=true;
		inheritedClass = classChart.getInherit().get(0).getName().substring(0,1).toUpperCase()+classChart.getInherit().get(0).getName().substring(1,classChart.getInherit().get(0).getName().length()).toLowerCase();
		cluster=clusterChart.getCluster().getParent();
		for (Class_chart tmpclassChart : classCharts) {
			if (tmpclassChart.getClass_().equals(classChart.getInherit().get(0))) {
				cluster=tmpclassChart.getClass_().getParent();
				while (cluster!=null) {
					inheritedClass=cluster.getName().toLowerCase()+"."+inheritedClass;
					cluster=cluster.getParent();
				}
				inheritFromOtherClass=true;
				break;
			}
		}		
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(packagename);
    stringBuffer.append(TEXT_2);
    if (inheritFromOtherClass) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inheritedClass);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(description);
    stringBuffer.append(TEXT_6);
    if (classChart.getChart_indexing()!=null) {
    stringBuffer.append(TEXT_7);
    for (Index_Identifier indexIdent : classChart.getChart_indexing().getIndex_term_list()) { if (!indexIdent.getName().equals("author")) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(indexIdent.getName());
    stringBuffer.append(TEXT_9);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(string.substring(1,string.length()-1));
    }
    stringBuffer.append(TEXT_10);
    }
 } }
    if (classChart.getExplanation()!=null) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(explanation.substring(1,explanation.length()-1));
    for (Index_Identifier indexIdent : classChart.getChart_indexing().getIndex_term_list()) {
    if (indexIdent.getName().equals("author")) {
    stringBuffer.append(TEXT_12);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(string.substring(1,string.length()-1));
    stringBuffer.append(TEXT_13);
    } } } }
    if (classChart.getQueries()!=null) {
    stringBuffer.append(TEXT_14);
    for (Query query : classChart.getQueries().getQuery()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(query.getName().substring(1,query.getName().length()-1));
    stringBuffer.append(TEXT_16);
    }
    }
    if (classChart.getCommands()!=null) {
    stringBuffer.append(TEXT_17);
    for (Command command : classChart.getCommands().getCommand()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(command.getName().substring(1,command.getName().length()-1));
    stringBuffer.append(TEXT_19);
    }
    }
    if (classChart.getConstraints()!=null) {
    stringBuffer.append(TEXT_20);
    for (Constraint constraint : classChart.getConstraints().getConstraint()) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(constraint.getName().substring(1,constraint.getName().length()-1));
    stringBuffer.append(TEXT_22);
    }
    }
    for (Event_chart eventChart : eventCharts) { for (Event event : eventChart.getEvent_entries()) { for (ClassBON classBON : event.getInvolves()) { if (classBON==bonclass) {
    if (isEvent) {
    stringBuffer.append(TEXT_23);
    isEvent=false;}
    stringBuffer.append(TEXT_24);
    stringBuffer.append(eventChart.getEvent_type().getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(event.getName().substring(1,event.getName().length()-1));
    stringBuffer.append(TEXT_26);
    } } } }
    for (Creation_chart creationChart : creationCharts) { for (Creation creation : creationChart.getCreation_entries()) { if (creation.getCreator()==bonclass) {
    if (isCreator) {
    stringBuffer.append(TEXT_27);
    isCreator=false;}
    stringBuffer.append(TEXT_28);
    stringBuffer.append(bonclass.getName().substring(0,1).toUpperCase()+bonclass.getName().substring(1,bonclass.getName().length()).toLowerCase());
    stringBuffer.append(TEXT_29);
    for (ClassBON creatingClasses : creation.getCreates()) {
    stringBuffer.append(creatingClasses.getName().substring(0,1).toUpperCase()+creatingClasses.getName().substring(1,creatingClasses.getName().length()).toLowerCase());
    stringBuffer.append(TEXT_30);
    }
    } } }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(bonclass.getName().substring(0,1).toUpperCase()+bonclass.getName().substring(1,bonclass.getName().length()).toLowerCase());
    stringBuffer.append(TEXT_32);
    if (inherits) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(classChart.getInherit().get(0).getName().substring(0,1).toUpperCase()+classChart.getInherit().get(0).getName().substring(1,classChart.getInherit().get(0).getName().length()).toLowerCase());
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(bonclass.getName().substring(0,1).toUpperCase()+bonclass.getName().substring(1,bonclass.getName().length()).toLowerCase());
    stringBuffer.append(TEXT_36);
    if (inherits) {
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
