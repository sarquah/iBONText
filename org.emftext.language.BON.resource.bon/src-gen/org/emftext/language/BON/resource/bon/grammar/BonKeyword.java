/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class BonKeyword extends org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement {
	
	private final String value;
	
	public BonKeyword(String value, org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
