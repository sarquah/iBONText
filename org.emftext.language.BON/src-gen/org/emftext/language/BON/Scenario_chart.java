/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Scenario chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Scenario_chart#getSystem_name <em>System name</em>}</li>
 *   <li>{@link org.emftext.language.BON.Scenario_chart#getScenario_entries <em>Scenario entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getScenario_chart()
 * @model
 * @generated
 */
public interface Scenario_chart extends Chart {
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
	 * @see org.emftext.language.BON.BONPackage#getScenario_chart_System_name()
	 * @model required="true"
	 * @generated
	 */
	System_chart getSystem_name();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Scenario_chart#getSystem_name <em>System name</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>System name</em>' reference.
	 * @see #getSystem_name()
	 * @generated
	 */
	void setSystem_name(System_chart value);

	/**
	 * Returns the value of the '<em><b>Scenario entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario entries</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario entries</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getScenario_chart_Scenario_entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getScenario_entries();

} // Scenario_chart
