/**
 */
package org.emftext.language.BON.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.emftext.language.BON.BONFactory;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Informal_charts;

/**
 * This is the item provider adapter for a {@link org.emftext.language.BON.Informal_charts} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class Informal_chartsItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Informal_chartsItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(BONPackage.Literals.INFORMAL_CHARTS__SYSTEM_CHART);
			childrenFeatures
					.add(BONPackage.Literals.INFORMAL_CHARTS__CLASS_CHARTS);
			childrenFeatures
					.add(BONPackage.Literals.INFORMAL_CHARTS__CLUSTER_CHARTS);
			childrenFeatures
					.add(BONPackage.Literals.INFORMAL_CHARTS__EVENT_CHARTS);
			childrenFeatures
					.add(BONPackage.Literals.INFORMAL_CHARTS__SCENARIO_CHARTS);
			childrenFeatures
					.add(BONPackage.Literals.INFORMAL_CHARTS__CREATION_CHARTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Informal_charts.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/Informal_charts"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Informal_charts_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Informal_charts.class)) {
		case BONPackage.INFORMAL_CHARTS__SYSTEM_CHART:
		case BONPackage.INFORMAL_CHARTS__CLASS_CHARTS:
		case BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS:
		case BONPackage.INFORMAL_CHARTS__EVENT_CHARTS:
		case BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS:
		case BONPackage.INFORMAL_CHARTS__CREATION_CHARTS:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				BONPackage.Literals.INFORMAL_CHARTS__SYSTEM_CHART,
				BONFactory.eINSTANCE.createSystem_chart()));

		newChildDescriptors.add(createChildParameter(
				BONPackage.Literals.INFORMAL_CHARTS__CLASS_CHARTS,
				BONFactory.eINSTANCE.createClass_chart()));

		newChildDescriptors.add(createChildParameter(
				BONPackage.Literals.INFORMAL_CHARTS__CLUSTER_CHARTS,
				BONFactory.eINSTANCE.createCluster_chart()));

		newChildDescriptors.add(createChildParameter(
				BONPackage.Literals.INFORMAL_CHARTS__EVENT_CHARTS,
				BONFactory.eINSTANCE.createEvent_chart()));

		newChildDescriptors.add(createChildParameter(
				BONPackage.Literals.INFORMAL_CHARTS__SCENARIO_CHARTS,
				BONFactory.eINSTANCE.createScenario_chart()));

		newChildDescriptors.add(createChildParameter(
				BONPackage.Literals.INFORMAL_CHARTS__CREATION_CHARTS,
				BONFactory.eINSTANCE.createCreation_chart()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return BONEditPlugin.INSTANCE;
	}

}
