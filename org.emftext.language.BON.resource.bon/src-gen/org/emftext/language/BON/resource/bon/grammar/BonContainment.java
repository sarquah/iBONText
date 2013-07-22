/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.grammar;

public class BonContainment extends org.emftext.language.BON.resource.bon.grammar.BonTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public BonContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.BON.resource.bon.grammar.BonCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.BON.resource.bon.util.BonStringUtil.explode(allowedTypes, ", ", new org.emftext.language.BON.resource.bon.IBonFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
