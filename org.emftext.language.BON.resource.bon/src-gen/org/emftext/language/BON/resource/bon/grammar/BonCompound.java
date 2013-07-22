/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

public class BonCompound extends org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement {
	
	public BonCompound(org.emftext.language.BON.resource.bon.grammar.BonChoice choice, org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality) {
		super(cardinality, new org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
