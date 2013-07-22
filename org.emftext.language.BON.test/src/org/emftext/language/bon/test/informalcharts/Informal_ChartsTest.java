package org.emftext.language.bon.test.informalcharts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import org.emftext.language.BON.impl.BONFactoryImpl;
import org.junit.Before;
import org.junit.Test;

public class Informal_ChartsTest {

	private Informal_charts informalCharts;
	private System_chart systemChart;
	private Cluster_chart clusterChart;
	private Cluster cluster;
	private ClassBON className1;
	private ClassBON className2;
	private Class_chart classChart1;
	private Class_chart classChart2;
	private Indexing indexing;
	private Index_Identifier indexIdentifier;
	private String authorname;
	private Explanation explanation;
	private Part part;
	private String date;
	private Queries queries;
	private Query query;
	private Constraints constraints;
	private Constraint constraint;
	private Commands commands;
	private Command command;
	private Event_chart eventChart;
	private Event event;
	private Scenario_chart scenarioChart;
	private Scenario scenario1;
	private Scenario scenario2;
	private Creation_chart creationChart;
	private Creation creation;	

	@Before
	public void setUp() throws Exception {
		/**
		 * Creating Informal_charts
		 */
		informalCharts = BONFactoryImpl.eINSTANCE.createInformal_charts();

		/**
		 * Creating System_chart
		 */
		systemChart = BONFactoryImpl.eINSTANCE.createSystem_chart();
		systemChart.setName("persons");
		/**
		 * System_chart Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * System_chart Index_Identifier
		 */
		indexIdentifier= BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("author");
		authorname="Stephen Sarquah";
		indexIdentifier.getIndex_string().add(authorname);
		indexing.getIndex_term_list().add(indexIdentifier);
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("keywords");
		indexIdentifier.getIndex_string().add("prototype");
		indexIdentifier.getIndex_string().add("person");
		indexing.getIndex_term_list().add(indexIdentifier);
		systemChart.setChart_indexing(indexing);
		/**
		 * System_chart Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("A person is a programmer using this tool");
		systemChart.setExplanation(explanation);
		/**
		 * System_chart Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		systemChart.setChart_part(part);		
		/**
		 * System_chart Cluster
		 */
		cluster = BONFactoryImpl.eINSTANCE.createCluster();
		cluster.setName("workgroup");
		cluster.setDescription("A workgroup consists of persons");
		systemChart.getCluster_entries().add(cluster);
		
		/**
		 * Creating Cluster_chart
		 */
		clusterChart = BONFactoryImpl.eINSTANCE.createCluster_chart();
		clusterChart.setCluster(cluster);
		/**
		 * Cluster_chart Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * Cluster_chart Index_Identifier
		 */
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("author");
		indexIdentifier.getIndex_string().add(authorname);
		indexing.getIndex_term_list().add(indexIdentifier);
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("keywords");
		indexIdentifier.getIndex_string().add("programmers");
		indexIdentifier.getIndex_string().add("person");
		indexing.getIndex_term_list().add(indexIdentifier);
		clusterChart.setChart_indexing(indexing);
		/**
		 * Cluster_chart Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("This cluster is a workgroup");
		clusterChart.setExplanation(explanation);
		/**
		 * Cluster_chart Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		clusterChart.setChart_part(part);
		/**
		 * Cluster_chart Class
		 */
		className1 = BONFactoryImpl.eINSTANCE.createClassBON();
		className1.setName("person");
		className1.setDescription("A person is a normal guy");
		clusterChart.getClass_entries().add(className1);
		className2 = BONFactoryImpl.eINSTANCE.createClassBON();
		className2.setName("programmer");
		className2.setDescription("A person is also a normal guy");
		clusterChart.getClass_entries().add(className2);
		
		/**
		 * Creating Class_chart #1
		 */
		classChart1 = BONFactoryImpl.eINSTANCE.createClass_chart();
		classChart1.setClass(className1);
		/**
		 * Class_chart #1 Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * Class_chart #1 Index_Identifier
		 */
		indexIdentifier= BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("in_cluster");
		indexIdentifier.getIndex_string().add("workgroup");
		indexing.getIndex_term_list().add(indexIdentifier);
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		date = "31-01-2013";
		indexIdentifier.setName("created");		
		indexIdentifier.getIndex_string().add(date);
		indexIdentifier.setName("revised");		
		indexIdentifier.getIndex_string().add(date);
		indexing.getIndex_term_list().add(indexIdentifier);
		classChart1.setChart_indexing(indexing);
		/**
		 * Class_chart #1 Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("A person is a normal guy");
		classChart1.setExplanation(explanation);
		/**
		 * Class_chart #1 Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		classChart1.setChart_part(part);
		/**
		 * Class_chart #1 Queries
		 */
		queries = BONFactoryImpl.eINSTANCE.createQueries();
		query = BONFactoryImpl.eINSTANCE.createQuery();
		query.setName("What is the person's name?");
		queries.getQuery().add(query);
		query.setName("What is the sex of the person?");
		queries.getQuery().add(query);
		query.setName("What is the age?");
		queries.getQuery().add(query);
		query.setName("What skills does this person have?");
		queries.getQuery().add(query);
		classChart1.setQueries(queries);
		/**
		 * Class_chart #1 Constraints
		 */
		constraints = BONFactoryImpl.eINSTANCE.createConstraints();
		constraint = BONFactoryImpl.eINSTANCE.createConstraint();
		constraint.setName("Each person must have skills");
		constraints.getConstraint().add(constraint);
		classChart1.setConstraints(constraints);
		
		/**
		 * Creating Class_chart #2
		 */
		classChart2 = BONFactoryImpl.eINSTANCE.createClass_chart();
		classChart2.setClass(className2);
		classChart2.getInherit().add(className1);
		/**
		 * Class_chart #2 Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * Class_chart #2 Index_Identifier
		 */
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("created");
		date="03-04-2013";
		indexIdentifier.getIndex_string().add(date);
		indexIdentifier.setName("revised");		
		indexIdentifier.getIndex_string().add(date);
		indexing.getIndex_term_list().add(indexIdentifier);
		classChart2.setChart_indexing(indexing);
		/**
		 * Class_chart #2 Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("A programmer is also a normal guy");
		classChart2.setExplanation(explanation);
		/**
		 * Class_chart #2 Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		classChart2.setChart_part(part);
		/**
		 * Class_chart #2 Commands
		 */
		commands = BONFactoryImpl.eINSTANCE.createCommands();
		command = BONFactoryImpl.eINSTANCE.createCommand();
		command.setName("Program");
		commands.getCommand().add(command);
		classChart2.setCommands(commands);
		/**
		 * Class_chart #2 Constraints
		 */
		constraints = BONFactoryImpl.eINSTANCE.createConstraints();
		constraint = BONFactoryImpl.eINSTANCE.createConstraint();
		constraint.setName("Each person cannot program while person is over 50");
		constraints.getConstraint().add(constraint);
		classChart2.setConstraints(constraints);
		
		/**
		 * Creating Event_chart
		 */
		eventChart = BONFactoryImpl.eINSTANCE.createEvent_chart();
		eventChart.setSystem_name(systemChart);
		eventChart.setEvent_type(Event_type.INCOMING);
		/**
		 * Event_chart Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * Event_chart Index_Identifier
		 */
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("author");		
		indexIdentifier.getIndex_string().add(authorname);		
		eventChart.setChart_indexing(indexing);
		/**
		 * Event_chart Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("This event chart shows all incoming events in the system");
		eventChart.setExplanation(explanation);
		/**
		 * Event_chart Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		eventChart.setChart_part(part);
		/**
		 * Event #1
		 */
		event = BONFactoryImpl.eINSTANCE.createEvent();
		event.setName("Call a person");
		event.getInvolves().add(className1);
		eventChart.getEvent_entries().add(event);
		/**
		 * Event #2
		 */
		event = BONFactoryImpl.eINSTANCE.createEvent();
		event.setName("Remove a programmer from system");
		event.getInvolves().add(className2);
		eventChart.getEvent_entries().add(event);
		
		/**
		 * Creating Scenario_chart
		 */
		scenarioChart = BONFactoryImpl.eINSTANCE.createScenario_chart();
		scenarioChart.setSystem_name(systemChart);
		/**
		 * Scenario_chart Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * Scenario_chart Index_Identifier
		 */
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("author");		
		indexIdentifier.getIndex_string().add(authorname);		
		scenarioChart.setChart_indexing(indexing);
		/**
		 * Scenario_chart Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("This scenario chart shows a possible scenario of a system");
		scenarioChart.setExplanation(explanation);
		/**
		 * Scenario_chart Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		scenarioChart.setChart_part(part);
		/**
		 * Scenario_chart Scenario #1
		 */
		scenario1 = BONFactoryImpl.eINSTANCE.createScenario();
		scenario1.setName("Phone rings");
		scenario1.setDescription("When the phone rings a person answers");
		scenarioChart.getScenario_entries().add(scenario1);
		/**
		 * Scenario_chart Scenario #2
		 */
		scenario2 = BONFactoryImpl.eINSTANCE.createScenario();
		scenario2.setName("Removing programmer from system");
		scenario2.setDescription("A programmer is removed from the system");
		scenarioChart.getScenario_entries().add(scenario2);
		
		/**
		 * Creating Creation_chart
		 */
		creationChart = BONFactoryImpl.eINSTANCE.createCreation_chart();
		creationChart.setSystem_name(systemChart);
		/**
		 * Creation_chart Indexing
		 */
		indexing = BONFactoryImpl.eINSTANCE.createIndexing();
		/**
		 * Creation_chart Index_Identifier
		 */
		indexIdentifier = BONFactoryImpl.eINSTANCE.createIndex_Identifier();
		indexIdentifier.setName("author");		
		indexIdentifier.getIndex_string().add(authorname);		
		creationChart.setChart_indexing(indexing);
		/**
		 * Creation_chart Explanation
		 */
		explanation = BONFactoryImpl.eINSTANCE.createExplanation();
		explanation.setName("This scenario chart shows a possible scenario of a system");
		creationChart.setExplanation(explanation);
		/**
		 * Creation_chart Part
		 */
		part = BONFactoryImpl.eINSTANCE.createPart();
		part.setName("1/1");
		creationChart.setChart_part(part);
		/**
		 * Creation
		 */
		creation = BONFactoryImpl.eINSTANCE.createCreation();
		creation.setCreator(className2);
		creation.getCreates().add(className1);
		
		/**
		 * Add System_chart, Cluster_chart, Class_chart, Event_chart, Scenario_chart, Creation_chart
		 */
		informalCharts.setSystem_chart(systemChart);
		informalCharts.getCluster_charts().add(clusterChart);
		informalCharts.getClass_charts().add(classChart1);
		informalCharts.getClass_charts().add(classChart2);
		informalCharts.getEvent_charts().add(eventChart);
		informalCharts.getScenario_charts().add(scenarioChart);
		informalCharts.getCreation_charts().add(creationChart);
	}

