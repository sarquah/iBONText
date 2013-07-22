/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IBonExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.emftext.language.BON.resource.bon.grammar.BonSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.emftext.language.BON.resource.bon.IBonExpectedElement follower, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]>> getFollowers();
	
}
