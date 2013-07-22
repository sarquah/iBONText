package templates;

import org.emftext.language.BON.*;
import org.emftext.language.BON.codegenerator.*;
import java.util.List;

public class SystemBONModel
{
  protected static String nl;
  public static synchronized SystemBONModel create(String lineSeparator)
  {
    nl = lineSeparator;
    SystemBONModel result = new SystemBONModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<HTML>" + NL + "<BODY>";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "</BODY>" + NL + "</HTML>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	String explanation=(String)argument;
	if (explanation!="") {
		String[] copyArray=explanation.split("\\\\");
		String copyName="";
		for (String string : copyArray) {
			copyName+=string;
		}
		explanation=copyName;
		explanation=explanation.substring(1,explanation.length()-1);
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(explanation);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
