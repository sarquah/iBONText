/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getExplanation(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getIndexing(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getPart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getIndex_Identifier(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getCluster(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getClassBON(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getQueries(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getCommands(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getConstraints(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getQuery(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getCommand(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getConstraint(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getEvent(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getScenario(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(),
			org.emftext.language.BON.BONPackage.eINSTANCE.getCreation(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(),
		};
	}
	
}
