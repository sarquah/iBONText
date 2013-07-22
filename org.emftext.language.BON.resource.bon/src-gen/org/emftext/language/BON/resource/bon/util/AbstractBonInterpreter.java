/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractBonInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.language.BON.resource.bon.IBonInterpreterListener> listeners = new java.util.ArrayList<org.emftext.language.BON.resource.bon.IBonInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.language.BON.System_chart) {
			result = interprete_org_emftext_language_BON_System_005fchart((org.emftext.language.BON.System_chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Chart) {
			result = interprete_org_emftext_language_BON_Chart((org.emftext.language.BON.Chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Cluster) {
			result = interprete_org_emftext_language_BON_Cluster((org.emftext.language.BON.Cluster) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.ClassBON) {
			result = interprete_org_emftext_language_BON_ClassBON((org.emftext.language.BON.ClassBON) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.DescriptionElement) {
			result = interprete_org_emftext_language_BON_DescriptionElement((org.emftext.language.BON.DescriptionElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Query) {
			result = interprete_org_emftext_language_BON_Query((org.emftext.language.BON.Query) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Constraint) {
			result = interprete_org_emftext_language_BON_Constraint((org.emftext.language.BON.Constraint) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Index_Identifier) {
			result = interprete_org_emftext_language_BON_Index_005fIdentifier((org.emftext.language.BON.Index_Identifier) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.NamedElement) {
			result = interprete_org_emftext_language_BON_NamedElement((org.emftext.language.BON.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Cluster_chart) {
			result = interprete_org_emftext_language_BON_Cluster_005fchart((org.emftext.language.BON.Cluster_chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Class_chart) {
			result = interprete_org_emftext_language_BON_Class_005fchart((org.emftext.language.BON.Class_chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Indexing) {
			result = interprete_org_emftext_language_BON_Indexing((org.emftext.language.BON.Indexing) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Informal_charts) {
			result = interprete_org_emftext_language_BON_Informal_005fcharts((org.emftext.language.BON.Informal_charts) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Command) {
			result = interprete_org_emftext_language_BON_Command((org.emftext.language.BON.Command) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Explanation) {
			result = interprete_org_emftext_language_BON_Explanation((org.emftext.language.BON.Explanation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Part) {
			result = interprete_org_emftext_language_BON_Part((org.emftext.language.BON.Part) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Commands) {
			result = interprete_org_emftext_language_BON_Commands((org.emftext.language.BON.Commands) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Constraints) {
			result = interprete_org_emftext_language_BON_Constraints((org.emftext.language.BON.Constraints) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Queries) {
			result = interprete_org_emftext_language_BON_Queries((org.emftext.language.BON.Queries) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Event_chart) {
			result = interprete_org_emftext_language_BON_Event_005fchart((org.emftext.language.BON.Event_chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Scenario_chart) {
			result = interprete_org_emftext_language_BON_Scenario_005fchart((org.emftext.language.BON.Scenario_chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Creation_chart) {
			result = interprete_org_emftext_language_BON_Creation_005fchart((org.emftext.language.BON.Creation_chart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Event) {
			result = interprete_org_emftext_language_BON_Event((org.emftext.language.BON.Event) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Scenario) {
			result = interprete_org_emftext_language_BON_Scenario((org.emftext.language.BON.Scenario) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.BON.Creation) {
			result = interprete_org_emftext_language_BON_Creation((org.emftext.language.BON.Creation) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_BON_System_005fchart(org.emftext.language.BON.System_chart system_chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Chart(org.emftext.language.BON.Chart chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_NamedElement(org.emftext.language.BON.NamedElement namedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Cluster(org.emftext.language.BON.Cluster cluster, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Cluster_005fchart(org.emftext.language.BON.Cluster_chart cluster_chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Class_005fchart(org.emftext.language.BON.Class_chart class_chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_DescriptionElement(org.emftext.language.BON.DescriptionElement descriptionElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Indexing(org.emftext.language.BON.Indexing indexing, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_ClassBON(org.emftext.language.BON.ClassBON classBON, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Informal_005fcharts(org.emftext.language.BON.Informal_charts informal_charts, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Query(org.emftext.language.BON.Query query, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Command(org.emftext.language.BON.Command command, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Constraint(org.emftext.language.BON.Constraint constraint, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Explanation(org.emftext.language.BON.Explanation explanation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Index_005fIdentifier(org.emftext.language.BON.Index_Identifier index_Identifier, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Part(org.emftext.language.BON.Part part, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Commands(org.emftext.language.BON.Commands commands, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Constraints(org.emftext.language.BON.Constraints constraints, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Queries(org.emftext.language.BON.Queries queries, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Event_005fchart(org.emftext.language.BON.Event_chart event_chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Scenario_005fchart(org.emftext.language.BON.Scenario_chart scenario_chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Creation_005fchart(org.emftext.language.BON.Creation_chart creation_chart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Event(org.emftext.language.BON.Event event, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Scenario(org.emftext.language.BON.Scenario scenario, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_BON_Creation(org.emftext.language.BON.Creation creation, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.language.BON.resource.bon.IBonInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.language.BON.resource.bon.IBonInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.BON.resource.bon.IBonInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
