/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon;

public interface IBonProblem {
	public String getMessage();
	public org.emftext.language.BON.resource.bon.BonEProblemSeverity getSeverity();
	public org.emftext.language.BON.resource.bon.BonEProblemType getType();
	public java.util.Collection<org.emftext.language.BON.resource.bon.IBonQuickFix> getQuickFixes();
}
