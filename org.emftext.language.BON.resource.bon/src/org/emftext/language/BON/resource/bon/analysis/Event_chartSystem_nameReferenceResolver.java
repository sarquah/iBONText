/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.analysis;

public class Event_chartSystem_nameReferenceResolver implements org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Event_chart, org.emftext.language.BON.System_chart> {
	
	private org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Event_chart, org.emftext.language.BON.System_chart> delegate = new org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Event_chart, org.emftext.language.BON.System_chart>();
	
	public void resolve(String identifier, org.emftext.language.BON.Event_chart container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.BON.resource.bon.IBonReferenceResolveResult<org.emftext.language.BON.System_chart> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.BON.System_chart element, org.emftext.language.BON.Event_chart container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
