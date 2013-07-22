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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Creation;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.System_chart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Creation chart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Creation_chartImpl#getSystem_name <em>System name</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Creation_chartImpl#getCreation_entries <em>Creation entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Creation_chartImpl extends ChartImpl implements Creation_chart {
	/**
	 * The cached value of the '{@link #getSystem_name() <em>System name</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSystem_name()
	 * @generated
	 * @ordered
	 */
	protected System_chart system_name;

	/**
	 * The cached value of the '{@link #getCreation_entries()
	 * <em>Creation entries</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreation_entries()
	 * @generated
	 * @ordered
	 */
	protected EList<Creation> creation_entries;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Creation_chartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.CREATION_CHART;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public System_chart getSystem_name() {
		if (system_name != null && system_name.eIsProxy()) {
			InternalEObject oldSystem_name = (InternalEObject) system_name;
			system_name = (System_chart) eResolveProxy(oldSystem_name);
			if (system_name != oldSystem_name) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BONPackage.CREATION_CHART__SYSTEM_NAME,
							oldSystem_name, system_name));
			}
		}
		return system_name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public System_chart basicGetSystem_name() {
		return system_name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem_name(System_chart newSystem_name) {
		System_chart oldSystem_name = system_name;
		system_name = newSystem_name;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CREATION_CHART__SYSTEM_NAME, oldSystem_name,
					system_name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Creation> getCreation_entries() {
		if (creation_entries == null) {
			creation_entries = new EObjectContainmentEList<Creation>(
					Creation.class, this,
					BONPackage.CREATION_CHART__CREATION_ENTRIES);
		}
		return creation_entries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.CREATION_CHART__CREATION_ENTRIES:
			return ((InternalEList<?>) getCreation_entries()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BONPackage.CREATION_CHART__SYSTEM_NAME:
			if (resolve)
				return getSystem_name();
			return basicGetSystem_name();
		case BONPackage.CREATION_CHART__CREATION_ENTRIES:
			return getCreation_entries();
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
		case BONPackage.CREATION_CHART__SYSTEM_NAME:
			setSystem_name((System_chart) newValue);
			return;
		case BONPackage.CREATION_CHART__CREATION_ENTRIES:
			getCreation_entries().clear();
			getCreation_entries().addAll(
					(Collection<? extends Creation>) newValue);
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
		case BONPackage.CREATION_CHART__SYSTEM_NAME:
			setSystem_name((System_chart) null);
			return;
		case BONPackage.CREATION_CHART__CREATION_ENTRIES:
			getCreation_entries().clear();
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
		case BONPackage.CREATION_CHART__SYSTEM_NAME:
			return system_name != null;
		case BONPackage.CREATION_CHART__CREATION_ENTRIES:
			return creation_entries != null && !creation_entries.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // Creation_chartImpl
