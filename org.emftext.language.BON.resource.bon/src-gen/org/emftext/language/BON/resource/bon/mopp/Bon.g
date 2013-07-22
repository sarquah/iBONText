grammar Bon;

options {
	superClass = BonANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.BON.resource.bon.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.BON.resource.bon.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_language_BON_Informal_005fcharts{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_BON_Informal_005fcharts returns [org.emftext.language.BON.Informal_charts element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_BON_System_005fchart		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_language_BON_Cluster_005fchart				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[6]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[7]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[10]);
			}
			
			
			|			(
				a2_0 = parse_org_emftext_language_BON_Class_005fchart				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[11]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[12]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[13]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[15]);
			}
			
			
			|			(
				a3_0 = parse_org_emftext_language_BON_Event_005fchart				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[17]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[18]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[19]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[20]);
			}
			
			
			|			(
				a4_0 = parse_org_emftext_language_BON_Scenario_005fchart				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[22]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[23]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[24]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[25]);
			}
			
			
			|			(
				a5_0 = parse_org_emftext_language_BON_Creation_005fchart				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[26]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[27]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[28]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[29]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[30]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[35]);
	}
	
;

parse_org_emftext_language_BON_System_005fchart returns [org.emftext.language.BON.System_chart element = null]
@init{
}
:
	a0 = 'system_chart' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[36]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[41]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_BON_Indexing				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[45]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[49]);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_BON_Explanation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[52]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[54]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[55]);
	}
	
	(
		(
			(
				a4_0 = parse_org_emftext_language_BON_Part				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[57]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[59]);
	}
	
	(
		(
			a5_0 = parse_org_emftext_language_BON_Cluster			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[61]);
	}
	
	a6 = 'end' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createSystem_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_1_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[66]);
	}
	
;

parse_org_emftext_language_BON_Explanation returns [org.emftext.language.BON.Explanation element = null]
@init{
}
:
	a0 = 'explanation' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createExplanation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[67]);
	}
	
	(
		a1 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
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
	
;

parse_org_emftext_language_BON_Indexing returns [org.emftext.language.BON.Indexing element = null]
@init{
}
:
	a0 = 'indexing' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndexing();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getIndexing(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[84]);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_BON_Index_005fIdentifier			{
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
		)
		
	)+	{
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
	
;

parse_org_emftext_language_BON_Part returns [org.emftext.language.BON.Part element = null]
@init{
}
:
	a0 = 'part' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createPart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[103]);
	}
	
	(
		a1 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
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
	
;

parse_org_emftext_language_BON_Index_005fIdentifier returns [org.emftext.language.BON.Index_Identifier element = null]
@init{
}
:
	(
		a0 = FEATURE_IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[119]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[120]);
	}
	
	(
		a2 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[122]);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[123]);
			}
			
			(
				a4 = MANIFEST_TEXTBLOCK				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[124]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[125]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[127]);
	}
	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createIndex_Identifier();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_5_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
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
	
;

parse_org_emftext_language_BON_Cluster returns [org.emftext.language.BON.Cluster element = null]
@init{
}
:
	a0 = 'cluster' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[146]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[147]);
	}
	
	a2 = 'description' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[148]);
	}
	
	(
		a3 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getSystem_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[152]);
	}
	
;

parse_org_emftext_language_BON_Cluster_005fchart returns [org.emftext.language.BON.Cluster_chart element = null]
@init{
}
:
	a0 = 'cluster_chart' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[153]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[159]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_BON_Indexing				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[160]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[161]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[162]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[163]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[164]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[169]);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_BON_Explanation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[170]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[171]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[172]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[173]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[177]);
	}
	
	(
		(
			(
				a4_0 = parse_org_emftext_language_BON_Part				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[178]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[179]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[180]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[183]);
	}
	
	(
		(
			(
				a5_0 = parse_org_emftext_language_BON_ClassBON				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[184]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[185]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[186]);
			}
			
			
			|			(
				a6_0 = parse_org_emftext_language_BON_Cluster				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[187]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[188]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[189]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[192]);
	}
	
	a7 = 'end' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCluster_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_7_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[197]);
	}
	
;

parse_org_emftext_language_BON_ClassBON returns [org.emftext.language.BON.ClassBON element = null]
@init{
}
:
	a0 = 'class' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_8_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[198]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[199]);
	}
	
	a2 = 'description' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClassBON();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_8_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[200]);
	}
	
	(
		a3 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCluster_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[203]);
	}
	
;

