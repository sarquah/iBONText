/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

public class BonWhiteSpace extends org.emftext.language.BON.resource.bon.grammar.BonFormattingElement {
	
	private final int amount;
	
	public BonWhiteSpace(int amount, org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
