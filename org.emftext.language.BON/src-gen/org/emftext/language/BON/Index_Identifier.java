/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Index Identifier</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Index_Identifier#getIndex_string <em>Index string</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getIndex_Identifier()
 * @model
 * @generated
 */
public interface Index_Identifier extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Index string</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index string</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Index string</em>' attribute list.
	 * @see org.emftext.language.BON.BONPackage#getIndex_Identifier_Index_string()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getIndex_string();
} // Index_Identifier
