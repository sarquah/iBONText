/**
 */
package org.emftext.language.BON.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.emftext.language.BON.*;
import org.emftext.language.BON.BONPackage;
import org.emftext.language.BON.Chart;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * @see org.emftext.language.BON.BONPackage
 * @generated
 */
public class BONSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static BONPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public BONSwitch() {
		if (modelPackage == null) {
			modelPackage = BONPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case BONPackage.SYSTEM_CHART: {
			System_chart system_chart = (System_chart) theEObject;
			T result = caseSystem_chart(system_chart);
			if (result == null)
				result = caseChart(system_chart);
			if (result == null)
				result = caseNamedElement(system_chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CHART: {
			Chart chart = (Chart) theEObject;
			T result = caseChart(chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.NAMED_ELEMENT: {
			NamedElement namedElement = (NamedElement) theEObject;
			T result = caseNamedElement(namedElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CLUSTER: {
			Cluster cluster = (Cluster) theEObject;
			T result = caseCluster(cluster);
			if (result == null)
				result = caseDescriptionElement(cluster);
			if (result == null)
				result = caseNamedElement(cluster);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CLUSTER_CHART: {
			Cluster_chart cluster_chart = (Cluster_chart) theEObject;
			T result = caseCluster_chart(cluster_chart);
			if (result == null)
				result = caseChart(cluster_chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CLASS_CHART: {
			Class_chart class_chart = (Class_chart) theEObject;
			T result = caseClass_chart(class_chart);
			if (result == null)
				result = caseChart(class_chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.DESCRIPTION_ELEMENT: {
			DescriptionElement descriptionElement = (DescriptionElement) theEObject;
			T result = caseDescriptionElement(descriptionElement);
			if (result == null)
				result = caseNamedElement(descriptionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.INDEXING: {
			Indexing indexing = (Indexing) theEObject;
			T result = caseIndexing(indexing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CLASS_BON: {
			ClassBON classBON = (ClassBON) theEObject;
			T result = caseClassBON(classBON);
			if (result == null)
				result = caseDescriptionElement(classBON);
			if (result == null)
				result = caseNamedElement(classBON);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.INFORMAL_CHARTS: {
			Informal_charts informal_charts = (Informal_charts) theEObject;
			T result = caseInformal_charts(informal_charts);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.QUERY: {
			Query query = (Query) theEObject;
			T result = caseQuery(query);
			if (result == null)
				result = caseNamedElement(query);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.COMMAND: {
			Command command = (Command) theEObject;
			T result = caseCommand(command);
			if (result == null)
				result = caseNamedElement(command);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CONSTRAINT: {
			Constraint constraint = (Constraint) theEObject;
			T result = caseConstraint(constraint);
			if (result == null)
				result = caseNamedElement(constraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.EXPLANATION: {
			Explanation explanation = (Explanation) theEObject;
			T result = caseExplanation(explanation);
			if (result == null)
				result = caseNamedElement(explanation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.INDEX_IDENTIFIER: {
			Index_Identifier index_Identifier = (Index_Identifier) theEObject;
			T result = caseIndex_Identifier(index_Identifier);
			if (result == null)
				result = caseNamedElement(index_Identifier);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.PART: {
			Part part = (Part) theEObject;
			T result = casePart(part);
			if (result == null)
				result = caseNamedElement(part);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.COMMANDS: {
			Commands commands = (Commands) theEObject;
			T result = caseCommands(commands);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CONSTRAINTS: {
			Constraints constraints = (Constraints) theEObject;
			T result = caseConstraints(constraints);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.QUERIES: {
			Queries queries = (Queries) theEObject;
			T result = caseQueries(queries);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.EVENT_CHART: {
			Event_chart event_chart = (Event_chart) theEObject;
			T result = caseEvent_chart(event_chart);
			if (result == null)
				result = caseChart(event_chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.SCENARIO_CHART: {
			Scenario_chart scenario_chart = (Scenario_chart) theEObject;
			T result = caseScenario_chart(scenario_chart);
			if (result == null)
				result = caseChart(scenario_chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CREATION_CHART: {
			Creation_chart creation_chart = (Creation_chart) theEObject;
			T result = caseCreation_chart(creation_chart);
			if (result == null)
				result = caseChart(creation_chart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.EVENT: {
			Event event = (Event) theEObject;
			T result = caseEvent(event);
			if (result == null)
				result = caseNamedElement(event);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.SCENARIO: {
			Scenario scenario = (Scenario) theEObject;
			T result = caseScenario(scenario);
			if (result == null)
				result = caseDescriptionElement(scenario);
			if (result == null)
				result = caseNamedElement(scenario);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BONPackage.CREATION: {
			Creation creation = (Creation) theEObject;
			T result = caseCreation(creation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System chart</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem_chart(System_chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chart</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChart(Chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cluster</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cluster</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCluster(Cluster object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cluster chart</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cluster chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCluster_chart(Cluster_chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class chart</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass_chart(Class_chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Element</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionElement(DescriptionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Indexing</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indexing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexing(Indexing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class BON</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class BON</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassBON(ClassBON object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Informal charts</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Informal charts</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformal_charts(Informal_charts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuery(Query object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Explanation</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Explanation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExplanation(Explanation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Identifier</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndex_Identifier(Index_Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Part</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePart(Part object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Commands</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Commands</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommands(Commands object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraints</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraints</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraints(Constraints object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Queries</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Queries</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueries(Queries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event chart</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent_chart(Event_chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario chart</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenario_chart(Scenario_chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Creation chart</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Creation chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreation_chart(Creation_chart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenario(Scenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Creation</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Creation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreation(Creation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // BONSwitch
