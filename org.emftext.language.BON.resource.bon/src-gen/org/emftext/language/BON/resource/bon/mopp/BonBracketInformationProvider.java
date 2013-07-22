/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.BON.resource.bon.IBonBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.emftext.language.BON.resource.bon.IBonBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.BON.resource.bon.IBonBracketPair> result = new java.util.ArrayList<org.emftext.language.BON.resource.bon.IBonBracketPair>();
		return result;
	}
	
}
