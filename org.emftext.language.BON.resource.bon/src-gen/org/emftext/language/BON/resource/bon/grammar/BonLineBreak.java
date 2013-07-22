/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

public class BonLineBreak extends org.emftext.language.BON.resource.bon.grammar.BonFormattingElement {
	
	private final int tabs;
	
	public BonLineBreak(org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
