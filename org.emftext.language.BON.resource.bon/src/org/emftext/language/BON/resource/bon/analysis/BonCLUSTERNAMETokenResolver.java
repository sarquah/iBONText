/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.analysis;

public class BonCLUSTERNAMETokenResolver implements org.emftext.language.BON.resource.bon.IBonTokenResolver {
	
	private org.emftext.language.BON.resource.bon.analysis.BonDefaultTokenResolver defaultTokenResolver = new org.emftext.language.BON.resource.bon.analysis.BonDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.BON.resource.bon.IBonTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
