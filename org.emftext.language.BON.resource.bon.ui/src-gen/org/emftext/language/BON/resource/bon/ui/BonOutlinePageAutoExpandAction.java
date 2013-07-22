/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

public class BonOutlinePageAutoExpandAction extends org.emftext.language.BON.resource.bon.ui.AbstractBonOutlinePageAction {
	
	public BonOutlinePageAutoExpandAction(org.emftext.language.BON.resource.bon.ui.BonOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
