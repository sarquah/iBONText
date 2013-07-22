/**
 */
package org.emftext.language.BON.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.ClassBON;
import org.emftext.language.BON.Creation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Creation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.BON.impl.CreationImpl#getCreator <em>Creator</em>}</li>
 *   <li>{@link org.emftext.language.BON.impl.CreationImpl#getCreates <em>Creates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreationImpl extends EObjectImpl implements Creation {
	/**
	 * The cached value of the '{@link #getCreator() <em>Creator</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected ClassBON creator;

	/**
	 * The cached value of the '{@link #getCreates() <em>Creates</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreates()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassBON> creates;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CreationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BONPackage.Literals.CREATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBON getCreator() {
		if (creator != null && creator.eIsProxy()) {
			InternalEObject oldCreator = (InternalEObject) creator;
			creator = (ClassBON) eResolveProxy(oldCreator);
			if (creator != oldCreator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BONPackage.CREATION__CREATOR, oldCreator, creator));
			}
		}
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBON basicGetCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreator(ClassBON newCreator) {
		ClassBON oldCreator = creator;
		creator = newCreator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BONPackage.CREATION__CREATOR, oldCreator, creator));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassBON> getCreates() {
		if (creates == null) {
			creates = new EObjectResolvingEList<ClassBON>(ClassBON.class, this,
					BONPackage.CREATION__CREATES);
		}
		return creates;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BONPackage.CREATION__CREATOR:
			if (resolve)
				return getCreator();
			return basicGetCreator();
		case BONPackage.CREATION__CREATES:
			return getCreates();
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
		case BONPackage.CREATION__CREATOR:
			setCreator((ClassBON) newValue);
			return;
		case BONPackage.CREATION__CREATES:
			getCreates().clear();
			getCreates().addAll((Collection<? extends ClassBON>) newValue);
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
		case BONPackage.CREATION__CREATOR:
			setCreator((ClassBON) null);
			return;
		case BONPackage.CREATION__CREATES:
			getCreates().clear();
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
		case BONPackage.CREATION__CREATOR:
			return creator != null;
		case BONPackage.CREATION__CREATES:
			return creates != null && !creates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // CreationImpl
