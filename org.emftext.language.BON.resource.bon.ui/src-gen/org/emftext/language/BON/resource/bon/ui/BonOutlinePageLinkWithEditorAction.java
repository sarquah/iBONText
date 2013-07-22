/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.ui;

public class BonOutlinePageLinkWithEditorAction extends org.emftext.language.BON.resource.bon.ui.AbstractBonOutlinePageAction {
	
	public BonOutlinePageLinkWithEditorAction(org.emftext.language.BON.resource.bon.ui.BonOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
