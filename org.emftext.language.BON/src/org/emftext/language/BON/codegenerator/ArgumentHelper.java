package org.emftext.language.BON.codegenerator;

import java.util.List;

import org.emftext.language.BON.ClassBON;
import org.emftext.language.BON.Class_chart;
import org.emftext.language.BON.Cluster_chart;
import org.emftext.language.BON.Creation_chart;
import org.emftext.language.BON.Event_chart;
import org.emftext.language.BON.Scenario_chart;

public class ArgumentHelper {
	private ClassBON classBON;
	private Class_chart classChart;
	private Cluster_chart clusterChart;
	private List<Event_chart> eventCharts;
	private Scenario_chart scenarioChart;
	private List<Creation_chart> creationCharts;
	private List<Class_chart> classCharts;
	
	public ClassBON getClassBON() {
		return classBON;
	}
	public void setClassBON(ClassBON classBON) {
		this.classBON = classBON;
	}
	public Class_chart getClassChart() {
		return classChart;
	}
	public void setClassChart(Class_chart classChart) {
		this.classChart = classChart;
	}
	public Cluster_chart getClusterChart() {
		return clusterChart;
	}
	public void setClusterChart(Cluster_chart clusterChart) {
		this.clusterChart = clusterChart;
	}
	public Scenario_chart getScenarioChart() {
		return scenarioChart;
	}
	public void setScenarioChart(Scenario_chart scenarioChart) {
		this.scenarioChart = scenarioChart;
	}
	public List<Event_chart> getEventCharts() {
		return eventCharts;
	}
	public void setEventCharts(List<Event_chart> eventCharts) {
		this.eventCharts = eventCharts;
	}
	public List<Creation_chart> getCreationCharts() {
		return creationCharts;
	}
	public void setCreationCharts(List<Creation_chart> creationCharts) {
		this.creationCharts = creationCharts;
	}
	public List<Class_chart> getClassCharts() {
		return classCharts;
	}
	public void setClassCharts(List<Class_chart> classCharts) {
		this.classCharts = classCharts;
	}
}
