/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public BonResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.BON.resource.bon.mopp.BonResource(uri);
	}
	
}
