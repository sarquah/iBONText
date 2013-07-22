package org.emftext.language.BON.javatobon;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ExtendVisitor extends ASTVisitor {

	private Type type;
	
	@Override
	public boolean visit(TypeDeclaration node) {
		if (node.getSuperclassType()!=null) {
			type=node.getSuperclassType();
		}		
		return super.visit(node);
	}
	
	public Type getType() {
		return type;
	}	
}