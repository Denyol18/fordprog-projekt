// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PolynomialParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, NUM=20, ID=21, WS=22, COMMENT=23;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_expr = 2, RULE_polynomial = 3, 
		RULE_polyTerm = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "expr", "polynomial", "polyTerm"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'polynom'", "','", "';'", "'number'", "'='", "'show'", "'['", 
			"']'", "'*'", "'/'", "'%'", "'+'", "'-'", "'('", "')'", "'<'", "'>'", 
			"'x'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "NUM", "ID", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PolynomialParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PolynomialParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2097234L) != 0) {
				{
				{
				setState(10);
				statement();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PolynomialParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PolynomialParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				match(T__0);
				setState(19);
				match(ID);
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(20);
					match(T__1);
					setState(21);
					match(ID);
					}
					}
					setState(26);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(27);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__3);
				setState(29);
				match(ID);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(30);
					match(T__1);
					setState(31);
					match(ID);
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(37);
				match(T__2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				match(ID);
				setState(39);
				match(T__4);
				setState(40);
				expr(0);
				setState(41);
				match(T__2);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(T__5);
				setState(44);
				expr(0);
				setState(45);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PolynomialExprContext extends ExprContext {
		public PolynomialContext polynomial() {
			return getRuleContext(PolynomialContext.class,0);
		}
		public PolynomialExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterPolynomialExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitPolynomialExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitPolynomialExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(PolynomialParser.NUM, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterMulDivModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitMulDivModExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitMulDivModExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EvalExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EvalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterEvalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitEvalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitEvalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(PolynomialParser.ID, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(50);
				match(T__13);
				setState(51);
				expr(0);
				setState(52);
				match(T__14);
				}
				break;
			case T__15:
				{
				_localctx = new PolynomialExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				polynomial();
				}
				break;
			case NUM:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(70);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(60);
						((MulDivModExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0) ) {
							((MulDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(62);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(63);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(64);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new EvalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(66);
						match(T__6);
						setState(67);
						expr(0);
						setState(68);
						match(T__7);
						}
						break;
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PolynomialContext extends ParserRuleContext {
		public List<PolyTermContext> polyTerm() {
			return getRuleContexts(PolyTermContext.class);
		}
		public PolyTermContext polyTerm(int i) {
			return getRuleContext(PolyTermContext.class,i);
		}
		public PolynomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polynomial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterPolynomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitPolynomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitPolynomial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolynomialContext polynomial() throws RecognitionException {
		PolynomialContext _localctx = new PolynomialContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_polynomial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__15);
			setState(76);
			polyTerm();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==T__12) {
				{
				{
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				polyTerm();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__16);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PolyTermContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(PolynomialParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(PolynomialParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(PolynomialParser.ID, 0); }
		public PolyTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polyTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).enterPolyTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolynomialListener ) ((PolynomialListener)listener).exitPolyTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolynomialVisitor ) return ((PolynomialVisitor<? extends T>)visitor).visitPolyTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyTermContext polyTerm() throws RecognitionException {
		PolyTermContext _localctx = new PolyTermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_polyTerm);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUM || _la==ID) {
					{
					setState(86);
					_la = _input.LA(1);
					if ( !(_la==NUM || _la==ID) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(89);
				match(T__17);
				setState(90);
				match(T__18);
				setState(91);
				match(NUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUM || _la==ID) {
					{
					setState(92);
					_la = _input.LA(1);
					if ( !(_la==NUM || _la==ID) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(95);
				match(T__17);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(ID);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u0017\b\u0001\n\u0001\f\u0001\u001a\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001$\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002G\b\u0002\n\u0002"+
		"\f\u0002J\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003P\b\u0003\n\u0003\f\u0003S\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0003\u0004X\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004^\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004c\b\u0004\u0001\u0004\u0000\u0001\u0004\u0005\u0000\u0002\u0004"+
		"\u0006\b\u0000\u0003\u0001\u0000\t\u000b\u0001\u0000\f\r\u0001\u0000\u0014"+
		"\u0015q\u0000\r\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000"+
		"\u00049\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000\u0000\bb\u0001"+
		"\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000"+
		"\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000"+
		"\r\u000e\u0001\u0000\u0000\u0000\u000e\u0010\u0001\u0000\u0000\u0000\u000f"+
		"\r\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0000\u0000\u0001\u0011\u0001"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u0018"+
		"\u0005\u0015\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0017"+
		"\u0005\u0015\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0017\u001a"+
		"\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u0018"+
		"\u0001\u0000\u0000\u0000\u001b0\u0005\u0003\u0000\u0000\u001c\u001d\u0005"+
		"\u0004\u0000\u0000\u001d\"\u0005\u0015\u0000\u0000\u001e\u001f\u0005\u0002"+
		"\u0000\u0000\u001f!\u0005\u0015\u0000\u0000 \u001e\u0001\u0000\u0000\u0000"+
		"!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%0\u0005\u0003"+
		"\u0000\u0000&\'\u0005\u0015\u0000\u0000\'(\u0005\u0005\u0000\u0000()\u0003"+
		"\u0004\u0002\u0000)*\u0005\u0003\u0000\u0000*0\u0001\u0000\u0000\u0000"+
		"+,\u0005\u0006\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u0005\u0003\u0000"+
		"\u0000.0\u0001\u0000\u0000\u0000/\u0012\u0001\u0000\u0000\u0000/\u001c"+
		"\u0001\u0000\u0000\u0000/&\u0001\u0000\u0000\u0000/+\u0001\u0000\u0000"+
		"\u00000\u0003\u0001\u0000\u0000\u000012\u0006\u0002\uffff\uffff\u0000"+
		"23\u0005\u000e\u0000\u000034\u0003\u0004\u0002\u000045\u0005\u000f\u0000"+
		"\u00005:\u0001\u0000\u0000\u00006:\u0003\u0006\u0003\u00007:\u0005\u0014"+
		"\u0000\u00008:\u0005\u0015\u0000\u000091\u0001\u0000\u0000\u000096\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000"+
		":H\u0001\u0000\u0000\u0000;<\n\u0006\u0000\u0000<=\u0007\u0000\u0000\u0000"+
		"=G\u0003\u0004\u0002\u0007>?\n\u0005\u0000\u0000?@\u0007\u0001\u0000\u0000"+
		"@G\u0003\u0004\u0002\u0006AB\n\u0007\u0000\u0000BC\u0005\u0007\u0000\u0000"+
		"CD\u0003\u0004\u0002\u0000DE\u0005\b\u0000\u0000EG\u0001\u0000\u0000\u0000"+
		"F;\u0001\u0000\u0000\u0000F>\u0001\u0000\u0000\u0000FA\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000I\u0005\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0010\u0000\u0000LQ\u0003\b\u0004\u0000MN\u0007\u0001\u0000\u0000"+
		"NP\u0003\b\u0004\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000TU\u0005\u0011\u0000\u0000U\u0007\u0001"+
		"\u0000\u0000\u0000VX\u0007\u0002\u0000\u0000WV\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\u0012\u0000"+
		"\u0000Z[\u0005\u0013\u0000\u0000[c\u0005\u0014\u0000\u0000\\^\u0007\u0002"+
		"\u0000\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_c\u0005\u0012\u0000\u0000`c\u0005\u0014\u0000\u0000"+
		"ac\u0005\u0015\u0000\u0000bW\u0001\u0000\u0000\u0000b]\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000c\t\u0001\u0000"+
		"\u0000\u0000\u000b\r\u0018\"/9FHQW]b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}