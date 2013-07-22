/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.util;

/**
 * Class BonTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.BON.resource.bon.util.BonResourceUtil.
 */
public class BonTextResourceUtil {
	
	/**
	 * Use org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.BON.resource.bon.mopp.BonResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.language.BON.resource.bon.util.BonEclipseProxy().getResource(file);
	}
	
	/**
	 * Use org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.BON.resource.bon.mopp.BonResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.BON.resource.bon.mopp.BonResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource(uri);
	}
	
	/**
	 * Use org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.BON.resource.bon.mopp.BonResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.BON.resource.bon.util.BonResourceUtil.getResource(uri, options);
	}
	
}
