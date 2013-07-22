/**
 */
package org.emftext.language.BON;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Class BON</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.ClassBON#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getClassBON()
 * @model
 * @generated
 */
public interface ClassBON extends DescriptionElement {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Cluster)
	 * @see org.emftext.language.BON.BONPackage#getClassBON_Parent()
	 * @model
	 * @generated
	 */
	Cluster getParent();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.ClassBON#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Cluster value);
} // ClassBON