	@Test
	public void testInformalCharts() {
		assertNotNull(informalCharts);		
	}
	@Test
	public void testSystemChart() {
		System_chart testSystemChart = informalCharts.getSystem_chart();
		assertNotNull(testSystemChart);
		assertEquals("persons", systemChart.getName());
		assertNotNull(testSystemChart.getChart_indexing());
		assertNotNull(testSystemChart.getChart_part());
		assertNotNull(testSystemChart.getCluster_entries());
		assertEquals("workgroup",testSystemChart.getCluster_entries().get(0).getName());
	}
	@Test
	public void testClusterChart() {
		assertNotNull(informalCharts.getCluster_charts());
		for (int i = 0; i < informalCharts.getCluster_charts().size(); i++) {
			assertNotNull(informalCharts.getCluster_charts().get(i).getCluster().getName());
			assertNotNull(informalCharts.getCluster_charts().get(i).getChart_indexing());
			assertNotNull(informalCharts.getCluster_charts().get(i).getChart_part());
			for (int j = 0; j < informalCharts.getCluster_charts().get(i).getClass_entries().size(); j++) {
				assertNotNull(informalCharts.getCluster_charts().get(i).getClass_entries().get(j));
			}
			assertEquals("Testing if name in class_chart is set to person", "person", informalCharts.getCluster_charts().get(i).getClass_entries().get(0).getName());
		}		
	}
	@Test
	public void testClassChart1() {
		assertNotNull(informalCharts.getClass_charts().get(0));
		assertNotNull(informalCharts.getClass_charts().get(0).getClass_().getName());
		assertEquals("Testing if name in class_chart is set to person", "person", informalCharts.getClass_charts().get(0).getClass_().getName());
		assertNotNull(informalCharts.getClass_charts().get(0).getClass_().getDescription());
		assertNotNull(informalCharts.getClass_charts().get(0).getChart_part());
		assertNotNull(informalCharts.getClass_charts().get(0).getChart_indexing());
		assertNotNull(informalCharts.getClass_charts().get(0).getExplanation());
		assertNotNull(informalCharts.getClass_charts().get(0).getQueries().getQuery());
		for (int i = 0; i < informalCharts.getClass_charts().get(0).getQueries().getQuery().size(); i++) {
			assertNotNull(informalCharts.getClass_charts().get(0).getQueries().getQuery().get(i));
		}
		assertNotNull(informalCharts.getClass_charts().get(0).getConstraints().getConstraint());
		for (int i = 0; i < informalCharts.getClass_charts().get(0).getConstraints().getConstraint().size(); i++) {
			assertNotNull(informalCharts.getClass_charts().get(0).getConstraints().getConstraint().get(i));
		}
	}
	@Test
	public void testClassChart2() {
		assertNotNull(informalCharts.getClass_charts().get(1));
		assertNotNull(informalCharts.getClass_charts().get(1).getClass_().getName());
		assertEquals("Testing if name in class_chart is set to programmer", "programmer", informalCharts.getClass_charts().get(1).getClass_().getName());
		assertNotNull(informalCharts.getClass_charts().get(1).getClass_().getDescription());
		assertNotNull(informalCharts.getClass_charts().get(1).getChart_part());
		assertNotNull(informalCharts.getClass_charts().get(1).getChart_indexing());
		assertNotNull(informalCharts.getClass_charts().get(1).getExplanation());
		for (int i = 0; i < informalCharts.getClass_charts().get(1).getInherit().size(); i++) {
			assertNotNull(informalCharts.getClass_charts().get(1).getInherit().get(i));
		}
		assertNotNull(informalCharts.getClass_charts().get(1).getCommands());
		for (int i = 0; i < informalCharts.getClass_charts().get(1).getCommands().getCommand().size(); i++) {
			assertNotNull(informalCharts.getClass_charts().get(1).getCommands().getCommand().get(i));
		}
		assertNotNull(informalCharts.getClass_charts().get(1).getConstraints().getConstraint());
		for (int i = 0; i < informalCharts.getClass_charts().get(1).getConstraints().getConstraint().size(); i++) {
			assertNotNull(informalCharts.getClass_charts().get(1).getConstraints().getConstraint().get(i));
		}
	}
	@Test
	public void testEventChart() {
		for (int i = 0; i < informalCharts.getEvent_charts().size(); i++) {
			assertNotNull(informalCharts.getEvent_charts().get(i));
			assertEquals("Testing if system name in event chart is set to persons","persons",informalCharts.getEvent_charts().get(i).getSystem_name().getName());
			assertNotNull(informalCharts.getEvent_charts().get(i).getChart_part());
			assertNotNull(informalCharts.getEvent_charts().get(i).getChart_indexing());
			assertNotNull(informalCharts.getEvent_charts().get(i).getExplanation());
			assertEquals("Testing if event type is incoming",Event_type.INCOMING, informalCharts.getEvent_charts().get(i).getEvent_type());
			for (int j = 0; j < informalCharts.getEvent_charts().get(i).getEvent_entries().size(); j++) {
				assertNotNull("Checking if events are not null", informalCharts.getEvent_charts().get(i).getEvent_entries().get(j));
				for (int j2 = 0; j2 < informalCharts.getEvent_charts().get(i).getEvent_entries().get(j).getInvolves().size(); j2++) {
					assertNotNull("Checking if events has set involves", informalCharts.getEvent_charts().get(i).getEvent_entries().get(j).getInvolves().get(j2));
				}				
			}
		}		
	}
	@Test
	public void testScenarioChart() {
		for (int i = 0; i < informalCharts.getScenario_charts().size(); i++) {
			assertNotNull(informalCharts.getScenario_charts().get(i));
			assertNotNull(informalCharts.getScenario_charts().get(i).getSystem_name());
			assertNotNull(informalCharts.getScenario_charts().get(i).getChart_indexing());
			assertNotNull(informalCharts.getScenario_charts().get(i).getChart_part());
			assertNotNull(informalCharts.getScenario_charts().get(i).getExplanation());
			for (int j = 0; j < informalCharts.getScenario_charts().get(i).getScenario_entries().size(); j++) {
				assertNotNull(informalCharts.getScenario_charts().get(i).getScenario_entries().get(j).getName());
				assertNotNull(informalCharts.getScenario_charts().get(i).getScenario_entries().get(j).getDescription());
			}			
		}
	}
	@Test
	public void testCreationChart() {
		for (int i = 0; i < informalCharts.getCreation_charts().size(); i++) {
			assertNotNull(informalCharts.getCreation_charts().get(i));
			assertEquals("persons", informalCharts.getCreation_charts().get(i).getSystem_name().getName());
			assertNotNull(informalCharts.getCreation_charts().get(i).getChart_indexing());
			assertNotNull(informalCharts.getCreation_charts().get(i).getChart_part());
			assertNotNull(informalCharts.getCreation_charts().get(i).getExplanation());
			for (int j = 0; j < informalCharts.getCreation_charts().get(i).getCreation_entries().size(); j++) {
				assertNotNull(informalCharts.getCreation_charts().get(i).getCreation_entries().get(j));
				assertEquals("programmer",informalCharts.getCreation_charts().get(i).getCreation_entries().get(j).getCreator().getName());
			}
		}
	}
}
