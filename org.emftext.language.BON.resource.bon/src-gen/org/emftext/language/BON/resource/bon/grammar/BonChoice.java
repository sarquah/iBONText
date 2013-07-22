/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

public class BonChoice extends org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement {
	
	public BonChoice(org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality, org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.BON.resource.bon.util.BonStringUtil.explode(getChildren(), "|");
	}
	
}
