/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonReferenceResolverSwitch implements org.emftext.language.BON.resource.bon.IBonReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.emftext.language.BON.resource.bon.analysis.Cluster_chartClusterReferenceResolver cluster_chartClusterReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.Cluster_chartClusterReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.Class_chartClassReferenceResolver class_chartClassReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.Class_chartClassReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.Class_chartInheritReferenceResolver class_chartInheritReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.Class_chartInheritReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.Event_chartSystem_nameReferenceResolver event_chartSystem_nameReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.Event_chartSystem_nameReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.EventInvolvesReferenceResolver eventInvolvesReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.EventInvolvesReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.Scenario_chartSystem_nameReferenceResolver scenario_chartSystem_nameReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.Scenario_chartSystem_nameReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.Creation_chartSystem_nameReferenceResolver creation_chartSystem_nameReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.Creation_chartSystem_nameReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.CreationCreatorReferenceResolver creationCreatorReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.CreationCreatorReferenceResolver();
	protected org.emftext.language.BON.resource.bon.analysis.CreationCreatesReferenceResolver creationCreatesReferenceResolver = new org.emftext.language.BON.resource.bon.analysis.CreationCreatesReferenceResolver();
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Cluster_chart, org.emftext.language.BON.Cluster> getCluster_chartClusterReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart_Cluster(), cluster_chartClusterReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Class_chart, org.emftext.language.BON.ClassBON> getClass_chartClassReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart_Class(), class_chartClassReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Class_chart, org.emftext.language.BON.ClassBON> getClass_chartInheritReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart_Inherit(), class_chartInheritReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Event_chart, org.emftext.language.BON.System_chart> getEvent_chartSystem_nameReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart_System_name(), event_chartSystem_nameReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Event, org.emftext.language.BON.ClassBON> getEventInvolvesReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_Involves(), eventInvolvesReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Scenario_chart, org.emftext.language.BON.System_chart> getScenario_chartSystem_nameReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart_System_name(), scenario_chartSystem_nameReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Creation_chart, org.emftext.language.BON.System_chart> getCreation_chartSystem_nameReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart_System_name(), creation_chartSystem_nameReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Creation, org.emftext.language.BON.ClassBON> getCreationCreatorReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_Creator(), creationCreatorReferenceResolver);
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<org.emftext.language.BON.Creation, org.emftext.language.BON.ClassBON> getCreationCreatesReferenceResolver() {
		return getResolverChain(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_Creates(), creationCreatesReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		cluster_chartClusterReferenceResolver.setOptions(options);
		class_chartClassReferenceResolver.setOptions(options);
		class_chartInheritReferenceResolver.setOptions(options);
		event_chartSystem_nameReferenceResolver.setOptions(options);
		eventInvolvesReferenceResolver.setOptions(options);
		scenario_chartSystem_nameReferenceResolver.setOptions(options);
		creation_chartSystem_nameReferenceResolver.setOptions(options);
		creationCreatorReferenceResolver.setOptions(options);
		creationCreatesReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.BON.resource.bon.IBonReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.Cluster> frr = new BonFuzzyResolveResult<org.emftext.language.BON.Cluster>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("cluster")) {
				cluster_chartClusterReferenceResolver.resolve(identifier, (org.emftext.language.BON.Cluster_chart) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.ClassBON> frr = new BonFuzzyResolveResult<org.emftext.language.BON.ClassBON>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("class")) {
				class_chartClassReferenceResolver.resolve(identifier, (org.emftext.language.BON.Class_chart) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.ClassBON> frr = new BonFuzzyResolveResult<org.emftext.language.BON.ClassBON>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("inherit")) {
				class_chartInheritReferenceResolver.resolve(identifier, (org.emftext.language.BON.Class_chart) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.System_chart> frr = new BonFuzzyResolveResult<org.emftext.language.BON.System_chart>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("system_name")) {
				event_chartSystem_nameReferenceResolver.resolve(identifier, (org.emftext.language.BON.Event_chart) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getEvent().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.ClassBON> frr = new BonFuzzyResolveResult<org.emftext.language.BON.ClassBON>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("involves")) {
				eventInvolvesReferenceResolver.resolve(identifier, (org.emftext.language.BON.Event) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.System_chart> frr = new BonFuzzyResolveResult<org.emftext.language.BON.System_chart>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("system_name")) {
				scenario_chartSystem_nameReferenceResolver.resolve(identifier, (org.emftext.language.BON.Scenario_chart) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.System_chart> frr = new BonFuzzyResolveResult<org.emftext.language.BON.System_chart>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("system_name")) {
				creation_chartSystem_nameReferenceResolver.resolve(identifier, (org.emftext.language.BON.Creation_chart) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getCreation().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.ClassBON> frr = new BonFuzzyResolveResult<org.emftext.language.BON.ClassBON>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("creator")) {
				creationCreatorReferenceResolver.resolve(identifier, (org.emftext.language.BON.Creation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.BON.BONPackage.eINSTANCE.getCreation().isInstance(container)) {
			BonFuzzyResolveResult<org.emftext.language.BON.ClassBON> frr = new BonFuzzyResolveResult<org.emftext.language.BON.ClassBON>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("creates")) {
				creationCreatesReferenceResolver.resolve(identifier, (org.emftext.language.BON.Creation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart_Cluster()) {
			return getResolverChain(reference, cluster_chartClusterReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart_Class()) {
			return getResolverChain(reference, class_chartClassReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart_Inherit()) {
			return getResolverChain(reference, class_chartInheritReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart_System_name()) {
			return getResolverChain(reference, event_chartSystem_nameReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_Involves()) {
			return getResolverChain(reference, eventInvolvesReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart_System_name()) {
			return getResolverChain(reference, scenario_chartSystem_nameReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart_System_name()) {
			return getResolverChain(reference, creation_chartSystem_nameReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_Creator()) {
			return getResolverChain(reference, creationCreatorReferenceResolver);
		}
		if (reference == org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_Creates()) {
			return getResolverChain(reference, creationCreatesReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.language.BON.resource.bon.IBonReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.language.BON.resource.bon.IBonReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.language.BON.resource.bon.IBonOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.language.BON.resource.bon.util.BonRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.language.BON.resource.bon.IBonOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.language.BON.resource.bon.IBonReferenceResolver) {
			org.emftext.language.BON.resource.bon.IBonReferenceResolver replacingResolver = (org.emftext.language.BON.resource.bon.IBonReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.language.BON.resource.bon.IBonDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.language.BON.resource.bon.IBonDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.emftext.language.BON.resource.bon.IBonReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.language.BON.resource.bon.IBonReferenceCache) {
					org.emftext.language.BON.resource.bon.IBonReferenceResolver nextResolver = (org.emftext.language.BON.resource.bon.IBonReferenceResolver) next;
					if (nextResolver instanceof org.emftext.language.BON.resource.bon.IBonDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.language.BON.resource.bon.IBonDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.language.BON.resource.bon.util.BonRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.BON.resource.bon.IBonOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.BON.resource.bon.IBonDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.language.BON.resource.bon.util.BonRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.BON.resource.bon.IBonOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.BON.resource.bon.IBonDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
