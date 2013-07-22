/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Class chart</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Class_chart#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.emftext.language.BON.Class_chart#getInherit <em>Inherit</em>}</li>
 *   <li>{@link org.emftext.language.BON.Class_chart#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.emftext.language.BON.Class_chart#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.emftext.language.BON.Class_chart#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getClass_chart()
 * @model
 * @generated
 */
public interface Class_chart extends Chart {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(ClassBON)
	 * @see org.emftext.language.BON.BONPackage#getClass_chart_Class()
	 * @model required="true"
	 * @generated
	 */
	ClassBON getClass_();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Class_chart#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(ClassBON value);

	/**
	 * Returns the value of the '<em><b>Inherit</b></em>' reference list. The
	 * list contents are of type {@link org.emftext.language.BON.ClassBON}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Inherit</em>' reference list.
	 * @see org.emftext.language.BON.BONPackage#getClass_chart_Inherit()
	 * @model
	 * @generated
	 */
	EList<ClassBON> getInherit();

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference.
	 * @see #setCommands(Commands)
	 * @see org.emftext.language.BON.BONPackage#getClass_chart_Commands()
	 * @model containment="true"
	 * @generated
	 */
	Commands getCommands();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Class_chart#getCommands <em>Commands</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Commands</em>' containment reference.
	 * @see #getCommands()
	 * @generated
	 */
	void setCommands(Commands value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(Constraints)
	 * @see org.emftext.language.BON.BONPackage#getClass_chart_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	Constraints getConstraints();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Class_chart#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(Constraints value);

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference.
	 * @see #setQueries(Queries)
	 * @see org.emftext.language.BON.BONPackage#getClass_chart_Queries()
	 * @model containment="true"
	 * @generated
	 */
	Queries getQueries();

	/**
	 * Sets the value of the '{@link org.emftext.language.BON.Class_chart#getQueries <em>Queries</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queries</em>' containment reference.
	 * @see #getQueries()
	 * @generated
	 */
	void setQueries(Queries value);

} // Class_chart
