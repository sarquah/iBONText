/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

public class BonOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.language.BON.resource.bon.ui.BonOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.language.BON.resource.bon.ui.BonOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.BON.resource.bon.ui.BonOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.BON.resource.bon.ui.BonOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.BON.resource.bon.ui.BonOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.BON.resource.bon.ui.BonOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.BON.resource.bon.ui.BonOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
