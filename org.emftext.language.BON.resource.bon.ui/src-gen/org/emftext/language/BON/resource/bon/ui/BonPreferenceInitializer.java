/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

/**
 * A class used to initialize default preference values.
 */
public class BonPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.BON.resource.bon.ui.BonUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.BON.resource.bon.ui.BonUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.language.BON.resource.bon.mopp.BonMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.BON.resource.bon.ui.BonUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.language.BON.resource.bon.mopp.BonMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.BON.resource.bon.IBonMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.language.BON.resource.bon.ui.BonBracketSet bracketSet = new org.emftext.language.BON.resource.bon.ui.BonBracketSet(null, null);
		final java.util.Collection<org.emftext.language.BON.resource.bon.IBonBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.language.BON.resource.bon.IBonBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.language.BON.resource.bon.ui.BonPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.BON.resource.bon.mopp.BonMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.emftext.language.BON.resource.bon.IBonTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.BON.resource.bon.ui.BonSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
