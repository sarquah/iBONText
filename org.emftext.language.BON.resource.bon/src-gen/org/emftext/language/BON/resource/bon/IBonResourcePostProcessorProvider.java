/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IBonResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.BON.resource.bon.IBonResourcePostProcessor getResourcePostProcessor();
	
}
