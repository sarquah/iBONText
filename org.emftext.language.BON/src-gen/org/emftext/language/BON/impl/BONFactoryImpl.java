/**
 */
package org.emftext.language.BON.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emftext.language.BON.*;
import org.emftext.language.BON.BONFactory;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Cluster;
import org.emftext.language.BON.Cluster_chart;
import org.emftext.language.BON.Command;
import org.emftext.language.BON.Commands;
import org.emftext.language.BON.Constraint;
import org.emftext.language.BON.Constraints;
import org.emftext.language.BON.Creation;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.Event;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Event_type;
import org.emftext.language.BON.Explanation;
import org.emftext.language.BON.Index_Identifier;
import org.emftext.language.BON.Indexing;
import org.emftext.language.BON.Informal_charts;
import org.emftext.language.BON.Part;
import org.emftext.language.BON.Queries;
import org.emftext.language.BON.Query;
import org.emftext.language.BON.Scenario;
import org.emftext.language.BON.Scenario_chart;
import org.emftext.language.BON.System_chart;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class BONFactoryImpl extends EFactoryImpl implements BONFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static BONFactory init() {
		try {
			BONFactory theBONFactory = (BONFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.emftext.org/language/BON");
			if (theBONFactory != null) {
				return theBONFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BONFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public BONFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case BONPackage.SYSTEM_CHART:
			return createSystem_chart();
		case BONPackage.CLUSTER:
			return createCluster();
		case BONPackage.CLUSTER_CHART:
			return createCluster_chart();
		case BONPackage.CLASS_CHART:
			return createClass_chart();
		case BONPackage.INDEXING:
			return createIndexing();
		case BONPackage.CLASS_BON:
			return createClassBON();
		case BONPackage.INFORMAL_CHARTS:
			return createInformal_charts();
		case BONPackage.QUERY:
			return createQuery();
		case BONPackage.COMMAND:
			return createCommand();
		case BONPackage.CONSTRAINT:
			return createConstraint();
		case BONPackage.EXPLANATION:
			return createExplanation();
		case BONPackage.INDEX_IDENTIFIER:
			return createIndex_Identifier();
		case BONPackage.PART:
			return createPart();
		case BONPackage.COMMANDS:
			return createCommands();
		case BONPackage.CONSTRAINTS:
			return createConstraints();
		case BONPackage.QUERIES:
			return createQueries();
		case BONPackage.EVENT_CHART:
			return createEvent_chart();
		case BONPackage.SCENARIO_CHART:
			return createScenario_chart();
		case BONPackage.CREATION_CHART:
			return createCreation_chart();
		case BONPackage.EVENT:
			return createEvent();
		case BONPackage.SCENARIO:
			return createScenario();
		case BONPackage.CREATION:
			return createCreation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case BONPackage.EVENT_TYPE:
			return createEvent_typeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case BONPackage.EVENT_TYPE:
			return convertEvent_typeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public System_chart createSystem_chart() {
		System_chartImpl system_chart = new System_chartImpl();
		return system_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Cluster createCluster() {
		ClusterImpl cluster = new ClusterImpl();
		return cluster;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Cluster_chart createCluster_chart() {
		Cluster_chartImpl cluster_chart = new Cluster_chartImpl();
		return cluster_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Class_chart createClass_chart() {
		Class_chartImpl class_chart = new Class_chartImpl();
		return class_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Indexing createIndexing() {
		IndexingImpl indexing = new IndexingImpl();
		return indexing;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBON createClassBON() {
		ClassBONImpl classBON = new ClassBONImpl();
		return classBON;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Informal_charts createInformal_charts() {
		Informal_chartsImpl informal_charts = new Informal_chartsImpl();
		return informal_charts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Command createCommand() {
		CommandImpl command = new CommandImpl();
		return command;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Explanation createExplanation() {
		ExplanationImpl explanation = new ExplanationImpl();
		return explanation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Index_Identifier createIndex_Identifier() {
		Index_IdentifierImpl index_Identifier = new Index_IdentifierImpl();
		return index_Identifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Part createPart() {
		PartImpl part = new PartImpl();
		return part;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Commands createCommands() {
		CommandsImpl commands = new CommandsImpl();
		return commands;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Constraints createConstraints() {
		ConstraintsImpl constraints = new ConstraintsImpl();
		return constraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Queries createQueries() {
		QueriesImpl queries = new QueriesImpl();
		return queries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Event_chart createEvent_chart() {
		Event_chartImpl event_chart = new Event_chartImpl();
		return event_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario_chart createScenario_chart() {
		Scenario_chartImpl scenario_chart = new Scenario_chartImpl();
		return scenario_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Creation_chart createCreation_chart() {
		Creation_chartImpl creation_chart = new Creation_chartImpl();
		return creation_chart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Creation createCreation() {
		CreationImpl creation = new CreationImpl();
		return creation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Event_type createEvent_typeFromString(EDataType eDataType,
			String initialValue) {
		Event_type result = Event_type.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
					+ "' is not a valid enumerator of '" + eDataType.getName()
					+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEvent_typeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BONPackage getBONPackage() {
		return (BONPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BONPackage getPackage() {
		return BONPackage.eINSTANCE;
	}

} // BONFactoryImpl
