/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Chart#getChart_indexing <em>Chart indexing</em>}</li>
 *   <li>{@link org.emftext.language.BON.Chart#getExplanation <em>Explanation</em>}</li>
 *   <li>{@link org.emftext.language.BON.Chart#getChart_part <em>Chart part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getChart()
 * @model abstract="true"
 * @generated
 */
public interface Chart extends EObject {
	/**
	 * Returns the value of the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explanation</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explanation</em>' containment reference.
	 * @see #setExplanation(Explanation)
	 * @see org.emftext.language.BON.BONPackage#getChart_Explanation()
	 * @model containment="true"
	 * @generated
	 */
	Explanation getExplanation();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Chart#getExplanation <em>Explanation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explanation</em>' containment reference.
	 * @see #getExplanation()
	 * @generated
	 */
	void setExplanation(Explanation value);

	/**
	 * Returns the value of the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chart part</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chart part</em>' containment reference.
	 * @see #setChart_part(Part)
	 * @see org.emftext.language.BON.BONPackage#getChart_Chart_part()
	 * @model containment="true"
	 * @generated
	 */
	Part getChart_part();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Chart#getChart_part <em>Chart part</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chart part</em>' containment reference.
	 * @see #getChart_part()
	 * @generated
	 */
	void setChart_part(Part value);

	/**
	 * Returns the value of the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chart indexing</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chart indexing</em>' containment reference.
	 * @see #setChart_indexing(Indexing)
	 * @see org.emftext.language.BON.BONPackage#getChart_Chart_indexing()
	 * @model containment="true"
	 * @generated
	 */
	Indexing getChart_indexing();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Chart#getChart_indexing <em>Chart indexing</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chart indexing</em>' containment reference.
	 * @see #getChart_indexing()
	 * @generated
	 */
	void setChart_indexing(Indexing value);

} // Chart
