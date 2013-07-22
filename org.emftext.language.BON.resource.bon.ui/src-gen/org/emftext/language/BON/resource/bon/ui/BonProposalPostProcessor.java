/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class BonProposalPostProcessor {
	
	public java.util.List<org.emftext.language.BON.resource.bon.ui.BonCompletionProposal> process(java.util.List<org.emftext.language.BON.resource.bon.ui.BonCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
