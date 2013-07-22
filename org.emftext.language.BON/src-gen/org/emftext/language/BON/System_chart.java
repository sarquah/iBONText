/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>System chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.System_chart#getCluster_entries <em>Cluster entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getSystem_chart()
 * @model
 * @generated
 */
public interface System_chart extends Chart, NamedElement {
	/**
	 * Returns the value of the '<em><b>Cluster entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Cluster}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster entries</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster entries</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getSystem_chart_Cluster_entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cluster> getCluster_entries();

} // System_chart
