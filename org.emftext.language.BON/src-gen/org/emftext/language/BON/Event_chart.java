/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Event chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Event_chart#getSystem_name <em>System name</em>}</li>
 *   <li>{@link org.emftext.language.BON.Event_chart#getEvent_entries <em>Event entries</em>}</li>
 *   <li>{@link org.emftext.language.BON.Event_chart#getEvent_type <em>Event type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getEvent_chart()
 * @model
 * @generated
 */
public interface Event_chart extends Chart {
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
	 * @see org.emftext.language.BON.BONPackage#getEvent_chart_System_name()
	 * @model required="true"
	 * @generated
	 */
	System_chart getSystem_name();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Event_chart#getSystem_name <em>System name</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>System name</em>' reference.
	 * @see #getSystem_name()
	 * @generated
	 */
	void setSystem_name(System_chart value);

	/**
	 * Returns the value of the '<em><b>Event entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event entries</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event entries</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getEvent_chart_Event_entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvent_entries();

	/**
	 * Returns the value of the '<em><b>Event type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.language.BON.Event_type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event type</em>' attribute.
	 * @see org.emftext.language.BON.Event_type
	 * @see #setEvent_type(Event_type)
	 * @see org.emftext.language.BON.BONPackage#getEvent_chart_Event_type()
	 * @model
	 * @generated
	 */
	Event_type getEvent_type();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Event_chart#getEvent_type <em>Event type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Event type</em>' attribute.
	 * @see org.emftext.language.BON.Event_type
	 * @see #getEvent_type()
	 * @generated
	 */
	void setEvent_type(Event_type value);

} // Event_chart
