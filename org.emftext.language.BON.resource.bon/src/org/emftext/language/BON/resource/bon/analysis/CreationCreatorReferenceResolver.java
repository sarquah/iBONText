/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.analysis;

import org.emftext.language.BON.ClassBON;

public class CreationCreatorReferenceResolver implements org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Creation, ClassBON> {
	
	private org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Creation, ClassBON> delegate = new org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Creation, ClassBON>();
	
	public void resolve(String identifier, org.emftext.language.BON.Creation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.BON.resource.bon.IBonReferenceResolveResult<ClassBON> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ClassBON element, org.emftext.language.BON.Creation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
