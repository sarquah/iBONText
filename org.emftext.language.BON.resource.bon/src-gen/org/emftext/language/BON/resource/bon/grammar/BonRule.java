/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class BonRule extends org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public BonRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.BON.resource.bon.grammar.BonChoice choice, org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality) {
		super(cardinality, new org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.BON.resource.bon.grammar.BonChoice getDefinition() {
		return (org.emftext.language.BON.resource.bon.grammar.BonChoice) getChildren()[0];
	}
	
}

