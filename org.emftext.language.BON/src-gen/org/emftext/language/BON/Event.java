/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Event</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.BON.Event#getInvolves <em>Involves</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.BON.BONPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Involves</b></em>' reference list. The
	 * list contents are of type {@link org.emftext.language.BON.ClassBON}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Involves</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Involves</em>' reference list.
	 * @see org.emftext.language.BON.BONPackage#getEvent_Involves()
	 * @model required="true"
	 * @generated
	 */
	EList<ClassBON> getInvolves();

} // Event
