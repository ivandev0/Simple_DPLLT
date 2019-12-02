// Generated from E:/!PROJECTS/IntelliJ_IDEA/dpllt/src/main/java/antlr\Common.g4 by ANTLR 4.7.2
package antlr.generated.common;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, IDENTIFIER=13, WS=14;
	public static final int
		RULE_formula = 0, RULE_equality = 1, RULE_fun = 2, RULE_args = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"formula", "equality", "fun", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'!'", "'v'", "'^'", "'->'", "'<->'", "'='", "'!='", 
			"'select'", "','", "'store'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Common.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CommonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NotContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquivalenceContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public EquivalenceContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitEquivalence(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConjunctionContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ConjunctionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DisjunctionContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public DisjunctionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImplicationContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImplicationContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitImplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleEqualityContext extends FormulaContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public SingleEqualityContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitSingleEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParenthesizedContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitParenthesized(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__11:
			case IDENTIFIER:
				{
				_localctx = new SingleEqualityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9);
				equality();
				}
				break;
			case T__0:
				{
				_localctx = new ParenthesizedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(10);
				match(T__0);
				setState(11);
				formula(0);
				setState(12);
				match(T__1);
				}
				break;
			case T__2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14);
				match(T__2);
				setState(15);
				formula(5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(30);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new DisjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(18);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(19);
						match(T__3);
						setState(20);
						formula(5);
						}
						break;
					case 2:
						{
						_localctx = new ConjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(21);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(22);
						match(T__4);
						setState(23);
						formula(4);
						}
						break;
					case 3:
						{
						_localctx = new ImplicationContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(24);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(25);
						match(T__5);
						setState(26);
						formula(3);
						}
						break;
					case 4:
						{
						_localctx = new EquivalenceContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(27);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(28);
						match(T__6);
						setState(29);
						formula(2);
						}
						break;
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
	 
		public EqualityContext() { }
		public void copyFrom(EqualityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualContext extends EqualityContext {
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public EqualContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualContext extends EqualityContext {
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public NotEqualContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_equality);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				fun();
				setState(36);
				match(T__7);
				setState(37);
				fun();
				}
				break;
			case 2:
				_localctx = new NotEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				fun();
				setState(40);
				match(T__8);
				setState(41);
				fun();
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

	public static class FunContext extends ParserRuleContext {
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	 
		public FunContext() { }
		public void copyFrom(FunContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectContext extends FunContext {
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public SelectContext(FunContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunWithArgsContext extends FunContext {
		public TerminalNode IDENTIFIER() { return getToken(CommonParser.IDENTIFIER, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunWithArgsContext(FunContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitFunWithArgs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleContext extends FunContext {
		public TerminalNode IDENTIFIER() { return getToken(CommonParser.IDENTIFIER, 0); }
		public SimpleContext(FunContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitSimple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreContext extends FunContext {
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public StoreContext(FunContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitStore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fun);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new FunWithArgsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(IDENTIFIER);
				setState(47);
				args();
				}
				break;
			case 3:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(T__9);
				setState(49);
				match(T__0);
				setState(50);
				fun();
				setState(51);
				match(T__10);
				setState(52);
				fun();
				setState(53);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(T__11);
				setState(56);
				match(T__0);
				setState(57);
				fun();
				setState(58);
				match(T__10);
				setState(59);
				fun();
				setState(60);
				match(T__10);
				setState(61);
				fun();
				setState(62);
				match(T__1);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommonVisitor ) return ((CommonVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__0);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(67);
				fun();
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(68);
					match(T__10);
					setState(69);
					fun();
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(77);
			match(T__1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20R\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\3\5\3\5\3\5\3\5\7"+
		"\5I\n\5\f\5\16\5L\13\5\5\5N\n\5\3\5\3\5\3\5\2\3\2\6\2\4\6\b\2\2\2Y\2\22"+
		"\3\2\2\2\4-\3\2\2\2\6B\3\2\2\2\bD\3\2\2\2\n\13\b\2\1\2\13\23\5\4\3\2\f"+
		"\r\7\3\2\2\r\16\5\2\2\2\16\17\7\4\2\2\17\23\3\2\2\2\20\21\7\5\2\2\21\23"+
		"\5\2\2\7\22\n\3\2\2\2\22\f\3\2\2\2\22\20\3\2\2\2\23\"\3\2\2\2\24\25\f"+
		"\6\2\2\25\26\7\6\2\2\26!\5\2\2\7\27\30\f\5\2\2\30\31\7\7\2\2\31!\5\2\2"+
		"\6\32\33\f\4\2\2\33\34\7\b\2\2\34!\5\2\2\5\35\36\f\3\2\2\36\37\7\t\2\2"+
		"\37!\5\2\2\4 \24\3\2\2\2 \27\3\2\2\2 \32\3\2\2\2 \35\3\2\2\2!$\3\2\2\2"+
		"\" \3\2\2\2\"#\3\2\2\2#\3\3\2\2\2$\"\3\2\2\2%&\5\6\4\2&\'\7\n\2\2\'(\5"+
		"\6\4\2(.\3\2\2\2)*\5\6\4\2*+\7\13\2\2+,\5\6\4\2,.\3\2\2\2-%\3\2\2\2-)"+
		"\3\2\2\2.\5\3\2\2\2/C\7\17\2\2\60\61\7\17\2\2\61C\5\b\5\2\62\63\7\f\2"+
		"\2\63\64\7\3\2\2\64\65\5\6\4\2\65\66\7\r\2\2\66\67\5\6\4\2\678\7\4\2\2"+
		"8C\3\2\2\29:\7\16\2\2:;\7\3\2\2;<\5\6\4\2<=\7\r\2\2=>\5\6\4\2>?\7\r\2"+
		"\2?@\5\6\4\2@A\7\4\2\2AC\3\2\2\2B/\3\2\2\2B\60\3\2\2\2B\62\3\2\2\2B9\3"+
		"\2\2\2C\7\3\2\2\2DM\7\3\2\2EJ\5\6\4\2FG\7\r\2\2GI\5\6\4\2HF\3\2\2\2IL"+
		"\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2ME\3\2\2\2MN\3\2\2\2N"+
		"O\3\2\2\2OP\7\4\2\2P\t\3\2\2\2\t\22 \"-BJM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}