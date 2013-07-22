/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.analysis;

public class Cluster_chartClusterReferenceResolver implements org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Cluster_chart, org.emftext.language.BON.Cluster> {
	
	private org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Cluster_chart, org.emftext.language.BON.Cluster> delegate = new org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Cluster_chart, org.emftext.language.BON.Cluster>();
	
	public void resolve(String identifier, org.emftext.language.BON.Cluster_chart container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.BON.resource.bon.IBonReferenceResolveResult<org.emftext.language.BON.Cluster> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.BON.Cluster element, org.emftext.language.BON.Cluster_chart container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
