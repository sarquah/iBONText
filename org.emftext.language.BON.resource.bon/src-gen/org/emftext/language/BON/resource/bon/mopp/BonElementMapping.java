/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.BON.resource.bon.IBonElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class BonElementMapping<ReferenceType> implements org.emftext.language.BON.resource.bon.IBonElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public BonElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
