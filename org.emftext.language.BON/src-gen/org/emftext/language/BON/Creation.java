/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Creation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Creation#getCreator <em>Creator</em>}</li>
 *   <li>{@link org.emftext.language.BON.Creation#getCreates <em>Creates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getCreation()
 * @model
 * @generated
 */
public interface Creation extends EObject {
	/**
	 * Returns the value of the '<em><b>Creator</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creator</em>' reference.
	 * @see #setCreator(ClassBON)
	 * @see org.emftext.language.BON.BONPackage#getCreation_Creator()
	 * @model required="true"
	 * @generated
	 */
	ClassBON getCreator();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Creation#getCreator <em>Creator</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creator</em>' reference.
	 * @see #getCreator()
	 * @generated
	 */
	void setCreator(ClassBON value);

	/**
	 * Returns the value of the '<em><b>Creates</b></em>' reference list. The
	 * list contents are of type {@link org.emftext.language.BON.ClassBON}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creates</em>' reference list.
	 * @see org.emftext.language.BON.BONPackage#getCreation_Creates()
	 * @model required="true"
	 * @generated
	 */
	EList<ClassBON> getCreates();

} // Creation
