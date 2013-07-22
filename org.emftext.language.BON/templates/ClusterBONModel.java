package templates;

import org.emftext.language.BON.*;
import org.emftext.language.BON.codegenerator.*;
import java.util.List;

public class ClusterBONModel
{
  protected static String nl;
  public static synchronized ClusterBONModel create(String lineSeparator)
  {
    nl = lineSeparator;
    ClusterBONModel result = new ClusterBONModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/**" + NL + " * ";
  protected final String TEXT_2 = NL + " * @bon.indexing ";
  protected final String TEXT_3 = NL + " *     <li>";
  protected final String TEXT_4 = ": ";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = "</li>";
  protected final String TEXT_8 = NL + " * @author ";
  protected final String TEXT_9 = NL + " * @bon.explanation ";
  protected final String TEXT_10 = NL + " */" + NL + "package ";
  protected final String TEXT_11 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
	Cluster_chart clusterChart = (Cluster_chart) argument;
	String packagename="";
	Cluster cluster=clusterChart.getCluster();
	while (cluster!=null) {
		packagename=cluster.getName().toLowerCase()+"."+packagename;
		cluster=cluster.getParent();
	}
	packagename=packagename.substring(0,packagename.length()-1);
	String description=clusterChart.getCluster().getDescription();
	String[] copyArray=description.split("\\\\");
	String copyName="";
	for (String string : copyArray) {
		copyName+=string;
	}
	description=copyName;
	description=description.substring(1,description.length()-1);
	String explanation="";
	if (clusterChart.getExplanation()!=null) {
		explanation=clusterChart.getExplanation().getName();
		copyArray=explanation.split("\\\\");
		copyName="";
		for (String string : copyArray) {
			copyName+=string;
		}
		explanation=copyName;
		explanation=explanation.substring(1,explanation.length()-1);
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(description);
    if (!clusterChart.getChart_indexing().getIndex_term_list().isEmpty()) {
    stringBuffer.append(TEXT_2);
    for (Index_Identifier indexIdent : clusterChart.getChart_indexing().getIndex_term_list()) { if (!indexIdent.getName().equals("author")) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(indexIdent.getName());
    stringBuffer.append(TEXT_4);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(string.substring(1,string.length()-1));
    if (indexIdent.getIndex_string().indexOf(string)!=indexIdent.getIndex_string().size()-1) {
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    }
} 
for (Index_Identifier indexIdent : clusterChart.getChart_indexing().getIndex_term_list()) { if (indexIdent.getName().equals("author")) {
    stringBuffer.append(TEXT_8);
    for (String string : indexIdent.getIndex_string()) {
    stringBuffer.append(string.substring(1,string.length()-1));
    } } } }
    if (clusterChart.getExplanation()!=null) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(explanation);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(packagename);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
