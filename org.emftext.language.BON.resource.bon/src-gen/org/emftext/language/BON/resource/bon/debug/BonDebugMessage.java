/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class BonDebugMessage {
	
	private static final char DELIMITER = ':';
	private org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes messageType;
	private String[] arguments;
	
	public BonDebugMessage(org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public BonDebugMessage(org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.emftext.language.BON.resource.bon.util.BonStringUtil.encode(DELIMITER, parts);
	}
	
	public static BonDebugMessage deserialize(String response) {
		java.util.List<String> parts = org.emftext.language.BON.resource.bon.util.BonStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes type = org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes.valueOf(messageType);
		BonDebugMessage message = new BonDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.emftext.language.BON.resource.bon.debug.EBonDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.emftext.language.BON.resource.bon.util.BonStringUtil.explode(arguments, ", ") + "]";
	}
	
}
