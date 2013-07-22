/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

public class BonOutlinePageLexicalSortingAction extends org.emftext.language.BON.resource.bon.ui.AbstractBonOutlinePageAction {
	
	public BonOutlinePageLexicalSortingAction(org.emftext.language.BON.resource.bon.ui.BonOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
