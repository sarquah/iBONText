/**
 */
package org.emftext.language.BON.impl;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Cluster_chart;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Informal_charts;
import org.emftext.language.BON.Scenario_chart;
import org.emftext.language.BON.System_chart;
import org.emftext.language.BON.codegenerator.GenerateJavaCode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Informal charts</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Informal_chartsImpl#getSystem_chart <em>System chart</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Informal_chartsImpl#getClass_charts <em>Class charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Informal_chartsImpl#getCluster_charts <em>Cluster charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Informal_chartsImpl#getEvent_charts <em>Event charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Informal_chartsImpl#getScenario_charts <em>Scenario charts</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Informal_chartsImpl#getCreation_charts <em>Creation charts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Informal_chartsImpl extends EObjectImpl implements Informal_charts {
	/**
	 * The cached value of the '{@link #getSystem_chart() <em>System chart</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSystem_chart()
	 * @generated
	 * @ordered
	 */
	protected System_chart system_chart;

	/**
	 * The cached value of the '{@link #getClass_charts() <em>Class charts</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getClass_charts()
	 * @generated
	 * @ordered
	 */
	protected EList<Class_chart> class_charts;

	/**
	 * The cached value of the '{@link #getCluster_charts() <em>Cluster charts</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getCluster_charts()
	 * @generated
	 * @ordered
	 */
	protected EList<Cluster_chart> cluster_charts;

	/**
	 * The cached value of the '{@link #getEvent_charts() <em>Event charts</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getEvent_charts()
	 * @generated
	 * @ordered
	 */
	protected EList<Event_chart> event_charts;

	/**
	 * The cached value of the '{@link #getScenario_charts()
	 * <em>Scenario charts</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getScenario_charts()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario_chart> scenario_charts;

	/**
	 * The cached value of the '{@link #getCreation_charts()
	 * <em>Creation charts</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreation_charts()
	 * @generated
	 * @ordered
	 */
	protected EList<Creation_chart> creation_charts;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @author Stephen Sarquah
	 */
	protected Informal_chartsImpl() {
		super();
		final GenerateJavaCode generator = GenerateJavaCode
				.getGenerateJavaCode();
		generator.setInformalCharts(this);
		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification notification) {
				if (notification.getEventType() == Notification.REMOVING_ADAPTER && !generator.isGeneratingJava2Bon()) {
					if (Diagnostician.INSTANCE.validate(
							generator.getInformalCharts()).getSeverity() == Diagnostic.OK) {
						try {
							generator.generateCode();
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		this.eAdapters().add(adapter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.INFORMAL_CHARTS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public System_chart getSystem_chart() {
		return system_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem_chart(System_chart newSystem_chart,
			NotificationChain msgs) {
		System_chart oldSystem_chart = system_chart;
		system_chart = newSystem_chart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.INFORMAL_CHARTS__SYSTEM_CHART,
					oldSystem_chart, newSystem_chart);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem_chart(System_chart newSystem_chart) {
		if (newSystem_chart != system_chart) {
			NotificationChain msgs = null;
			if (system_chart != null)
				msgs = ((InternalEObject) system_chart).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.INFORMAL_CHARTS__SYSTEM_CHART,
						null, msgs);
			if (newSystem_chart != null)
				msgs = ((InternalEObject) newSystem_chart).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.INFORMAL_CHARTS__SYSTEM_CHART,
						null, msgs);
			msgs = basicSetSystem_chart(newSystem_chart, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.INFORMAL_CHARTS__SYSTEM_CHART, newSystem_chart,
					newSystem_chart));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Class_chart> getClass_charts() {
		if (class_charts == null) {
			class_charts = new EObjectContainmentEList<Class_chart>(
					Class_chart.class, this,
					BONPackage.INFORMAL_CHARTS__CLASS_CHARTS);
		}
		return class_charts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cluster_chart> getCluster_charts() {
		if (cluster_charts == null) {
			cluster_charts = new EObjectContainmentEList<Cluster_chart>(
					Cluster_chart.class, this,
					BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS);
		}
		return cluster_charts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event_chart> getEvent_charts() {
		if (event_charts == null) {
			event_charts = new EObjectContainmentEList<Event_chart>(
					Event_chart.class, this,
					BONPackage.INFORMAL_CHARTS__EVENT_CHARTS);
		}
		return event_charts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario_chart> getScenario_charts() {
		if (scenario_charts == null) {
			scenario_charts = new EObjectContainmentEList<Scenario_chart>(
					Scenario_chart.class, this,
					BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS);
		}
		return scenario_charts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Creation_chart> getCreation_charts() {
		if (creation_charts == null) {
			creation_charts = new EObjectContainmentEList<Creation_chart>(
					Creation_chart.class, this,
					BONPackage.INFORMAL_CHARTS__CREATION_CHARTS);
		}
		return creation_charts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.INFORMAL_CHARTS__SYSTEM_CHART:
			return basicSetSystem_chart(null, msgs);
		case BONPackage.INFORMAL_CHARTS__CLASS_CHARTS:
			return ((InternalEList<?>) getClass_charts()).basicRemove(otherEnd,
					msgs);
		case BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS:
			return ((InternalEList<?>) getCluster_charts()).basicRemove(
					otherEnd, msgs);
		case BONPackage.INFORMAL_CHARTS__EVENT_CHARTS:
			return ((InternalEList<?>) getEvent_charts()).basicRemove(otherEnd,
					msgs);
		case BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS:
			return ((InternalEList<?>) getScenario_charts()).basicRemove(
					otherEnd, msgs);
		case BONPackage.INFORMAL_CHARTS__CREATION_CHARTS:
			return ((InternalEList<?>) getCreation_charts()).basicRemove(
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
		case BONPackage.INFORMAL_CHARTS__SYSTEM_CHART:
			return getSystem_chart();
		case BONPackage.INFORMAL_CHARTS__CLASS_CHARTS:
			return getClass_charts();
		case BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS:
			return getCluster_charts();
		case BONPackage.INFORMAL_CHARTS__EVENT_CHARTS:
			return getEvent_charts();
		case BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS:
			return getScenario_charts();
		case BONPackage.INFORMAL_CHARTS__CREATION_CHARTS:
			return getCreation_charts();
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
		case BONPackage.INFORMAL_CHARTS__SYSTEM_CHART:
			setSystem_chart((System_chart) newValue);
			return;
		case BONPackage.INFORMAL_CHARTS__CLASS_CHARTS:
			getClass_charts().clear();
			getClass_charts().addAll(
					(Collection<? extends Class_chart>) newValue);
			return;
		case BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS:
			getCluster_charts().clear();
			getCluster_charts().addAll(
					(Collection<? extends Cluster_chart>) newValue);
			return;
		case BONPackage.INFORMAL_CHARTS__EVENT_CHARTS:
			getEvent_charts().clear();
			getEvent_charts().addAll(
					(Collection<? extends Event_chart>) newValue);
			return;
		case BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS:
			getScenario_charts().clear();
			getScenario_charts().addAll(
					(Collection<? extends Scenario_chart>) newValue);
			return;
		case BONPackage.INFORMAL_CHARTS__CREATION_CHARTS:
			getCreation_charts().clear();
			getCreation_charts().addAll(
					(Collection<? extends Creation_chart>) newValue);
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
		case BONPackage.INFORMAL_CHARTS__SYSTEM_CHART:
			setSystem_chart((System_chart) null);
			return;
		case BONPackage.INFORMAL_CHARTS__CLASS_CHARTS:
			getClass_charts().clear();
			return;
		case BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS:
			getCluster_charts().clear();
			return;
		case BONPackage.INFORMAL_CHARTS__EVENT_CHARTS:
			getEvent_charts().clear();
			return;
		case BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS:
			getScenario_charts().clear();
			return;
		case BONPackage.INFORMAL_CHARTS__CREATION_CHARTS:
			getCreation_charts().clear();
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
		case BONPackage.INFORMAL_CHARTS__SYSTEM_CHART:
			return system_chart != null;
		case BONPackage.INFORMAL_CHARTS__CLASS_CHARTS:
			return class_charts != null && !class_charts.isEmpty();
		case BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS:
			return cluster_charts != null && !cluster_charts.isEmpty();
		case BONPackage.INFORMAL_CHARTS__EVENT_CHARTS:
			return event_charts != null && !event_charts.isEmpty();
		case BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS:
			return scenario_charts != null && !scenario_charts.isEmpty();
		case BONPackage.INFORMAL_CHARTS__CREATION_CHARTS:
			return creation_charts != null && !creation_charts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // Informal_chartsImpl
