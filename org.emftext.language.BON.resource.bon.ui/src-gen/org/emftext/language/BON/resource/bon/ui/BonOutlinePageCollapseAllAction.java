/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

public class BonOutlinePageCollapseAllAction extends org.emftext.language.BON.resource.bon.ui.AbstractBonOutlinePageAction {
	
	public BonOutlinePageCollapseAllAction(org.emftext.language.BON.resource.bon.ui.BonOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
