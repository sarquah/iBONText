/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

public class BonMetaInformation implements org.emftext.language.BON.resource.bon.IBonMetaInformation {
	
	public String getSyntaxName() {
		return "bon";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/BON";
	}
	
	public org.emftext.language.BON.resource.bon.IBonTextScanner createLexer() {
		return new org.emftext.language.BON.resource.bon.mopp.BonAntlrScanner(new org.emftext.language.BON.resource.bon.mopp.BonLexer());
	}
	
	public org.emftext.language.BON.resource.bon.IBonTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.BON.resource.bon.mopp.BonParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.BON.resource.bon.IBonTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.BON.resource.bon.IBonTextResource resource) {
		return new org.emftext.language.BON.resource.bon.mopp.BonPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.BON.resource.bon.mopp.BonSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.BON.resource.bon.mopp.BonSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.BON.resource.bon.IBonReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.BON.resource.bon.mopp.BonReferenceResolverSwitch();
	}
	
	public org.emftext.language.BON.resource.bon.IBonTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.BON.resource.bon.mopp.BonTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.BON/metamodel/BON.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.language.BON.resource.bon.mopp.BonParser.tokenNames;
	}
	
	public org.emftext.language.BON.resource.bon.IBonTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.BON.resource.bon.mopp.BonTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.BON.resource.bon.IBonBracketPair> getBracketPairs() {
		return new org.emftext.language.BON.resource.bon.mopp.BonBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.BON.resource.bon.mopp.BonFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.BON.resource.bon.mopp.BonResourceFactory();
	}
	
	public org.emftext.language.BON.resource.bon.mopp.BonNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.BON.resource.bon.mopp.BonNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.BON.resource.bon.mopp.BonResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.language.BON.resource.bon.ui.launchConfigurationType";
	}
	
	public org.emftext.language.BON.resource.bon.IBonNameProvider createNameProvider() {
		return new org.emftext.language.BON.resource.bon.analysis.BonDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.language.BON.resource.bon.mopp.BonAntlrTokenHelper tokenHelper = new org.emftext.language.BON.resource.bon.mopp.BonAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.emftext.language.BON.resource.bon.mopp.BonTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
