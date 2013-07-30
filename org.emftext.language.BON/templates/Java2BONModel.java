package templates;

import org.emftext.language.BON.*;
import org.emftext.language.BON.codegenerator.*;
import java.util.List;

public class Java2BONModel
{
  protected static String nl;
  public static synchronized Java2BONModel create(String lineSeparator)
  {
    nl = lineSeparator;
    Java2BONModel result = new Java2BONModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "-- Created by iBONText" + NL + "system_chart ";
  protected final String TEXT_2 = NL + "indexing ";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = ": ";
  protected final String TEXT_5 = "\"";
  protected final String TEXT_6 = "\"";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ";\t\t\t\t\t\t";
  protected final String TEXT_9 = NL + "explanation" + NL + "\t\"";
  protected final String TEXT_10 = "\"";
  protected final String TEXT_11 = NL + "cluster ";
  protected final String TEXT_12 = NL + "description" + NL + "\t\"";
  protected final String TEXT_13 = "\"\t\t\t\t";
  protected final String TEXT_14 = NL + "end" + NL;
  protected final String TEXT_15 = NL + "cluster_chart ";
  protected final String TEXT_16 = NL + "indexing ";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = ": ";
  protected final String TEXT_19 = "\"";
  protected final String TEXT_20 = "\"";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ";\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + "explanation" + NL + "\t\"";
  protected final String TEXT_24 = "\"";
  protected final String TEXT_25 = NL + "cluster ";
  protected final String TEXT_26 = NL + "description" + NL + "\t\"";
  protected final String TEXT_27 = "\"";
  protected final String TEXT_28 = NL + "class ";
  protected final String TEXT_29 = NL + "description" + NL + "\t\"";
  protected final String TEXT_30 = "\"";
  protected final String TEXT_31 = NL + "end" + NL;
  protected final String TEXT_32 = NL + "class_chart ";
  protected final String TEXT_33 = NL + "indexing ";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = ": ";
  protected final String TEXT_36 = "\"";
  protected final String TEXT_37 = "\"";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ";\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "explanation" + NL + "\t\"";
  protected final String TEXT_41 = "\"";
  protected final String TEXT_42 = NL + "inherit ";
  protected final String TEXT_43 = NL + "query";
  protected final String TEXT_44 = NL + "\t\"";
  protected final String TEXT_45 = "\"";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = NL + "command";
  protected final String TEXT_48 = NL + "\t\"";
  protected final String TEXT_49 = "\"";
  protected final String TEXT_50 = ",";
  protected final String TEXT_51 = NL + "constraint";
  protected final String TEXT_52 = NL + "\t\"";
  protected final String TEXT_53 = "\"";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = NL + "end" + NL;
  protected final String TEXT_56 = " " + NL;
  protected final String TEXT_57 = NL + "event_chart ";
  protected final String TEXT_58 = NL;
  protected final String TEXT_59 = NL + "event" + NL + "\t\"";
  protected final String TEXT_60 = "\"" + NL + "involves ";
  protected final String TEXT_61 = NL + "\t";
  protected final String TEXT_62 = NL + "end" + NL;
  protected final String TEXT_63 = NL;
  protected final String TEXT_64 = NL + "creation_chart ";
  protected final String TEXT_65 = NL + "creator ";
  protected final String TEXT_66 = " creates ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = NL + "end" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  Informal_charts informalCharts = (Informal_charts) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(informalCharts.getSystem_chart().getName().toUpperCase());
    if (informalCharts.getSystem_chart().getChart_indexing()!=null) {
    stringBuffer.append(TEXT_2);
    for (Index_Identifier indexIdent : informalCharts.getSystem_chart().getChart_indexing().getIndex_term_list()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(indexIdent.getName());
    stringBuffer.append(TEXT_4);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(string);
    stringBuffer.append(TEXT_6);
    if (indexIdent.getIndex_string().indexOf(string)!=indexIdent.getIndex_string().size()-1) {
    stringBuffer.append(TEXT_7);
    } }
    stringBuffer.append(TEXT_8);
    } }
    if (informalCharts.getSystem_chart().getExplanation()!=null) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(informalCharts.getSystem_chart().getExplanation().getName());
    stringBuffer.append(TEXT_10);
    }
    for (Cluster cluster : informalCharts.getSystem_chart().getCluster_entries()) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cluster.getName().toUpperCase());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cluster.getDescription());
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    for (Cluster_chart clusterChart : informalCharts.getCluster_charts()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(clusterChart.getCluster().getName().toUpperCase());
    if (clusterChart.getChart_indexing()!=null) {
    stringBuffer.append(TEXT_16);
    for (Index_Identifier indexIdent : clusterChart.getChart_indexing().getIndex_term_list()) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(indexIdent.getName());
    stringBuffer.append(TEXT_18);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(string);
    stringBuffer.append(TEXT_20);
    if (indexIdent.getIndex_string().indexOf(string)!=indexIdent.getIndex_string().size()-1) {
    stringBuffer.append(TEXT_21);
    } }
    stringBuffer.append(TEXT_22);
    }
}
    if (clusterChart.getExplanation()!=null) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(clusterChart.getExplanation().getName());
    stringBuffer.append(TEXT_24);
    }
    for (Cluster clusterEntry : clusterChart.getClusterchart_entries()) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(clusterEntry.getName().toUpperCase());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(clusterEntry.getDescription());
    stringBuffer.append(TEXT_27);
    }
    for (ClassBON classBon : clusterChart.getClass_entries()) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(classBon.getName().toUpperCase());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(classBon.getDescription());
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    }
    for (Class_chart classChart : informalCharts.getClass_charts()) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(classChart.getClass_().getName().toUpperCase());
    if (classChart.getChart_indexing()!=null) {
    stringBuffer.append(TEXT_33);
    for (Index_Identifier indexIdent : classChart.getChart_indexing().getIndex_term_list()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(indexIdent.getName());
    stringBuffer.append(TEXT_35);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(string);
    stringBuffer.append(TEXT_37);
    if (indexIdent.getIndex_string().indexOf(string)!=indexIdent.getIndex_string().size()-1) {
    stringBuffer.append(TEXT_38);
    } }
    stringBuffer.append(TEXT_39);
    } }
    if (classChart.getExplanation()!=null) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(classChart.getExplanation().getName());
    stringBuffer.append(TEXT_41);
    }
    if (classChart.getInherit().size()>0) {
    stringBuffer.append(TEXT_42);
    for (ClassBON classbon : classChart.getInherit()) {
    stringBuffer.append(classbon.getName().toUpperCase());
    }
    }
    if (classChart.getQueries()!=null) {
    stringBuffer.append(TEXT_43);
    for (Query query : classChart.getQueries().getQuery()) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(query.getName());
    stringBuffer.append(TEXT_45);
    if (classChart.getQueries().getQuery().indexOf(query)!=classChart.getQueries().getQuery().size()-1) {
    stringBuffer.append(TEXT_46);
    }
    }
    }
    if (classChart.getCommands()!=null) {
    stringBuffer.append(TEXT_47);
    for (Command command : classChart.getCommands().getCommand()) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(command.getName());
    stringBuffer.append(TEXT_49);
    if (classChart.getCommands().getCommand().indexOf(command)!=classChart.getCommands().getCommand().size()-1) {
    stringBuffer.append(TEXT_50);
    }
    }
    }
    if (classChart.getConstraints()!=null) {
    stringBuffer.append(TEXT_51);
    for (Constraint constraint : classChart.getConstraints().getConstraint()) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(constraint.getName());
    stringBuffer.append(TEXT_53);
    if (classChart.getConstraints().getConstraint().indexOf(constraint)!=classChart.getConstraints().getConstraint().size()-1) {
    stringBuffer.append(TEXT_54);
    }
    }
    }
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    for (Event_chart eventChart : informalCharts.getEvent_charts()) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eventChart.getSystem_name().getName().toUpperCase());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(eventChart.getEvent_type().getName().toLowerCase());
    for (Event event : eventChart.getEvent_entries()) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(event.getName());
    stringBuffer.append(TEXT_60);
    for (ClassBON involvedClass : event.getInvolves()) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(involvedClass.getName().toUpperCase());
    }
    }
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    for (Creation_chart creationChart : informalCharts.getCreation_charts()) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(creationChart.getSystem_name().getName().toUpperCase());
    for (Creation creation : creationChart.getCreation_entries()) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(creation.getCreator().getName().toUpperCase());
    stringBuffer.append(TEXT_66);
    for (ClassBON classbon : creation.getCreates()) {
    stringBuffer.append(classbon.getName().toUpperCase());
    if (creation.getCreates().indexOf(classbon)!=creation.getCreates().size()-1) {
    stringBuffer.append(TEXT_67);
    }
    }
    }
    stringBuffer.append(TEXT_68);
    }
    return stringBuffer.toString();
  }
}
