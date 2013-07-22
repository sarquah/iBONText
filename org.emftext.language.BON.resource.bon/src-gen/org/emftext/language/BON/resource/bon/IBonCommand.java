/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IBonCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
