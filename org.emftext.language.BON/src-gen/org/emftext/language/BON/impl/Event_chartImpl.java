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
import org.emftext.language.BON.Event;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Event_type;
import org.emftext.language.BON.NamedElement;
import org.emftext.language.BON.System_chart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Event chart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Event_chartImpl#getSystem_name <em>System name</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Event_chartImpl#getEvent_entries <em>Event entries</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Event_chartImpl#getEvent_type <em>Event type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Event_chartImpl extends ChartImpl implements Event_chart {
	/**
	 * The cached value of the '{@link #getSystem_name() <em>System name</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSystem_name()
	 * @generated
	 * @ordered
	 */
	protected System_chart system_name;

	/**
	 * The cached value of the '{@link #getEvent_entries() <em>Event entries</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getEvent_entries()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> event_entries;

	/**
	 * The default value of the '{@link #getEvent_type() <em>Event type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEvent_type()
	 * @generated
	 * @ordered
	 */
	protected static final Event_type EVENT_TYPE_EDEFAULT = Event_type.INCOMING;

	/**
	 * The cached value of the '{@link #getEvent_type() <em>Event type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEvent_type()
	 * @generated
	 * @ordered
	 */
	protected Event_type event_type = EVENT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Event_chartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.EVENT_CHART;
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
							BONPackage.EVENT_CHART__SYSTEM_NAME,
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
					BONPackage.EVENT_CHART__SYSTEM_NAME, oldSystem_name,
					system_name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvent_entries() {
		if (event_entries == null) {
			event_entries = new EObjectContainmentEList<Event>(Event.class,
					this, BONPackage.EVENT_CHART__EVENT_ENTRIES);
		}
		return event_entries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Event_type getEvent_type() {
		return event_type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent_type(Event_type newEvent_type) {
		Event_type oldEvent_type = event_type;
		event_type = newEvent_type == null ? EVENT_TYPE_EDEFAULT
				: newEvent_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.EVENT_CHART__EVENT_TYPE, oldEvent_type,
					event_type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.EVENT_CHART__EVENT_ENTRIES:
			return ((InternalEList<?>) getEvent_entries()).basicRemove(
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
		case BONPackage.EVENT_CHART__SYSTEM_NAME:
			if (resolve)
				return getSystem_name();
			return basicGetSystem_name();
		case BONPackage.EVENT_CHART__EVENT_ENTRIES:
			return getEvent_entries();
		case BONPackage.EVENT_CHART__EVENT_TYPE:
			return getEvent_type();
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
		case BONPackage.EVENT_CHART__SYSTEM_NAME:
			setSystem_name((System_chart) newValue);
			return;
		case BONPackage.EVENT_CHART__EVENT_ENTRIES:
			getEvent_entries().clear();
			getEvent_entries().addAll((Collection<? extends Event>) newValue);
			return;
		case BONPackage.EVENT_CHART__EVENT_TYPE:
			setEvent_type((Event_type) newValue);
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
		case BONPackage.EVENT_CHART__SYSTEM_NAME:
			setSystem_name((System_chart) null);
			return;
		case BONPackage.EVENT_CHART__EVENT_ENTRIES:
			getEvent_entries().clear();
			return;
		case BONPackage.EVENT_CHART__EVENT_TYPE:
			setEvent_type(EVENT_TYPE_EDEFAULT);
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
		case BONPackage.EVENT_CHART__SYSTEM_NAME:
			return system_name != null;
		case BONPackage.EVENT_CHART__EVENT_ENTRIES:
			return event_entries != null && !event_entries.isEmpty();
		case BONPackage.EVENT_CHART__EVENT_TYPE:
			return event_type != EVENT_TYPE_EDEFAULT;
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
		result.append(" (event_type: ");
		result.append(event_type);
		result.append(')');
		return result.toString();
	}

} // Event_chartImpl
