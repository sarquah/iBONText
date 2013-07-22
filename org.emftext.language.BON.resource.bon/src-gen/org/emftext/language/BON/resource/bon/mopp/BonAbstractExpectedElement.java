/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class BonAbstractExpectedElement implements org.emftext.language.BON.resource.bon.IBonExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]>>();
	
	public BonAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.BON.resource.bon.IBonExpectedElement follower, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[] path) {
		followers.add(new org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
