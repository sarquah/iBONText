/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonParseResult implements org.emftext.language.BON.resource.bon.IBonParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>> commands = new java.util.ArrayList<org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>>();
	
	public BonParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
