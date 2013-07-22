/**
 */
package org.emftext.language.BON.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Chart;
import org.emftext.language.BON.Explanation;
import org.emftext.language.BON.Indexing;
import org.emftext.language.BON.Part;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Chart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.ChartImpl#getChart_indexing <em>Chart indexing</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.ChartImpl#getExplanation <em>Explanation</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.ChartImpl#getChart_part <em>Chart part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChartImpl extends EObjectImpl implements Chart {
	/**
	 * The cached value of the '{@link #getChart_indexing() <em>Chart indexing</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChart_indexing()
	 * @generated
	 * @ordered
	 */
	protected Indexing chart_indexing;

	/**
	 * The cached value of the '{@link #getExplanation() <em>Explanation</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExplanation()
	 * @generated
	 * @ordered
	 */
	protected Explanation explanation;

	/**
	 * The cached value of the '{@link #getChart_part() <em>Chart part</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChart_part()
	 * @generated
	 * @ordered
	 */
	protected Part chart_part;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.CHART;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Explanation getExplanation() {
		return explanation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExplanation(Explanation newExplanation,
			NotificationChain msgs) {
		Explanation oldExplanation = explanation;
		explanation = newExplanation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.CHART__EXPLANATION,
					oldExplanation, newExplanation);
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
	public void setExplanation(Explanation newExplanation) {
		if (newExplanation != explanation) {
			NotificationChain msgs = null;
			if (explanation != null)
				msgs = ((InternalEObject) explanation).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BONPackage.CHART__EXPLANATION,
						null, msgs);
			if (newExplanation != null)
				msgs = ((InternalEObject) newExplanation).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BONPackage.CHART__EXPLANATION,
						null, msgs);
			msgs = basicSetExplanation(newExplanation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CHART__EXPLANATION, newExplanation,
					newExplanation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Part getChart_part() {
		return chart_part;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChart_part(Part newChart_part,
			NotificationChain msgs) {
		Part oldChart_part = chart_part;
		chart_part = newChart_part;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.CHART__CHART_PART,
					oldChart_part, newChart_part);
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
	public void setChart_part(Part newChart_part) {
		if (newChart_part != chart_part) {
			NotificationChain msgs = null;
			if (chart_part != null)
				msgs = ((InternalEObject) chart_part).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BONPackage.CHART__CHART_PART,
						null, msgs);
			if (newChart_part != null)
				msgs = ((InternalEObject) newChart_part).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BONPackage.CHART__CHART_PART,
						null, msgs);
			msgs = basicSetChart_part(newChart_part, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CHART__CHART_PART, newChart_part, newChart_part));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Indexing getChart_indexing() {
		return chart_indexing;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChart_indexing(Indexing newChart_indexing,
			NotificationChain msgs) {
		Indexing oldChart_indexing = chart_indexing;
		chart_indexing = newChart_indexing;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.CHART__CHART_INDEXING,
					oldChart_indexing, newChart_indexing);
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
	public void setChart_indexing(Indexing newChart_indexing) {
		if (newChart_indexing != chart_indexing) {
			NotificationChain msgs = null;
			if (chart_indexing != null)
				msgs = ((InternalEObject) chart_indexing).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CHART__CHART_INDEXING, null, msgs);
			if (newChart_indexing != null)
				msgs = ((InternalEObject) newChart_indexing).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CHART__CHART_INDEXING, null, msgs);
			msgs = basicSetChart_indexing(newChart_indexing, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CHART__CHART_INDEXING, newChart_indexing,
					newChart_indexing));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.CHART__CHART_INDEXING:
			return basicSetChart_indexing(null, msgs);
		case BONPackage.CHART__EXPLANATION:
			return basicSetExplanation(null, msgs);
		case BONPackage.CHART__CHART_PART:
			return basicSetChart_part(null, msgs);
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
		case BONPackage.CHART__CHART_INDEXING:
			return getChart_indexing();
		case BONPackage.CHART__EXPLANATION:
			return getExplanation();
		case BONPackage.CHART__CHART_PART:
			return getChart_part();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BONPackage.CHART__CHART_INDEXING:
			setChart_indexing((Indexing) newValue);
			return;
		case BONPackage.CHART__EXPLANATION:
			setExplanation((Explanation) newValue);
			return;
		case BONPackage.CHART__CHART_PART:
			setChart_part((Part) newValue);
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
		case BONPackage.CHART__CHART_INDEXING:
			setChart_indexing((Indexing) null);
			return;
		case BONPackage.CHART__EXPLANATION:
			setExplanation((Explanation) null);
			return;
		case BONPackage.CHART__CHART_PART:
			setChart_part((Part) null);
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
		case BONPackage.CHART__CHART_INDEXING:
			return chart_indexing != null;
		case BONPackage.CHART__EXPLANATION:
			return explanation != null;
		case BONPackage.CHART__CHART_PART:
			return chart_part != null;
		}
		return super.eIsSet(featureID);
	}

} // ChartImpl