parse_org_emftext_language_BON_Class_005fchart returns [org.emftext.language.BON.Class_chart element = null]
@init{
}
:
	a0 = 'class_chart' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[204]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
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
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_BON_Indexing				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[213]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[214]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[215]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[216]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[217]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[218]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[219]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[226]);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_BON_Explanation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[227]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[228]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[229]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[230]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[231]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[232]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[234]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[238]);
	}
	
	(
		(
			(
				a4_0 = parse_org_emftext_language_BON_Part				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[239]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[240]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[241]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[242]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[243]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[244]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[248]);
	}
	
	(
		(
			a5 = 'inherit' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[249]);
			}
			
			(
				a6 = IDENTIFIER				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[250]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[251]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[252]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[253]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[254]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[255]);
			}
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_5_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[256]);
					}
					
					(
						a8 = IDENTIFIER						
						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[257]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[258]);
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[259]);
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[260]);
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[261]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[262]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[263]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[264]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[265]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[266]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[267]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[268]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[271]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[273]);
	}
	
	(
		(
			a9_0 = parse_org_emftext_language_BON_Queries			{
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
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[276]);
	}
	
	(
		(
			a10_0 = parse_org_emftext_language_BON_Commands			{
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
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[278]);
	}
	
	(
		(
			a11_0 = parse_org_emftext_language_BON_Constraints			{
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
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[279]);
	}
	
	a12 = 'end' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createClass_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_9_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[280]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[282]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[284]);
	}
	
;

parse_org_emftext_language_BON_Queries returns [org.emftext.language.BON.Queries element = null]
@init{
}
:
	(
		(
			a0 = 'query' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createQueries();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_10_0_0_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getQueries(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[285]);
			}
			
			(
				a1_0 = parse_org_emftext_language_BON_Query				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[286]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[287]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[288]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[289]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[290]);
			}
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.BON.BONFactory.eINSTANCE.createQueries();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_10_0_0_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getQueries(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[291]);
					}
					
					(
						a3_0 = parse_org_emftext_language_BON_Query						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[292]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[293]);
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[294]);
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[295]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[296]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[297]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[298]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[299]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[300]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[301]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[303]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[305]);
	}
	
;

parse_org_emftext_language_BON_Commands returns [org.emftext.language.BON.Commands element = null]
@init{
}
:
	(
		(
			a0 = 'command' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommands();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_11_0_0_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCommands(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[306]);
			}
			
			(
				a1_0 = parse_org_emftext_language_BON_Command				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[307]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[308]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[309]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[310]);
			}
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.BON.BONFactory.eINSTANCE.createCommands();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_11_0_0_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCommands(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[311]);
					}
					
					(
						a3_0 = parse_org_emftext_language_BON_Command						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[312]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[313]);
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[314]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[315]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[316]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[317]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[318]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[319]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[320]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[321]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[322]);
	}
	
;

parse_org_emftext_language_BON_Constraints returns [org.emftext.language.BON.Constraints element = null]
@init{
}
:
	(
		(
			a0 = 'constraint' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraints();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_12_0_0_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getConstraints(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[323]);
			}
			
			(
				a1_0 = parse_org_emftext_language_BON_Constraint				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[324]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[325]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[326]);
			}
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.BON.BONFactory.eINSTANCE.createConstraints();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_12_0_0_0_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getConstraints(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[327]);
					}
					
					(
						a3_0 = parse_org_emftext_language_BON_Constraint						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[328]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[329]);
						addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[330]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[331]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[332]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[333]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[334]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[335]);
	}
	
;

parse_org_emftext_language_BON_Query returns [org.emftext.language.BON.Query element = null]
@init{
}
:
	(
		a0 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[336]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[337]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[338]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[339]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[340]);
	}
	
;

parse_org_emftext_language_BON_Command returns [org.emftext.language.BON.Command element = null]
@init{
}
:
	(
		a0 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[341]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[342]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getClass_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[343]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[344]);
	}
	
;

parse_org_emftext_language_BON_Constraint returns [org.emftext.language.BON.Constraint element = null]
@init{
}
:
	(
		a0 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[345]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[347]);
	}
	
;

parse_org_emftext_language_BON_Event_005fchart returns [org.emftext.language.BON.Event_chart element = null]
@init{
}
:
	a0 = 'event_chart' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[348]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[349]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[351]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[352]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[353]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[354]);
	}
	
	(
		(
			a2 = EVENTTYPE			
			{
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
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[355]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[356]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[357]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[359]);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_BON_Indexing				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[360]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[361]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[362]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[363]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[364]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[365]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[366]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[367]);
	}
	
	(
		(
			(
				a4_0 = parse_org_emftext_language_BON_Explanation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[368]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[369]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[370]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[371]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[372]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[373]);
	}
	
	(
		(
			(
				a5_0 = parse_org_emftext_language_BON_Part				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[374]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[375]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[376]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[377]);
	}
	
	(
		(
			a6_0 = parse_org_emftext_language_BON_Event			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[378]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[379]);
	}
	
	a7 = 'end' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_16_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[380]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[381]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[382]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[383]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[384]);
	}
	
;

parse_org_emftext_language_BON_Event returns [org.emftext.language.BON.Event element = null]
@init{
}
:
	a0 = 'event' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[385]);
	}
	
	(
		a1 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[386]);
	}
	
	a2 = 'involves' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[387]);
	}
	
	(
		a3 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[388]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[390]);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createEvent();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_17_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[391]);
			}
			
			(
				a5 = IDENTIFIER				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[392]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[393]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[394]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[395]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getEvent_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[396]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[397]);
	}
	
