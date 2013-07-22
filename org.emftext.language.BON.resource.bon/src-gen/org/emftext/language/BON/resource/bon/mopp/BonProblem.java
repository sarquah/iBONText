/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonProblem implements org.emftext.language.BON.resource.bon.IBonProblem {
	
	private String message;
	private org.emftext.language.BON.resource.bon.BonEProblemType type;
	private org.emftext.language.BON.resource.bon.BonEProblemSeverity severity;
	private java.util.Collection<org.emftext.language.BON.resource.bon.IBonQuickFix> quickFixes;
	
	public BonProblem(String message, org.emftext.language.BON.resource.bon.BonEProblemType type, org.emftext.language.BON.resource.bon.BonEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.BON.resource.bon.IBonQuickFix>emptySet());
	}
	
	public BonProblem(String message, org.emftext.language.BON.resource.bon.BonEProblemType type, org.emftext.language.BON.resource.bon.BonEProblemSeverity severity, org.emftext.language.BON.resource.bon.IBonQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public BonProblem(String message, org.emftext.language.BON.resource.bon.BonEProblemType type, org.emftext.language.BON.resource.bon.BonEProblemSeverity severity, java.util.Collection<org.emftext.language.BON.resource.bon.IBonQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.BON.resource.bon.IBonQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.BON.resource.bon.BonEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.BON.resource.bon.BonEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.BON.resource.bon.IBonQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
