/**
 */
package org.emftext.language.BON;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.BON.BONFactory
 * @model kind="package"
 * @generated
 */
public interface BONPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BON";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/BON";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "BON";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	BONPackage eINSTANCE = org.emftext.language.BON.impl.BONPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.NamedElementImpl
	 * <em>Named Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.NamedElementImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.ChartImpl <em>Chart</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.ChartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getChart()
	 * @generated
	 */
	int CHART = 1;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.System_chartImpl
	 * <em>System chart</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.System_chartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getSystem_chart()
	 * @generated
	 */
	int SYSTEM_CHART = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.DescriptionElementImpl <em>Description Element</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.emftext.language.BON.impl.DescriptionElementImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getDescriptionElement()
	 * @generated
	 */
	int DESCRIPTION_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHART__CHART_INDEXING = 0;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHART__EXPLANATION = 1;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHART__CHART_PART = 2;

	/**
	 * The number of structural features of the '<em>Chart</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHART_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CHART__CHART_INDEXING = CHART__CHART_INDEXING;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CHART__EXPLANATION = CHART__EXPLANATION;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CHART__CHART_PART = CHART__CHART_PART;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CHART__NAME = CHART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cluster entries</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CHART__CLUSTER_ENTRIES = CHART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System chart</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CHART_FEATURE_COUNT = CHART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ELEMENT__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Description Element</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.ClusterImpl <em>Cluster</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.ClusterImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getCluster()
	 * @generated
	 */
	int CLUSTER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLUSTER__NAME = DESCRIPTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLUSTER__DESCRIPTION = DESCRIPTION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLUSTER__PARENT = DESCRIPTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cluster</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLUSTER_FEATURE_COUNT = DESCRIPTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.Cluster_chartImpl
	 * <em>Cluster chart</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.Cluster_chartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getCluster_chart()
	 * @generated
	 */
	int CLUSTER_CHART = 4;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART__CHART_INDEXING = CHART__CHART_INDEXING;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART__EXPLANATION = CHART__EXPLANATION;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART__CHART_PART = CHART__CHART_PART;

	/**
	 * The feature id for the '<em><b>Class entries</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART__CLASS_ENTRIES = CHART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART__CLUSTER = CHART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clusterchart entries</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART__CLUSTERCHART_ENTRIES = CHART_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cluster chart</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_CHART_FEATURE_COUNT = CHART_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.Class_chartImpl
	 * <em>Class chart</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.Class_chartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getClass_chart()
	 * @generated
	 */
	int CLASS_CHART = 5;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__CHART_INDEXING = CHART__CHART_INDEXING;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__EXPLANATION = CHART__EXPLANATION;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__CHART_PART = CHART__CHART_PART;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__CLASS = CHART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherit</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__INHERIT = CHART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__COMMANDS = CHART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__CONSTRAINTS = CHART_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART__QUERIES = CHART_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class chart</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CHART_FEATURE_COUNT = CHART_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.IndexingImpl <em>Indexing</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.IndexingImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getIndexing()
	 * @generated
	 */
	int INDEXING = 7;

	/**
	 * The feature id for the '<em><b>Index term list</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXING__INDEX_TERM_LIST = 0;

	/**
	 * The number of structural features of the '<em>Indexing</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INDEXING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.ClassBONImpl <em>Class BON</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.ClassBONImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getClassBON()
	 * @generated
	 */
	int CLASS_BON = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_BON__NAME = DESCRIPTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_BON__DESCRIPTION = DESCRIPTION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_BON__PARENT = DESCRIPTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class BON</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_BON_FEATURE_COUNT = DESCRIPTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.Informal_chartsImpl <em>Informal charts</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.emftext.language.BON.impl.Informal_chartsImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getInformal_charts()
	 * @generated
	 */
	int INFORMAL_CHARTS = 9;

	/**
	 * The feature id for the '<em><b>System chart</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS__SYSTEM_CHART = 0;

	/**
	 * The feature id for the '<em><b>Class charts</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS__CLASS_CHARTS = 1;

	/**
	 * The feature id for the '<em><b>Cluster charts</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS__CLUSTER_CHARTS = 2;

	/**
	 * The feature id for the '<em><b>Event charts</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS__EVENT_CHARTS = 3;

	/**
	 * The feature id for the '<em><b>Scenario charts</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS__SCENARIO_CHARTS = 4;

	/**
	 * The feature id for the '<em><b>Creation charts</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS__CREATION_CHARTS = 5;

	/**
	 * The number of structural features of the '<em>Informal charts</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMAL_CHARTS_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.QueryImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Query</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.CommandImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Command</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.ConstraintImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.ExplanationImpl
	 * <em>Explanation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.ExplanationImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getExplanation()
	 * @generated
	 */
	int EXPLANATION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLANATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Explanation</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLANATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.Index_IdentifierImpl <em>Index Identifier</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.emftext.language.BON.impl.Index_IdentifierImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getIndex_Identifier()
	 * @generated
	 */
	int INDEX_IDENTIFIER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INDEX_IDENTIFIER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Index string</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_IDENTIFIER__INDEX_STRING = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index Identifier</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_IDENTIFIER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.PartImpl <em>Part</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.emftext.language.BON.impl.PartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getPart()
	 * @generated
	 */
	int PART = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PART__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Part</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.CommandsImpl <em>Commands</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.CommandsImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getCommands()
	 * @generated
	 */
	int COMMANDS = 16;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMANDS__COMMAND = 0;

	/**
	 * The number of structural features of the '<em>Commands</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMANDS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.ConstraintsImpl
	 * <em>Constraints</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.ConstraintsImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getConstraints()
	 * @generated
	 */
	int CONSTRAINTS = 17;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__CONSTRAINT = 0;

	/**
	 * The number of structural features of the '<em>Constraints</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.QueriesImpl <em>Queries</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.QueriesImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getQueries()
	 * @generated
	 */
	int QUERIES = 18;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERIES__QUERY = 0;

	/**
	 * The number of structural features of the '<em>Queries</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERIES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.emftext.language.BON.impl.Event_chartImpl
	 * <em>Event chart</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.emftext.language.BON.impl.Event_chartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getEvent_chart()
	 * @generated
	 */
	int EVENT_CHART = 19;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART__CHART_INDEXING = CHART__CHART_INDEXING;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART__EXPLANATION = CHART__EXPLANATION;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART__CHART_PART = CHART__CHART_PART;

	/**
	 * The feature id for the '<em><b>System name</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART__SYSTEM_NAME = CHART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event entries</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART__EVENT_ENTRIES = CHART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART__EVENT_TYPE = CHART_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event chart</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CHART_FEATURE_COUNT = CHART_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.Scenario_chartImpl <em>Scenario chart</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.emftext.language.BON.impl.Scenario_chartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getScenario_chart()
	 * @generated
	 */
	int SCENARIO_CHART = 20;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CHART__CHART_INDEXING = CHART__CHART_INDEXING;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CHART__EXPLANATION = CHART__EXPLANATION;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CHART__CHART_PART = CHART__CHART_PART;

	/**
	 * The feature id for the '<em><b>System name</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CHART__SYSTEM_NAME = CHART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenario entries</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CHART__SCENARIO_ENTRIES = CHART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scenario chart</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CHART_FEATURE_COUNT = CHART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.Creation_chartImpl <em>Creation chart</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.emftext.language.BON.impl.Creation_chartImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getCreation_chart()
	 * @generated
	 */
	int CREATION_CHART = 21;

	/**
	 * The feature id for the '<em><b>Chart indexing</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_CHART__CHART_INDEXING = CHART__CHART_INDEXING;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_CHART__EXPLANATION = CHART__EXPLANATION;

	/**
	 * The feature id for the '<em><b>Chart part</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_CHART__CHART_PART = CHART__CHART_PART;

	/**
	 * The feature id for the '<em><b>System name</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_CHART__SYSTEM_NAME = CHART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Creation entries</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_CHART__CREATION_ENTRIES = CHART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Creation chart</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATION_CHART_FEATURE_COUNT = CHART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.EventImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Involves</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT__INVOLVES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.ScenarioImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = DESCRIPTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO__DESCRIPTION = DESCRIPTION_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = DESCRIPTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.impl.CreationImpl <em>Creation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.impl.CreationImpl
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getCreation()
	 * @generated
	 */
	int CREATION = 24;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION__CREATOR = 0;

	/**
	 * The feature id for the '<em><b>Creates</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION__CREATES = 1;

	/**
	 * The number of structural features of the '<em>Creation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.BON.Event_type <em>Event type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.emftext.language.BON.Event_type
	 * @see org.emftext.language.BON.impl.BONPackageImpl#getEvent_type()
	 * @generated
	 */
	int EVENT_TYPE = 25;

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.System_chart <em>System chart</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>System chart</em>'.
	 * @see org.emftext.language.BON.System_chart
	 * @generated
	 */
	EClass getSystem_chart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.System_chart#getCluster_entries <em>Cluster entries</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cluster entries</em>'.
	 * @see org.emftext.language.BON.System_chart#getCluster_entries()
	 * @see #getSystem_chart()
	 * @generated
	 */
	EReference getSystem_chart_Cluster_entries();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Chart <em>Chart</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chart</em>'.
	 * @see org.emftext.language.BON.Chart
	 * @generated
	 */
	EClass getChart();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Chart#getExplanation <em>Explanation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Explanation</em>'.
	 * @see org.emftext.language.BON.Chart#getExplanation()
	 * @see #getChart()
	 * @generated
	 */
	EReference getChart_Explanation();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Chart#getChart_part <em>Chart part</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Chart part</em>'.
	 * @see org.emftext.language.BON.Chart#getChart_part()
	 * @see #getChart()
	 * @generated
	 */
	EReference getChart_Chart_part();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Chart#getChart_indexing <em>Chart indexing</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Chart indexing</em>'.
	 * @see org.emftext.language.BON.Chart#getChart_indexing()
	 * @see #getChart()
	 * @generated
	 */
	EReference getChart_Chart_indexing();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.emftext.language.BON.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.BON.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.BON.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Cluster <em>Cluster</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Cluster</em>'.
	 * @see org.emftext.language.BON.Cluster
	 * @generated
	 */
	EClass getCluster();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.emftext.language.BON.Cluster#getParent <em>Parent</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.emftext.language.BON.Cluster#getParent()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_Parent();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Cluster_chart <em>Cluster chart</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cluster chart</em>'.
	 * @see org.emftext.language.BON.Cluster_chart
	 * @generated
	 */
	EClass getCluster_chart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Cluster_chart#getClass_entries <em>Class entries</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class entries</em>'.
	 * @see org.emftext.language.BON.Cluster_chart#getClass_entries()
	 * @see #getCluster_chart()
	 * @generated
	 */
	EReference getCluster_chart_Class_entries();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.Cluster_chart#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cluster</em>'.
	 * @see org.emftext.language.BON.Cluster_chart#getCluster()
	 * @see #getCluster_chart()
	 * @generated
	 */
	EReference getCluster_chart_Cluster();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Cluster_chart#getClusterchart_entries <em>Clusterchart entries</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clusterchart entries</em>'.
	 * @see org.emftext.language.BON.Cluster_chart#getClusterchart_entries()
	 * @see #getCluster_chart()
	 * @generated
	 */
	EReference getCluster_chart_Clusterchart_entries();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Class_chart <em>Class chart</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Class chart</em>'.
	 * @see org.emftext.language.BON.Class_chart
	 * @generated
	 */
	EClass getClass_chart();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.Class_chart#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.emftext.language.BON.Class_chart#getClass_()
	 * @see #getClass_chart()
	 * @generated
	 */
	EReference getClass_chart_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.language.BON.Class_chart#getInherit <em>Inherit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherit</em>'.
	 * @see org.emftext.language.BON.Class_chart#getInherit()
	 * @see #getClass_chart()
	 * @generated
	 */
	EReference getClass_chart_Inherit();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Class_chart#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Commands</em>'.
	 * @see org.emftext.language.BON.Class_chart#getCommands()
	 * @see #getClass_chart()
	 * @generated
	 */
	EReference getClass_chart_Commands();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Class_chart#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see org.emftext.language.BON.Class_chart#getConstraints()
	 * @see #getClass_chart()
	 * @generated
	 */
	EReference getClass_chart_Constraints();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Class_chart#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Queries</em>'.
	 * @see org.emftext.language.BON.Class_chart#getQueries()
	 * @see #getClass_chart()
	 * @generated
	 */
	EReference getClass_chart_Queries();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.DescriptionElement
	 * <em>Description Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Description Element</em>'.
	 * @see org.emftext.language.BON.DescriptionElement
	 * @generated
	 */
	EClass getDescriptionElement();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.BON.DescriptionElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.emftext.language.BON.DescriptionElement#getDescription()
	 * @see #getDescriptionElement()
	 * @generated
	 */
	EAttribute getDescriptionElement_Description();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Indexing <em>Indexing</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Indexing</em>'.
	 * @see org.emftext.language.BON.Indexing
	 * @generated
	 */
	EClass getIndexing();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Indexing#getIndex_term_list <em>Index term list</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Index term list</em>'.
	 * @see org.emftext.language.BON.Indexing#getIndex_term_list()
	 * @see #getIndexing()
	 * @generated
	 */
	EReference getIndexing_Index_term_list();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.ClassBON <em>Class BON</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Class BON</em>'.
	 * @see org.emftext.language.BON.ClassBON
	 * @generated
	 */
	EClass getClassBON();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.ClassBON#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.emftext.language.BON.ClassBON#getParent()
	 * @see #getClassBON()
	 * @generated
	 */
	EReference getClassBON_Parent();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Informal_charts <em>Informal charts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Informal charts</em>'.
	 * @see org.emftext.language.BON.Informal_charts
	 * @generated
	 */
	EClass getInformal_charts();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.BON.Informal_charts#getSystem_chart <em>System chart</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System chart</em>'.
	 * @see org.emftext.language.BON.Informal_charts#getSystem_chart()
	 * @see #getInformal_charts()
	 * @generated
	 */
	EReference getInformal_charts_System_chart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Informal_charts#getClass_charts <em>Class charts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class charts</em>'.
	 * @see org.emftext.language.BON.Informal_charts#getClass_charts()
	 * @see #getInformal_charts()
	 * @generated
	 */
	EReference getInformal_charts_Class_charts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Informal_charts#getCluster_charts <em>Cluster charts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cluster charts</em>'.
	 * @see org.emftext.language.BON.Informal_charts#getCluster_charts()
	 * @see #getInformal_charts()
	 * @generated
	 */
	EReference getInformal_charts_Cluster_charts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Informal_charts#getEvent_charts <em>Event charts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event charts</em>'.
	 * @see org.emftext.language.BON.Informal_charts#getEvent_charts()
	 * @see #getInformal_charts()
	 * @generated
	 */
	EReference getInformal_charts_Event_charts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Informal_charts#getScenario_charts <em>Scenario charts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenario charts</em>'.
	 * @see org.emftext.language.BON.Informal_charts#getScenario_charts()
	 * @see #getInformal_charts()
	 * @generated
	 */
	EReference getInformal_charts_Scenario_charts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Informal_charts#getCreation_charts <em>Creation charts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Creation charts</em>'.
	 * @see org.emftext.language.BON.Informal_charts#getCreation_charts()
	 * @see #getInformal_charts()
	 * @generated
	 */
	EReference getInformal_charts_Creation_charts();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Query <em>Query</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see org.emftext.language.BON.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Command <em>Command</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.emftext.language.BON.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Constraint <em>Constraint</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.emftext.language.BON.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Explanation <em>Explanation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Explanation</em>'.
	 * @see org.emftext.language.BON.Explanation
	 * @generated
	 */
	EClass getExplanation();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Index_Identifier
	 * <em>Index Identifier</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Index Identifier</em>'.
	 * @see org.emftext.language.BON.Index_Identifier
	 * @generated
	 */
	EClass getIndex_Identifier();

	/**
	 * Returns the meta object for the attribute list '{@link org.emftext.language.BON.Index_Identifier#getIndex_string <em>Index string</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Index string</em>'.
	 * @see org.emftext.language.BON.Index_Identifier#getIndex_string()
	 * @see #getIndex_Identifier()
	 * @generated
	 */
	EAttribute getIndex_Identifier_Index_string();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Part <em>Part</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see org.emftext.language.BON.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Commands <em>Commands</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Commands</em>'.
	 * @see org.emftext.language.BON.Commands
	 * @generated
	 */
	EClass getCommands();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Commands#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Command</em>'.
	 * @see org.emftext.language.BON.Commands#getCommand()
	 * @see #getCommands()
	 * @generated
	 */
	EReference getCommands_Command();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Constraints <em>Constraints</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constraints</em>'.
	 * @see org.emftext.language.BON.Constraints
	 * @generated
	 */
	EClass getConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Constraints#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.emftext.language.BON.Constraints#getConstraint()
	 * @see #getConstraints()
	 * @generated
	 */
	EReference getConstraints_Constraint();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Queries <em>Queries</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Queries</em>'.
	 * @see org.emftext.language.BON.Queries
	 * @generated
	 */
	EClass getQueries();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.emftext.language.BON.Queries#getQuery <em>Query</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Query</em>'.
	 * @see org.emftext.language.BON.Queries#getQuery()
	 * @see #getQueries()
	 * @generated
	 */
	EReference getQueries_Query();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Event_chart <em>Event chart</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event chart</em>'.
	 * @see org.emftext.language.BON.Event_chart
	 * @generated
	 */
	EClass getEvent_chart();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.Event_chart#getSystem_name <em>System name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System name</em>'.
	 * @see org.emftext.language.BON.Event_chart#getSystem_name()
	 * @see #getEvent_chart()
	 * @generated
	 */
	EReference getEvent_chart_System_name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.BON.Event_chart#getEvent_entries <em>Event entries</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event entries</em>'.
	 * @see org.emftext.language.BON.Event_chart#getEvent_entries()
	 * @see #getEvent_chart()
	 * @generated
	 */
	EReference getEvent_chart_Event_entries();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.BON.Event_chart#getEvent_type <em>Event type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event type</em>'.
	 * @see org.emftext.language.BON.Event_chart#getEvent_type()
	 * @see #getEvent_chart()
	 * @generated
	 */
	EAttribute getEvent_chart_Event_type();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Scenario_chart <em>Scenario chart</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario chart</em>'.
	 * @see org.emftext.language.BON.Scenario_chart
	 * @generated
	 */
	EClass getScenario_chart();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.Scenario_chart#getSystem_name <em>System name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System name</em>'.
	 * @see org.emftext.language.BON.Scenario_chart#getSystem_name()
	 * @see #getScenario_chart()
	 * @generated
	 */
	EReference getScenario_chart_System_name();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.emftext.language.BON.Scenario_chart#getScenario_entries
	 * <em>Scenario entries</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Scenario entries</em>'.
	 * @see org.emftext.language.BON.Scenario_chart#getScenario_entries()
	 * @see #getScenario_chart()
	 * @generated
	 */
	EReference getScenario_chart_Scenario_entries();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Creation_chart <em>Creation chart</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Creation chart</em>'.
	 * @see org.emftext.language.BON.Creation_chart
	 * @generated
	 */
	EClass getCreation_chart();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.Creation_chart#getSystem_name <em>System name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System name</em>'.
	 * @see org.emftext.language.BON.Creation_chart#getSystem_name()
	 * @see #getCreation_chart()
	 * @generated
	 */
	EReference getCreation_chart_System_name();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.emftext.language.BON.Creation_chart#getCreation_entries
	 * <em>Creation entries</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Creation entries</em>'.
	 * @see org.emftext.language.BON.Creation_chart#getCreation_entries()
	 * @see #getCreation_chart()
	 * @generated
	 */
	EReference getCreation_chart_Creation_entries();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.BON.Event <em>Event</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.emftext.language.BON.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.language.BON.Event#getInvolves <em>Involves</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Involves</em>'.
	 * @see org.emftext.language.BON.Event#getInvolves()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Involves();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Scenario <em>Scenario</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.emftext.language.BON.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for class '
	 * {@link org.emftext.language.BON.Creation <em>Creation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Creation</em>'.
	 * @see org.emftext.language.BON.Creation
	 * @generated
	 */
	EClass getCreation();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.BON.Creation#getCreator <em>Creator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Creator</em>'.
	 * @see org.emftext.language.BON.Creation#getCreator()
	 * @see #getCreation()
	 * @generated
	 */
	EReference getCreation_Creator();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.language.BON.Creation#getCreates <em>Creates</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Creates</em>'.
	 * @see org.emftext.language.BON.Creation#getCreates()
	 * @see #getCreation()
	 * @generated
	 */
	EReference getCreation_Creates();

	/**
	 * Returns the meta object for enum '
	 * {@link org.emftext.language.BON.Event_type <em>Event type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Event type</em>'.
	 * @see org.emftext.language.BON.Event_type
	 * @generated
	 */
	EEnum getEvent_type();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BONFactory getBONFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.System_chartImpl <em>System chart</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.System_chartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getSystem_chart()
		 * @generated
		 */
		EClass SYSTEM_CHART = eINSTANCE.getSystem_chart();

		/**
		 * The meta object literal for the '<em><b>Cluster entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CHART__CLUSTER_ENTRIES = eINSTANCE
				.getSystem_chart_Cluster_entries();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ChartImpl <em>Chart</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.ChartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getChart()
		 * @generated
		 */
		EClass CHART = eINSTANCE.getChart();

		/**
		 * The meta object literal for the '<em><b>Explanation</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CHART__EXPLANATION = eINSTANCE.getChart_Explanation();

		/**
		 * The meta object literal for the '<em><b>Chart part</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CHART__CHART_PART = eINSTANCE.getChart_Chart_part();

		/**
		 * The meta object literal for the '<em><b>Chart indexing</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CHART__CHART_INDEXING = eINSTANCE.getChart_Chart_indexing();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.NamedElementImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ClusterImpl <em>Cluster</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.ClusterImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getCluster()
		 * @generated
		 */
		EClass CLUSTER = eINSTANCE.getCluster();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__PARENT = eINSTANCE.getCluster_Parent();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Cluster_chartImpl <em>Cluster chart</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Cluster_chartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getCluster_chart()
		 * @generated
		 */
		EClass CLUSTER_CHART = eINSTANCE.getCluster_chart();

		/**
		 * The meta object literal for the '<em><b>Class entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER_CHART__CLASS_ENTRIES = eINSTANCE
				.getCluster_chart_Class_entries();

		/**
		 * The meta object literal for the '<em><b>Cluster</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER_CHART__CLUSTER = eINSTANCE
				.getCluster_chart_Cluster();

		/**
		 * The meta object literal for the '<em><b>Clusterchart entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER_CHART__CLUSTERCHART_ENTRIES = eINSTANCE
				.getCluster_chart_Clusterchart_entries();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Class_chartImpl <em>Class chart</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Class_chartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getClass_chart()
		 * @generated
		 */
		EClass CLASS_CHART = eINSTANCE.getClass_chart();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CHART__CLASS = eINSTANCE.getClass_chart_Class();

		/**
		 * The meta object literal for the '<em><b>Inherit</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CHART__INHERIT = eINSTANCE.getClass_chart_Inherit();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CHART__COMMANDS = eINSTANCE.getClass_chart_Commands();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CHART__CONSTRAINTS = eINSTANCE
				.getClass_chart_Constraints();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CHART__QUERIES = eINSTANCE.getClass_chart_Queries();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.DescriptionElementImpl <em>Description Element</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.DescriptionElementImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getDescriptionElement()
		 * @generated
		 */
		EClass DESCRIPTION_ELEMENT = eINSTANCE.getDescriptionElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION_ELEMENT__DESCRIPTION = eINSTANCE
				.getDescriptionElement_Description();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.IndexingImpl <em>Indexing</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.IndexingImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getIndexing()
		 * @generated
		 */
		EClass INDEXING = eINSTANCE.getIndexing();

		/**
		 * The meta object literal for the '<em><b>Index term list</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INDEXING__INDEX_TERM_LIST = eINSTANCE
				.getIndexing_Index_term_list();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ClassBONImpl <em>Class BON</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.ClassBONImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getClassBON()
		 * @generated
		 */
		EClass CLASS_BON = eINSTANCE.getClassBON();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_BON__PARENT = eINSTANCE.getClassBON_Parent();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Informal_chartsImpl <em>Informal charts</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Informal_chartsImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getInformal_charts()
		 * @generated
		 */
		EClass INFORMAL_CHARTS = eINSTANCE.getInformal_charts();

		/**
		 * The meta object literal for the '<em><b>System chart</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INFORMAL_CHARTS__SYSTEM_CHART = eINSTANCE
				.getInformal_charts_System_chart();

		/**
		 * The meta object literal for the '<em><b>Class charts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INFORMAL_CHARTS__CLASS_CHARTS = eINSTANCE
				.getInformal_charts_Class_charts();

		/**
		 * The meta object literal for the '<em><b>Cluster charts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INFORMAL_CHARTS__CLUSTER_CHARTS = eINSTANCE
				.getInformal_charts_Cluster_charts();

		/**
		 * The meta object literal for the '<em><b>Event charts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INFORMAL_CHARTS__EVENT_CHARTS = eINSTANCE
				.getInformal_charts_Event_charts();

		/**
		 * The meta object literal for the '<em><b>Scenario charts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INFORMAL_CHARTS__SCENARIO_CHARTS = eINSTANCE
				.getInformal_charts_Scenario_charts();

		/**
		 * The meta object literal for the '<em><b>Creation charts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INFORMAL_CHARTS__CREATION_CHARTS = eINSTANCE
				.getInformal_charts_Creation_charts();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.QueryImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.CommandImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.ConstraintImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ExplanationImpl <em>Explanation</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.ExplanationImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getExplanation()
		 * @generated
		 */
		EClass EXPLANATION = eINSTANCE.getExplanation();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Index_IdentifierImpl <em>Index Identifier</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Index_IdentifierImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getIndex_Identifier()
		 * @generated
		 */
		EClass INDEX_IDENTIFIER = eINSTANCE.getIndex_Identifier();

		/**
		 * The meta object literal for the '<em><b>Index string</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_IDENTIFIER__INDEX_STRING = eINSTANCE
				.getIndex_Identifier_Index_string();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.PartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.CommandsImpl <em>Commands</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.CommandsImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getCommands()
		 * @generated
		 */
		EClass COMMANDS = eINSTANCE.getCommands();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMANDS__COMMAND = eINSTANCE.getCommands_Command();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ConstraintsImpl <em>Constraints</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.ConstraintsImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getConstraints()
		 * @generated
		 */
		EClass CONSTRAINTS = eINSTANCE.getConstraints();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINTS__CONSTRAINT = eINSTANCE
				.getConstraints_Constraint();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.QueriesImpl <em>Queries</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.QueriesImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getQueries()
		 * @generated
		 */
		EClass QUERIES = eINSTANCE.getQueries();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERIES__QUERY = eINSTANCE.getQueries_Query();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Event_chartImpl <em>Event chart</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Event_chartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getEvent_chart()
		 * @generated
		 */
		EClass EVENT_CHART = eINSTANCE.getEvent_chart();

		/**
		 * The meta object literal for the '<em><b>System name</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CHART__SYSTEM_NAME = eINSTANCE
				.getEvent_chart_System_name();

		/**
		 * The meta object literal for the '<em><b>Event entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CHART__EVENT_ENTRIES = eINSTANCE
				.getEvent_chart_Event_entries();

		/**
		 * The meta object literal for the '<em><b>Event type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_CHART__EVENT_TYPE = eINSTANCE
				.getEvent_chart_Event_type();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Scenario_chartImpl <em>Scenario chart</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Scenario_chartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getScenario_chart()
		 * @generated
		 */
		EClass SCENARIO_CHART = eINSTANCE.getScenario_chart();

		/**
		 * The meta object literal for the '<em><b>System name</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO_CHART__SYSTEM_NAME = eINSTANCE
				.getScenario_chart_System_name();

		/**
		 * The meta object literal for the '<em><b>Scenario entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO_CHART__SCENARIO_ENTRIES = eINSTANCE
				.getScenario_chart_Scenario_entries();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.Creation_chartImpl <em>Creation chart</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.emftext.language.BON.impl.Creation_chartImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getCreation_chart()
		 * @generated
		 */
		EClass CREATION_CHART = eINSTANCE.getCreation_chart();

		/**
		 * The meta object literal for the '<em><b>System name</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATION_CHART__SYSTEM_NAME = eINSTANCE
				.getCreation_chart_System_name();

		/**
		 * The meta object literal for the '<em><b>Creation entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CREATION_CHART__CREATION_ENTRIES = eINSTANCE
				.getCreation_chart_Creation_entries();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.EventImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Involves</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__INVOLVES = eINSTANCE.getEvent_Involves();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.ScenarioImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.impl.CreationImpl <em>Creation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.impl.CreationImpl
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getCreation()
		 * @generated
		 */
		EClass CREATION = eINSTANCE.getCreation();

		/**
		 * The meta object literal for the '<em><b>Creator</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATION__CREATOR = eINSTANCE.getCreation_Creator();

		/**
		 * The meta object literal for the '<em><b>Creates</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATION__CREATES = eINSTANCE.getCreation_Creates();

		/**
		 * The meta object literal for the '{@link org.emftext.language.BON.Event_type <em>Event type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.emftext.language.BON.Event_type
		 * @see org.emftext.language.BON.impl.BONPackageImpl#getEvent_type()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEvent_type();

	}

} // BONPackage
