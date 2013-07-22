/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class BonPlaceholder extends org.emftext.language.BON.resource.bon.grammar.BonTerminal {
	
	private final String tokenName;
	
	public BonPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
