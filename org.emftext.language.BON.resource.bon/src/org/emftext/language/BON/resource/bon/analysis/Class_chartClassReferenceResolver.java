/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.analysis;

import org.emftext.language.BON.ClassBON;

public class Class_chartClassReferenceResolver implements org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Class_chart, ClassBON> {
	
	private org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Class_chart, ClassBON> delegate = new org.emftext.language.BON.resource.bon.analysis.BonDefaultResolverDelegate<org.emftext.language.BON.Class_chart, ClassBON>();
	
	public void resolve(String identifier, org.emftext.language.BON.Class_chart container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.BON.resource.bon.IBonReferenceResolveResult<ClassBON> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ClassBON element, org.emftext.language.BON.Class_chart container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
