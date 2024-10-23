// Generated from org\apache\skywalking\oal\rt\grammar\OALParser.g4 by ANTLR 4.7.1
package org.apache.skywalking.oal.rt.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OALParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FROM=1, FILTER=2, DISABLE=3, SRC_ALL=4, SRC_SERVICE=5, SRC_SERVICE_INSTANCE=6, 
		SRC_ENDPOINT=7, SRC_SERVICE_RELATION=8, SRC_SERVICE_INSTANCE_RELATION=9, 
		SRC_ENDPOINT_RELATION=10, SRC_SERVICE_INSTANCE_JVM_CPU=11, SRC_SERVICE_INSTANCE_JVM_MEMORY=12, 
		SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL=13, SRC_SERVICE_INSTANCE_JVM_GC=14, 
		SRC_SERVICE_INSTANCE_JVM_THREAD=15, SRC_SERVICE_INSTANCE_JVM_CLASS=16, 
		SRC_DATABASE_ACCESS=17, SRC_SERVICE_INSTANCE_CLR_CPU=18, SRC_SERVICE_INSTANCE_CLR_GC=19, 
		SRC_SERVICE_INSTANCE_CLR_THREAD=20, SRC_ENVOY_INSTANCE_METRIC=21, SRC_EVENT=22, 
		SRC_BROWSER_APP_PERF=23, SRC_BROWSER_APP_PAGE_PERF=24, SRC_BROWSER_APP_SINGLE_VERSION_PERF=25, 
		SRC_BROWSER_APP_TRAFFIC=26, SRC_BROWSER_APP_PAGE_TRAFFIC=27, SRC_BROWSER_APP_SINGLE_VERSION_TRAFFIC=28, 
		DOT=29, LR_BRACKET=30, RR_BRACKET=31, LS_BRACKET=32, RS_BRACKET=33, COMMA=34, 
		SEMI=35, EQUAL=36, DUALEQUALS=37, ALL=38, GREATER=39, LESS=40, GREATER_EQUAL=41, 
		LESS_EQUAL=42, NOT_EQUAL=43, LIKE=44, IN=45, CONTAIN=46, NOT_CONTAIN=47, 
		BOOL_LITERAL=48, NUMBER_LITERAL=49, CHAR_LITERAL=50, STRING_LITERAL=51, 
		DelimitedComment=52, LineComment=53, SPACE=54, IDENTIFIER=55;
	public static final int
		RULE_root = 0, RULE_aggregationStatement = 1, RULE_disableStatement = 2, 
		RULE_metricStatement = 3, RULE_filterStatement = 4, RULE_filterExpression = 5, 
		RULE_source = 6, RULE_disableSource = 7, RULE_sourceAttributeStmt = 8, 
		RULE_sourceAttribute = 9, RULE_variable = 10, RULE_aggregateFunction = 11, 
		RULE_functionName = 12, RULE_funcParamExpression = 13, RULE_literalExpression = 14, 
		RULE_expression = 15, RULE_containMatch = 16, RULE_notContainMatch = 17, 
		RULE_booleanMatch = 18, RULE_stringMatch = 19, RULE_greaterMatch = 20, 
		RULE_lessMatch = 21, RULE_greaterEqualMatch = 22, RULE_lessEqualMatch = 23, 
		RULE_booleanNotEqualMatch = 24, RULE_notEqualMatch = 25, RULE_likeMatch = 26, 
		RULE_inMatch = 27, RULE_multiConditionValue = 28, RULE_conditionAttributeStmt = 29, 
		RULE_conditionAttribute = 30, RULE_booleanConditionValue = 31, RULE_stringConditionValue = 32, 
		RULE_enumConditionValue = 33, RULE_numberConditionValue = 34;
	public static final String[] ruleNames = {
		"root", "aggregationStatement", "disableStatement", "metricStatement", 
		"filterStatement", "filterExpression", "source", "disableSource", "sourceAttributeStmt", 
		"sourceAttribute", "variable", "aggregateFunction", "functionName", "funcParamExpression", 
		"literalExpression", "expression", "containMatch", "notContainMatch", 
		"booleanMatch", "stringMatch", "greaterMatch", "lessMatch", "greaterEqualMatch", 
		"lessEqualMatch", "booleanNotEqualMatch", "notEqualMatch", "likeMatch", 
		"inMatch", "multiConditionValue", "conditionAttributeStmt", "conditionAttribute", 
		"booleanConditionValue", "stringConditionValue", "enumConditionValue", 
		"numberConditionValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'from'", "'filter'", "'disable'", "'All'", "'Service'", "'ServiceInstance'", 
		"'Endpoint'", "'ServiceRelation'", "'ServiceInstanceRelation'", "'EndpointRelation'", 
		"'ServiceInstanceJVMCPU'", "'ServiceInstanceJVMMemory'", "'ServiceInstanceJVMMemoryPool'", 
		"'ServiceInstanceJVMGC'", "'ServiceInstanceJVMThread'", "'ServiceInstanceJVMClass'", 
		"'DatabaseAccess'", "'ServiceInstanceCLRCPU'", "'ServiceInstanceCLRGC'", 
		"'ServiceInstanceCLRThread'", "'EnvoyInstanceMetric'", "'Event'", "'BrowserAppPerf'", 
		"'BrowserAppPagePerf'", "'BrowserAppSingleVersionPerf'", "'BrowserAppTraffic'", 
		"'BrowserAppPageTraffic'", "'BrowserAppSingleVersionTraffic'", "'.'", 
		"'('", "')'", "'['", "']'", "','", "';'", "'='", "'=='", "'*'", "'>'", 
		"'<'", "'>='", "'<='", "'!='", "'like'", "'in'", "'contain'", "'not contain'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FROM", "FILTER", "DISABLE", "SRC_ALL", "SRC_SERVICE", "SRC_SERVICE_INSTANCE", 
		"SRC_ENDPOINT", "SRC_SERVICE_RELATION", "SRC_SERVICE_INSTANCE_RELATION", 
		"SRC_ENDPOINT_RELATION", "SRC_SERVICE_INSTANCE_JVM_CPU", "SRC_SERVICE_INSTANCE_JVM_MEMORY", 
		"SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL", "SRC_SERVICE_INSTANCE_JVM_GC", 
		"SRC_SERVICE_INSTANCE_JVM_THREAD", "SRC_SERVICE_INSTANCE_JVM_CLASS", "SRC_DATABASE_ACCESS", 
		"SRC_SERVICE_INSTANCE_CLR_CPU", "SRC_SERVICE_INSTANCE_CLR_GC", "SRC_SERVICE_INSTANCE_CLR_THREAD", 
		"SRC_ENVOY_INSTANCE_METRIC", "SRC_EVENT", "SRC_BROWSER_APP_PERF", "SRC_BROWSER_APP_PAGE_PERF", 
		"SRC_BROWSER_APP_SINGLE_VERSION_PERF", "SRC_BROWSER_APP_TRAFFIC", "SRC_BROWSER_APP_PAGE_TRAFFIC", 
		"SRC_BROWSER_APP_SINGLE_VERSION_TRAFFIC", "DOT", "LR_BRACKET", "RR_BRACKET", 
		"LS_BRACKET", "RS_BRACKET", "COMMA", "SEMI", "EQUAL", "DUALEQUALS", "ALL", 
		"GREATER", "LESS", "GREATER_EQUAL", "LESS_EQUAL", "NOT_EQUAL", "LIKE", 
		"IN", "CONTAIN", "NOT_CONTAIN", "BOOL_LITERAL", "NUMBER_LITERAL", "CHAR_LITERAL", 
		"STRING_LITERAL", "DelimitedComment", "LineComment", "SPACE", "IDENTIFIER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OALParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OALParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public List<AggregationStatementContext> aggregationStatement() {
			return getRuleContexts(AggregationStatementContext.class);
		}
		public AggregationStatementContext aggregationStatement(int i) {
			return getRuleContext(AggregationStatementContext.class,i);
		}
		public List<DisableStatementContext> disableStatement() {
			return getRuleContexts(DisableStatementContext.class);
		}
		public DisableStatementContext disableStatement(int i) {
			return getRuleContext(DisableStatementContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DISABLE || _la==IDENTIFIER) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(70);
					aggregationStatement();
					}
					break;
				case DISABLE:
					{
					setState(71);
					disableStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationStatementContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(OALParser.EQUAL, 0); }
		public MetricStatementContext metricStatement() {
			return getRuleContext(MetricStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(OALParser.SEMI, 0); }
		public TerminalNode EOF() { return getToken(OALParser.EOF, 0); }
		public List<TerminalNode> SPACE() { return getTokens(OALParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(OALParser.SPACE, i);
		}
		public TerminalNode DelimitedComment() { return getToken(OALParser.DelimitedComment, 0); }
		public TerminalNode LineComment() { return getToken(OALParser.LineComment, 0); }
		public AggregationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterAggregationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitAggregationStatement(this);
		}
	}

	public final AggregationStatementContext aggregationStatement() throws RecognitionException {
		AggregationStatementContext _localctx = new AggregationStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aggregationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			variable();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(78);
				match(SPACE);
				}
			}

			setState(81);
			match(EQUAL);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(82);
				match(SPACE);
				}
			}

			setState(85);
			metricStatement();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DelimitedComment) {
				{
				setState(86);
				match(DelimitedComment);
				}
			}

			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LineComment) {
				{
				setState(89);
				match(LineComment);
				}
			}

			setState(92);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==SEMI) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisableStatementContext extends ParserRuleContext {
		public TerminalNode DISABLE() { return getToken(OALParser.DISABLE, 0); }
		public TerminalNode LR_BRACKET() { return getToken(OALParser.LR_BRACKET, 0); }
		public DisableSourceContext disableSource() {
			return getRuleContext(DisableSourceContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(OALParser.RR_BRACKET, 0); }
		public TerminalNode SEMI() { return getToken(OALParser.SEMI, 0); }
		public TerminalNode EOF() { return getToken(OALParser.EOF, 0); }
		public TerminalNode DelimitedComment() { return getToken(OALParser.DelimitedComment, 0); }
		public TerminalNode LineComment() { return getToken(OALParser.LineComment, 0); }
		public DisableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterDisableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitDisableStatement(this);
		}
	}

	public final DisableStatementContext disableStatement() throws RecognitionException {
		DisableStatementContext _localctx = new DisableStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_disableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(DISABLE);
			setState(95);
			match(LR_BRACKET);
			setState(96);
			disableSource();
			setState(97);
			match(RR_BRACKET);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DelimitedComment) {
				{
				setState(98);
				match(DelimitedComment);
				}
			}

			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LineComment) {
				{
				setState(101);
				match(LineComment);
				}
			}

			setState(104);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==SEMI) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricStatementContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(OALParser.FROM, 0); }
		public TerminalNode LR_BRACKET() { return getToken(OALParser.LR_BRACKET, 0); }
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(OALParser.RR_BRACKET, 0); }
		public TerminalNode DOT() { return getToken(OALParser.DOT, 0); }
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public List<SourceAttributeStmtContext> sourceAttributeStmt() {
			return getRuleContexts(SourceAttributeStmtContext.class);
		}
		public SourceAttributeStmtContext sourceAttributeStmt(int i) {
			return getRuleContext(SourceAttributeStmtContext.class,i);
		}
		public List<FilterStatementContext> filterStatement() {
			return getRuleContexts(FilterStatementContext.class);
		}
		public FilterStatementContext filterStatement(int i) {
			return getRuleContext(FilterStatementContext.class,i);
		}
		public MetricStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterMetricStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitMetricStatement(this);
		}
	}

	public final MetricStatementContext metricStatement() throws RecognitionException {
		MetricStatementContext _localctx = new MetricStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_metricStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(FROM);
			setState(107);
			match(LR_BRACKET);
			setState(108);
			source();
			{
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				sourceAttributeStmt();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
			}
			setState(114);
			match(RR_BRACKET);
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(116); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(115);
						filterStatement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(118); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			setState(122);
			match(DOT);
			setState(123);
			aggregateFunction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterStatementContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(OALParser.DOT, 0); }
		public TerminalNode FILTER() { return getToken(OALParser.FILTER, 0); }
		public TerminalNode LR_BRACKET() { return getToken(OALParser.LR_BRACKET, 0); }
		public FilterExpressionContext filterExpression() {
			return getRuleContext(FilterExpressionContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(OALParser.RR_BRACKET, 0); }
		public FilterStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterFilterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitFilterStatement(this);
		}
	}

	public final FilterStatementContext filterStatement() throws RecognitionException {
		FilterStatementContext _localctx = new FilterStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_filterStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(DOT);
			setState(126);
			match(FILTER);
			setState(127);
			match(LR_BRACKET);
			setState(128);
			filterExpression();
			setState(129);
			match(RR_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterFilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitFilterExpression(this);
		}
	}

	public final FilterExpressionContext filterExpression() throws RecognitionException {
		FilterExpressionContext _localctx = new FilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_filterExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceContext extends ParserRuleContext {
		public TerminalNode SRC_ALL() { return getToken(OALParser.SRC_ALL, 0); }
		public TerminalNode SRC_SERVICE() { return getToken(OALParser.SRC_SERVICE, 0); }
		public TerminalNode SRC_DATABASE_ACCESS() { return getToken(OALParser.SRC_DATABASE_ACCESS, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE() { return getToken(OALParser.SRC_SERVICE_INSTANCE, 0); }
		public TerminalNode SRC_ENDPOINT() { return getToken(OALParser.SRC_ENDPOINT, 0); }
		public TerminalNode SRC_SERVICE_RELATION() { return getToken(OALParser.SRC_SERVICE_RELATION, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_RELATION() { return getToken(OALParser.SRC_SERVICE_INSTANCE_RELATION, 0); }
		public TerminalNode SRC_ENDPOINT_RELATION() { return getToken(OALParser.SRC_ENDPOINT_RELATION, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_CLR_CPU() { return getToken(OALParser.SRC_SERVICE_INSTANCE_CLR_CPU, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_CLR_GC() { return getToken(OALParser.SRC_SERVICE_INSTANCE_CLR_GC, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_CLR_THREAD() { return getToken(OALParser.SRC_SERVICE_INSTANCE_CLR_THREAD, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_CPU() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_CPU, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_MEMORY() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_MEMORY, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_GC() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_GC, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_THREAD() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_THREAD, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_CLASS() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_CLASS, 0); }
		public TerminalNode SRC_ENVOY_INSTANCE_METRIC() { return getToken(OALParser.SRC_ENVOY_INSTANCE_METRIC, 0); }
		public TerminalNode SRC_BROWSER_APP_PERF() { return getToken(OALParser.SRC_BROWSER_APP_PERF, 0); }
		public TerminalNode SRC_BROWSER_APP_PAGE_PERF() { return getToken(OALParser.SRC_BROWSER_APP_PAGE_PERF, 0); }
		public TerminalNode SRC_BROWSER_APP_SINGLE_VERSION_PERF() { return getToken(OALParser.SRC_BROWSER_APP_SINGLE_VERSION_PERF, 0); }
		public TerminalNode SRC_BROWSER_APP_TRAFFIC() { return getToken(OALParser.SRC_BROWSER_APP_TRAFFIC, 0); }
		public TerminalNode SRC_BROWSER_APP_PAGE_TRAFFIC() { return getToken(OALParser.SRC_BROWSER_APP_PAGE_TRAFFIC, 0); }
		public TerminalNode SRC_BROWSER_APP_SINGLE_VERSION_TRAFFIC() { return getToken(OALParser.SRC_BROWSER_APP_SINGLE_VERSION_TRAFFIC, 0); }
		public TerminalNode SRC_EVENT() { return getToken(OALParser.SRC_EVENT, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SRC_ALL) | (1L << SRC_SERVICE) | (1L << SRC_SERVICE_INSTANCE) | (1L << SRC_ENDPOINT) | (1L << SRC_SERVICE_RELATION) | (1L << SRC_SERVICE_INSTANCE_RELATION) | (1L << SRC_ENDPOINT_RELATION) | (1L << SRC_SERVICE_INSTANCE_JVM_CPU) | (1L << SRC_SERVICE_INSTANCE_JVM_MEMORY) | (1L << SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL) | (1L << SRC_SERVICE_INSTANCE_JVM_GC) | (1L << SRC_SERVICE_INSTANCE_JVM_THREAD) | (1L << SRC_SERVICE_INSTANCE_JVM_CLASS) | (1L << SRC_DATABASE_ACCESS) | (1L << SRC_SERVICE_INSTANCE_CLR_CPU) | (1L << SRC_SERVICE_INSTANCE_CLR_GC) | (1L << SRC_SERVICE_INSTANCE_CLR_THREAD) | (1L << SRC_ENVOY_INSTANCE_METRIC) | (1L << SRC_EVENT) | (1L << SRC_BROWSER_APP_PERF) | (1L << SRC_BROWSER_APP_PAGE_PERF) | (1L << SRC_BROWSER_APP_SINGLE_VERSION_PERF) | (1L << SRC_BROWSER_APP_TRAFFIC) | (1L << SRC_BROWSER_APP_PAGE_TRAFFIC) | (1L << SRC_BROWSER_APP_SINGLE_VERSION_TRAFFIC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisableSourceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public DisableSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disableSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterDisableSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitDisableSource(this);
		}
	}

	public final DisableSourceContext disableSource() throws RecognitionException {
		DisableSourceContext _localctx = new DisableSourceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_disableSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceAttributeStmtContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(OALParser.DOT, 0); }
		public SourceAttributeContext sourceAttribute() {
			return getRuleContext(SourceAttributeContext.class,0);
		}
		public SourceAttributeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceAttributeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterSourceAttributeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitSourceAttributeStmt(this);
		}
	}

	public final SourceAttributeStmtContext sourceAttributeStmt() throws RecognitionException {
		SourceAttributeStmtContext _localctx = new SourceAttributeStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sourceAttributeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(DOT);
			setState(138);
			sourceAttribute();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceAttributeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public TerminalNode ALL() { return getToken(OALParser.ALL, 0); }
		public SourceAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterSourceAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitSourceAttribute(this);
		}
	}

	public final SourceAttributeContext sourceAttribute() throws RecognitionException {
		SourceAttributeContext _localctx = new SourceAttributeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sourceAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateFunctionContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LR_BRACKET() { return getToken(OALParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(OALParser.RR_BRACKET, 0); }
		public List<FuncParamExpressionContext> funcParamExpression() {
			return getRuleContexts(FuncParamExpressionContext.class);
		}
		public FuncParamExpressionContext funcParamExpression(int i) {
			return getRuleContext(FuncParamExpressionContext.class,i);
		}
		public List<LiteralExpressionContext> literalExpression() {
			return getRuleContexts(LiteralExpressionContext.class);
		}
		public LiteralExpressionContext literalExpression(int i) {
			return getRuleContext(LiteralExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(OALParser.COMMA, 0); }
		public AggregateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterAggregateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitAggregateFunction(this);
		}
	}

	public final AggregateFunctionContext aggregateFunction() throws RecognitionException {
		AggregateFunctionContext _localctx = new AggregateFunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_aggregateFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			functionName();
			setState(145);
			match(LR_BRACKET);
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(146);
				funcParamExpression();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(147);
					match(COMMA);
					setState(148);
					funcParamExpression();
					}
				}

				}
				}
				break;
			case 2:
				{
				{
				setState(151);
				literalExpression();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(152);
					match(COMMA);
					setState(153);
					literalExpression();
					}
				}

				}
				}
				break;
			}
			setState(158);
			match(RR_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitFunctionName(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncParamExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FuncParamExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParamExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterFuncParamExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitFuncParamExpression(this);
		}
	}

	public final FuncParamExpressionContext funcParamExpression() throws RecognitionException {
		FuncParamExpressionContext _localctx = new FuncParamExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcParamExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralExpressionContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(OALParser.BOOL_LITERAL, 0); }
		public TerminalNode NUMBER_LITERAL() { return getToken(OALParser.NUMBER_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitLiteralExpression(this);
		}
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_literalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL_LITERAL) | (1L << NUMBER_LITERAL) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanMatchContext booleanMatch() {
			return getRuleContext(BooleanMatchContext.class,0);
		}
		public StringMatchContext stringMatch() {
			return getRuleContext(StringMatchContext.class,0);
		}
		public GreaterMatchContext greaterMatch() {
			return getRuleContext(GreaterMatchContext.class,0);
		}
		public LessMatchContext lessMatch() {
			return getRuleContext(LessMatchContext.class,0);
		}
		public GreaterEqualMatchContext greaterEqualMatch() {
			return getRuleContext(GreaterEqualMatchContext.class,0);
		}
		public LessEqualMatchContext lessEqualMatch() {
			return getRuleContext(LessEqualMatchContext.class,0);
		}
		public NotEqualMatchContext notEqualMatch() {
			return getRuleContext(NotEqualMatchContext.class,0);
		}
		public BooleanNotEqualMatchContext booleanNotEqualMatch() {
			return getRuleContext(BooleanNotEqualMatchContext.class,0);
		}
		public LikeMatchContext likeMatch() {
			return getRuleContext(LikeMatchContext.class,0);
		}
		public InMatchContext inMatch() {
			return getRuleContext(InMatchContext.class,0);
		}
		public ContainMatchContext containMatch() {
			return getRuleContext(ContainMatchContext.class,0);
		}
		public NotContainMatchContext notContainMatch() {
			return getRuleContext(NotContainMatchContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				booleanMatch();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				stringMatch();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				greaterMatch();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				lessMatch();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(170);
				greaterEqualMatch();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				lessEqualMatch();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(172);
				notEqualMatch();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(173);
				booleanNotEqualMatch();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(174);
				likeMatch();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(175);
				inMatch();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(176);
				containMatch();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(177);
				notContainMatch();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContainMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode CONTAIN() { return getToken(OALParser.CONTAIN, 0); }
		public StringConditionValueContext stringConditionValue() {
			return getRuleContext(StringConditionValueContext.class,0);
		}
		public ContainMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_containMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterContainMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitContainMatch(this);
		}
	}

	public final ContainMatchContext containMatch() throws RecognitionException {
		ContainMatchContext _localctx = new ContainMatchContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_containMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			conditionAttributeStmt();
			setState(181);
			match(CONTAIN);
			setState(182);
			stringConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContainMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode NOT_CONTAIN() { return getToken(OALParser.NOT_CONTAIN, 0); }
		public StringConditionValueContext stringConditionValue() {
			return getRuleContext(StringConditionValueContext.class,0);
		}
		public NotContainMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notContainMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterNotContainMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitNotContainMatch(this);
		}
	}

	public final NotContainMatchContext notContainMatch() throws RecognitionException {
		NotContainMatchContext _localctx = new NotContainMatchContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_notContainMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			conditionAttributeStmt();
			setState(185);
			match(NOT_CONTAIN);
			setState(186);
			stringConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode DUALEQUALS() { return getToken(OALParser.DUALEQUALS, 0); }
		public BooleanConditionValueContext booleanConditionValue() {
			return getRuleContext(BooleanConditionValueContext.class,0);
		}
		public BooleanMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterBooleanMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitBooleanMatch(this);
		}
	}

	public final BooleanMatchContext booleanMatch() throws RecognitionException {
		BooleanMatchContext _localctx = new BooleanMatchContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_booleanMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			conditionAttributeStmt();
			setState(189);
			match(DUALEQUALS);
			setState(190);
			booleanConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode DUALEQUALS() { return getToken(OALParser.DUALEQUALS, 0); }
		public StringConditionValueContext stringConditionValue() {
			return getRuleContext(StringConditionValueContext.class,0);
		}
		public EnumConditionValueContext enumConditionValue() {
			return getRuleContext(EnumConditionValueContext.class,0);
		}
		public StringMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterStringMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitStringMatch(this);
		}
	}

	public final StringMatchContext stringMatch() throws RecognitionException {
		StringMatchContext _localctx = new StringMatchContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stringMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			conditionAttributeStmt();
			setState(193);
			match(DUALEQUALS);
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				{
				setState(194);
				stringConditionValue();
				}
				break;
			case IDENTIFIER:
				{
				setState(195);
				enumConditionValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreaterMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(OALParser.GREATER, 0); }
		public NumberConditionValueContext numberConditionValue() {
			return getRuleContext(NumberConditionValueContext.class,0);
		}
		public GreaterMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterGreaterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitGreaterMatch(this);
		}
	}

	public final GreaterMatchContext greaterMatch() throws RecognitionException {
		GreaterMatchContext _localctx = new GreaterMatchContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_greaterMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			conditionAttributeStmt();
			setState(199);
			match(GREATER);
			setState(200);
			numberConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LessMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode LESS() { return getToken(OALParser.LESS, 0); }
		public NumberConditionValueContext numberConditionValue() {
			return getRuleContext(NumberConditionValueContext.class,0);
		}
		public LessMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterLessMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitLessMatch(this);
		}
	}

	public final LessMatchContext lessMatch() throws RecognitionException {
		LessMatchContext _localctx = new LessMatchContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_lessMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			conditionAttributeStmt();
			setState(203);
			match(LESS);
			setState(204);
			numberConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreaterEqualMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode GREATER_EQUAL() { return getToken(OALParser.GREATER_EQUAL, 0); }
		public NumberConditionValueContext numberConditionValue() {
			return getRuleContext(NumberConditionValueContext.class,0);
		}
		public GreaterEqualMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterEqualMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterGreaterEqualMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitGreaterEqualMatch(this);
		}
	}

	public final GreaterEqualMatchContext greaterEqualMatch() throws RecognitionException {
		GreaterEqualMatchContext _localctx = new GreaterEqualMatchContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_greaterEqualMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			conditionAttributeStmt();
			setState(207);
			match(GREATER_EQUAL);
			setState(208);
			numberConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LessEqualMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode LESS_EQUAL() { return getToken(OALParser.LESS_EQUAL, 0); }
		public NumberConditionValueContext numberConditionValue() {
			return getRuleContext(NumberConditionValueContext.class,0);
		}
		public LessEqualMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessEqualMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterLessEqualMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitLessEqualMatch(this);
		}
	}

	public final LessEqualMatchContext lessEqualMatch() throws RecognitionException {
		LessEqualMatchContext _localctx = new LessEqualMatchContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lessEqualMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			conditionAttributeStmt();
			setState(211);
			match(LESS_EQUAL);
			setState(212);
			numberConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanNotEqualMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode NOT_EQUAL() { return getToken(OALParser.NOT_EQUAL, 0); }
		public BooleanConditionValueContext booleanConditionValue() {
			return getRuleContext(BooleanConditionValueContext.class,0);
		}
		public BooleanNotEqualMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanNotEqualMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterBooleanNotEqualMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitBooleanNotEqualMatch(this);
		}
	}

	public final BooleanNotEqualMatchContext booleanNotEqualMatch() throws RecognitionException {
		BooleanNotEqualMatchContext _localctx = new BooleanNotEqualMatchContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_booleanNotEqualMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			conditionAttributeStmt();
			setState(215);
			match(NOT_EQUAL);
			setState(216);
			booleanConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotEqualMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode NOT_EQUAL() { return getToken(OALParser.NOT_EQUAL, 0); }
		public NumberConditionValueContext numberConditionValue() {
			return getRuleContext(NumberConditionValueContext.class,0);
		}
		public StringConditionValueContext stringConditionValue() {
			return getRuleContext(StringConditionValueContext.class,0);
		}
		public EnumConditionValueContext enumConditionValue() {
			return getRuleContext(EnumConditionValueContext.class,0);
		}
		public NotEqualMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notEqualMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterNotEqualMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitNotEqualMatch(this);
		}
	}

	public final NotEqualMatchContext notEqualMatch() throws RecognitionException {
		NotEqualMatchContext _localctx = new NotEqualMatchContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_notEqualMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			conditionAttributeStmt();
			setState(219);
			match(NOT_EQUAL);
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LITERAL:
				{
				setState(220);
				numberConditionValue();
				}
				break;
			case STRING_LITERAL:
				{
				setState(221);
				stringConditionValue();
				}
				break;
			case IDENTIFIER:
				{
				setState(222);
				enumConditionValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(OALParser.LIKE, 0); }
		public StringConditionValueContext stringConditionValue() {
			return getRuleContext(StringConditionValueContext.class,0);
		}
		public LikeMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterLikeMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitLikeMatch(this);
		}
	}

	public final LikeMatchContext likeMatch() throws RecognitionException {
		LikeMatchContext _localctx = new LikeMatchContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_likeMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			conditionAttributeStmt();
			setState(226);
			match(LIKE);
			setState(227);
			stringConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InMatchContext extends ParserRuleContext {
		public ConditionAttributeStmtContext conditionAttributeStmt() {
			return getRuleContext(ConditionAttributeStmtContext.class,0);
		}
		public TerminalNode IN() { return getToken(OALParser.IN, 0); }
		public MultiConditionValueContext multiConditionValue() {
			return getRuleContext(MultiConditionValueContext.class,0);
		}
		public InMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inMatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterInMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitInMatch(this);
		}
	}

	public final InMatchContext inMatch() throws RecognitionException {
		InMatchContext _localctx = new InMatchContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_inMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			conditionAttributeStmt();
			setState(230);
			match(IN);
			setState(231);
			multiConditionValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiConditionValueContext extends ParserRuleContext {
		public TerminalNode LS_BRACKET() { return getToken(OALParser.LS_BRACKET, 0); }
		public TerminalNode RS_BRACKET() { return getToken(OALParser.RS_BRACKET, 0); }
		public List<NumberConditionValueContext> numberConditionValue() {
			return getRuleContexts(NumberConditionValueContext.class);
		}
		public NumberConditionValueContext numberConditionValue(int i) {
			return getRuleContext(NumberConditionValueContext.class,i);
		}
		public List<StringConditionValueContext> stringConditionValue() {
			return getRuleContexts(StringConditionValueContext.class);
		}
		public StringConditionValueContext stringConditionValue(int i) {
			return getRuleContext(StringConditionValueContext.class,i);
		}
		public List<EnumConditionValueContext> enumConditionValue() {
			return getRuleContexts(EnumConditionValueContext.class);
		}
		public EnumConditionValueContext enumConditionValue(int i) {
			return getRuleContext(EnumConditionValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OALParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OALParser.COMMA, i);
		}
		public MultiConditionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiConditionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterMultiConditionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitMultiConditionValue(this);
		}
	}

	public final MultiConditionValueContext multiConditionValue() throws RecognitionException {
		MultiConditionValueContext _localctx = new MultiConditionValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_multiConditionValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LS_BRACKET);
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LITERAL:
				{
				setState(234);
				numberConditionValue();
				{
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(235);
					match(COMMA);
					setState(236);
					numberConditionValue();
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STRING_LITERAL:
				{
				setState(242);
				stringConditionValue();
				{
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(243);
					match(COMMA);
					setState(244);
					stringConditionValue();
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case IDENTIFIER:
				{
				setState(250);
				enumConditionValue();
				{
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(251);
					match(COMMA);
					setState(252);
					enumConditionValue();
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(260);
			match(RS_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionAttributeStmtContext extends ParserRuleContext {
		public List<ConditionAttributeContext> conditionAttribute() {
			return getRuleContexts(ConditionAttributeContext.class);
		}
		public ConditionAttributeContext conditionAttribute(int i) {
			return getRuleContext(ConditionAttributeContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(OALParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(OALParser.DOT, i);
		}
		public ConditionAttributeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAttributeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterConditionAttributeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitConditionAttributeStmt(this);
		}
	}

	public final ConditionAttributeStmtContext conditionAttributeStmt() throws RecognitionException {
		ConditionAttributeStmtContext _localctx = new ConditionAttributeStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_conditionAttributeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			conditionAttribute();
			{
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(263);
				match(DOT);
				setState(264);
				conditionAttribute();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionAttributeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public ConditionAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterConditionAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitConditionAttribute(this);
		}
	}

	public final ConditionAttributeContext conditionAttribute() throws RecognitionException {
		ConditionAttributeContext _localctx = new ConditionAttributeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_conditionAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanConditionValueContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(OALParser.BOOL_LITERAL, 0); }
		public BooleanConditionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanConditionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterBooleanConditionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitBooleanConditionValue(this);
		}
	}

	public final BooleanConditionValueContext booleanConditionValue() throws RecognitionException {
		BooleanConditionValueContext _localctx = new BooleanConditionValueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_booleanConditionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(BOOL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringConditionValueContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(OALParser.STRING_LITERAL, 0); }
		public StringConditionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConditionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterStringConditionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitStringConditionValue(this);
		}
	}

	public final StringConditionValueContext stringConditionValue() throws RecognitionException {
		StringConditionValueContext _localctx = new StringConditionValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_stringConditionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConditionValueContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(OALParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(OALParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(OALParser.DOT, 0); }
		public EnumConditionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConditionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterEnumConditionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitEnumConditionValue(this);
		}
	}

	public final EnumConditionValueContext enumConditionValue() throws RecognitionException {
		EnumConditionValueContext _localctx = new EnumConditionValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_enumConditionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(IDENTIFIER);
			setState(277);
			match(DOT);
			setState(278);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberConditionValueContext extends ParserRuleContext {
		public TerminalNode NUMBER_LITERAL() { return getToken(OALParser.NUMBER_LITERAL, 0); }
		public NumberConditionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberConditionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterNumberConditionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitNumberConditionValue(this);
		}
	}

	public final NumberConditionValueContext numberConditionValue() throws RecognitionException {
		NumberConditionValueContext _localctx = new NumberConditionValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_numberConditionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(NUMBER_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u011d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\3\3\3\5\3R\n"+
		"\3\3\3\3\3\5\3V\n\3\3\3\3\3\5\3Z\n\3\3\3\5\3]\n\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\5\4f\n\4\3\4\5\4i\n\4\3\4\3\4\3\5\3\5\3\5\3\5\6\5q\n\5\r\5\16"+
		"\5r\3\5\3\5\6\5w\n\5\r\5\16\5x\5\5{\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0098\n\r\3\r\3\r\3\r\5\r\u009d\n\r\5\r\u009f\n\r\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00b5\n\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00c7\n\25\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u00e2\n\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00f0\n\36"+
		"\f\36\16\36\u00f3\13\36\3\36\3\36\3\36\7\36\u00f8\n\36\f\36\16\36\u00fb"+
		"\13\36\3\36\3\36\3\36\7\36\u0100\n\36\f\36\16\36\u0103\13\36\5\36\u0105"+
		"\n\36\3\36\3\36\3\37\3\37\3\37\7\37\u010c\n\37\f\37\16\37\u010f\13\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\2\2%\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\6\3\3%%\3\2\6\36\4\2(("+
		"99\4\2\62\6399\2\u011c\2L\3\2\2\2\4O\3\2\2\2\6`\3\2\2\2\bl\3\2\2\2\n\177"+
		"\3\2\2\2\f\u0085\3\2\2\2\16\u0087\3\2\2\2\20\u0089\3\2\2\2\22\u008b\3"+
		"\2\2\2\24\u008e\3\2\2\2\26\u0090\3\2\2\2\30\u0092\3\2\2\2\32\u00a2\3\2"+
		"\2\2\34\u00a4\3\2\2\2\36\u00a6\3\2\2\2 \u00b4\3\2\2\2\"\u00b6\3\2\2\2"+
		"$\u00ba\3\2\2\2&\u00be\3\2\2\2(\u00c2\3\2\2\2*\u00c8\3\2\2\2,\u00cc\3"+
		"\2\2\2.\u00d0\3\2\2\2\60\u00d4\3\2\2\2\62\u00d8\3\2\2\2\64\u00dc\3\2\2"+
		"\2\66\u00e3\3\2\2\28\u00e7\3\2\2\2:\u00eb\3\2\2\2<\u0108\3\2\2\2>\u0110"+
		"\3\2\2\2@\u0112\3\2\2\2B\u0114\3\2\2\2D\u0116\3\2\2\2F\u011a\3\2\2\2H"+
		"K\5\4\3\2IK\5\6\4\2JH\3\2\2\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2"+
		"M\3\3\2\2\2NL\3\2\2\2OQ\5\26\f\2PR\78\2\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2"+
		"\2SU\7&\2\2TV\78\2\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WY\5\b\5\2XZ\7\66\2"+
		"\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\7\67\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3"+
		"\2\2\2^_\t\2\2\2_\5\3\2\2\2`a\7\5\2\2ab\7 \2\2bc\5\20\t\2ce\7!\2\2df\7"+
		"\66\2\2ed\3\2\2\2ef\3\2\2\2fh\3\2\2\2gi\7\67\2\2hg\3\2\2\2hi\3\2\2\2i"+
		"j\3\2\2\2jk\t\2\2\2k\7\3\2\2\2lm\7\3\2\2mn\7 \2\2np\5\16\b\2oq\5\22\n"+
		"\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tz\7!\2\2uw\5\n\6"+
		"\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zv\3\2\2\2z{\3\2\2"+
		"\2{|\3\2\2\2|}\7\37\2\2}~\5\30\r\2~\t\3\2\2\2\177\u0080\7\37\2\2\u0080"+
		"\u0081\7\4\2\2\u0081\u0082\7 \2\2\u0082\u0083\5\f\7\2\u0083\u0084\7!\2"+
		"\2\u0084\13\3\2\2\2\u0085\u0086\5 \21\2\u0086\r\3\2\2\2\u0087\u0088\t"+
		"\3\2\2\u0088\17\3\2\2\2\u0089\u008a\79\2\2\u008a\21\3\2\2\2\u008b\u008c"+
		"\7\37\2\2\u008c\u008d\5\24\13\2\u008d\23\3\2\2\2\u008e\u008f\t\4\2\2\u008f"+
		"\25\3\2\2\2\u0090\u0091\79\2\2\u0091\27\3\2\2\2\u0092\u0093\5\32\16\2"+
		"\u0093\u009e\7 \2\2\u0094\u0097\5\34\17\2\u0095\u0096\7$\2\2\u0096\u0098"+
		"\5\34\17\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009f\3\2\2\2"+
		"\u0099\u009c\5\36\20\2\u009a\u009b\7$\2\2\u009b\u009d\5\36\20\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0094\3\2"+
		"\2\2\u009e\u0099\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\7!\2\2\u00a1\31\3\2\2\2\u00a2\u00a3\79\2\2\u00a3\33\3\2\2\2\u00a4"+
		"\u00a5\5 \21\2\u00a5\35\3\2\2\2\u00a6\u00a7\t\5\2\2\u00a7\37\3\2\2\2\u00a8"+
		"\u00b5\5&\24\2\u00a9\u00b5\5(\25\2\u00aa\u00b5\5*\26\2\u00ab\u00b5\5,"+
		"\27\2\u00ac\u00b5\5.\30\2\u00ad\u00b5\5\60\31\2\u00ae\u00b5\5\64\33\2"+
		"\u00af\u00b5\5\62\32\2\u00b0\u00b5\5\66\34\2\u00b1\u00b5\58\35\2\u00b2"+
		"\u00b5\5\"\22\2\u00b3\u00b5\5$\23\2\u00b4\u00a8\3\2\2\2\u00b4\u00a9\3"+
		"\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00ab\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4"+
		"\u00ad\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b0\3\2"+
		"\2\2\u00b4\u00b1\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"!\3\2\2\2\u00b6\u00b7\5<\37\2\u00b7\u00b8\7\60\2\2\u00b8\u00b9\5B\"\2"+
		"\u00b9#\3\2\2\2\u00ba\u00bb\5<\37\2\u00bb\u00bc\7\61\2\2\u00bc\u00bd\5"+
		"B\"\2\u00bd%\3\2\2\2\u00be\u00bf\5<\37\2\u00bf\u00c0\7\'\2\2\u00c0\u00c1"+
		"\5@!\2\u00c1\'\3\2\2\2\u00c2\u00c3\5<\37\2\u00c3\u00c6\7\'\2\2\u00c4\u00c7"+
		"\5B\"\2\u00c5\u00c7\5D#\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		")\3\2\2\2\u00c8\u00c9\5<\37\2\u00c9\u00ca\7)\2\2\u00ca\u00cb\5F$\2\u00cb"+
		"+\3\2\2\2\u00cc\u00cd\5<\37\2\u00cd\u00ce\7*\2\2\u00ce\u00cf\5F$\2\u00cf"+
		"-\3\2\2\2\u00d0\u00d1\5<\37\2\u00d1\u00d2\7+\2\2\u00d2\u00d3\5F$\2\u00d3"+
		"/\3\2\2\2\u00d4\u00d5\5<\37\2\u00d5\u00d6\7,\2\2\u00d6\u00d7\5F$\2\u00d7"+
		"\61\3\2\2\2\u00d8\u00d9\5<\37\2\u00d9\u00da\7-\2\2\u00da\u00db\5@!\2\u00db"+
		"\63\3\2\2\2\u00dc\u00dd\5<\37\2\u00dd\u00e1\7-\2\2\u00de\u00e2\5F$\2\u00df"+
		"\u00e2\5B\"\2\u00e0\u00e2\5D#\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2"+
		"\2\u00e1\u00e0\3\2\2\2\u00e2\65\3\2\2\2\u00e3\u00e4\5<\37\2\u00e4\u00e5"+
		"\7.\2\2\u00e5\u00e6\5B\"\2\u00e6\67\3\2\2\2\u00e7\u00e8\5<\37\2\u00e8"+
		"\u00e9\7/\2\2\u00e9\u00ea\5:\36\2\u00ea9\3\2\2\2\u00eb\u0104\7\"\2\2\u00ec"+
		"\u00f1\5F$\2\u00ed\u00ee\7$\2\2\u00ee\u00f0\5F$\2\u00ef\u00ed\3\2\2\2"+
		"\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u0105"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f9\5B\"\2\u00f5\u00f6\7$\2\2\u00f6"+
		"\u00f8\5B\"\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u0105\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u0101\5D#\2\u00fd\u00fe\7$\2\2\u00fe\u0100\5D#\2\u00ff\u00fd\3\2\2\2"+
		"\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0105"+
		"\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u00ec\3\2\2\2\u0104\u00f4\3\2\2\2\u0104"+
		"\u00fc\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\7#\2\2\u0107;\3\2\2\2\u0108"+
		"\u010d\5> \2\u0109\u010a\7\37\2\2\u010a\u010c\5> \2\u010b\u0109\3\2\2"+
		"\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e="+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\79\2\2\u0111?\3\2\2\2\u0112\u0113"+
		"\7\62\2\2\u0113A\3\2\2\2\u0114\u0115\7\65\2\2\u0115C\3\2\2\2\u0116\u0117"+
		"\79\2\2\u0117\u0118\7\37\2\2\u0118\u0119\79\2\2\u0119E\3\2\2\2\u011a\u011b"+
		"\7\63\2\2\u011bG\3\2\2\2\30JLQUY\\ehrxz\u0097\u009c\u009e\u00b4\u00c6"+
		"\u00e1\u00f1\u00f9\u0101\u0104\u010d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}