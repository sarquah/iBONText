/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Informal charts</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Informal_charts#getSystem_chart <em>System chart</em>}</li>
 *   <li>{@link org.emftext.language.BON.Informal_charts#getClass_charts <em>Class charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.Informal_charts#getCluster_charts <em>Cluster charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.Informal_charts#getEvent_charts <em>Event charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.Informal_charts#getScenario_charts <em>Scenario charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.Informal_charts#getCreation_charts <em>Creation charts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getInformal_charts()
 * @model
 * @generated
 */
public interface Informal_charts extends EObject {
	/**
	 * Returns the value of the '<em><b>System chart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System chart</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System chart</em>' containment reference.
	 * @see #setSystem_chart(System_chart)
	 * @see org.emftext.language.BON.BONPackage#getInformal_charts_System_chart()
	 * @model containment="true" required="true"
	 * @generated
	 */
	System_chart getSystem_chart();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Informal_charts#getSystem_chart <em>System chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System chart</em>' containment reference.
	 * @see #getSystem_chart()
	 * @generated
	 */
	void setSystem_chart(System_chart value);

	/**
	 * Returns the value of the '<em><b>Class charts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Class_chart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class charts</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class charts</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getInformal_charts_Class_charts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Class_chart> getClass_charts();

	/**
	 * Returns the value of the '<em><b>Cluster charts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Cluster_chart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster charts</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster charts</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getInformal_charts_Cluster_charts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cluster_chart> getCluster_charts();

	/**
	 * Returns the value of the '<em><b>Event charts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Event_chart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event charts</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event charts</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getInformal_charts_Event_charts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event_chart> getEvent_charts();

	/**
	 * Returns the value of the '<em><b>Scenario charts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Scenario_chart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario charts</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario charts</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getInformal_charts_Scenario_charts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario_chart> getScenario_charts();

	/**
	 * Returns the value of the '<em><b>Creation charts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Creation_chart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation charts</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation charts</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getInformal_charts_Creation_charts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Creation_chart> getCreation_charts();

} // Informal_charts
