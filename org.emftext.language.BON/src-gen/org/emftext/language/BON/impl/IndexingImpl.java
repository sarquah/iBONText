/**
 */
package org.emftext.language.BON.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Cluster;
import org.emftext.language.BON.Index_Identifier;
import org.emftext.language.BON.Indexing;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Indexing</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.IndexingImpl#getIndex_term_list <em>Index term list</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexingImpl extends EObjectImpl implements Indexing {
	/**
	 * The cached value of the '{@link #getIndex_term_list()
	 * <em>Index term list</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIndex_term_list()
	 * @generated
	 * @ordered
	 */
	protected EList<Index_Identifier> index_term_list;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.INDEXING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.INDEXING__INDEX_TERM_LIST:
			return ((InternalEList<?>) getIndex_term_list()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Index_Identifier> getIndex_term_list() {
		if (index_term_list == null) {
			index_term_list = new EObjectContainmentEList<Index_Identifier>(
					Index_Identifier.class, this,
					BONPackage.INDEXING__INDEX_TERM_LIST);
		}
		return index_term_list;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BONPackage.INDEXING__INDEX_TERM_LIST:
			return getIndex_term_list();
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
		case BONPackage.INDEXING__INDEX_TERM_LIST:
			getIndex_term_list().clear();
			getIndex_term_list().addAll(
					(Collection<? extends Index_Identifier>) newValue);
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
		case BONPackage.INDEXING__INDEX_TERM_LIST:
			getIndex_term_list().clear();
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
		case BONPackage.INDEXING__INDEX_TERM_LIST:
			return index_term_list != null && !index_term_list.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // IndexingImpl
