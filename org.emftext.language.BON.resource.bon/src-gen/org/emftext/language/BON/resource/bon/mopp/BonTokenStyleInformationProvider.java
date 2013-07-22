/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.language.BON.resource.bon.IBonTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x00, 0xbb, 0x00}, null, false, true, false, false);
		}
		if ("MANIFEST_TEXTBLOCK".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x2a, 0x00, 0xff}, null, false, false, false, false);
		}
		if ("EVENTTYPE".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("KEYWORDS".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("PREDEFINED_NAMES".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x00, 0x00, 0x00}, null, false, true, false, false);
		}
		if ("system_chart".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("end".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("explanation".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("indexing".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("part".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("cluster".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("description".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("cluster_chart".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("class".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("class_chart".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("inherit".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("query".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("command".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("constraint".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("event_chart".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("event".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("involves".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("scenario_chart".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("scenario".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("creation_chart".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("creator".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("creates".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
