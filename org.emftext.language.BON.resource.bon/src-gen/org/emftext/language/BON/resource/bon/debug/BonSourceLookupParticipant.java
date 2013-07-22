/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.debug;

public class BonSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof org.emftext.language.BON.resource.bon.debug.BonStackFrame) {
			org.emftext.language.BON.resource.bon.debug.BonStackFrame frame = (org.emftext.language.BON.resource.bon.debug.BonStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
