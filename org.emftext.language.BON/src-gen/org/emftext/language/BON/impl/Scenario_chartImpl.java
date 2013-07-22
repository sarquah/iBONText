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
import org.emftext.language.BON.Scenario;
import org.emftext.language.BON.Scenario_chart;
import org.emftext.language.BON.System_chart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Scenario chart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Scenario_chartImpl#getSystem_name <em>System name</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Scenario_chartImpl#getScenario_entries <em>Scenario entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Scenario_chartImpl extends ChartImpl implements Scenario_chart {
	/**
	 * The cached value of the '{@link #getSystem_name() <em>System name</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSystem_name()
	 * @generated
	 * @ordered
	 */
	protected System_chart system_name;

	/**
	 * The cached value of the '{@link #getScenario_entries()
	 * <em>Scenario entries</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getScenario_entries()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> scenario_entries;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Scenario_chartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.SCENARIO_CHART;
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
							BONPackage.SCENARIO_CHART__SYSTEM_NAME,
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
					BONPackage.SCENARIO_CHART__SYSTEM_NAME, oldSystem_name,
					system_name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getScenario_entries() {
		if (scenario_entries == null) {
			scenario_entries = new EObjectContainmentEList<Scenario>(
					Scenario.class, this,
					BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES);
		}
		return scenario_entries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES:
			return ((InternalEList<?>) getScenario_entries()).basicRemove(
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
		case BONPackage.SCENARIO_CHART__SYSTEM_NAME:
			if (resolve)
				return getSystem_name();
			return basicGetSystem_name();
		case BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES:
			return getScenario_entries();
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
		case BONPackage.SCENARIO_CHART__SYSTEM_NAME:
			setSystem_name((System_chart) newValue);
			return;
		case BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES:
			getScenario_entries().clear();
			getScenario_entries().addAll(
					(Collection<? extends Scenario>) newValue);
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
		case BONPackage.SCENARIO_CHART__SYSTEM_NAME:
			setSystem_name((System_chart) null);
			return;
		case BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES:
			getScenario_entries().clear();
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
		case BONPackage.SCENARIO_CHART__SYSTEM_NAME:
			return system_name != null;
		case BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES:
			return scenario_entries != null && !scenario_entries.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // Scenario_chartImpl
