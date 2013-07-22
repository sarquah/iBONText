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
import org.emftext.language.BON.ClassBON;
import org.emftext.language.BON.Cluster;
import org.emftext.language.BON.Cluster_chart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cluster chart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Cluster_chartImpl#getClass_entries <em>Class entries</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Cluster_chartImpl#getCluster <em>Cluster</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Cluster_chartImpl#getClusterchart_entries <em>Clusterchart entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Cluster_chartImpl extends ChartImpl implements Cluster_chart {
	/**
	 * The cached value of the '{@link #getClass_entries() <em>Class entries</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getClass_entries()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassBON> class_entries;

	/**
	 * The cached value of the '{@link #getCluster() <em>Cluster</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCluster()
	 * @generated
	 * @ordered
	 */
	protected Cluster cluster;

	/**
	 * The cached value of the '{@link #getClusterchart_entries()
	 * <em>Clusterchart entries</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClusterchart_entries()
	 * @generated
	 * @ordered
	 */
	protected EList<Cluster> clusterchart_entries;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Cluster_chartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.CLUSTER_CHART;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassBON> getClass_entries() {
		if (class_entries == null) {
			class_entries = new EObjectContainmentEList<ClassBON>(
					ClassBON.class, this,
					BONPackage.CLUSTER_CHART__CLASS_ENTRIES);
		}
		return class_entries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Cluster getCluster() {
		if (cluster != null && cluster.eIsProxy()) {
			InternalEObject oldCluster = (InternalEObject) cluster;
			cluster = (Cluster) eResolveProxy(oldCluster);
			if (cluster != oldCluster) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BONPackage.CLUSTER_CHART__CLUSTER, oldCluster,
							cluster));
			}
		}
		return cluster;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Cluster basicGetCluster() {
		return cluster;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCluster(Cluster newCluster) {
		Cluster oldCluster = cluster;
		cluster = newCluster;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CLUSTER_CHART__CLUSTER, oldCluster, cluster));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cluster> getClusterchart_entries() {
		if (clusterchart_entries == null) {
			clusterchart_entries = new EObjectContainmentEList<Cluster>(
					Cluster.class, this,
					BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES);
		}
		return clusterchart_entries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.CLUSTER_CHART__CLASS_ENTRIES:
			return ((InternalEList<?>) getClass_entries()).basicRemove(
					otherEnd, msgs);
		case BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES:
			return ((InternalEList<?>) getClusterchart_entries()).basicRemove(
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
		case BONPackage.CLUSTER_CHART__CLASS_ENTRIES:
			return getClass_entries();
		case BONPackage.CLUSTER_CHART__CLUSTER:
			if (resolve)
				return getCluster();
			return basicGetCluster();
		case BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES:
			return getClusterchart_entries();
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
		case BONPackage.CLUSTER_CHART__CLASS_ENTRIES:
			getClass_entries().clear();
			getClass_entries()
					.addAll((Collection<? extends ClassBON>) newValue);
			return;
		case BONPackage.CLUSTER_CHART__CLUSTER:
			setCluster((Cluster) newValue);
			return;
		case BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES:
			getClusterchart_entries().clear();
			getClusterchart_entries().addAll(
					(Collection<? extends Cluster>) newValue);
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
		case BONPackage.CLUSTER_CHART__CLASS_ENTRIES:
			getClass_entries().clear();
			return;
		case BONPackage.CLUSTER_CHART__CLUSTER:
			setCluster((Cluster) null);
			return;
		case BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES:
			getClusterchart_entries().clear();
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
		case BONPackage.CLUSTER_CHART__CLASS_ENTRIES:
			return class_entries != null && !class_entries.isEmpty();
		case BONPackage.CLUSTER_CHART__CLUSTER:
			return cluster != null;
		case BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES:
			return clusterchart_entries != null
					&& !clusterchart_entries.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // Cluster_chartImpl
