/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Queries</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Queries#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getQueries()
 * @model
 * @generated
 */
public interface Queries extends EObject {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Query}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getQueries_Query()
	 * @model containment="true"
	 * @generated
	 */
	EList<Query> getQuery();

} // Queries
