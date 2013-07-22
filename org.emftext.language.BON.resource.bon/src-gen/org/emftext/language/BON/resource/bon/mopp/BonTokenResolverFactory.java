/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.BON.resource.bon.mopp;

/**
 * The BonTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class BonTokenResolverFactory implements org.emftext.language.BON.resource.bon.IBonTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.language.BON.resource.bon.IBonTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.language.BON.resource.bon.IBonTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.BON.resource.bon.IBonTokenResolver defaultResolver = new org.emftext.language.BON.resource.bon.analysis.BonDefaultTokenResolver();
	
	public BonTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.BON.resource.bon.IBonTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.BON.resource.bon.IBonTokenResolver>();
		registerTokenResolver("EVENTTYPE", new org.emftext.language.BON.resource.bon.analysis.BonEVENTTYPETokenResolver());
		registerTokenResolver("IDENTIFIER", new org.emftext.language.BON.resource.bon.analysis.BonIDENTIFIERTokenResolver());
		registerTokenResolver("FEATURE_IDENTIFIER", new org.emftext.language.BON.resource.bon.analysis.BonFEATURE_IDENTIFIERTokenResolver());
		registerTokenResolver("MANIFEST_TEXTBLOCK", new org.emftext.language.BON.resource.bon.analysis.BonMANIFEST_TEXTBLOCKTokenResolver());
	}
	
	public org.emftext.language.BON.resource.bon.IBonTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.BON.resource.bon.IBonTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.BON.resource.bon.IBonTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.BON.resource.bon.IBonTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.BON.resource.bon.IBonTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.BON.resource.bon.IBonTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.language.BON.resource.bon.IBonTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.language.BON.resource.bon.IBonTokenResolver> resolverMap, String key, org.emftext.language.BON.resource.bon.IBonTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
