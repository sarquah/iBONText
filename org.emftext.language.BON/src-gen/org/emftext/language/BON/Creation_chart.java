/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Creation chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Creation_chart#getSystem_name <em>System name</em>}</li>
 *   <li>{@link org.emftext.language.BON.Creation_chart#getCreation_entries <em>Creation entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getCreation_chart()
 * @model
 * @generated
 */
public interface Creation_chart extends Chart {
	/**
	 * Returns the value of the '<em><b>System name</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System name</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>System name</em>' reference.
	 * @see #setSystem_name(System_chart)
	 * @see org.emftext.language.BON.BONPackage#getCreation_chart_System_name()
	 * @model required="true"
	 * @generated
	 */
	System_chart getSystem_name();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Creation_chart#getSystem_name <em>System name</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>System name</em>' reference.
	 * @see #getSystem_name()
	 * @generated
	 */
	void setSystem_name(System_chart value);

	/**
	 * Returns the value of the '<em><b>Creation entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Creation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation entries</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation entries</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getCreation_chart_Creation_entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Creation> getCreation_entries();

} // Creation_chart
