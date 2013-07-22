/**
 */
package org.emftext.language.BON.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Index_Identifier;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Index Identifier</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Index_IdentifierImpl#getIndex_string <em>Index string</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Index_IdentifierImpl extends NamedElementImpl implements
		Index_Identifier {
	/**
	 * The cached value of the '{@link #getIndex_string() <em>Index string</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIndex_string()
	 * @generated
	 * @ordered
	 */
	protected EList<String> index_string;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Index_IdentifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.INDEX_IDENTIFIER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIndex_string() {
		if (index_string == null) {
			index_string = new EDataTypeUniqueEList<String>(String.class, this,
					BONPackage.INDEX_IDENTIFIER__INDEX_STRING);
		}
		return index_string;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BONPackage.INDEX_IDENTIFIER__INDEX_STRING:
			return getIndex_string();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BONPackage.INDEX_IDENTIFIER__INDEX_STRING:
			getIndex_string().clear();
			getIndex_string().addAll((Collection<? extends String>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case BONPackage.INDEX_IDENTIFIER__INDEX_STRING:
			getIndex_string().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case BONPackage.INDEX_IDENTIFIER__INDEX_STRING:
			return index_string != null && !index_string.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (index_string: ");
		result.append(index_string);
		result.append(')');
		return result.toString();
	}

} // Index_IdentifierImpl
