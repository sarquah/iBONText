/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

public class BonUIMetaInformation extends org.emftext.language.BON.resource.bon.mopp.BonMetaInformation {
	
	public org.emftext.language.BON.resource.bon.IBonHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.BON.resource.bon.ui.BonHoverTextProvider();
	}
	
	public org.emftext.language.BON.resource.bon.ui.BonImageProvider getImageProvider() {
		return org.emftext.language.BON.resource.bon.ui.BonImageProvider.INSTANCE;
	}
	
	public org.emftext.language.BON.resource.bon.ui.BonColorManager createColorManager() {
		return new org.emftext.language.BON.resource.bon.ui.BonColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.BON.resource.bon.IBonTextResource,
	 * org.emftext.language.BON.resource.bon.ui.BonColorManager) instead.
	 */
	public org.emftext.language.BON.resource.bon.ui.BonTokenScanner createTokenScanner(org.emftext.language.BON.resource.bon.ui.BonColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.BON.resource.bon.ui.BonTokenScanner createTokenScanner(org.emftext.language.BON.resource.bon.IBonTextResource resource, org.emftext.language.BON.resource.bon.ui.BonColorManager colorManager) {
		return new org.emftext.language.BON.resource.bon.ui.BonTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.BON.resource.bon.ui.BonCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.BON.resource.bon.ui.BonCodeCompletionHelper();
	}
	
}
