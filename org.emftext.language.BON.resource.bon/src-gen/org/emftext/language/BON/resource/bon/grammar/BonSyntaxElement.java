/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class BonSyntaxElement {
	
	private BonSyntaxElement[] children;
	private BonSyntaxElement parent;
	private org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality;
	
	public BonSyntaxElement(org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality, BonSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (BonSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(BonSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public BonSyntaxElement getParent() {
		return parent;
	}
	
	public BonSyntaxElement[] getChildren() {
		if (children == null) {
			return new BonSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.BON.resource.bon.grammar.BonCardinality getCardinality() {
		return cardinality;
	}
	
}
