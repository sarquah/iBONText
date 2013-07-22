/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Indexing</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Indexing#getIndex_term_list <em>Index term list</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getIndexing()
 * @model
 * @generated
 */
public interface Indexing extends EObject {
	/**
	 * Returns the value of the '<em><b>Index term list</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Index_Identifier}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Index term list</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index term list</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getIndexing_Index_term_list()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Index_Identifier> getIndex_term_list();

} // Indexing
