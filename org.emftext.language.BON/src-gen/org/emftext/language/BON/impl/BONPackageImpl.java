/**
 */
package org.emftext.language.BON.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.emftext.language.BON.BONFactory;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Chart;
import org.emftext.language.BON.ClassBON;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Cluster;
import org.emftext.language.BON.Cluster_chart;
import org.emftext.language.BON.Command;
import org.emftext.language.BON.Commands;
import org.emftext.language.BON.Constraint;
import org.emftext.language.BON.Constraints;
import org.emftext.language.BON.Creation;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.DescriptionElement;
import org.emftext.language.BON.Event;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Event_type;
import org.emftext.language.BON.Explanation;
import org.emftext.language.BON.Index_Identifier;
import org.emftext.language.BON.Indexing;
import org.emftext.language.BON.Informal_charts;
import org.emftext.language.BON.NamedElement;
import org.emftext.language.BON.Part;
import org.emftext.language.BON.Queries;
import org.emftext.language.BON.Query;
import org.emftext.language.BON.Scenario;
import org.emftext.language.BON.Scenario_chart;
import org.emftext.language.BON.System_chart;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class BONPackageImpl extends EPackageImpl implements BONPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass system_chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clusterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cluster_chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass class_chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classBONEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informal_chartsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass explanationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass index_IdentifierEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queriesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass event_chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenario_chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass creation_chartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass creationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum event_typeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emftext.language.BON.BONPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BONPackageImpl() {
		super(eNS_URI, BONFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link BONPackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BONPackage init() {
		if (isInited)
			return (BONPackage) EPackage.Registry.INSTANCE
					.getEPackage(BONPackage.eNS_URI);

		// Obtain or create and register package
		BONPackageImpl theBONPackage = (BONPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof BONPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new BONPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBONPackage.createPackageContents();

		// Initialize created meta-data
		theBONPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBONPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BONPackage.eNS_URI, theBONPackage);
		return theBONPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem_chart() {
		return system_chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_chart_Cluster_entries() {
		return (EReference) system_chartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChart() {
		return chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChart_Explanation() {
		return (EReference) chartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChart_Chart_part() {
		return (EReference) chartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChart_Chart_indexing() {
		return (EReference) chartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCluster() {
		return clusterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCluster_Parent() {
		return (EReference) clusterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCluster_chart() {
		return cluster_chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCluster_chart_Class_entries() {
		return (EReference) cluster_chartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCluster_chart_Cluster() {
		return (EReference) cluster_chartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCluster_chart_Clusterchart_entries() {
		return (EReference) cluster_chartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_chart() {
		return class_chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_chart_Class() {
		return (EReference) class_chartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_chart_Inherit() {
		return (EReference) class_chartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_chart_Commands() {
		return (EReference) class_chartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_chart_Constraints() {
		return (EReference) class_chartEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_chart_Queries() {
		return (EReference) class_chartEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionElement() {
		return descriptionElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionElement_Description() {
		return (EAttribute) descriptionElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexing() {
		return indexingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexing_Index_term_list() {
		return (EReference) indexingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassBON() {
		return classBONEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassBON_Parent() {
		return (EReference) classBONEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInformal_charts() {
		return informal_chartsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformal_charts_System_chart() {
		return (EReference) informal_chartsEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformal_charts_Class_charts() {
		return (EReference) informal_chartsEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformal_charts_Cluster_charts() {
		return (EReference) informal_chartsEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformal_charts_Event_charts() {
		return (EReference) informal_chartsEClass.getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformal_charts_Scenario_charts() {
		return (EReference) informal_chartsEClass.getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformal_charts_Creation_charts() {
		return (EReference) informal_chartsEClass.getEStructuralFeatures().get(
				5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuery() {
		return queryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExplanation() {
		return explanationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndex_Identifier() {
		return index_IdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_Identifier_Index_string() {
		return (EAttribute) index_IdentifierEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPart() {
		return partEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommands() {
		return commandsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommands_Command() {
		return (EReference) commandsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraints() {
		return constraintsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraints_Constraint() {
		return (EReference) constraintsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueries() {
		return queriesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueries_Query() {
		return (EReference) queriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent_chart() {
		return event_chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_chart_System_name() {
		return (EReference) event_chartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_chart_Event_entries() {
		return (EReference) event_chartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_chart_Event_type() {
		return (EAttribute) event_chartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario_chart() {
		return scenario_chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_chart_System_name() {
		return (EReference) scenario_chartEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_chart_Scenario_entries() {
		return (EReference) scenario_chartEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreation_chart() {
		return creation_chartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreation_chart_System_name() {
		return (EReference) creation_chartEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreation_chart_Creation_entries() {
		return (EReference) creation_chartEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Involves() {
		return (EReference) eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreation() {
		return creationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreation_Creator() {
		return (EReference) creationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreation_Creates() {
		return (EReference) creationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEvent_type() {
		return event_typeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BONFactory getBONFactory() {
		return (BONFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		system_chartEClass = createEClass(SYSTEM_CHART);
		createEReference(system_chartEClass, SYSTEM_CHART__CLUSTER_ENTRIES);

		chartEClass = createEClass(CHART);
		createEReference(chartEClass, CHART__CHART_INDEXING);
		createEReference(chartEClass, CHART__EXPLANATION);
		createEReference(chartEClass, CHART__CHART_PART);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		clusterEClass = createEClass(CLUSTER);
		createEReference(clusterEClass, CLUSTER__PARENT);

		cluster_chartEClass = createEClass(CLUSTER_CHART);
		createEReference(cluster_chartEClass, CLUSTER_CHART__CLASS_ENTRIES);
		createEReference(cluster_chartEClass, CLUSTER_CHART__CLUSTER);
		createEReference(cluster_chartEClass,
				CLUSTER_CHART__CLUSTERCHART_ENTRIES);

		class_chartEClass = createEClass(CLASS_CHART);
		createEReference(class_chartEClass, CLASS_CHART__CLASS);
		createEReference(class_chartEClass, CLASS_CHART__INHERIT);
		createEReference(class_chartEClass, CLASS_CHART__COMMANDS);
		createEReference(class_chartEClass, CLASS_CHART__CONSTRAINTS);
		createEReference(class_chartEClass, CLASS_CHART__QUERIES);

		descriptionElementEClass = createEClass(DESCRIPTION_ELEMENT);
		createEAttribute(descriptionElementEClass,
				DESCRIPTION_ELEMENT__DESCRIPTION);

		indexingEClass = createEClass(INDEXING);
		createEReference(indexingEClass, INDEXING__INDEX_TERM_LIST);

		classBONEClass = createEClass(CLASS_BON);
		createEReference(classBONEClass, CLASS_BON__PARENT);

		informal_chartsEClass = createEClass(INFORMAL_CHARTS);
		createEReference(informal_chartsEClass, INFORMAL_CHARTS__SYSTEM_CHART);
		createEReference(informal_chartsEClass, INFORMAL_CHARTS__CLASS_CHARTS);
		createEReference(informal_chartsEClass, INFORMAL_CHARTS__CLUSTER_CHARTS);
		createEReference(informal_chartsEClass, INFORMAL_CHARTS__EVENT_CHARTS);
		createEReference(informal_chartsEClass,
				INFORMAL_CHARTS__SCENARIO_CHARTS);
		createEReference(informal_chartsEClass,
				INFORMAL_CHARTS__CREATION_CHARTS);

		queryEClass = createEClass(QUERY);

		commandEClass = createEClass(COMMAND);

		constraintEClass = createEClass(CONSTRAINT);

		explanationEClass = createEClass(EXPLANATION);

		index_IdentifierEClass = createEClass(INDEX_IDENTIFIER);
		createEAttribute(index_IdentifierEClass, INDEX_IDENTIFIER__INDEX_STRING);

		partEClass = createEClass(PART);

		commandsEClass = createEClass(COMMANDS);
		createEReference(commandsEClass, COMMANDS__COMMAND);

		constraintsEClass = createEClass(CONSTRAINTS);
		createEReference(constraintsEClass, CONSTRAINTS__CONSTRAINT);

		queriesEClass = createEClass(QUERIES);
		createEReference(queriesEClass, QUERIES__QUERY);

		event_chartEClass = createEClass(EVENT_CHART);
		createEReference(event_chartEClass, EVENT_CHART__SYSTEM_NAME);
		createEReference(event_chartEClass, EVENT_CHART__EVENT_ENTRIES);
		createEAttribute(event_chartEClass, EVENT_CHART__EVENT_TYPE);

		scenario_chartEClass = createEClass(SCENARIO_CHART);
		createEReference(scenario_chartEClass, SCENARIO_CHART__SYSTEM_NAME);
		createEReference(scenario_chartEClass, SCENARIO_CHART__SCENARIO_ENTRIES);

		creation_chartEClass = createEClass(CREATION_CHART);
		createEReference(creation_chartEClass, CREATION_CHART__SYSTEM_NAME);
		createEReference(creation_chartEClass, CREATION_CHART__CREATION_ENTRIES);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__INVOLVES);

		scenarioEClass = createEClass(SCENARIO);

		creationEClass = createEClass(CREATION);
		createEReference(creationEClass, CREATION__CREATOR);
		createEReference(creationEClass, CREATION__CREATES);

		// Create enums
		event_typeEEnum = createEEnum(EVENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		system_chartEClass.getESuperTypes().add(this.getChart());
		system_chartEClass.getESuperTypes().add(this.getNamedElement());
		clusterEClass.getESuperTypes().add(this.getDescriptionElement());
		cluster_chartEClass.getESuperTypes().add(this.getChart());
		class_chartEClass.getESuperTypes().add(this.getChart());
		descriptionElementEClass.getESuperTypes().add(this.getNamedElement());
		classBONEClass.getESuperTypes().add(this.getDescriptionElement());
		queryEClass.getESuperTypes().add(this.getNamedElement());
		commandEClass.getESuperTypes().add(this.getNamedElement());
		constraintEClass.getESuperTypes().add(this.getNamedElement());
		explanationEClass.getESuperTypes().add(this.getNamedElement());
		index_IdentifierEClass.getESuperTypes().add(this.getNamedElement());
		partEClass.getESuperTypes().add(this.getNamedElement());
		event_chartEClass.getESuperTypes().add(this.getChart());
		scenario_chartEClass.getESuperTypes().add(this.getChart());
		creation_chartEClass.getESuperTypes().add(this.getChart());
		eventEClass.getESuperTypes().add(this.getNamedElement());
		scenarioEClass.getESuperTypes().add(this.getDescriptionElement());

		// Initialize classes and features; add operations and parameters
		initEClass(system_chartEClass, System_chart.class, "System_chart",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_chart_Cluster_entries(), this.getCluster(),
				null, "cluster_entries", null, 0, -1, System_chart.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(chartEClass, Chart.class, "Chart", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChart_Chart_indexing(), this.getIndexing(), null,
				"chart_indexing", null, 0, 1, Chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChart_Explanation(), this.getExplanation(), null,
				"explanation", null, 0, 1, Chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChart_Chart_part(), this.getPart(), null,
				"chart_part", null, 0, 1, Chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(),
				"name", null, 1, 1, NamedElement.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(clusterEClass, Cluster.class, "Cluster", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCluster_Parent(), this.getCluster(), null, "parent",
				null, 0, 1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cluster_chartEClass, Cluster_chart.class, "Cluster_chart",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCluster_chart_Class_entries(), this.getClassBON(),
				null, "class_entries", null, 0, -1, Cluster_chart.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getCluster_chart_Cluster(), this.getCluster(), null,
				"cluster", null, 1, 1, Cluster_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCluster_chart_Clusterchart_entries(),
				this.getCluster(), null, "clusterchart_entries", null, 0, -1,
				Cluster_chart.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(class_chartEClass, Class_chart.class, "Class_chart",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_chart_Class(), this.getClassBON(), null,
				"class", null, 1, 1, Class_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_chart_Inherit(), this.getClassBON(), null,
				"inherit", null, 0, -1, Class_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_chart_Commands(), this.getCommands(), null,
				"commands", null, 0, 1, Class_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_chart_Constraints(), this.getConstraints(),
				null, "constraints", null, 0, 1, Class_chart.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getClass_chart_Queries(), this.getQueries(), null,
				"queries", null, 0, 1, Class_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionElementEClass, DescriptionElement.class,
				"DescriptionElement", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionElement_Description(),
				ecorePackage.getEString(), "description", null, 1, 1,
				DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(indexingEClass, Indexing.class, "Indexing", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndexing_Index_term_list(),
				this.getIndex_Identifier(), null, "index_term_list", null, 1,
				-1, Indexing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(classBONEClass, ClassBON.class, "ClassBON", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassBON_Parent(), this.getCluster(), null, "parent",
				null, 0, 1, ClassBON.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(informal_chartsEClass, Informal_charts.class,
				"Informal_charts", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInformal_charts_System_chart(),
				this.getSystem_chart(), null, "system_chart", null, 1, 1,
				Informal_charts.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformal_charts_Class_charts(),
				this.getClass_chart(), null, "class_charts", null, 0, -1,
				Informal_charts.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformal_charts_Cluster_charts(),
				this.getCluster_chart(), null, "cluster_charts", null, 0, -1,
				Informal_charts.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformal_charts_Event_charts(),
				this.getEvent_chart(), null, "event_charts", null, 0, -1,
				Informal_charts.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformal_charts_Scenario_charts(),
				this.getScenario_chart(), null, "scenario_charts", null, 0, -1,
				Informal_charts.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformal_charts_Creation_charts(),
				this.getCreation_chart(), null, "creation_charts", null, 0, -1,
				Informal_charts.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryEClass, Query.class, "Query", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constraintEClass, Constraint.class, "Constraint",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(explanationEClass, Explanation.class, "Explanation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(index_IdentifierEClass, Index_Identifier.class,
				"Index_Identifier", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndex_Identifier_Index_string(),
				ecorePackage.getEString(), "index_string", null, 1, -1,
				Index_Identifier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(partEClass, Part.class, "Part", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(commandsEClass, Commands.class, "Commands", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommands_Command(), this.getCommand(), null,
				"command", null, 0, -1, Commands.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintsEClass, Constraints.class, "Constraints",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraints_Constraint(), this.getConstraint(), null,
				"constraint", null, 0, -1, Constraints.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queriesEClass, Queries.class, "Queries", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueries_Query(), this.getQuery(), null, "query",
				null, 0, -1, Queries.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(event_chartEClass, Event_chart.class, "Event_chart",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_chart_System_name(), this.getSystem_chart(),
				null, "system_name", null, 1, 1, Event_chart.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEvent_chart_Event_entries(), this.getEvent(), null,
				"event_entries", null, 0, -1, Event_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_chart_Event_type(), this.getEvent_type(),
				"event_type", null, 0, 1, Event_chart.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(scenario_chartEClass, Scenario_chart.class,
				"Scenario_chart", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_chart_System_name(), this.getSystem_chart(),
				null, "system_name", null, 1, 1, Scenario_chart.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getScenario_chart_Scenario_entries(),
				this.getScenario(), null, "scenario_entries", null, 0, -1,
				Scenario_chart.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(creation_chartEClass, Creation_chart.class,
				"Creation_chart", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreation_chart_System_name(), this.getSystem_chart(),
				null, "system_name", null, 1, 1, Creation_chart.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getCreation_chart_Creation_entries(),
				this.getCreation(), null, "creation_entries", null, 0, -1,
				Creation_chart.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_Involves(), this.getClassBON(), null,
				"involves", null, 1, -1, Event.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(creationEClass, Creation.class, "Creation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreation_Creator(), this.getClassBON(), null,
				"creator", null, 1, 1, Creation.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreation_Creates(), this.getClassBON(), null,
				"creates", null, 1, -1, Creation.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(event_typeEEnum, Event_type.class, "Event_type");
		addEEnumLiteral(event_typeEEnum, Event_type.INCOMING);
		addEEnumLiteral(event_typeEEnum, Event_type.OUTGOING);

		// Create resource
		createResource(eNS_URI);
	}

} // BONPackageImpl
