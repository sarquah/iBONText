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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.ClassBON;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Commands;
import org.emftext.language.BON.Constraints;
import org.emftext.language.BON.Queries;
import org.emftext.language.BON.Command;
import org.emftext.language.BON.Constraint;
import org.emftext.language.BON.Query;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Class chart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.Class_chartImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Class_chartImpl#getInherit <em>Inherit</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Class_chartImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Class_chartImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.Class_chartImpl#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Class_chartImpl extends ChartImpl implements Class_chart {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected ClassBON class_;

	/**
	 * The cached value of the '{@link #getInherit() <em>Inherit</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInherit()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassBON> inherit;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected Commands commands;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected Constraints constraints;

	/**
	 * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getQueries()
	 * @generated
	 * @ordered
	 */
	protected Queries queries;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Class_chartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.CLASS_CHART;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBON getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject) class_;
			class_ = (ClassBON) eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BONPackage.CLASS_CHART__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBON basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(ClassBON newClass) {
		ClassBON oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CLASS_CHART__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassBON> getInherit() {
		if (inherit == null) {
			inherit = new EObjectResolvingEList<ClassBON>(ClassBON.class, this,
					BONPackage.CLASS_CHART__INHERIT);
		}
		return inherit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Commands getCommands() {
		return commands;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommands(Commands newCommands,
			NotificationChain msgs) {
		Commands oldCommands = commands;
		commands = newCommands;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.CLASS_CHART__COMMANDS,
					oldCommands, newCommands);
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
	public void setCommands(Commands newCommands) {
		if (newCommands != commands) {
			NotificationChain msgs = null;
			if (commands != null)
				msgs = ((InternalEObject) commands).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CLASS_CHART__COMMANDS, null, msgs);
			if (newCommands != null)
				msgs = ((InternalEObject) newCommands).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CLASS_CHART__COMMANDS, null, msgs);
			msgs = basicSetCommands(newCommands, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CLASS_CHART__COMMANDS, newCommands, newCommands));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Constraints getConstraints() {
		return constraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraints(Constraints newConstraints,
			NotificationChain msgs) {
		Constraints oldConstraints = constraints;
		constraints = newConstraints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.CLASS_CHART__CONSTRAINTS,
					oldConstraints, newConstraints);
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
	public void setConstraints(Constraints newConstraints) {
		if (newConstraints != constraints) {
			NotificationChain msgs = null;
			if (constraints != null)
				msgs = ((InternalEObject) constraints).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CLASS_CHART__CONSTRAINTS, null,
						msgs);
			if (newConstraints != null)
				msgs = ((InternalEObject) newConstraints).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CLASS_CHART__CONSTRAINTS, null,
						msgs);
			msgs = basicSetConstraints(newConstraints, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CLASS_CHART__CONSTRAINTS, newConstraints,
					newConstraints));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Queries getQueries() {
		return queries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQueries(Queries newQueries,
			NotificationChain msgs) {
		Queries oldQueries = queries;
		queries = newQueries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BONPackage.CLASS_CHART__QUERIES,
					oldQueries, newQueries);
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
	public void setQueries(Queries newQueries) {
		if (newQueries != queries) {
			NotificationChain msgs = null;
			if (queries != null)
				msgs = ((InternalEObject) queries).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CLASS_CHART__QUERIES, null, msgs);
			if (newQueries != null)
				msgs = ((InternalEObject) newQueries).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BONPackage.CLASS_CHART__QUERIES, null, msgs);
			msgs = basicSetQueries(newQueries, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CLASS_CHART__QUERIES, newQueries, newQueries));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BONPackage.CLASS_CHART__COMMANDS:
			return basicSetCommands(null, msgs);
		case BONPackage.CLASS_CHART__CONSTRAINTS:
			return basicSetConstraints(null, msgs);
		case BONPackage.CLASS_CHART__QUERIES:
			return basicSetQueries(null, msgs);
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
		case BONPackage.CLASS_CHART__CLASS:
			if (resolve)
				return getClass_();
			return basicGetClass();
		case BONPackage.CLASS_CHART__INHERIT:
			return getInherit();
		case BONPackage.CLASS_CHART__COMMANDS:
			return getCommands();
		case BONPackage.CLASS_CHART__CONSTRAINTS:
			return getConstraints();
		case BONPackage.CLASS_CHART__QUERIES:
			return getQueries();
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
		case BONPackage.CLASS_CHART__CLASS:
			setClass((ClassBON) newValue);
			return;
		case BONPackage.CLASS_CHART__INHERIT:
			getInherit().clear();
			getInherit().addAll((Collection<? extends ClassBON>) newValue);
			return;
		case BONPackage.CLASS_CHART__COMMANDS:
			setCommands((Commands) newValue);
			return;
		case BONPackage.CLASS_CHART__CONSTRAINTS:
			setConstraints((Constraints) newValue);
			return;
		case BONPackage.CLASS_CHART__QUERIES:
			setQueries((Queries) newValue);
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
		case BONPackage.CLASS_CHART__CLASS:
			setClass((ClassBON) null);
			return;
		case BONPackage.CLASS_CHART__INHERIT:
			getInherit().clear();
			return;
		case BONPackage.CLASS_CHART__COMMANDS:
			setCommands((Commands) null);
			return;
		case BONPackage.CLASS_CHART__CONSTRAINTS:
			setConstraints((Constraints) null);
			return;
		case BONPackage.CLASS_CHART__QUERIES:
			setQueries((Queries) null);
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
		case BONPackage.CLASS_CHART__CLASS:
			return class_ != null;
		case BONPackage.CLASS_CHART__INHERIT:
			return inherit != null && !inherit.isEmpty();
		case BONPackage.CLASS_CHART__COMMANDS:
			return commands != null;
		case BONPackage.CLASS_CHART__CONSTRAINTS:
			return constraints != null;
		case BONPackage.CLASS_CHART__QUERIES:
			return queries != null;
		}
		return super.eIsSet(featureID);
	}

} // Class_chartImpl
