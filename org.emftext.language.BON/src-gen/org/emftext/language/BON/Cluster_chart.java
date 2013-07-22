/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Cluster chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Cluster_chart#getClass_entries <em>Class entries</em>}</li>
 *   <li>{@link org.emftext.language.BON.Cluster_chart#getCluster <em>Cluster</em>}</li>
 *   <li>{@link org.emftext.language.BON.Cluster_chart#getClusterchart_entries <em>Clusterchart entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getCluster_chart()
 * @model
 * @generated
 */
public interface Cluster_chart extends Chart {
	/**
	 * Returns the value of the '<em><b>Class entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.ClassBON}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class entries</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class entries</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getCluster_chart_Class_entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassBON> getClass_entries();

	/**
	 * Returns the value of the '<em><b>Cluster</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cluster</em>' reference.
	 * @see #setCluster(Cluster)
	 * @see org.emftext.language.BON.BONPackage#getCluster_chart_Cluster()
	 * @model required="true"
	 * @generated
	 */
	Cluster getCluster();

	/**
	 * Sets the value of the '
	 * {@link org.emftext.language.BON.Cluster_chart#getCluster
	 * <em>Cluster</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Cluster</em>' reference.
	 * @see #getCluster()
	 * @generated
	 */
	void setCluster(Cluster value);

	/**
	 * Returns the value of the '<em><b>Clusterchart entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.BON.Cluster}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clusterchart entries</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clusterchart entries</em>' containment reference list.
	 * @see org.emftext.language.BON.BONPackage#getCluster_chart_Clusterchart_entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cluster> getClusterchart_entries();

} // Cluster_chart