;

parse_org_emftext_language_BON_Scenario_005fchart returns [org.emftext.language.BON.Scenario_chart element = null]
@init{
}
:
	a0 = 'scenario_chart' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[398]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[402]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[403]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_BON_Indexing				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[404]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[405]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[406]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[407]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[408]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[411]);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_BON_Explanation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[412]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[413]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[414]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[416]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[417]);
	}
	
	(
		(
			(
				a4_0 = parse_org_emftext_language_BON_Part				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[418]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[419]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[420]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[421]);
	}
	
	(
		(
			a5_0 = parse_org_emftext_language_BON_Scenario			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[423]);
	}
	
	a6 = 'end' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_18_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[424]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[425]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[426]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[427]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[428]);
	}
	
;

parse_org_emftext_language_BON_Scenario returns [org.emftext.language.BON.Scenario element = null]
@init{
}
:
	a0 = 'scenario' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_19_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[429]);
	}
	
	(
		a1 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[430]);
	}
	
	a2 = 'description' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createScenario();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_19_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[431]);
	}
	
	(
		a3 = MANIFEST_TEXTBLOCK		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getScenario_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[432]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[433]);
	}
	
;

parse_org_emftext_language_BON_Creation_005fchart returns [org.emftext.language.BON.Creation_chart element = null]
@init{
}
:
	a0 = 'creation_chart' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[434]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[435]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[436]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[437]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[438]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[439]);
	}
	
	(
		(
			(
				a2_0 = parse_org_emftext_language_BON_Indexing				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[440]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[441]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[442]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[443]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[444]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[445]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[446]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[447]);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_BON_Explanation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[448]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[449]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[450]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[451]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[452]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[453]);
	}
	
	(
		(
			(
				a4_0 = parse_org_emftext_language_BON_Part				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[454]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[455]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[456]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[457]);
	}
	
	(
		(
			a5_0 = parse_org_emftext_language_BON_Creation			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[458]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[459]);
	}
	
	a6 = 'end' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation_chart();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_20_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[460]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[461]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[462]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getInformal_charts(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[464]);
	}
	
;

parse_org_emftext_language_BON_Creation returns [org.emftext.language.BON.Creation element = null]
@init{
}
:
	a0 = 'creator' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[465]);
	}
	
	(
		a1 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[466]);
	}
	
	a2 = 'creates' {
		if (element == null) {
			element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[467]);
	}
	
	(
		a3 = IDENTIFIER		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[468]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[469]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[470]);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.BON.BONFactory.eINSTANCE.createCreation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.BON.resource.bon.grammar.BonGrammarInformationProvider.BON_21_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[471]);
			}
			
			(
				a5 = IDENTIFIER				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[472]);
				addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[473]);
				addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[474]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[475]);
		addExpectedElement(org.emftext.language.BON.BONPackage.eINSTANCE.getCreation_chart(), org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[476]);
		addExpectedElement(null, org.emftext.language.BON.resource.bon.mopp.BonExpectationConstants.EXPECTATIONS[477]);
	}
	
;

WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;
COMMENT:
	('--'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
EVENTTYPE:
	(('incoming'|'outgoing'))
;
KEYWORDS:
	(('action'| 'and'| 'calls'| 'client'| 'component'| 'concatenator'| 'deferred'|
	'delta'| 'dictionary'| 'dynamic_diagram'| 'effective'| 'ensure'| 'exists'| 'false'| 'feature'|
	'for_all'| 'infix'| 'interfaced'| 'invariant'| 'it_holds'| 'keyword_prefix'| 'member_of'|
	'nameless'| 'not'| 'object'| 'object_group'| 'object_stack'| 'old'| 'or'| 'persistent'|
	'prefix'| 'redefined'| 'require'| 'reused'| 'root'| 'static_diagram'| 'string_marks'|
	'such_that'| 'true'| 'xor'))
	{ _channel = 99; }
;
PREDEFINED_NAMES:
	(('Current' | 'Result' | 'Void'))
	{ _channel = 99; }
;
IDENTIFIER:
	(('A'..'Z')('A'..'Z'|'0'..'9'|'_')+('A'..'Z'|'0'..'9'))
;
FEATURE_IDENTIFIER:
	(('a'..'z')('a'..'z'|'0'..'9'|'_')+('a'..'z'|'0'..'9'))
;
SIMPLE_STRING:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'/'|'-'|'\''|'.'|','|'\;'|'\('|'\)'|'?')+)
	{ _channel = 99; }
;
MANIFEST_TEXTBLOCK:
	('"'(('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'/'|'-'|'\''|'.'|','|'\;'|'\('|'\)'|'?')+|'\\' ('\r\n'|'\r'|'\n')(' '|'\t'|'\f')* '\\'((' '|'\t'|'\f'))*('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'/'|'-'|'\''|'.'|','|'\;'|'\('|'\)'|'?')+ | (' '|'\t'|'\f'))+'"')
;
STRING_BEGIN_END:
	('"')
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n'|'\r'|'\n'))
	{ _channel = 99; }
;

