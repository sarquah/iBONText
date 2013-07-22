// $ANTLR 3.4

	package org.emftext.language.BON.resource.bon.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BonParser extends BonANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "EVENTTYPE", "FEATURE_IDENTIFIER", "IDENTIFIER", "KEYWORDS", "LINEBREAK", "MANIFEST_TEXTBLOCK", "PREDEFINED_NAMES", "SIMPLE_STRING", "STRING_BEGIN_END", "WHITESPACE", "','", "':'", "';'", "'class'", "'class_chart'", "'cluster'", "'cluster_chart'", "'command'", "'constraint'", "'creates'", "'creation_chart'", "'creator'", "'description'", "'end'", "'event'", "'event_chart'", "'explanation'", "'indexing'", "'inherit'", "'involves'", "'part'", "'query'", "'scenario'", "'scenario_chart'", "'system_chart'"
    };

    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int COMMENT=4;
    public static final int EVENTTYPE=5;
    public static final int FEATURE_IDENTIFIER=6;
    public static final int IDENTIFIER=7;
    public static final int KEYWORDS=8;
    public static final int LINEBREAK=9;
    public static final int MANIFEST_TEXTBLOCK=10;
    public static final int PREDEFINED_NAMES=11;
    public static final int SIMPLE_STRING=12;
    public static final int STRING_BEGIN_END=13;
    public static final int WHITESPACE=14;

    // delegates
    public BonANTLRParserBase[] getDelegates() {
        return new BonANTLRParserBase[] {};
    }

    // delegators


    public BonParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public BonParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(68 + 1);
         

    }

    public String[] getTokenNames() { return BonParser.tokenNames; }
    public String getGrammarFileName() { return "Bon.g"; }


    	private org.emftext.language.BON.resource.bon.IBonTokenResolverFactory tokenResolverFactory = new org.emftext.language.BON.resource.bon.mopp.BonTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>() {
    			public boolean execute(org.emftext.language.BON.resource.bon.IBonTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.language.BON.resource.bon.IBonProblem() {
    					public org.emftext.language.BON.resource.bon.BonEProblemSeverity getSeverity() {
    						return org.emftext.language.BON.resource.bon.BonEProblemSeverity.ERROR;
    					}
    					public org.emftext.language.BON.resource.bon.BonEProblemType getType() {
    						return org.emftext.language.BON.resource.bon.BonEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.emftext.language.BON.resource.bon.IBonQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		org.emftext.language.BON.resource.bon.IBonExpectedElement terminal = org.emftext.language.BON.resource.bon.grammar.BonFollowSetProvider.TERMINALS[terminalID];
    		org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[] containmentFeatures = new org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.emftext.language.BON.resource.bon.grammar.BonFollowSetProvider.LINKS[ids[i]];
    		}
    		org.emftext.language.BON.resource.bon.grammar.BonContainmentTrace containmentTrace = new org.emftext.language.BON.resource.bon.grammar.BonContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal expectedElement = new org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>() {
    			public boolean execute(org.emftext.language.BON.resource.bon.IBonTextResource resource) {
    				org.emftext.language.BON.resource.bon.IBonLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>() {
    			public boolean execute(org.emftext.language.BON.resource.bon.IBonTextResource resource) {
    				org.emftext.language.BON.resource.bon.IBonLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>() {
    			public boolean execute(org.emftext.language.BON.resource.bon.IBonTextResource resource) {
    				org.emftext.language.BON.resource.bon.IBonLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.emftext.language.BON.resource.bon.IBonTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new BonParser(new org.antlr.runtime3_4_0.CommonTokenStream(new BonLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new BonParser(new org.antlr.runtime3_4_0.CommonTokenStream(new BonLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.emftext.language.BON.resource.bon.util.BonRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public BonParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((BonLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((BonLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.language.BON.Informal_charts.class) {
    				return parse_org_emftext_language_BON_Informal_005fcharts();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.System_chart.class) {
    				return parse_org_emftext_language_BON_System_005fchart();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Explanation.class) {
    				return parse_org_emftext_language_BON_Explanation();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Indexing.class) {
    				return parse_org_emftext_language_BON_Indexing();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Part.class) {
    				return parse_org_emftext_language_BON_Part();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Index_Identifier.class) {
    				return parse_org_emftext_language_BON_Index_005fIdentifier();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Cluster.class) {
    				return parse_org_emftext_language_BON_Cluster();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Cluster_chart.class) {
    				return parse_org_emftext_language_BON_Cluster_005fchart();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.ClassBON.class) {
    				return parse_org_emftext_language_BON_ClassBON();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Class_chart.class) {
    				return parse_org_emftext_language_BON_Class_005fchart();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Queries.class) {
    				return parse_org_emftext_language_BON_Queries();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Commands.class) {
    				return parse_org_emftext_language_BON_Commands();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Constraints.class) {
    				return parse_org_emftext_language_BON_Constraints();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Query.class) {
    				return parse_org_emftext_language_BON_Query();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Command.class) {
    				return parse_org_emftext_language_BON_Command();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Constraint.class) {
    				return parse_org_emftext_language_BON_Constraint();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Event_chart.class) {
    				return parse_org_emftext_language_BON_Event_005fchart();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Event.class) {
    				return parse_org_emftext_language_BON_Event();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Scenario_chart.class) {
    				return parse_org_emftext_language_BON_Scenario_005fchart();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Scenario.class) {
    				return parse_org_emftext_language_BON_Scenario();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Creation_chart.class) {
    				return parse_org_emftext_language_BON_Creation_005fchart();
    			}
    			if (type.getInstanceClass() == org.emftext.language.BON.Creation.class) {
    				return parse_org_emftext_language_BON_Creation();
    			}
    		}
    		throw new org.emftext.language.BON.resource.bon.mopp.BonUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.emftext.language.BON.resource.bon.IBonOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.emftext.language.BON.resource.bon.IBonParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource>>();
    		org.emftext.language.BON.resource.bon.mopp.BonParseResult parseResult = new org.emftext.language.BON.resource.bon.mopp.BonParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.BON.resource.bon.IBonTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.emftext.language.BON.resource.bon.IBonParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (org.emftext.language.BON.resource.bon.IBonCommand<org.emftext.language.BON.resource.bon.IBonTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal>();
    		java.util.List<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 139;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.language.BON.resource.bon.util.BonPair<org.emftext.language.BON.resource.bon.IBonExpectedElement, org.emftext.language.BON.resource.bon.mopp.BonContainedFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.language.BON.resource.bon.IBonExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.emftext.language.BON.resource.bon.grammar.BonContainmentTrace containmentTrace = new org.emftext.language.BON.resource.bon.grammar.BonContainmentTrace(null, newFollowerPair.getRight());
    							org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal newFollowTerminal = new org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.language.BON.resource.bon.mopp.BonExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Bon.g:562:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_BON_Informal_005fcharts ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.language.BON.Informal_charts c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Bon.g:563:2: ( (c0= parse_org_emftext_language_BON_Informal_005fcharts ) EOF )
            // Bon.g:564:2: (c0= parse_org_emftext_language_BON_Informal_005fcharts ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Bon.g:569:2: (c0= parse_org_emftext_language_BON_Informal_005fcharts )
            // Bon.g:570:3: c0= parse_org_emftext_language_BON_Informal_005fcharts
            {
            pushFollow(FOLLOW_parse_org_emftext_language_BON_Informal_005fcharts_in_start82);
            c0=parse_org_emftext_language_BON_Informal_005fcharts();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_emftext_language_BON_Informal_005fcharts"
    // Bon.g:578:1: parse_org_emftext_language_BON_Informal_005fcharts returns [org.emftext.language.BON.Informal_charts element = null] : (a0_0= parse_org_emftext_language_BON_System_005fchart ) ( ( (a1_0= parse_org_emftext_language_BON_Cluster_005fchart ) | (a2_0= parse_org_emftext_language_BON_Class_005fchart ) | (a3_0= parse_org_emftext_language_BON_Event_005fchart ) | (a4_0= parse_org_emftext_language_BON_Scenario_005fchart ) | (a5_0= parse_org_emftext_language_BON_Creation_005fchart ) ) )* ;
    public final org.emftext.language.BON.Informal_charts parse_org_emftext_language_BON_Informal_005fcharts() throws RecognitionException {
        org.emftext.language.BON.Informal_charts element =  null;

        int parse_org_emftext_language_BON_Informal_005fcharts_StartIndex = input.index();

        org.emftext.language.BON.System_chart a0_0 =null;

        org.emftext.language.BON.Cluster_chart a1_0 =null;

        org.emftext.language.BON.Class_chart a2_0 =null;

        org.emftext.language.BON.Event_chart a3_0 =null;

        org.emftext.language.BON.Scenario_chart a4_0 =null;

        org.emftext.language.BON.Creation_chart a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Bon.g:581:2: ( (a0_0= parse_org_emftext_language_BON_System_005fchart ) ( ( (a1_0= parse_org_emftext_language_BON_Cluster_005fchart ) | (a2_0= parse_org_emftext_language_BON_Class_005fchart ) | (a3_0= parse_org_emftext_language_BON_Event_005fchart ) | (a4_0= parse_org_emftext_language_BON_Scenario_005fchart ) | (a5_0= parse_org_emftext_language_BON_Creation_005fchart ) ) )* )
            // Bon.g:582:2: (a0_0= parse_org_emftext_language_BON_System_005fchart ) ( ( (a1_0= parse_org_emftext_language_BON_Cluster_005fchart ) | (a2_0= parse_org_emftext_language_BON_Class_005fchart ) | (a3_0= parse_org_emftext_language_BON_Event_005fchart ) | (a4_0= parse_org_emftext_language_BON_Scenario_005fchart ) | (a5_0= parse_org_emftext_language_BON_Creation_005fchart ) ) )*
            {
            // Bon.g:582:2: (a0_0= parse_org_emftext_language_BON_System_005fchart )
            // Bon.g:583:3: a0_0= parse_org_emftext_language_BON_System_005fchart
            {
            pushFollow(FOLLOW_parse_org_emftext_language_BON_System_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts119);
            a0_0=parse_org_emftext_language_BON_System_005fchart();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createInformal_charts();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.INFORMAL_CHARTS__SYSTEM_CHART), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_0_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[5]);
            	}

            // Bon.g:612:2: ( ( (a1_0= parse_org_emftext_language_BON_Cluster_005fchart ) | (a2_0= parse_org_emftext_language_BON_Class_005fchart ) | (a3_0= parse_org_emftext_language_BON_Event_005fchart ) | (a4_0= parse_org_emftext_language_BON_Scenario_005fchart ) | (a5_0= parse_org_emftext_language_BON_Creation_005fchart ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19||LA2_0==21||LA2_0==25||LA2_0==30||LA2_0==38) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Bon.g:613:3: ( (a1_0= parse_org_emftext_language_BON_Cluster_005fchart ) | (a2_0= parse_org_emftext_language_BON_Class_005fchart ) | (a3_0= parse_org_emftext_language_BON_Event_005fchart ) | (a4_0= parse_org_emftext_language_BON_Scenario_005fchart ) | (a5_0= parse_org_emftext_language_BON_Creation_005fchart ) )
            	    {
            	    // Bon.g:613:3: ( (a1_0= parse_org_emftext_language_BON_Cluster_005fchart ) | (a2_0= parse_org_emftext_language_BON_Class_005fchart ) | (a3_0= parse_org_emftext_language_BON_Event_005fchart ) | (a4_0= parse_org_emftext_language_BON_Scenario_005fchart ) | (a5_0= parse_org_emftext_language_BON_Creation_005fchart ) )
            	    int alt1=5;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt1=4;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt1=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // Bon.g:614:4: (a1_0= parse_org_emftext_language_BON_Cluster_005fchart )
            	            {
            	            // Bon.g:614:4: (a1_0= parse_org_emftext_language_BON_Cluster_005fchart )
            	            // Bon.g:615:5: a1_0= parse_org_emftext_language_BON_Cluster_005fchart
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_Cluster_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts152);
            	            a1_0=parse_org_emftext_language_BON_Cluster_005fchart();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createInformal_charts();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a1_0 != null) {
            	            						if (a1_0 != null) {
            	            							Object value = a1_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.INFORMAL_CHARTS__CLUSTER_CHARTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_0_0_0_1_0_0_0, a1_0, true);
            	            						copyLocalizationInfos(a1_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[6]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[7]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[8]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[9]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[10]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Bon.g:645:8: (a2_0= parse_org_emftext_language_BON_Class_005fchart )
            	            {
            	            // Bon.g:645:8: (a2_0= parse_org_emftext_language_BON_Class_005fchart )
            	            // Bon.g:646:5: a2_0= parse_org_emftext_language_BON_Class_005fchart
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_Class_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts194);
            	            a2_0=parse_org_emftext_language_BON_Class_005fchart();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createInformal_charts();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a2_0 != null) {
            	            						if (a2_0 != null) {
            	            							Object value = a2_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.INFORMAL_CHARTS__CLASS_CHARTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_0_0_0_1_0_1_0, a2_0, true);
            	            						copyLocalizationInfos(a2_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[11]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[12]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[13]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[14]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[15]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Bon.g:676:8: (a3_0= parse_org_emftext_language_BON_Event_005fchart )
            	            {
            	            // Bon.g:676:8: (a3_0= parse_org_emftext_language_BON_Event_005fchart )
            	            // Bon.g:677:5: a3_0= parse_org_emftext_language_BON_Event_005fchart
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_Event_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts236);
            	            a3_0=parse_org_emftext_language_BON_Event_005fchart();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createInformal_charts();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a3_0 != null) {
            	            						if (a3_0 != null) {
            	            							Object value = a3_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.INFORMAL_CHARTS__EVENT_CHARTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_0_0_0_1_0_2_0, a3_0, true);
            	            						copyLocalizationInfos(a3_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[16]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[17]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[18]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[19]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[20]);
            	            			}

            	            }
            	            break;
            	        case 4 :
            	            // Bon.g:707:8: (a4_0= parse_org_emftext_language_BON_Scenario_005fchart )
            	            {
            	            // Bon.g:707:8: (a4_0= parse_org_emftext_language_BON_Scenario_005fchart )
            	            // Bon.g:708:5: a4_0= parse_org_emftext_language_BON_Scenario_005fchart
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_Scenario_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts278);
            	            a4_0=parse_org_emftext_language_BON_Scenario_005fchart();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createInformal_charts();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a4_0 != null) {
            	            						if (a4_0 != null) {
            	            							Object value = a4_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.INFORMAL_CHARTS__SCENARIO_CHARTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_0_0_0_1_0_3_0, a4_0, true);
            	            						copyLocalizationInfos(a4_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[21]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[22]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[23]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[24]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[25]);
            	            			}

            	            }
            	            break;
            	        case 5 :
            	            // Bon.g:738:8: (a5_0= parse_org_emftext_language_BON_Creation_005fchart )
            	            {
            	            // Bon.g:738:8: (a5_0= parse_org_emftext_language_BON_Creation_005fchart )
            	            // Bon.g:739:5: a5_0= parse_org_emftext_language_BON_Creation_005fchart
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_Creation_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts320);
            	            a5_0=parse_org_emftext_language_BON_Creation_005fchart();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createInformal_charts();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a5_0 != null) {
            	            						if (a5_0 != null) {
            	            							Object value = a5_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.INFORMAL_CHARTS__CREATION_CHARTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_0_0_0_1_0_4_0, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[26]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[27]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[28]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[29]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[30]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[35]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_BON_Informal_005fcharts_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Informal_005fcharts"



    // $ANTLR start "parse_org_emftext_language_BON_System_005fchart"
    // Bon.g:781:1: parse_org_emftext_language_BON_System_005fchart returns [org.emftext.language.BON.System_chart element = null] : a0= 'system_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Cluster ) )* a6= 'end' ;
    public final org.emftext.language.BON.System_chart parse_org_emftext_language_BON_System_005fchart() throws RecognitionException {
        org.emftext.language.BON.System_chart element =  null;

        int parse_org_emftext_language_BON_System_005fchart_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a6=null;
        org.emftext.language.BON.Indexing a2_0 =null;

        org.emftext.language.BON.Explanation a3_0 =null;

        org.emftext.language.BON.Part a4_0 =null;

        org.emftext.language.BON.Cluster a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Bon.g:784:2: (a0= 'system_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Cluster ) )* a6= 'end' )
            // Bon.g:785:2: a0= 'system_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Cluster ) )* a6= 'end'
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_language_BON_System_005fchart376); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[36]);
            	}

            // Bon.g:799:2: (a1= IDENTIFIER )
            // Bon.g:800:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_System_005fchart394); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SYSTEM_CHART__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SYSTEM_CHART__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[41]);
            	}

            // Bon.g:839:2: ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==32) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Bon.g:840:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    {
                    // Bon.g:840:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    // Bon.g:841:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    {
                    // Bon.g:841:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    // Bon.g:842:5: a2_0= parse_org_emftext_language_BON_Indexing
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_System_005fchart430);
                    a2_0=parse_org_emftext_language_BON_Indexing();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SYSTEM_CHART__CHART_INDEXING), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[42]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[43]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[44]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[45]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[49]);
            	}

            // Bon.g:880:2: ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==31) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Bon.g:881:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    {
                    // Bon.g:881:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    // Bon.g:882:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    {
                    // Bon.g:882:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    // Bon.g:883:5: a3_0= parse_org_emftext_language_BON_Explanation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_System_005fchart486);
                    a3_0=parse_org_emftext_language_BON_Explanation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SYSTEM_CHART__EXPLANATION), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[50]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[51]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[52]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[55]);
            	}

            // Bon.g:919:2: ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==35) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Bon.g:920:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    {
                    // Bon.g:920:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    // Bon.g:921:4: (a4_0= parse_org_emftext_language_BON_Part )
                    {
                    // Bon.g:921:4: (a4_0= parse_org_emftext_language_BON_Part )
                    // Bon.g:922:5: a4_0= parse_org_emftext_language_BON_Part
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_System_005fchart542);
                    a4_0=parse_org_emftext_language_BON_Part();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SYSTEM_CHART__CHART_PART), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_4_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[57]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[59]);
            	}

            // Bon.g:956:2: ( (a5_0= parse_org_emftext_language_BON_Cluster ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Bon.g:957:3: (a5_0= parse_org_emftext_language_BON_Cluster )
            	    {
            	    // Bon.g:957:3: (a5_0= parse_org_emftext_language_BON_Cluster )
            	    // Bon.g:958:4: a5_0= parse_org_emftext_language_BON_Cluster
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Cluster_in_parse_org_emftext_language_BON_System_005fchart592);
            	    a5_0=parse_org_emftext_language_BON_Cluster();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a5_0 != null) {
            	    					if (a5_0 != null) {
            	    						Object value = a5_0;
            	    						addObjectToList(element, org.emftext.language.BON.BONPackage.SYSTEM_CHART__CLUSTER_ENTRIES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_5, a5_0, true);
            	    					copyLocalizationInfos(a5_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[61]);
            	}

            a6=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_BON_System_005fchart618); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[66]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_BON_System_005fchart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_System_005fchart"



    // $ANTLR start "parse_org_emftext_language_BON_Explanation"
    // Bon.g:1005:1: parse_org_emftext_language_BON_Explanation returns [org.emftext.language.BON.Explanation element = null] : a0= 'explanation' (a1= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Explanation parse_org_emftext_language_BON_Explanation() throws RecognitionException {
        org.emftext.language.BON.Explanation element =  null;

        int parse_org_emftext_language_BON_Explanation_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Bon.g:1008:2: (a0= 'explanation' (a1= MANIFEST_TEXTBLOCK ) )
            // Bon.g:1009:2: a0= 'explanation' (a1= MANIFEST_TEXTBLOCK )
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_language_BON_Explanation647); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createExplanation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[67]);
            	}

            // Bon.g:1023:2: (a1= MANIFEST_TEXTBLOCK )
            // Bon.g:1024:3: a1= MANIFEST_TEXTBLOCK
            {
            a1=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Explanation665); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createExplanation();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EXPLANATION__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EXPLANATION__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_2_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[77]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[83]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_BON_Explanation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Explanation"



    // $ANTLR start "parse_org_emftext_language_BON_Indexing"
    // Bon.g:1076:1: parse_org_emftext_language_BON_Indexing returns [org.emftext.language.BON.Indexing element = null] : a0= 'indexing' ( (a1_0= parse_org_emftext_language_BON_Index_005fIdentifier ) )+ ;
    public final org.emftext.language.BON.Indexing parse_org_emftext_language_BON_Indexing() throws RecognitionException {
        org.emftext.language.BON.Indexing element =  null;

        int parse_org_emftext_language_BON_Indexing_StartIndex = input.index();

        Token a0=null;
        org.emftext.language.BON.Index_Identifier a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Bon.g:1079:2: (a0= 'indexing' ( (a1_0= parse_org_emftext_language_BON_Index_005fIdentifier ) )+ )
            // Bon.g:1080:2: a0= 'indexing' ( (a1_0= parse_org_emftext_language_BON_Index_005fIdentifier ) )+
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_language_BON_Indexing701); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndexing();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getIndexing(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[84]);
            	}

            // Bon.g:1094:2: ( (a1_0= parse_org_emftext_language_BON_Index_005fIdentifier ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==FEATURE_IDENTIFIER) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Bon.g:1095:3: (a1_0= parse_org_emftext_language_BON_Index_005fIdentifier )
            	    {
            	    // Bon.g:1095:3: (a1_0= parse_org_emftext_language_BON_Index_005fIdentifier )
            	    // Bon.g:1096:4: a1_0= parse_org_emftext_language_BON_Index_005fIdentifier
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Index_005fIdentifier_in_parse_org_emftext_language_BON_Indexing724);
            	    a1_0=parse_org_emftext_language_BON_Index_005fIdentifier();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndexing();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a1_0 != null) {
            	    					if (a1_0 != null) {
            	    						Object value = a1_0;
            	    						addObjectToList(element, org.emftext.language.BON.BONPackage.INDEXING__INDEX_TERM_LIST, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_3_0_0_1, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getIndexing(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[102]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_BON_Indexing_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Indexing"



    // $ANTLR start "parse_org_emftext_language_BON_Part"
    // Bon.g:1141:1: parse_org_emftext_language_BON_Part returns [org.emftext.language.BON.Part element = null] : a0= 'part' (a1= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Part parse_org_emftext_language_BON_Part() throws RecognitionException {
        org.emftext.language.BON.Part element =  null;

        int parse_org_emftext_language_BON_Part_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Bon.g:1144:2: (a0= 'part' (a1= MANIFEST_TEXTBLOCK ) )
            // Bon.g:1145:2: a0= 'part' (a1= MANIFEST_TEXTBLOCK )
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_language_BON_Part765); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createPart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[103]);
            	}

            // Bon.g:1159:2: (a1= MANIFEST_TEXTBLOCK )
            // Bon.g:1160:3: a1= MANIFEST_TEXTBLOCK
            {
            a1=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Part783); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createPart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.PART__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.PART__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_4_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[118]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_BON_Part_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Part"



    // $ANTLR start "parse_org_emftext_language_BON_Index_005fIdentifier"
    // Bon.g:1211:1: parse_org_emftext_language_BON_Index_005fIdentifier returns [org.emftext.language.BON.Index_Identifier element = null] : (a0= FEATURE_IDENTIFIER ) a1= ':' (a2= MANIFEST_TEXTBLOCK ) ( (a3= ',' (a4= MANIFEST_TEXTBLOCK ) ) )* a5= ';' ;
    public final org.emftext.language.BON.Index_Identifier parse_org_emftext_language_BON_Index_005fIdentifier() throws RecognitionException {
        org.emftext.language.BON.Index_Identifier element =  null;

        int parse_org_emftext_language_BON_Index_005fIdentifier_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Bon.g:1214:2: ( (a0= FEATURE_IDENTIFIER ) a1= ':' (a2= MANIFEST_TEXTBLOCK ) ( (a3= ',' (a4= MANIFEST_TEXTBLOCK ) ) )* a5= ';' )
            // Bon.g:1215:2: (a0= FEATURE_IDENTIFIER ) a1= ':' (a2= MANIFEST_TEXTBLOCK ) ( (a3= ',' (a4= MANIFEST_TEXTBLOCK ) ) )* a5= ';'
            {
            // Bon.g:1215:2: (a0= FEATURE_IDENTIFIER )
            // Bon.g:1216:3: a0= FEATURE_IDENTIFIER
            {
            a0=(Token)match(input,FEATURE_IDENTIFIER,FOLLOW_FEATURE_IDENTIFIER_in_parse_org_emftext_language_BON_Index_005fIdentifier823); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("FEATURE_IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.INDEX_IDENTIFIER__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.INDEX_IDENTIFIER__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[119]);
            	}

            a1=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_BON_Index_005fIdentifier844); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[120]);
            	}

            // Bon.g:1265:2: (a2= MANIFEST_TEXTBLOCK )
            // Bon.g:1266:3: a2= MANIFEST_TEXTBLOCK
            {
            a2=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Index_005fIdentifier862); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.INDEX_IDENTIFIER__INDEX_STRING), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					addObjectToList(element, org.emftext.language.BON.BONPackage.INDEX_IDENTIFIER__INDEX_STRING, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[122]);
            	}

            // Bon.g:1302:2: ( (a3= ',' (a4= MANIFEST_TEXTBLOCK ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Bon.g:1303:3: (a3= ',' (a4= MANIFEST_TEXTBLOCK ) )
            	    {
            	    // Bon.g:1303:3: (a3= ',' (a4= MANIFEST_TEXTBLOCK ) )
            	    // Bon.g:1304:4: a3= ',' (a4= MANIFEST_TEXTBLOCK )
            	    {
            	    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Index_005fIdentifier892); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[123]);
            	    			}

            	    // Bon.g:1318:4: (a4= MANIFEST_TEXTBLOCK )
            	    // Bon.g:1319:5: a4= MANIFEST_TEXTBLOCK
            	    {
            	    a4=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Index_005fIdentifier918); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4 != null) {
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.INDEX_IDENTIFIER__INDEX_STRING), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.INDEX_IDENTIFIER__INDEX_STRING, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_3_0_0_1, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[124]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[125]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[127]);
            	}

            a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_BON_Index_005fIdentifier964); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getIndexing(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[145]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_BON_Index_005fIdentifier_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Index_005fIdentifier"



    // $ANTLR start "parse_org_emftext_language_BON_Cluster"
    // Bon.g:1396:1: parse_org_emftext_language_BON_Cluster returns [org.emftext.language.BON.Cluster element = null] : a0= 'cluster' (a1= IDENTIFIER ) a2= 'description' (a3= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Cluster parse_org_emftext_language_BON_Cluster() throws RecognitionException {
        org.emftext.language.BON.Cluster element =  null;

        int parse_org_emftext_language_BON_Cluster_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Bon.g:1399:2: (a0= 'cluster' (a1= IDENTIFIER ) a2= 'description' (a3= MANIFEST_TEXTBLOCK ) )
            // Bon.g:1400:2: a0= 'cluster' (a1= IDENTIFIER ) a2= 'description' (a3= MANIFEST_TEXTBLOCK )
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_BON_Cluster993); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[146]);
            	}

            // Bon.g:1414:2: (a1= IDENTIFIER )
            // Bon.g:1415:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Cluster1011); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_6_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[147]);
            	}

            a2=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_BON_Cluster1032); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_6_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[148]);
            	}

            // Bon.g:1464:2: (a3= MANIFEST_TEXTBLOCK )
            // Bon.g:1465:3: a3= MANIFEST_TEXTBLOCK
            {
            a3=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Cluster1050); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER__DESCRIPTION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER__DESCRIPTION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_6_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[152]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_BON_Cluster_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Cluster"



    // $ANTLR start "parse_org_emftext_language_BON_Cluster_005fchart"
    // Bon.g:1505:1: parse_org_emftext_language_BON_Cluster_005fchart returns [org.emftext.language.BON.Cluster_chart element = null] : a0= 'cluster_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( ( (a5_0= parse_org_emftext_language_BON_ClassBON ) | (a6_0= parse_org_emftext_language_BON_Cluster ) ) )* a7= 'end' ;
    public final org.emftext.language.BON.Cluster_chart parse_org_emftext_language_BON_Cluster_005fchart() throws RecognitionException {
        org.emftext.language.BON.Cluster_chart element =  null;

        int parse_org_emftext_language_BON_Cluster_005fchart_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a7=null;
        org.emftext.language.BON.Indexing a2_0 =null;

        org.emftext.language.BON.Explanation a3_0 =null;

        org.emftext.language.BON.Part a4_0 =null;

        org.emftext.language.BON.ClassBON a5_0 =null;

        org.emftext.language.BON.Cluster a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Bon.g:1508:2: (a0= 'cluster_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( ( (a5_0= parse_org_emftext_language_BON_ClassBON ) | (a6_0= parse_org_emftext_language_BON_Cluster ) ) )* a7= 'end' )
            // Bon.g:1509:2: a0= 'cluster_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( ( (a5_0= parse_org_emftext_language_BON_ClassBON ) | (a6_0= parse_org_emftext_language_BON_Cluster ) ) )* a7= 'end'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_BON_Cluster_005fchart1086); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[153]);
            	}

            // Bon.g:1523:2: (a1= IDENTIFIER )
            // Bon.g:1524:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Cluster_005fchart1104); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER_CHART__CLUSTER), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.Cluster proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Cluster_chart, org.emftext.language.BON.Cluster>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCluster_chartClusterReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER_CHART__CLUSTER), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER_CHART__CLUSTER), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[159]);
            	}

            // Bon.g:1568:2: ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Bon.g:1569:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    {
                    // Bon.g:1569:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    // Bon.g:1570:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    {
                    // Bon.g:1570:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    // Bon.g:1571:5: a2_0= parse_org_emftext_language_BON_Indexing
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Cluster_005fchart1140);
                    a2_0=parse_org_emftext_language_BON_Indexing();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER_CHART__CHART_INDEXING), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[160]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[161]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[162]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[163]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[164]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[169]);
            	}

            // Bon.g:1611:2: ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Bon.g:1612:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    {
                    // Bon.g:1612:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    // Bon.g:1613:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    {
                    // Bon.g:1613:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    // Bon.g:1614:5: a3_0= parse_org_emftext_language_BON_Explanation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Cluster_005fchart1196);
                    a3_0=parse_org_emftext_language_BON_Explanation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER_CHART__EXPLANATION), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[170]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[171]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[172]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[173]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[177]);
            	}

            // Bon.g:1652:2: ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==35) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Bon.g:1653:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    {
                    // Bon.g:1653:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    // Bon.g:1654:4: (a4_0= parse_org_emftext_language_BON_Part )
                    {
                    // Bon.g:1654:4: (a4_0= parse_org_emftext_language_BON_Part )
                    // Bon.g:1655:5: a4_0= parse_org_emftext_language_BON_Part
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Cluster_005fchart1252);
                    a4_0=parse_org_emftext_language_BON_Part();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLUSTER_CHART__CHART_PART), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_4_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[178]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[179]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[180]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[183]);
            	}

            // Bon.g:1691:2: ( ( (a5_0= parse_org_emftext_language_BON_ClassBON ) | (a6_0= parse_org_emftext_language_BON_Cluster ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18||LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Bon.g:1692:3: ( (a5_0= parse_org_emftext_language_BON_ClassBON ) | (a6_0= parse_org_emftext_language_BON_Cluster ) )
            	    {
            	    // Bon.g:1692:3: ( (a5_0= parse_org_emftext_language_BON_ClassBON ) | (a6_0= parse_org_emftext_language_BON_Cluster ) )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==18) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==20) ) {
            	        alt12=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // Bon.g:1693:4: (a5_0= parse_org_emftext_language_BON_ClassBON )
            	            {
            	            // Bon.g:1693:4: (a5_0= parse_org_emftext_language_BON_ClassBON )
            	            // Bon.g:1694:5: a5_0= parse_org_emftext_language_BON_ClassBON
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_ClassBON_in_parse_org_emftext_language_BON_Cluster_005fchart1308);
            	            a5_0=parse_org_emftext_language_BON_ClassBON();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a5_0 != null) {
            	            						if (a5_0 != null) {
            	            							Object value = a5_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.CLUSTER_CHART__CLASS_ENTRIES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_5_0_0_0, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[184]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[185]);
            	            				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[186]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Bon.g:1722:8: (a6_0= parse_org_emftext_language_BON_Cluster )
            	            {
            	            // Bon.g:1722:8: (a6_0= parse_org_emftext_language_BON_Cluster )
            	            // Bon.g:1723:5: a6_0= parse_org_emftext_language_BON_Cluster
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_language_BON_Cluster_in_parse_org_emftext_language_BON_Cluster_005fchart1350);
            	            a6_0=parse_org_emftext_language_BON_Cluster();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a6_0 != null) {
            	            						if (a6_0 != null) {
            	            							Object value = a6_0;
            	            							addObjectToList(element, org.emftext.language.BON.BONPackage.CLUSTER_CHART__CLUSTERCHART_ENTRIES, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_5_0_1_0, a6_0, true);
            	            						copyLocalizationInfos(a6_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[187]);
            	            				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[188]);
            	            				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[189]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[192]);
            	}

            a7=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_BON_Cluster_005fchart1391); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[197]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_BON_Cluster_005fchart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Cluster_005fchart"



    // $ANTLR start "parse_org_emftext_language_BON_ClassBON"
    // Bon.g:1779:1: parse_org_emftext_language_BON_ClassBON returns [org.emftext.language.BON.ClassBON element = null] : a0= 'class' (a1= IDENTIFIER ) a2= 'description' (a3= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.ClassBON parse_org_emftext_language_BON_ClassBON() throws RecognitionException {
        org.emftext.language.BON.ClassBON element =  null;

        int parse_org_emftext_language_BON_ClassBON_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Bon.g:1782:2: (a0= 'class' (a1= IDENTIFIER ) a2= 'description' (a3= MANIFEST_TEXTBLOCK ) )
            // Bon.g:1783:2: a0= 'class' (a1= IDENTIFIER ) a2= 'description' (a3= MANIFEST_TEXTBLOCK )
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_BON_ClassBON1420); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_8_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[198]);
            	}

            // Bon.g:1797:2: (a1= IDENTIFIER )
            // Bon.g:1798:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_ClassBON1438); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_BON__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_BON__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_8_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[199]);
            	}

            a2=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_BON_ClassBON1459); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_8_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[200]);
            	}

            // Bon.g:1847:2: (a3= MANIFEST_TEXTBLOCK )
            // Bon.g:1848:3: a3= MANIFEST_TEXTBLOCK
            {
            a3=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_ClassBON1477); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_BON__DESCRIPTION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_BON__DESCRIPTION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_8_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[201]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[202]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[203]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_BON_ClassBON_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_ClassBON"



    // $ANTLR start "parse_org_emftext_language_BON_Class_005fchart"
    // Bon.g:1887:1: parse_org_emftext_language_BON_Class_005fchart returns [org.emftext.language.BON.Class_chart element = null] : a0= 'class_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )* ) )* ( (a9_0= parse_org_emftext_language_BON_Queries ) )? ( (a10_0= parse_org_emftext_language_BON_Commands ) )? ( (a11_0= parse_org_emftext_language_BON_Constraints ) )? a12= 'end' ;
    public final org.emftext.language.BON.Class_chart parse_org_emftext_language_BON_Class_005fchart() throws RecognitionException {
        org.emftext.language.BON.Class_chart element =  null;

        int parse_org_emftext_language_BON_Class_005fchart_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a12=null;
        org.emftext.language.BON.Indexing a2_0 =null;

        org.emftext.language.BON.Explanation a3_0 =null;

        org.emftext.language.BON.Part a4_0 =null;

        org.emftext.language.BON.Queries a9_0 =null;

        org.emftext.language.BON.Commands a10_0 =null;

        org.emftext.language.BON.Constraints a11_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Bon.g:1890:2: (a0= 'class_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )* ) )* ( (a9_0= parse_org_emftext_language_BON_Queries ) )? ( (a10_0= parse_org_emftext_language_BON_Commands ) )? ( (a11_0= parse_org_emftext_language_BON_Constraints ) )? a12= 'end' )
            // Bon.g:1891:2: a0= 'class_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )* ) )* ( (a9_0= parse_org_emftext_language_BON_Queries ) )? ( (a10_0= parse_org_emftext_language_BON_Commands ) )? ( (a11_0= parse_org_emftext_language_BON_Constraints ) )? a12= 'end'
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_BON_Class_005fchart1513); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[204]);
            	}

            // Bon.g:1905:2: (a1= IDENTIFIER )
            // Bon.g:1906:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Class_005fchart1531); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__CLASS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Class_chart, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClass_chartClassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__CLASS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__CLASS), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[207]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[209]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[210]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[211]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[212]);
            	}

            // Bon.g:1952:2: ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Bon.g:1953:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    {
                    // Bon.g:1953:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    // Bon.g:1954:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    {
                    // Bon.g:1954:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    // Bon.g:1955:5: a2_0= parse_org_emftext_language_BON_Indexing
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Class_005fchart1567);
                    a2_0=parse_org_emftext_language_BON_Indexing();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__CHART_INDEXING), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[213]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[214]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[215]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[216]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[217]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[218]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[219]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[220]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[221]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[222]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[223]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[226]);
            	}

            // Bon.g:1999:2: ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Bon.g:2000:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    {
                    // Bon.g:2000:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    // Bon.g:2001:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    {
                    // Bon.g:2001:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    // Bon.g:2002:5: a3_0= parse_org_emftext_language_BON_Explanation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Class_005fchart1623);
                    a3_0=parse_org_emftext_language_BON_Explanation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__EXPLANATION), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[227]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[228]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[229]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[230]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[231]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[232]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[238]);
            	}

            // Bon.g:2044:2: ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Bon.g:2045:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    {
                    // Bon.g:2045:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    // Bon.g:2046:4: (a4_0= parse_org_emftext_language_BON_Part )
                    {
                    // Bon.g:2046:4: (a4_0= parse_org_emftext_language_BON_Part )
                    // Bon.g:2047:5: a4_0= parse_org_emftext_language_BON_Part
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Class_005fchart1679);
                    a4_0=parse_org_emftext_language_BON_Part();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__CHART_PART), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_4_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[239]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[240]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[241]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[242]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[243]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[248]);
            	}

            // Bon.g:2087:2: ( (a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )* ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==33) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Bon.g:2088:3: (a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )* )
            	    {
            	    // Bon.g:2088:3: (a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )* )
            	    // Bon.g:2089:4: a5= 'inherit' (a6= IDENTIFIER ) ( (a7= ',' (a8= IDENTIFIER ) ) )*
            	    {
            	    a5=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_language_BON_Class_005fchart1729); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_5_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[249]);
            	    			}

            	    // Bon.g:2103:4: (a6= IDENTIFIER )
            	    // Bon.g:2104:5: a6= IDENTIFIER
            	    {
            	    a6=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Class_005fchart1755); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a6 != null) {
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__INHERIT), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            	    						}
            	    						String resolved = (String) resolvedObject;
            	    						org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            	    						collectHiddenTokens(element);
            	    						registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Class_chart, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClass_chartInheritReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__INHERIT), resolved, proxy);
            	    						if (proxy != null) {
            	    							Object value = proxy;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.CLASS_CHART__INHERIT, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_5_0_0_1, proxy, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[250]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[251]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[252]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[253]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[254]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[255]);
            	    			}

            	    // Bon.g:2148:4: ( (a7= ',' (a8= IDENTIFIER ) ) )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==15) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // Bon.g:2149:5: (a7= ',' (a8= IDENTIFIER ) )
            	    	    {
            	    	    // Bon.g:2149:5: (a7= ',' (a8= IDENTIFIER ) )
            	    	    // Bon.g:2150:6: a7= ',' (a8= IDENTIFIER )
            	    	    {
            	    	    a7=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Class_005fchart1801); if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    						if (element == null) {
            	    	    							element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            	    	    							startIncompleteElement(element);
            	    	    						}
            	    	    						collectHiddenTokens(element);
            	    	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_5_0_0_2_0_0_0, null, true);
            	    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	    	    					}

            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[256]);
            	    	    					}

            	    	    // Bon.g:2164:6: (a8= IDENTIFIER )
            	    	    // Bon.g:2165:7: a8= IDENTIFIER
            	    	    {
            	    	    a8=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Class_005fchart1835); if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    							if (terminateParsing) {
            	    	    								throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    	    							}
            	    	    							if (element == null) {
            	    	    								element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            	    	    								startIncompleteElement(element);
            	    	    							}
            	    	    							if (a8 != null) {
            	    	    								org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            	    	    								tokenResolver.setOptions(getOptions());
            	    	    								org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            	    	    								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__INHERIT), result);
            	    	    								Object resolvedObject = result.getResolvedToken();
            	    	    								if (resolvedObject == null) {
            	    	    									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            	    	    								}
            	    	    								String resolved = (String) resolvedObject;
            	    	    								org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            	    	    								collectHiddenTokens(element);
            	    	    								registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Class_chart, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClass_chartInheritReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__INHERIT), resolved, proxy);
            	    	    								if (proxy != null) {
            	    	    									Object value = proxy;
            	    	    									addObjectToList(element, org.emftext.language.BON.BONPackage.CLASS_CHART__INHERIT, value);
            	    	    									completedElement(value, false);
            	    	    								}
            	    	    								collectHiddenTokens(element);
            	    	    								retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_5_0_0_2_0_0_1, proxy, true);
            	    	    								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            	    	    								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
            	    	    							}
            	    	    						}

            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[257]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[258]);
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[259]);
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[260]);
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[261]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[262]);
            	    	    					}

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[263]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[264]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[265]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[266]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[267]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[268]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[269]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[270]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[272]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[273]);
            	}

            // Bon.g:2232:2: ( (a9_0= parse_org_emftext_language_BON_Queries ) )?
            int alt19=2;
            switch ( input.LA(1) ) {
                case 36:
                    {
                    alt19=1;
                    }
                    break;
                case 22:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred22_Bon()) ) {
                        alt19=1;
                    }
                    }
                    break;
                case 23:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred22_Bon()) ) {
                        alt19=1;
                    }
                    }
                    break;
                case 28:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred22_Bon()) ) {
                        alt19=1;
                    }
                    }
                    break;
            }

            switch (alt19) {
                case 1 :
                    // Bon.g:2233:3: (a9_0= parse_org_emftext_language_BON_Queries )
                    {
                    // Bon.g:2233:3: (a9_0= parse_org_emftext_language_BON_Queries )
                    // Bon.g:2234:4: a9_0= parse_org_emftext_language_BON_Queries
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Queries_in_parse_org_emftext_language_BON_Class_005fchart1925);
                    a9_0=parse_org_emftext_language_BON_Queries();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
                    					startIncompleteElement(element);
                    				}
                    				if (a9_0 != null) {
                    					if (a9_0 != null) {
                    						Object value = a9_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__QUERIES), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_6, a9_0, true);
                    					copyLocalizationInfos(a9_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[276]);
            	}

            // Bon.g:2262:2: ( (a10_0= parse_org_emftext_language_BON_Commands ) )?
            int alt20=2;
            switch ( input.LA(1) ) {
                case 22:
                    {
                    alt20=1;
                    }
                    break;
                case 23:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred23_Bon()) ) {
                        alt20=1;
                    }
                    }
                    break;
                case 28:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred23_Bon()) ) {
                        alt20=1;
                    }
                    }
                    break;
            }

            switch (alt20) {
                case 1 :
                    // Bon.g:2263:3: (a10_0= parse_org_emftext_language_BON_Commands )
                    {
                    // Bon.g:2263:3: (a10_0= parse_org_emftext_language_BON_Commands )
                    // Bon.g:2264:4: a10_0= parse_org_emftext_language_BON_Commands
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Commands_in_parse_org_emftext_language_BON_Class_005fchart1960);
                    a10_0=parse_org_emftext_language_BON_Commands();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
                    					startIncompleteElement(element);
                    				}
                    				if (a10_0 != null) {
                    					if (a10_0 != null) {
                    						Object value = a10_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__COMMANDS), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_7, a10_0, true);
                    					copyLocalizationInfos(a10_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[278]);
            	}

            // Bon.g:2291:2: ( (a11_0= parse_org_emftext_language_BON_Constraints ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            else if ( (LA21_0==28) ) {
                int LA21_2 = input.LA(2);

                if ( (synpred24_Bon()) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // Bon.g:2292:3: (a11_0= parse_org_emftext_language_BON_Constraints )
                    {
                    // Bon.g:2292:3: (a11_0= parse_org_emftext_language_BON_Constraints )
                    // Bon.g:2293:4: a11_0= parse_org_emftext_language_BON_Constraints
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Constraints_in_parse_org_emftext_language_BON_Class_005fchart1995);
                    a11_0=parse_org_emftext_language_BON_Constraints();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
                    					startIncompleteElement(element);
                    				}
                    				if (a11_0 != null) {
                    					if (a11_0 != null) {
                    						Object value = a11_0;
                    						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CLASS_CHART__CONSTRAINTS), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_8, a11_0, true);
                    					copyLocalizationInfos(a11_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[279]);
            	}

            a12=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_BON_Class_005fchart2021); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[281]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[284]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_BON_Class_005fchart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Class_005fchart"



    // $ANTLR start "parse_org_emftext_language_BON_Queries"
    // Bon.g:2339:1: parse_org_emftext_language_BON_Queries returns [org.emftext.language.BON.Queries element = null] : ( (a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )* ) )* ;
    public final org.emftext.language.BON.Queries parse_org_emftext_language_BON_Queries() throws RecognitionException {
        org.emftext.language.BON.Queries element =  null;

        int parse_org_emftext_language_BON_Queries_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.emftext.language.BON.Query a1_0 =null;

        org.emftext.language.BON.Query a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Bon.g:2342:2: ( ( (a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )* ) )* )
            // Bon.g:2343:2: ( (a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )* ) )*
            {
            // Bon.g:2343:2: ( (a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )* ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==36) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Bon.g:2344:3: (a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )* )
            	    {
            	    // Bon.g:2344:3: (a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )* )
            	    // Bon.g:2345:4: a0= 'query' (a1_0= parse_org_emftext_language_BON_Query ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )*
            	    {
            	    a0=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_language_BON_Queries2059); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createQueries();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_10_0_0_0_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getQueries(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[285]);
            	    			}

            	    // Bon.g:2359:4: (a1_0= parse_org_emftext_language_BON_Query )
            	    // Bon.g:2360:5: a1_0= parse_org_emftext_language_BON_Query
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Query_in_parse_org_emftext_language_BON_Queries2085);
            	    a1_0=parse_org_emftext_language_BON_Query();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createQueries();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a1_0 != null) {
            	    						if (a1_0 != null) {
            	    							Object value = a1_0;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.QUERIES__QUERY, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_10_0_0_0_0_0_1, a1_0, true);
            	    						copyLocalizationInfos(a1_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[286]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[287]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[288]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[289]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[290]);
            	    			}

            	    // Bon.g:2389:4: ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==15) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // Bon.g:2390:5: (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) )
            	    	    {
            	    	    // Bon.g:2390:5: (a2= ',' (a3_0= parse_org_emftext_language_BON_Query ) )
            	    	    // Bon.g:2391:6: a2= ',' (a3_0= parse_org_emftext_language_BON_Query )
            	    	    {
            	    	    a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Queries2126); if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    						if (element == null) {
            	    	    							element = org.emftext.language.BON.BONFactory.eINSTANCE.createQueries();
            	    	    							startIncompleteElement(element);
            	    	    						}
            	    	    						collectHiddenTokens(element);
            	    	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_10_0_0_0_0_0_2_0_0_0, null, true);
            	    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    	    					}

            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getQueries(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[291]);
            	    	    					}

            	    	    // Bon.g:2405:6: (a3_0= parse_org_emftext_language_BON_Query )
            	    	    // Bon.g:2406:7: a3_0= parse_org_emftext_language_BON_Query
            	    	    {
            	    	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Query_in_parse_org_emftext_language_BON_Queries2160);
            	    	    a3_0=parse_org_emftext_language_BON_Query();

            	    	    state._fsp--;
            	    	    if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    							if (terminateParsing) {
            	    	    								throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    	    							}
            	    	    							if (element == null) {
            	    	    								element = org.emftext.language.BON.BONFactory.eINSTANCE.createQueries();
            	    	    								startIncompleteElement(element);
            	    	    							}
            	    	    							if (a3_0 != null) {
            	    	    								if (a3_0 != null) {
            	    	    									Object value = a3_0;
            	    	    									addObjectToList(element, org.emftext.language.BON.BONPackage.QUERIES__QUERY, value);
            	    	    									completedElement(value, true);
            	    	    								}
            	    	    								collectHiddenTokens(element);
            	    	    								retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_10_0_0_0_0_0_2_0_0_1, a3_0, true);
            	    	    								copyLocalizationInfos(a3_0, element);
            	    	    							}
            	    	    						}

            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[292]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[293]);
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[294]);
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[295]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[296]);
            	    	    					}

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[297]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[298]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[299]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[300]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[301]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[305]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_BON_Queries_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Queries"



    // $ANTLR start "parse_org_emftext_language_BON_Commands"
    // Bon.g:2458:1: parse_org_emftext_language_BON_Commands returns [org.emftext.language.BON.Commands element = null] : ( (a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )* ) )* ;
    public final org.emftext.language.BON.Commands parse_org_emftext_language_BON_Commands() throws RecognitionException {
        org.emftext.language.BON.Commands element =  null;

        int parse_org_emftext_language_BON_Commands_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.emftext.language.BON.Command a1_0 =null;

        org.emftext.language.BON.Command a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Bon.g:2461:2: ( ( (a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )* ) )* )
            // Bon.g:2462:2: ( (a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )* ) )*
            {
            // Bon.g:2462:2: ( (a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )* ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==22) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // Bon.g:2463:3: (a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )* )
            	    {
            	    // Bon.g:2463:3: (a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )* )
            	    // Bon.g:2464:4: a0= 'command' (a1_0= parse_org_emftext_language_BON_Command ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )*
            	    {
            	    a0=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_BON_Commands2258); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommands();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_11_0_0_0_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCommands(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[306]);
            	    			}

            	    // Bon.g:2478:4: (a1_0= parse_org_emftext_language_BON_Command )
            	    // Bon.g:2479:5: a1_0= parse_org_emftext_language_BON_Command
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Command_in_parse_org_emftext_language_BON_Commands2284);
            	    a1_0=parse_org_emftext_language_BON_Command();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommands();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a1_0 != null) {
            	    						if (a1_0 != null) {
            	    							Object value = a1_0;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.COMMANDS__COMMAND, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_11_0_0_0_0_0_1, a1_0, true);
            	    						copyLocalizationInfos(a1_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[307]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[308]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[309]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[310]);
            	    			}

            	    // Bon.g:2507:4: ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==15) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // Bon.g:2508:5: (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) )
            	    	    {
            	    	    // Bon.g:2508:5: (a2= ',' (a3_0= parse_org_emftext_language_BON_Command ) )
            	    	    // Bon.g:2509:6: a2= ',' (a3_0= parse_org_emftext_language_BON_Command )
            	    	    {
            	    	    a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Commands2325); if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    						if (element == null) {
            	    	    							element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommands();
            	    	    							startIncompleteElement(element);
            	    	    						}
            	    	    						collectHiddenTokens(element);
            	    	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_11_0_0_0_0_0_2_0_0_0, null, true);
            	    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    	    					}

            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCommands(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[311]);
            	    	    					}

            	    	    // Bon.g:2523:6: (a3_0= parse_org_emftext_language_BON_Command )
            	    	    // Bon.g:2524:7: a3_0= parse_org_emftext_language_BON_Command
            	    	    {
            	    	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Command_in_parse_org_emftext_language_BON_Commands2359);
            	    	    a3_0=parse_org_emftext_language_BON_Command();

            	    	    state._fsp--;
            	    	    if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    							if (terminateParsing) {
            	    	    								throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    	    							}
            	    	    							if (element == null) {
            	    	    								element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommands();
            	    	    								startIncompleteElement(element);
            	    	    							}
            	    	    							if (a3_0 != null) {
            	    	    								if (a3_0 != null) {
            	    	    									Object value = a3_0;
            	    	    									addObjectToList(element, org.emftext.language.BON.BONPackage.COMMANDS__COMMAND, value);
            	    	    									completedElement(value, true);
            	    	    								}
            	    	    								collectHiddenTokens(element);
            	    	    								retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_11_0_0_0_0_0_2_0_0_1, a3_0, true);
            	    	    								copyLocalizationInfos(a3_0, element);
            	    	    							}
            	    	    						}

            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[312]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[313]);
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[314]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[315]);
            	    	    					}

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[316]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[317]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[318]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[319]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[320]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[321]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[322]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_BON_Commands_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Commands"



    // $ANTLR start "parse_org_emftext_language_BON_Constraints"
    // Bon.g:2573:1: parse_org_emftext_language_BON_Constraints returns [org.emftext.language.BON.Constraints element = null] : ( (a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )* ) )* ;
    public final org.emftext.language.BON.Constraints parse_org_emftext_language_BON_Constraints() throws RecognitionException {
        org.emftext.language.BON.Constraints element =  null;

        int parse_org_emftext_language_BON_Constraints_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.emftext.language.BON.Constraint a1_0 =null;

        org.emftext.language.BON.Constraint a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Bon.g:2576:2: ( ( (a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )* ) )* )
            // Bon.g:2577:2: ( (a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )* ) )*
            {
            // Bon.g:2577:2: ( (a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )* ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==23) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Bon.g:2578:3: (a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )* )
            	    {
            	    // Bon.g:2578:3: (a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )* )
            	    // Bon.g:2579:4: a0= 'constraint' (a1_0= parse_org_emftext_language_BON_Constraint ) ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )*
            	    {
            	    a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_BON_Constraints2457); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraints();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_12_0_0_0_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getConstraints(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[323]);
            	    			}

            	    // Bon.g:2593:4: (a1_0= parse_org_emftext_language_BON_Constraint )
            	    // Bon.g:2594:5: a1_0= parse_org_emftext_language_BON_Constraint
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Constraint_in_parse_org_emftext_language_BON_Constraints2483);
            	    a1_0=parse_org_emftext_language_BON_Constraint();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraints();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a1_0 != null) {
            	    						if (a1_0 != null) {
            	    							Object value = a1_0;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.CONSTRAINTS__CONSTRAINT, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_12_0_0_0_0_0_1, a1_0, true);
            	    						copyLocalizationInfos(a1_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[324]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[325]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[326]);
            	    			}

            	    // Bon.g:2621:4: ( (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==15) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // Bon.g:2622:5: (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) )
            	    	    {
            	    	    // Bon.g:2622:5: (a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint ) )
            	    	    // Bon.g:2623:6: a2= ',' (a3_0= parse_org_emftext_language_BON_Constraint )
            	    	    {
            	    	    a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Constraints2524); if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    						if (element == null) {
            	    	    							element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraints();
            	    	    							startIncompleteElement(element);
            	    	    						}
            	    	    						collectHiddenTokens(element);
            	    	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_12_0_0_0_0_0_2_0_0_0, null, true);
            	    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    	    					}

            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getConstraints(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[327]);
            	    	    					}

            	    	    // Bon.g:2637:6: (a3_0= parse_org_emftext_language_BON_Constraint )
            	    	    // Bon.g:2638:7: a3_0= parse_org_emftext_language_BON_Constraint
            	    	    {
            	    	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Constraint_in_parse_org_emftext_language_BON_Constraints2558);
            	    	    a3_0=parse_org_emftext_language_BON_Constraint();

            	    	    state._fsp--;
            	    	    if (state.failed) return element;

            	    	    if ( state.backtracking==0 ) {
            	    	    							if (terminateParsing) {
            	    	    								throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    	    							}
            	    	    							if (element == null) {
            	    	    								element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraints();
            	    	    								startIncompleteElement(element);
            	    	    							}
            	    	    							if (a3_0 != null) {
            	    	    								if (a3_0 != null) {
            	    	    									Object value = a3_0;
            	    	    									addObjectToList(element, org.emftext.language.BON.BONPackage.CONSTRAINTS__CONSTRAINT, value);
            	    	    									completedElement(value, true);
            	    	    								}
            	    	    								collectHiddenTokens(element);
            	    	    								retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_12_0_0_0_0_0_2_0_0_1, a3_0, true);
            	    	    								copyLocalizationInfos(a3_0, element);
            	    	    							}
            	    	    						}

            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    						// expected elements (follow set)
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[328]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[329]);
            	    	    						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[330]);
            	    	    					}

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[331]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[332]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[333]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[335]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_BON_Constraints_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Constraints"



    // $ANTLR start "parse_org_emftext_language_BON_Query"
    // Bon.g:2684:1: parse_org_emftext_language_BON_Query returns [org.emftext.language.BON.Query element = null] : (a0= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Query parse_org_emftext_language_BON_Query() throws RecognitionException {
        org.emftext.language.BON.Query element =  null;

        int parse_org_emftext_language_BON_Query_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Bon.g:2687:2: ( (a0= MANIFEST_TEXTBLOCK ) )
            // Bon.g:2688:2: (a0= MANIFEST_TEXTBLOCK )
            {
            // Bon.g:2688:2: (a0= MANIFEST_TEXTBLOCK )
            // Bon.g:2689:3: a0= MANIFEST_TEXTBLOCK
            {
            a0=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Query2651); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createQuery();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.QUERY__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.QUERY__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_13_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[336]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[339]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[340]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_BON_Query_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Query"



    // $ANTLR start "parse_org_emftext_language_BON_Command"
    // Bon.g:2730:1: parse_org_emftext_language_BON_Command returns [org.emftext.language.BON.Command element = null] : (a0= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Command parse_org_emftext_language_BON_Command() throws RecognitionException {
        org.emftext.language.BON.Command element =  null;

        int parse_org_emftext_language_BON_Command_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Bon.g:2733:2: ( (a0= MANIFEST_TEXTBLOCK ) )
            // Bon.g:2734:2: (a0= MANIFEST_TEXTBLOCK )
            {
            // Bon.g:2734:2: (a0= MANIFEST_TEXTBLOCK )
            // Bon.g:2735:3: a0= MANIFEST_TEXTBLOCK
            {
            a0=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Command2691); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommand();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.COMMAND__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.COMMAND__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_14_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[344]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_BON_Command_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Command"



    // $ANTLR start "parse_org_emftext_language_BON_Constraint"
    // Bon.g:2775:1: parse_org_emftext_language_BON_Constraint returns [org.emftext.language.BON.Constraint element = null] : (a0= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Constraint parse_org_emftext_language_BON_Constraint() throws RecognitionException {
        org.emftext.language.BON.Constraint element =  null;

        int parse_org_emftext_language_BON_Constraint_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Bon.g:2778:2: ( (a0= MANIFEST_TEXTBLOCK ) )
            // Bon.g:2779:2: (a0= MANIFEST_TEXTBLOCK )
            {
            // Bon.g:2779:2: (a0= MANIFEST_TEXTBLOCK )
            // Bon.g:2780:3: a0= MANIFEST_TEXTBLOCK
            {
            a0=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Constraint2731); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraint();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CONSTRAINT__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CONSTRAINT__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_15_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[345]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[346]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[347]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_BON_Constraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Constraint"



    // $ANTLR start "parse_org_emftext_language_BON_Event_005fchart"
    // Bon.g:2819:1: parse_org_emftext_language_BON_Event_005fchart returns [org.emftext.language.BON.Event_chart element = null] : a0= 'event_chart' (a1= IDENTIFIER ) ( (a2= EVENTTYPE ) )? ( ( (a3_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a5_0= parse_org_emftext_language_BON_Part ) ) )? ( (a6_0= parse_org_emftext_language_BON_Event ) )* a7= 'end' ;
    public final org.emftext.language.BON.Event_chart parse_org_emftext_language_BON_Event_005fchart() throws RecognitionException {
        org.emftext.language.BON.Event_chart element =  null;

        int parse_org_emftext_language_BON_Event_005fchart_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a7=null;
        org.emftext.language.BON.Indexing a3_0 =null;

        org.emftext.language.BON.Explanation a4_0 =null;

        org.emftext.language.BON.Part a5_0 =null;

        org.emftext.language.BON.Event a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Bon.g:2822:2: (a0= 'event_chart' (a1= IDENTIFIER ) ( (a2= EVENTTYPE ) )? ( ( (a3_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a5_0= parse_org_emftext_language_BON_Part ) ) )? ( (a6_0= parse_org_emftext_language_BON_Event ) )* a7= 'end' )
            // Bon.g:2823:2: a0= 'event_chart' (a1= IDENTIFIER ) ( (a2= EVENTTYPE ) )? ( ( (a3_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a5_0= parse_org_emftext_language_BON_Part ) ) )? ( (a6_0= parse_org_emftext_language_BON_Event ) )* a7= 'end'
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_language_BON_Event_005fchart2767); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[348]);
            	}

            // Bon.g:2837:2: (a1= IDENTIFIER )
            // Bon.g:2838:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Event_005fchart2785); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__SYSTEM_NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.System_chart proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Event_chart, org.emftext.language.BON.System_chart>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEvent_chartSystem_nameReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__SYSTEM_NAME), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__SYSTEM_NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[349]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[351]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[354]);
            	}

            // Bon.g:2882:2: ( (a2= EVENTTYPE ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==EVENTTYPE) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // Bon.g:2883:3: (a2= EVENTTYPE )
                    {
                    // Bon.g:2883:3: (a2= EVENTTYPE )
                    // Bon.g:2884:4: a2= EVENTTYPE
                    {
                    a2=(Token)match(input,EVENTTYPE,FOLLOW_EVENTTYPE_in_parse_org_emftext_language_BON_Event_005fchart2815); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
                    					startIncompleteElement(element);
                    				}
                    				if (a2 != null) {
                    					org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("EVENTTYPE");
                    					tokenResolver.setOptions(getOptions());
                    					org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__EVENT_TYPE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    					}
                    					org.emftext.language.BON.Event_type resolved = (org.emftext.language.BON.Event_type) resolvedObject;
                    					if (resolved != null) {
                    						Object value = resolved;
                    						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__EVENT_TYPE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_2, resolved, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[356]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[357]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[358]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[359]);
            	}

            // Bon.g:2924:2: ( ( (a3_0= parse_org_emftext_language_BON_Indexing ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Bon.g:2925:3: ( (a3_0= parse_org_emftext_language_BON_Indexing ) )
                    {
                    // Bon.g:2925:3: ( (a3_0= parse_org_emftext_language_BON_Indexing ) )
                    // Bon.g:2926:4: (a3_0= parse_org_emftext_language_BON_Indexing )
                    {
                    // Bon.g:2926:4: (a3_0= parse_org_emftext_language_BON_Indexing )
                    // Bon.g:2927:5: a3_0= parse_org_emftext_language_BON_Indexing
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Event_005fchart2860);
                    a3_0=parse_org_emftext_language_BON_Indexing();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__CHART_INDEXING), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[360]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[361]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[362]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[363]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[364]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[365]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[366]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[367]);
            	}

            // Bon.g:2965:2: ( ( (a4_0= parse_org_emftext_language_BON_Explanation ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==31) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Bon.g:2966:3: ( (a4_0= parse_org_emftext_language_BON_Explanation ) )
                    {
                    // Bon.g:2966:3: ( (a4_0= parse_org_emftext_language_BON_Explanation ) )
                    // Bon.g:2967:4: (a4_0= parse_org_emftext_language_BON_Explanation )
                    {
                    // Bon.g:2967:4: (a4_0= parse_org_emftext_language_BON_Explanation )
                    // Bon.g:2968:5: a4_0= parse_org_emftext_language_BON_Explanation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Event_005fchart2916);
                    a4_0=parse_org_emftext_language_BON_Explanation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__EXPLANATION), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_4_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[368]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[369]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[370]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[373]);
            	}

            // Bon.g:3004:2: ( ( (a5_0= parse_org_emftext_language_BON_Part ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Bon.g:3005:3: ( (a5_0= parse_org_emftext_language_BON_Part ) )
                    {
                    // Bon.g:3005:3: ( (a5_0= parse_org_emftext_language_BON_Part ) )
                    // Bon.g:3006:4: (a5_0= parse_org_emftext_language_BON_Part )
                    {
                    // Bon.g:3006:4: (a5_0= parse_org_emftext_language_BON_Part )
                    // Bon.g:3007:5: a5_0= parse_org_emftext_language_BON_Part
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Event_005fchart2972);
                    a5_0=parse_org_emftext_language_BON_Part();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a5_0 != null) {
                    						if (a5_0 != null) {
                    							Object value = a5_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT_CHART__CHART_PART), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_5_0_0_0, a5_0, true);
                    						copyLocalizationInfos(a5_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[374]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[375]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[377]);
            	}

            // Bon.g:3041:2: ( (a6_0= parse_org_emftext_language_BON_Event ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==29) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Bon.g:3042:3: (a6_0= parse_org_emftext_language_BON_Event )
            	    {
            	    // Bon.g:3042:3: (a6_0= parse_org_emftext_language_BON_Event )
            	    // Bon.g:3043:4: a6_0= parse_org_emftext_language_BON_Event
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Event_in_parse_org_emftext_language_BON_Event_005fchart3022);
            	    a6_0=parse_org_emftext_language_BON_Event();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a6_0 != null) {
            	    					if (a6_0 != null) {
            	    						Object value = a6_0;
            	    						addObjectToList(element, org.emftext.language.BON.BONPackage.EVENT_CHART__EVENT_ENTRIES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_6, a6_0, true);
            	    					copyLocalizationInfos(a6_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[379]);
            	}

            a7=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_BON_Event_005fchart3048); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[383]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[384]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_language_BON_Event_005fchart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Event_005fchart"



    // $ANTLR start "parse_org_emftext_language_BON_Event"
    // Bon.g:3090:1: parse_org_emftext_language_BON_Event returns [org.emftext.language.BON.Event element = null] : a0= 'event' (a1= MANIFEST_TEXTBLOCK ) a2= 'involves' (a3= IDENTIFIER ) ( (a4= ',' (a5= IDENTIFIER ) ) )* ;
    public final org.emftext.language.BON.Event parse_org_emftext_language_BON_Event() throws RecognitionException {
        org.emftext.language.BON.Event element =  null;

        int parse_org_emftext_language_BON_Event_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Bon.g:3093:2: (a0= 'event' (a1= MANIFEST_TEXTBLOCK ) a2= 'involves' (a3= IDENTIFIER ) ( (a4= ',' (a5= IDENTIFIER ) ) )* )
            // Bon.g:3094:2: a0= 'event' (a1= MANIFEST_TEXTBLOCK ) a2= 'involves' (a3= IDENTIFIER ) ( (a4= ',' (a5= IDENTIFIER ) ) )*
            {
            a0=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_language_BON_Event3077); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[385]);
            	}

            // Bon.g:3108:2: (a1= MANIFEST_TEXTBLOCK )
            // Bon.g:3109:3: a1= MANIFEST_TEXTBLOCK
            {
            a1=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Event3095); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[386]);
            	}

            a2=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_language_BON_Event3116); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[387]);
            	}

            // Bon.g:3158:2: (a3= IDENTIFIER )
            // Bon.g:3159:3: a3= IDENTIFIER
            {
            a3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Event3134); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT__INVOLVES), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Event, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventInvolvesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT__INVOLVES), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, org.emftext.language.BON.BONPackage.EVENT__INVOLVES, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_3, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[388]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[390]);
            	}

            // Bon.g:3200:2: ( (a4= ',' (a5= IDENTIFIER ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==15) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Bon.g:3201:3: (a4= ',' (a5= IDENTIFIER ) )
            	    {
            	    // Bon.g:3201:3: (a4= ',' (a5= IDENTIFIER ) )
            	    // Bon.g:3202:4: a4= ',' (a5= IDENTIFIER )
            	    {
            	    a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Event3164); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[391]);
            	    			}

            	    // Bon.g:3216:4: (a5= IDENTIFIER )
            	    // Bon.g:3217:5: a5= IDENTIFIER
            	    {
            	    a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Event3190); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a5 != null) {
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT__INVOLVES), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            	    						}
            	    						String resolved = (String) resolvedObject;
            	    						org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            	    						collectHiddenTokens(element);
            	    						registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Event, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventInvolvesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.EVENT__INVOLVES), resolved, proxy);
            	    						if (proxy != null) {
            	    							Object value = proxy;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.EVENT__INVOLVES, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_4_0_0_1, proxy, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[392]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[393]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[394]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[395]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[396]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[397]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_language_BON_Event_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Event"



    // $ANTLR start "parse_org_emftext_language_BON_Scenario_005fchart"
    // Bon.g:3269:1: parse_org_emftext_language_BON_Scenario_005fchart returns [org.emftext.language.BON.Scenario_chart element = null] : a0= 'scenario_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Scenario ) )* a6= 'end' ;
    public final org.emftext.language.BON.Scenario_chart parse_org_emftext_language_BON_Scenario_005fchart() throws RecognitionException {
        org.emftext.language.BON.Scenario_chart element =  null;

        int parse_org_emftext_language_BON_Scenario_005fchart_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a6=null;
        org.emftext.language.BON.Indexing a2_0 =null;

        org.emftext.language.BON.Explanation a3_0 =null;

        org.emftext.language.BON.Part a4_0 =null;

        org.emftext.language.BON.Scenario a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Bon.g:3272:2: (a0= 'scenario_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Scenario ) )* a6= 'end' )
            // Bon.g:3273:2: a0= 'scenario_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Scenario ) )* a6= 'end'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_language_BON_Scenario_005fchart3251); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[398]);
            	}

            // Bon.g:3287:2: (a1= IDENTIFIER )
            // Bon.g:3288:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Scenario_005fchart3269); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO_CHART__SYSTEM_NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.System_chart proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Scenario_chart, org.emftext.language.BON.System_chart>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getScenario_chartSystem_nameReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO_CHART__SYSTEM_NAME), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO_CHART__SYSTEM_NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[399]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[400]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[401]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[402]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[403]);
            	}

            // Bon.g:3331:2: ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // Bon.g:3332:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    {
                    // Bon.g:3332:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    // Bon.g:3333:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    {
                    // Bon.g:3333:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    // Bon.g:3334:5: a2_0= parse_org_emftext_language_BON_Indexing
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Scenario_005fchart3305);
                    a2_0=parse_org_emftext_language_BON_Indexing();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO_CHART__CHART_INDEXING), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[404]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[405]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[406]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[407]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[408]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[409]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[410]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[411]);
            	}

            // Bon.g:3372:2: ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==31) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // Bon.g:3373:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    {
                    // Bon.g:3373:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    // Bon.g:3374:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    {
                    // Bon.g:3374:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    // Bon.g:3375:5: a3_0= parse_org_emftext_language_BON_Explanation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Scenario_005fchart3361);
                    a3_0=parse_org_emftext_language_BON_Explanation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO_CHART__EXPLANATION), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[412]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[413]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[414]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[415]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[416]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[417]);
            	}

            // Bon.g:3411:2: ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // Bon.g:3412:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    {
                    // Bon.g:3412:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    // Bon.g:3413:4: (a4_0= parse_org_emftext_language_BON_Part )
                    {
                    // Bon.g:3413:4: (a4_0= parse_org_emftext_language_BON_Part )
                    // Bon.g:3414:5: a4_0= parse_org_emftext_language_BON_Part
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Scenario_005fchart3417);
                    a4_0=parse_org_emftext_language_BON_Part();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO_CHART__CHART_PART), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_4_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[418]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[419]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[420]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[421]);
            	}

            // Bon.g:3448:2: ( (a5_0= parse_org_emftext_language_BON_Scenario ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==37) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // Bon.g:3449:3: (a5_0= parse_org_emftext_language_BON_Scenario )
            	    {
            	    // Bon.g:3449:3: (a5_0= parse_org_emftext_language_BON_Scenario )
            	    // Bon.g:3450:4: a5_0= parse_org_emftext_language_BON_Scenario
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Scenario_in_parse_org_emftext_language_BON_Scenario_005fchart3467);
            	    a5_0=parse_org_emftext_language_BON_Scenario();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a5_0 != null) {
            	    					if (a5_0 != null) {
            	    						Object value = a5_0;
            	    						addObjectToList(element, org.emftext.language.BON.BONPackage.SCENARIO_CHART__SCENARIO_ENTRIES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_5, a5_0, true);
            	    					copyLocalizationInfos(a5_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[422]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[423]);
            	}

            a6=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_BON_Scenario_005fchart3493); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[424]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[425]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[426]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[427]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[428]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_language_BON_Scenario_005fchart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Scenario_005fchart"



    // $ANTLR start "parse_org_emftext_language_BON_Scenario"
    // Bon.g:3497:1: parse_org_emftext_language_BON_Scenario returns [org.emftext.language.BON.Scenario element = null] : a0= 'scenario' (a1= MANIFEST_TEXTBLOCK ) a2= 'description' (a3= MANIFEST_TEXTBLOCK ) ;
    public final org.emftext.language.BON.Scenario parse_org_emftext_language_BON_Scenario() throws RecognitionException {
        org.emftext.language.BON.Scenario element =  null;

        int parse_org_emftext_language_BON_Scenario_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Bon.g:3500:2: (a0= 'scenario' (a1= MANIFEST_TEXTBLOCK ) a2= 'description' (a3= MANIFEST_TEXTBLOCK ) )
            // Bon.g:3501:2: a0= 'scenario' (a1= MANIFEST_TEXTBLOCK ) a2= 'description' (a3= MANIFEST_TEXTBLOCK )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_language_BON_Scenario3522); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_19_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[429]);
            	}

            // Bon.g:3515:2: (a1= MANIFEST_TEXTBLOCK )
            // Bon.g:3516:3: a1= MANIFEST_TEXTBLOCK
            {
            a1=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Scenario3540); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_19_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[430]);
            	}

            a2=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_BON_Scenario3561); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_19_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[431]);
            	}

            // Bon.g:3565:2: (a3= MANIFEST_TEXTBLOCK )
            // Bon.g:3566:3: a3= MANIFEST_TEXTBLOCK
            {
            a3=(Token)match(input,MANIFEST_TEXTBLOCK,FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Scenario3579); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MANIFEST_TEXTBLOCK");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO__DESCRIPTION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.SCENARIO__DESCRIPTION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_19_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[432]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[433]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_language_BON_Scenario_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Scenario"



    // $ANTLR start "parse_org_emftext_language_BON_Creation_005fchart"
    // Bon.g:3604:1: parse_org_emftext_language_BON_Creation_005fchart returns [org.emftext.language.BON.Creation_chart element = null] : a0= 'creation_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Creation ) )* a6= 'end' ;
    public final org.emftext.language.BON.Creation_chart parse_org_emftext_language_BON_Creation_005fchart() throws RecognitionException {
        org.emftext.language.BON.Creation_chart element =  null;

        int parse_org_emftext_language_BON_Creation_005fchart_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a6=null;
        org.emftext.language.BON.Indexing a2_0 =null;

        org.emftext.language.BON.Explanation a3_0 =null;

        org.emftext.language.BON.Part a4_0 =null;

        org.emftext.language.BON.Creation a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Bon.g:3607:2: (a0= 'creation_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Creation ) )* a6= 'end' )
            // Bon.g:3608:2: a0= 'creation_chart' (a1= IDENTIFIER ) ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )? ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )? ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )? ( (a5_0= parse_org_emftext_language_BON_Creation ) )* a6= 'end'
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_BON_Creation_005fchart3615); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[434]);
            	}

            // Bon.g:3622:2: (a1= IDENTIFIER )
            // Bon.g:3623:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation_005fchart3633); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION_CHART__SYSTEM_NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.System_chart proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Creation_chart, org.emftext.language.BON.System_chart>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCreation_chartSystem_nameReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION_CHART__SYSTEM_NAME), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION_CHART__SYSTEM_NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[435]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[436]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[437]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[438]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[439]);
            	}

            // Bon.g:3666:2: ( ( (a2_0= parse_org_emftext_language_BON_Indexing ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==32) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // Bon.g:3667:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    {
                    // Bon.g:3667:3: ( (a2_0= parse_org_emftext_language_BON_Indexing ) )
                    // Bon.g:3668:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    {
                    // Bon.g:3668:4: (a2_0= parse_org_emftext_language_BON_Indexing )
                    // Bon.g:3669:5: a2_0= parse_org_emftext_language_BON_Indexing
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Creation_005fchart3669);
                    a2_0=parse_org_emftext_language_BON_Indexing();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION_CHART__CHART_INDEXING), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[440]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[441]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[442]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[443]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[444]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[445]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[446]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[447]);
            	}

            // Bon.g:3707:2: ( ( (a3_0= parse_org_emftext_language_BON_Explanation ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // Bon.g:3708:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    {
                    // Bon.g:3708:3: ( (a3_0= parse_org_emftext_language_BON_Explanation ) )
                    // Bon.g:3709:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    {
                    // Bon.g:3709:4: (a3_0= parse_org_emftext_language_BON_Explanation )
                    // Bon.g:3710:5: a3_0= parse_org_emftext_language_BON_Explanation
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Creation_005fchart3725);
                    a3_0=parse_org_emftext_language_BON_Explanation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION_CHART__EXPLANATION), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[448]);
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[449]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[450]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[451]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[452]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[453]);
            	}

            // Bon.g:3746:2: ( ( (a4_0= parse_org_emftext_language_BON_Part ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // Bon.g:3747:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    {
                    // Bon.g:3747:3: ( (a4_0= parse_org_emftext_language_BON_Part ) )
                    // Bon.g:3748:4: (a4_0= parse_org_emftext_language_BON_Part )
                    {
                    // Bon.g:3748:4: (a4_0= parse_org_emftext_language_BON_Part )
                    // Bon.g:3749:5: a4_0= parse_org_emftext_language_BON_Part
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Creation_005fchart3781);
                    a4_0=parse_org_emftext_language_BON_Part();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
                    						startIncompleteElement(element);
                    					}
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION_CHART__CHART_PART), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_4_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[454]);
                    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[455]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[456]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[457]);
            	}

            // Bon.g:3783:2: ( (a5_0= parse_org_emftext_language_BON_Creation ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==26) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // Bon.g:3784:3: (a5_0= parse_org_emftext_language_BON_Creation )
            	    {
            	    // Bon.g:3784:3: (a5_0= parse_org_emftext_language_BON_Creation )
            	    // Bon.g:3785:4: a5_0= parse_org_emftext_language_BON_Creation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_BON_Creation_in_parse_org_emftext_language_BON_Creation_005fchart3831);
            	    a5_0=parse_org_emftext_language_BON_Creation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a5_0 != null) {
            	    					if (a5_0 != null) {
            	    						Object value = a5_0;
            	    						addObjectToList(element, org.emftext.language.BON.BONPackage.CREATION_CHART__CREATION_ENTRIES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_5, a5_0, true);
            	    					copyLocalizationInfos(a5_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[458]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[459]);
            	}

            a6=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_BON_Creation_005fchart3857); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[460]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[461]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[462]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[464]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_language_BON_Creation_005fchart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Creation_005fchart"



    // $ANTLR start "parse_org_emftext_language_BON_Creation"
    // Bon.g:3832:1: parse_org_emftext_language_BON_Creation returns [org.emftext.language.BON.Creation element = null] : a0= 'creator' (a1= IDENTIFIER ) a2= 'creates' (a3= IDENTIFIER ) ( (a4= ',' (a5= IDENTIFIER ) ) )* ;
    public final org.emftext.language.BON.Creation parse_org_emftext_language_BON_Creation() throws RecognitionException {
        org.emftext.language.BON.Creation element =  null;

        int parse_org_emftext_language_BON_Creation_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Bon.g:3835:2: (a0= 'creator' (a1= IDENTIFIER ) a2= 'creates' (a3= IDENTIFIER ) ( (a4= ',' (a5= IDENTIFIER ) ) )* )
            // Bon.g:3836:2: a0= 'creator' (a1= IDENTIFIER ) a2= 'creates' (a3= IDENTIFIER ) ( (a4= ',' (a5= IDENTIFIER ) ) )*
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_BON_Creation3886); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[465]);
            	}

            // Bon.g:3850:2: (a1= IDENTIFIER )
            // Bon.g:3851:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation3904); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATOR), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Creation, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCreationCreatorReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATOR), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATOR), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[466]);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_BON_Creation3925); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[467]);
            	}

            // Bon.g:3904:2: (a3= IDENTIFIER )
            // Bon.g:3905:3: a3= IDENTIFIER
            {
            a3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation3943); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATES), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Creation, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCreationCreatesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATES), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, org.emftext.language.BON.BONPackage.CREATION__CREATES, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_3, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[468]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[469]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[470]);
            	}

            // Bon.g:3946:2: ( (a4= ',' (a5= IDENTIFIER ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==15) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // Bon.g:3947:3: (a4= ',' (a5= IDENTIFIER ) )
            	    {
            	    // Bon.g:3947:3: (a4= ',' (a5= IDENTIFIER ) )
            	    // Bon.g:3948:4: a4= ',' (a5= IDENTIFIER )
            	    {
            	    a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_BON_Creation3973); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[471]);
            	    			}

            	    // Bon.g:3962:4: (a5= IDENTIFIER )
            	    // Bon.g:3963:5: a5= IDENTIFIER
            	    {
            	    a5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation3999); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.BON.resource.bon.mopp.BonTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a5 != null) {
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            	    						tokenResolver.setOptions(getOptions());
            	    						org.emftext.language.BON.resource.bon.IBonTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATES), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            	    						}
            	    						String resolved = (String) resolvedObject;
            	    						org.emftext.language.BON.ClassBON proxy = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
            	    						collectHiddenTokens(element);
            	    						registerContextDependentProxy(new org.emftext.language.BON.resource.bon.mopp.BonContextDependentURIFragmentFactory<org.emftext.language.BON.Creation, org.emftext.language.BON.ClassBON>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCreationCreatesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.BON.BONPackage.CREATION__CREATES), resolved, proxy);
            	    						if (proxy != null) {
            	    							Object value = proxy;
            	    							addObjectToList(element, org.emftext.language.BON.BONPackage.CREATION__CREATES, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_4_0_0_1, proxy, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[472]);
            	    				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[473]);
            	    				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[474]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[475]);
            		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[476]);
            		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[477]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_language_BON_Creation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_BON_Creation"

    // $ANTLR start synpred22_Bon
    public final void synpred22_Bon_fragment() throws RecognitionException {
        org.emftext.language.BON.Queries a9_0 =null;


        // Bon.g:2233:3: ( (a9_0= parse_org_emftext_language_BON_Queries ) )
        // Bon.g:2233:3: (a9_0= parse_org_emftext_language_BON_Queries )
        {
        // Bon.g:2233:3: (a9_0= parse_org_emftext_language_BON_Queries )
        // Bon.g:2234:4: a9_0= parse_org_emftext_language_BON_Queries
        {
        pushFollow(FOLLOW_parse_org_emftext_language_BON_Queries_in_synpred22_Bon1925);
        a9_0=parse_org_emftext_language_BON_Queries();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred22_Bon

    // $ANTLR start synpred23_Bon
    public final void synpred23_Bon_fragment() throws RecognitionException {
        org.emftext.language.BON.Commands a10_0 =null;


        // Bon.g:2263:3: ( (a10_0= parse_org_emftext_language_BON_Commands ) )
        // Bon.g:2263:3: (a10_0= parse_org_emftext_language_BON_Commands )
        {
        // Bon.g:2263:3: (a10_0= parse_org_emftext_language_BON_Commands )
        // Bon.g:2264:4: a10_0= parse_org_emftext_language_BON_Commands
        {
        pushFollow(FOLLOW_parse_org_emftext_language_BON_Commands_in_synpred23_Bon1960);
        a10_0=parse_org_emftext_language_BON_Commands();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred23_Bon

    // $ANTLR start synpred24_Bon
    public final void synpred24_Bon_fragment() throws RecognitionException {
        org.emftext.language.BON.Constraints a11_0 =null;


        // Bon.g:2292:3: ( (a11_0= parse_org_emftext_language_BON_Constraints ) )
        // Bon.g:2292:3: (a11_0= parse_org_emftext_language_BON_Constraints )
        {
        // Bon.g:2292:3: (a11_0= parse_org_emftext_language_BON_Constraints )
        // Bon.g:2293:4: a11_0= parse_org_emftext_language_BON_Constraints
        {
        pushFollow(FOLLOW_parse_org_emftext_language_BON_Constraints_in_synpred24_Bon1995);
        a11_0=parse_org_emftext_language_BON_Constraints();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred24_Bon

    // Delegated rules

    public final boolean synpred22_Bon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Bon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_Bon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Bon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_Bon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_Bon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Informal_005fcharts_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_System_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts119 = new BitSet(new long[]{0x0000004042280002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Cluster_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts152 = new BitSet(new long[]{0x0000004042280002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Class_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts194 = new BitSet(new long[]{0x0000004042280002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Event_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts236 = new BitSet(new long[]{0x0000004042280002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Scenario_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts278 = new BitSet(new long[]{0x0000004042280002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Creation_005fchart_in_parse_org_emftext_language_BON_Informal_005fcharts320 = new BitSet(new long[]{0x0000004042280002L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_language_BON_System_005fchart376 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_System_005fchart394 = new BitSet(new long[]{0x0000000990100000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_System_005fchart430 = new BitSet(new long[]{0x0000000890100000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_System_005fchart486 = new BitSet(new long[]{0x0000000810100000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_System_005fchart542 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Cluster_in_parse_org_emftext_language_BON_System_005fchart592 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_BON_System_005fchart618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_language_BON_Explanation647 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Explanation665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_language_BON_Indexing701 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Index_005fIdentifier_in_parse_org_emftext_language_BON_Indexing724 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_language_BON_Part765 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Part783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FEATURE_IDENTIFIER_in_parse_org_emftext_language_BON_Index_005fIdentifier823 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_BON_Index_005fIdentifier844 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Index_005fIdentifier862 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Index_005fIdentifier892 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Index_005fIdentifier918 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_BON_Index_005fIdentifier964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_BON_Cluster993 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Cluster1011 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_BON_Cluster1032 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Cluster1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_BON_Cluster_005fchart1086 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Cluster_005fchart1104 = new BitSet(new long[]{0x0000000990140000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Cluster_005fchart1140 = new BitSet(new long[]{0x0000000890140000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Cluster_005fchart1196 = new BitSet(new long[]{0x0000000810140000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Cluster_005fchart1252 = new BitSet(new long[]{0x0000000010140000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_ClassBON_in_parse_org_emftext_language_BON_Cluster_005fchart1308 = new BitSet(new long[]{0x0000000010140000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Cluster_in_parse_org_emftext_language_BON_Cluster_005fchart1350 = new BitSet(new long[]{0x0000000010140000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_BON_Cluster_005fchart1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_BON_ClassBON1420 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_ClassBON1438 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_BON_ClassBON1459 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_ClassBON1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_BON_Class_005fchart1513 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Class_005fchart1531 = new BitSet(new long[]{0x0000001B90C00000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Class_005fchart1567 = new BitSet(new long[]{0x0000001A90C00000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Class_005fchart1623 = new BitSet(new long[]{0x0000001A10C00000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Class_005fchart1679 = new BitSet(new long[]{0x0000001210C00000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_language_BON_Class_005fchart1729 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Class_005fchart1755 = new BitSet(new long[]{0x0000001210C08000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Class_005fchart1801 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Class_005fchart1835 = new BitSet(new long[]{0x0000001210C08000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Queries_in_parse_org_emftext_language_BON_Class_005fchart1925 = new BitSet(new long[]{0x0000000010C00000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Commands_in_parse_org_emftext_language_BON_Class_005fchart1960 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Constraints_in_parse_org_emftext_language_BON_Class_005fchart1995 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_BON_Class_005fchart2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_language_BON_Queries2059 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Query_in_parse_org_emftext_language_BON_Queries2085 = new BitSet(new long[]{0x0000001000008002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Queries2126 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Query_in_parse_org_emftext_language_BON_Queries2160 = new BitSet(new long[]{0x0000001000008002L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_BON_Commands2258 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Command_in_parse_org_emftext_language_BON_Commands2284 = new BitSet(new long[]{0x0000000000408002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Commands2325 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Command_in_parse_org_emftext_language_BON_Commands2359 = new BitSet(new long[]{0x0000000000408002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_BON_Constraints2457 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Constraint_in_parse_org_emftext_language_BON_Constraints2483 = new BitSet(new long[]{0x0000000000808002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Constraints2524 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Constraint_in_parse_org_emftext_language_BON_Constraints2558 = new BitSet(new long[]{0x0000000000808002L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Query2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Command2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Constraint2731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_language_BON_Event_005fchart2767 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Event_005fchart2785 = new BitSet(new long[]{0x00000009B0000020L});
    public static final BitSet FOLLOW_EVENTTYPE_in_parse_org_emftext_language_BON_Event_005fchart2815 = new BitSet(new long[]{0x00000009B0000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Event_005fchart2860 = new BitSet(new long[]{0x00000008B0000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Event_005fchart2916 = new BitSet(new long[]{0x0000000830000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Event_005fchart2972 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Event_in_parse_org_emftext_language_BON_Event_005fchart3022 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_BON_Event_005fchart3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_language_BON_Event3077 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Event3095 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_language_BON_Event3116 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Event3134 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Event3164 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Event3190 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_language_BON_Scenario_005fchart3251 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Scenario_005fchart3269 = new BitSet(new long[]{0x0000002990000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Scenario_005fchart3305 = new BitSet(new long[]{0x0000002890000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Scenario_005fchart3361 = new BitSet(new long[]{0x0000002810000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Scenario_005fchart3417 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Scenario_in_parse_org_emftext_language_BON_Scenario_005fchart3467 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_BON_Scenario_005fchart3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_language_BON_Scenario3522 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Scenario3540 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_BON_Scenario3561 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MANIFEST_TEXTBLOCK_in_parse_org_emftext_language_BON_Scenario3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_BON_Creation_005fchart3615 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation_005fchart3633 = new BitSet(new long[]{0x0000000994000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Indexing_in_parse_org_emftext_language_BON_Creation_005fchart3669 = new BitSet(new long[]{0x0000000894000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Explanation_in_parse_org_emftext_language_BON_Creation_005fchart3725 = new BitSet(new long[]{0x0000000814000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Part_in_parse_org_emftext_language_BON_Creation_005fchart3781 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Creation_in_parse_org_emftext_language_BON_Creation_005fchart3831 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_BON_Creation_005fchart3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_BON_Creation3886 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation3904 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_BON_Creation3925 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation3943 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_BON_Creation3973 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_org_emftext_language_BON_Creation3999 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Queries_in_synpred22_Bon1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Commands_in_synpred23_Bon1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_BON_Constraints_in_synpred24_Bon1995 = new BitSet(new long[]{0x0000000000000002L});

}