SYNTAXDEF bon
FOR <http://www.emftext.org/language/BON>
START Informal_charts

OPTIONS {
	generateCodeFromGeneratorModel = "true";
	usePredefinedTokens = "false";
	disableTokenSorting="true";
}
TOKENS {	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;	
	DEFINE COMMENT $'--'(~('\n'|'\r'|'\uffff'))*$;		
	DEFINE EVENTTYPE $('incoming'|'outgoing')$;
	DEFINE KEYWORDS $('action'| 'and'| 'calls'| 'client'| 'component'| 'concatenator'| 'deferred'|
	'delta'| 'dictionary'| 'dynamic_diagram'| 'effective'| 'ensure'| 'exists'| 'false'| 'feature'|
	'for_all'| 'infix'| 'interfaced'| 'invariant'| 'it_holds'| 'keyword_prefix'| 'member_of'|
	'nameless'| 'not'| 'object'| 'object_group'| 'object_stack'| 'old'| 'or'| 'persistent'|
	'prefix'| 'redefined'| 'require'| 'reused'| 'root'| 'static_diagram'| 'string_marks'|
	'such_that'| 'true'| 'xor')$;
	DEFINE PREDEFINED_NAMES $('Current' | 'Result' | 'Void')$;
	DEFINE IDENTIFIER $('A'..'Z')('A'..'Z'|'0'..'9'|'_')+('A'..'Z'|'0'..'9')$;
	DEFINE FEATURE_IDENTIFIER $('a'..'z')('a'..'z'|'0'..'9'|'_')+('a'..'z'|'0'..'9')$;
	DEFINE SIMPLE_STRING $('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'/'|'-'|'\''|'.'|','|'\;'|'\('|'\)'|'?')+$;
	DEFINE MANIFEST_TEXTBLOCK STRING_BEGIN_END+$($+SIMPLE_STRING+$|'\\' $+LINEBREAK+WHITESPACE+$* '\\'($+WHITESPACE+$)*$
	+SIMPLE_STRING+$ | $+WHITESPACE+$)+$+STRING_BEGIN_END;
	DEFINE STRING_BEGIN_END $'"'$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}
TOKENSTYLES {
	"COMMENT" COLOR #00bb00, ITALIC;
	"MANIFEST_TEXTBLOCK" COLOR #2a00ff;
	"EVENTTYPE" COLOR #7F0055, BOLD;
	"KEYWORDS" COLOR #7F0055, BOLD;
	"PREDEFINED_NAMES" COLOR #000000, ITALIC;
}
RULES {
	Informal_charts ::= system_chart (cluster_charts | class_charts | event_charts | scenario_charts | creation_charts)*;

	System_chart ::= "system_chart" name[IDENTIFIER]
	(chart_indexing)?
	(explanation)?
	(chart_part)?
	cluster_entries*
	"end";
	
	Explanation ::= "explanation" name[MANIFEST_TEXTBLOCK];
	Indexing ::= "indexing" index_term_list+;
	Part ::= "part" name[MANIFEST_TEXTBLOCK];
	
	Index_Identifier ::= name[FEATURE_IDENTIFIER] ":" index_string[MANIFEST_TEXTBLOCK] ("," index_string[MANIFEST_TEXTBLOCK])* ";";
	
	Cluster ::= "cluster" name[IDENTIFIER] "description" description[MANIFEST_TEXTBLOCK];
	
	Cluster_chart ::= "cluster_chart" cluster[IDENTIFIER]
	(chart_indexing)?
	(explanation)?
	(chart_part)?
	(class_entries | clusterchart_entries)*
	"end"; 
	
	ClassBON ::= "class" name[IDENTIFIER] "description" description[MANIFEST_TEXTBLOCK];
	
	Class_chart ::= "class_chart" class[IDENTIFIER]
	(chart_indexing)?
	(explanation)?
	(chart_part)?
	("inherit" inherit[IDENTIFIER] ("," inherit[IDENTIFIER])*)*
	queries?
	commands?
	constraints?
	"end";
	
	Queries ::= ("query" query ("," query)*)*;
	Commands ::= ("command" command ("," command)*)*;
	Constraints ::= ("constraint" constraint ("," constraint)*)*;
	
	Query ::= name[MANIFEST_TEXTBLOCK];
	Command ::= name[MANIFEST_TEXTBLOCK];
	Constraint ::= name[MANIFEST_TEXTBLOCK];
	
	Event_chart ::= "event_chart" system_name[IDENTIFIER]
	event_type[EVENTTYPE]?
	(chart_indexing)?
	(explanation)?
	(chart_part)?
	event_entries*
	"end";
	
	Event ::= "event" name[MANIFEST_TEXTBLOCK] "involves" involves[IDENTIFIER] ("," involves[IDENTIFIER])*;
	
	Scenario_chart ::= "scenario_chart" system_name[IDENTIFIER]
	(chart_indexing)?
	(explanation)?
	(chart_part)?
	scenario_entries*
	"end";
	
	Scenario ::= "scenario" name[MANIFEST_TEXTBLOCK] "description" description[MANIFEST_TEXTBLOCK];
	
	Creation_chart ::= "creation_chart" system_name[IDENTIFIER]
	(chart_indexing)?
	(explanation)?
	(chart_part)?
	creation_entries*
	"end";
	
	Creation ::= "creator" creator[IDENTIFIER] "creates" creates[IDENTIFIER] ("," creates[IDENTIFIER])*;
}