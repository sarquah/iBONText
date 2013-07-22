/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

public class BonSequence extends org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement {
	
	public BonSequence(org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality, org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.BON.resource.bon.util.BonStringUtil.explode(getChildren(), " ");
	}
	
}
