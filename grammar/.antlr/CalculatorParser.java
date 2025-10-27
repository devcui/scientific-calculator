// Generated from c:/Users/T24008/Desktop/items/compilers/grammar/Calculator.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, PI=2, E=3, ID=4, IMAG=5, BIN=6, OCT=7, HEX=8, DECIMAL=9, NUMBER=10, 
		PLUS=11, MINUS=12, MULT=13, DIV=14, MOD=15, POW=16, ASSIGN=17, LPAREN=18, 
		RPAREN=19, LBRACK=20, RBRACK=21, COMMA=22, SEMICOLON=23, EQUAL=24, NOT_EQUAL=25, 
		LESS_EQUAL=26, GREATER_EQUAL=27, LESS=28, GREATER=29, FACT=30, LINE_COMMENT=31, 
		BLOCK_COMMENT=32, WS=33, NEWLINE=34, PRINT=35, OR=36, AND=37, NOT=38;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_defineStmt = 2, RULE_assignment = 3, 
		RULE_equationStmt = 4, RULE_equation = 5, RULE_printStmt = 6, RULE_exprStmt = 7, 
		RULE_expr = 8, RULE_expr2 = 9, RULE_expr3 = 10, RULE_comparison = 11, 
		RULE_arith = 12, RULE_term = 13, RULE_factor = 14, RULE_unary = 15, RULE_atom = 16, 
		RULE_implicitMul = 17, RULE_functionCall = 18, RULE_argList = 19, RULE_constant = 20, 
		RULE_vector = 21, RULE_matrix = 22, RULE_row = 23, RULE_exprList = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "defineStmt", "assignment", "equationStmt", "equation", 
			"printStmt", "exprStmt", "expr", "expr2", "expr3", "comparison", "arith", 
			"term", "factor", "unary", "atom", "implicitMul", "functionCall", "argList", 
			"constant", "vector", "matrix", "row", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'pi'", "'e'", null, null, null, null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'='", "'('", "')'", "'['", 
			"']'", "','", "';'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'!'", 
			null, null, null, null, "'print'", "'or'", "'and'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "PI", "E", "ID", "IMAG", "BIN", "OCT", "HEX", "DECIMAL", 
			"NUMBER", "PLUS", "MINUS", "MULT", "DIV", "MOD", "POW", "ASSIGN", "LPAREN", 
			"RPAREN", "LBRACK", "RBRACK", "COMMA", "SEMICOLON", "EQUAL", "NOT_EQUAL", 
			"LESS_EQUAL", "GREATER_EQUAL", "LESS", "GREATER", "FACT", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS", "NEWLINE", "PRINT", "OR", "AND", "NOT"
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
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CalculatorParser.EOF, 0); }
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 326418832446L) != 0)) {
				{
				{
				setState(50);
				statement();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
		public DefineStmtContext defineStmt() {
			return getRuleContext(DefineStmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(CalculatorParser.NEWLINE, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public EquationStmtContext equationStmt() {
			return getRuleContext(EquationStmtContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				defineStmt();
				setState(60);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(59);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				assignment();
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(63);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				equationStmt();
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(67);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				printStmt();
				setState(72);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(71);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				exprStmt();
				setState(76);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(75);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(78);
				match(NEWLINE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefineStmtContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(CalculatorParser.VAR, 0); }
		public TerminalNode ID() { return getToken(CalculatorParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CalculatorParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefineStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineStmt; }
	}

	public final DefineStmtContext defineStmt() throws RecognitionException {
		DefineStmtContext _localctx = new DefineStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defineStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(VAR);
			setState(82);
			match(ID);
			setState(83);
			match(ASSIGN);
			setState(84);
			expr(0);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CalculatorParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CalculatorParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(87);
			match(ASSIGN);
			setState(88);
			expr(0);
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
	public static class EquationStmtContext extends ParserRuleContext {
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public EquationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equationStmt; }
	}

	public final EquationStmtContext equationStmt() throws RecognitionException {
		EquationStmtContext _localctx = new EquationStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_equationStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			equation();
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
	public static class EquationContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CalculatorParser.EQUAL, 0); }
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			expr(0);
			setState(93);
			match(EQUAL);
			setState(94);
			expr(0);
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
	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(CalculatorParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(PRINT);
			setState(97);
			match(LPAREN);
			setState(98);
			expr(0);
			setState(99);
			match(RPAREN);
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
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			expr(0);
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
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OR() { return getToken(CalculatorParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(104);
			expr2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(106);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(107);
					match(OR);
					setState(108);
					expr2(0);
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class Expr2Context extends ParserRuleContext {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode AND() { return getToken(CalculatorParser.AND, 0); }
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
	}

	public final Expr2Context expr2() throws RecognitionException {
		return expr2(0);
	}

	private Expr2Context expr2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr2Context _localctx = new Expr2Context(_ctx, _parentState);
		Expr2Context _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(115);
			expr3();
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr2Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr2);
					setState(117);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(118);
					match(AND);
					setState(119);
					expr3();
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
	public static class Expr3Context extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(CalculatorParser.NOT, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr3);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(NOT);
				setState(126);
				expr3();
				}
				break;
			case PI:
			case E:
			case ID:
			case IMAG:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LPAREN:
			case LBRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				comparison();
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
	public static class ComparisonContext extends ParserRuleContext {
		public List<ArithContext> arith() {
			return getRuleContexts(ArithContext.class);
		}
		public ArithContext arith(int i) {
			return getRuleContext(ArithContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(CalculatorParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(CalculatorParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(CalculatorParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(CalculatorParser.NOT_EQUAL, i);
		}
		public List<TerminalNode> LESS() { return getTokens(CalculatorParser.LESS); }
		public TerminalNode LESS(int i) {
			return getToken(CalculatorParser.LESS, i);
		}
		public List<TerminalNode> LESS_EQUAL() { return getTokens(CalculatorParser.LESS_EQUAL); }
		public TerminalNode LESS_EQUAL(int i) {
			return getToken(CalculatorParser.LESS_EQUAL, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(CalculatorParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(CalculatorParser.GREATER, i);
		}
		public List<TerminalNode> GREATER_EQUAL() { return getTokens(CalculatorParser.GREATER_EQUAL); }
		public TerminalNode GREATER_EQUAL(int i) {
			return getToken(CalculatorParser.GREATER_EQUAL, i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparison);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			arith(0);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(131);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1056964608L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(132);
					arith(0);
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArithContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ArithContext arith() {
			return getRuleContext(ArithContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public ArithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith; }
	}

	public final ArithContext arith() throws RecognitionException {
		return arith(0);
	}

	private ArithContext arith(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithContext _localctx = new ArithContext(_ctx, _parentState);
		ArithContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_arith, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(139);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ArithContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arith);
						setState(141);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(142);
						match(PLUS);
						setState(143);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new ArithContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arith);
						setState(144);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(145);
						match(MINUS);
						setState(146);
						term(0);
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CalculatorParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CalculatorParser.MOD, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(153);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(164);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(155);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(156);
						match(MULT);
						setState(157);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(158);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(159);
						match(DIV);
						setState(160);
						factor();
						}
						break;
					case 3:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(161);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(162);
						match(MOD);
						setState(163);
						factor();
						}
						break;
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class FactorContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorParser.POW, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				unary();
				setState(170);
				match(POW);
				setState(171);
				factor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				unary();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(PLUS);
				setState(177);
				unary();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(MINUS);
				setState(179);
				unary();
				}
				break;
			case PI:
			case E:
			case ID:
			case IMAG:
			case NUMBER:
			case LPAREN:
			case LBRACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				atom(0);
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
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CalculatorParser.NUMBER, 0); }
		public TerminalNode IMAG() { return getToken(CalculatorParser.IMAG, 0); }
		public TerminalNode ID() { return getToken(CalculatorParser.ID, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public ImplicitMulContext implicitMul() {
			return getRuleContext(ImplicitMulContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode FACT() { return getToken(CalculatorParser.FACT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		return atom(0);
	}

	private AtomContext atom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AtomContext _localctx = new AtomContext(_ctx, _parentState);
		AtomContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_atom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(184);
				match(NUMBER);
				}
				break;
			case 2:
				{
				setState(185);
				match(IMAG);
				}
				break;
			case 3:
				{
				setState(186);
				match(ID);
				}
				break;
			case 4:
				{
				setState(187);
				constant();
				}
				break;
			case 5:
				{
				setState(188);
				functionCall();
				}
				break;
			case 6:
				{
				setState(189);
				match(LPAREN);
				setState(190);
				expr(0);
				setState(191);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(193);
				vector();
				}
				break;
			case 8:
				{
				setState(194);
				matrix();
				}
				break;
			case 9:
				{
				setState(195);
				implicitMul();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AtomContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_atom);
					setState(198);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(199);
					match(FACT);
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class ImplicitMulContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CalculatorParser.NUMBER, 0); }
		public List<TerminalNode> ID() { return getTokens(CalculatorParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CalculatorParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ImplicitMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicitMul; }
	}

	public final ImplicitMulContext implicitMul() throws RecognitionException {
		ImplicitMulContext _localctx = new ImplicitMulContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_implicitMul);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(NUMBER);
				setState(206);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(NUMBER);
				setState(208);
				match(LPAREN);
				setState(209);
				expr(0);
				setState(210);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(ID);
				setState(213);
				match(LPAREN);
				setState(214);
				expr(0);
				setState(215);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				constant();
				setState(218);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				match(ID);
				setState(221);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CalculatorParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(ID);
			setState(225);
			match(LPAREN);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274879224892L) != 0)) {
				{
				setState(226);
				argList();
				}
			}

			setState(229);
			match(RPAREN);
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
	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CalculatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculatorParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			expr(0);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(232);
				match(COMMA);
				setState(233);
				expr(0);
				}
				}
				setState(238);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode PI() { return getToken(CalculatorParser.PI, 0); }
		public TerminalNode E() { return getToken(CalculatorParser.E, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !(_la==PI || _la==E) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class VectorContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(CalculatorParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(CalculatorParser.RBRACK, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(LBRACK);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274879224892L) != 0)) {
				{
				setState(242);
				exprList();
				}
			}

			setState(245);
			match(RBRACK);
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
	public static class MatrixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(CalculatorParser.LBRACK, 0); }
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(CalculatorParser.RBRACK, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(CalculatorParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CalculatorParser.SEMICOLON, i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(LBRACK);
			setState(248);
			row();
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(249);
				match(SEMICOLON);
				setState(250);
				row();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(RBRACK);
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
	public static class RowContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_row);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			exprList();
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
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CalculatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculatorParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			expr(0);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(261);
				match(COMMA);
				setState(262);
				expr(0);
				}
				}
				setState(267);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 9:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		case 12:
			return arith_sempred((ArithContext)_localctx, predIndex);
		case 13:
			return term_sempred((TermContext)_localctx, predIndex);
		case 16:
			return atom_sempred((AtomContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arith_sempred(ArithContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean atom_sempred(AtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u010d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0005\u00004\b\u0000\n\u0000\f\u00007\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"E\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001I\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001M\b\u0001\u0001\u0001\u0003\u0001P\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\bn\b\b\n\b\f\bq\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\ty\b\t\n\t\f\t|\t\t\u0001\n\u0001\n\u0001\n\u0003\n\u0081"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0086\b\u000b\n\u000b"+
		"\f\u000b\u0089\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0094\b\f\n\f\f\f\u0097\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u00a5\b\r\n\r\f\r\u00a8\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00af\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00b6\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00c5\b\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00c9\b\u0010\n\u0010\f\u0010\u00cc\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00df\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00e4\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00eb\b\u0013\n\u0013\f\u0013"+
		"\u00ee\t\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u00f4\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u00fc\b\u0016\n\u0016\f\u0016\u00ff\t\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u0108\b\u0018\n\u0018\f\u0018\u010b\t\u0018\u0001\u0018"+
		"\u0000\u0005\u0010\u0012\u0018\u001a \u0019\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000"+
		"\u0002\u0001\u0000\u0018\u001d\u0001\u0000\u0002\u0003\u011c\u00005\u0001"+
		"\u0000\u0000\u0000\u0002O\u0001\u0000\u0000\u0000\u0004Q\u0001\u0000\u0000"+
		"\u0000\u0006V\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\n\\\u0001"+
		"\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000"+
		"\u0000\u0010g\u0001\u0000\u0000\u0000\u0012r\u0001\u0000\u0000\u0000\u0014"+
		"\u0080\u0001\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018"+
		"\u008a\u0001\u0000\u0000\u0000\u001a\u0098\u0001\u0000\u0000\u0000\u001c"+
		"\u00ae\u0001\u0000\u0000\u0000\u001e\u00b5\u0001\u0000\u0000\u0000 \u00c4"+
		"\u0001\u0000\u0000\u0000\"\u00de\u0001\u0000\u0000\u0000$\u00e0\u0001"+
		"\u0000\u0000\u0000&\u00e7\u0001\u0000\u0000\u0000(\u00ef\u0001\u0000\u0000"+
		"\u0000*\u00f1\u0001\u0000\u0000\u0000,\u00f7\u0001\u0000\u0000\u0000."+
		"\u0102\u0001\u0000\u0000\u00000\u0104\u0001\u0000\u0000\u000024\u0003"+
		"\u0002\u0001\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000089\u0005\u0000\u0000\u00019\u0001\u0001"+
		"\u0000\u0000\u0000:<\u0003\u0004\u0002\u0000;=\u0005\"\u0000\u0000<;\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=P\u0001\u0000\u0000\u0000"+
		">@\u0003\u0006\u0003\u0000?A\u0005\"\u0000\u0000@?\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AP\u0001\u0000\u0000\u0000BD\u0003\b\u0004\u0000"+
		"CE\u0005\"\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EP\u0001\u0000\u0000\u0000FH\u0003\f\u0006\u0000GI\u0005\"\u0000\u0000"+
		"HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IP\u0001\u0000\u0000"+
		"\u0000JL\u0003\u000e\u0007\u0000KM\u0005\"\u0000\u0000LK\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NP\u0005\"\u0000"+
		"\u0000O:\u0001\u0000\u0000\u0000O>\u0001\u0000\u0000\u0000OB\u0001\u0000"+
		"\u0000\u0000OF\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000\u0000ON\u0001"+
		"\u0000\u0000\u0000P\u0003\u0001\u0000\u0000\u0000QR\u0005\u0001\u0000"+
		"\u0000RS\u0005\u0004\u0000\u0000ST\u0005\u0011\u0000\u0000TU\u0003\u0010"+
		"\b\u0000U\u0005\u0001\u0000\u0000\u0000VW\u0005\u0004\u0000\u0000WX\u0005"+
		"\u0011\u0000\u0000XY\u0003\u0010\b\u0000Y\u0007\u0001\u0000\u0000\u0000"+
		"Z[\u0003\n\u0005\u0000[\t\u0001\u0000\u0000\u0000\\]\u0003\u0010\b\u0000"+
		"]^\u0005\u0018\u0000\u0000^_\u0003\u0010\b\u0000_\u000b\u0001\u0000\u0000"+
		"\u0000`a\u0005#\u0000\u0000ab\u0005\u0012\u0000\u0000bc\u0003\u0010\b"+
		"\u0000cd\u0005\u0013\u0000\u0000d\r\u0001\u0000\u0000\u0000ef\u0003\u0010"+
		"\b\u0000f\u000f\u0001\u0000\u0000\u0000gh\u0006\b\uffff\uffff\u0000hi"+
		"\u0003\u0012\t\u0000io\u0001\u0000\u0000\u0000jk\n\u0002\u0000\u0000k"+
		"l\u0005$\u0000\u0000ln\u0003\u0012\t\u0000mj\u0001\u0000\u0000\u0000n"+
		"q\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000p\u0011\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0006"+
		"\t\uffff\uffff\u0000st\u0003\u0014\n\u0000tz\u0001\u0000\u0000\u0000u"+
		"v\n\u0002\u0000\u0000vw\u0005%\u0000\u0000wy\u0003\u0014\n\u0000xu\u0001"+
		"\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{\u0013\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000}~\u0005&\u0000\u0000~\u0081\u0003\u0014\n\u0000\u007f\u0081"+
		"\u0003\u0016\u000b\u0000\u0080}\u0001\u0000\u0000\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u0087\u0003"+
		"\u0018\f\u0000\u0083\u0084\u0007\u0000\u0000\u0000\u0084\u0086\u0003\u0018"+
		"\f\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0017\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0006\f\uffff\uffff\u0000\u008b\u008c\u0003\u001a\r"+
		"\u0000\u008c\u0095\u0001\u0000\u0000\u0000\u008d\u008e\n\u0003\u0000\u0000"+
		"\u008e\u008f\u0005\u000b\u0000\u0000\u008f\u0094\u0003\u001a\r\u0000\u0090"+
		"\u0091\n\u0002\u0000\u0000\u0091\u0092\u0005\f\u0000\u0000\u0092\u0094"+
		"\u0003\u001a\r\u0000\u0093\u008d\u0001\u0000\u0000\u0000\u0093\u0090\u0001"+
		"\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0019\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099\u0006"+
		"\r\uffff\uffff\u0000\u0099\u009a\u0003\u001c\u000e\u0000\u009a\u00a6\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\n\u0004\u0000\u0000\u009c\u009d\u0005\r"+
		"\u0000\u0000\u009d\u00a5\u0003\u001c\u000e\u0000\u009e\u009f\n\u0003\u0000"+
		"\u0000\u009f\u00a0\u0005\u000e\u0000\u0000\u00a0\u00a5\u0003\u001c\u000e"+
		"\u0000\u00a1\u00a2\n\u0002\u0000\u0000\u00a2\u00a3\u0005\u000f\u0000\u0000"+
		"\u00a3\u00a5\u0003\u001c\u000e\u0000\u00a4\u009b\u0001\u0000\u0000\u0000"+
		"\u00a4\u009e\u0001\u0000\u0000\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u001b\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u0003\u001e\u000f\u0000"+
		"\u00aa\u00ab\u0005\u0010\u0000\u0000\u00ab\u00ac\u0003\u001c\u000e\u0000"+
		"\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00af\u0003\u001e\u000f\u0000"+
		"\u00ae\u00a9\u0001\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u001d\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u000b\u0000\u0000"+
		"\u00b1\u00b6\u0003\u001e\u000f\u0000\u00b2\u00b3\u0005\f\u0000\u0000\u00b3"+
		"\u00b6\u0003\u001e\u000f\u0000\u00b4\u00b6\u0003 \u0010\u0000\u00b5\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b6\u001f\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0006\u0010\uffff\uffff\u0000\u00b8\u00c5\u0005\n\u0000\u0000\u00b9\u00c5"+
		"\u0005\u0005\u0000\u0000\u00ba\u00c5\u0005\u0004\u0000\u0000\u00bb\u00c5"+
		"\u0003(\u0014\u0000\u00bc\u00c5\u0003$\u0012\u0000\u00bd\u00be\u0005\u0012"+
		"\u0000\u0000\u00be\u00bf\u0003\u0010\b\u0000\u00bf\u00c0\u0005\u0013\u0000"+
		"\u0000\u00c0\u00c5\u0001\u0000\u0000\u0000\u00c1\u00c5\u0003*\u0015\u0000"+
		"\u00c2\u00c5\u0003,\u0016\u0000\u00c3\u00c5\u0003\"\u0011\u0000\u00c4"+
		"\u00b7\u0001\u0000\u0000\u0000\u00c4\u00b9\u0001\u0000\u0000\u0000\u00c4"+
		"\u00ba\u0001\u0000\u0000\u0000\u00c4\u00bb\u0001\u0000\u0000\u0000\u00c4"+
		"\u00bc\u0001\u0000\u0000\u0000\u00c4\u00bd\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c5\u00ca\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\n\u0002\u0000\u0000\u00c7\u00c9\u0005\u001e\u0000\u0000\u00c8\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb!\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005"+
		"\n\u0000\u0000\u00ce\u00df\u0005\u0004\u0000\u0000\u00cf\u00d0\u0005\n"+
		"\u0000\u0000\u00d0\u00d1\u0005\u0012\u0000\u0000\u00d1\u00d2\u0003\u0010"+
		"\b\u0000\u00d2\u00d3\u0005\u0013\u0000\u0000\u00d3\u00df\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0005\u0004\u0000\u0000\u00d5\u00d6\u0005\u0012\u0000"+
		"\u0000\u00d6\u00d7\u0003\u0010\b\u0000\u00d7\u00d8\u0005\u0013\u0000\u0000"+
		"\u00d8\u00df\u0001\u0000\u0000\u0000\u00d9\u00da\u0003(\u0014\u0000\u00da"+
		"\u00db\u0005\u0004\u0000\u0000\u00db\u00df\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0005\u0004\u0000\u0000\u00dd\u00df\u0005\u0004\u0000\u0000\u00de"+
		"\u00cd\u0001\u0000\u0000\u0000\u00de\u00cf\u0001\u0000\u0000\u0000\u00de"+
		"\u00d4\u0001\u0000\u0000\u0000\u00de\u00d9\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df#\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0005\u0004\u0000\u0000\u00e1\u00e3\u0005\u0012\u0000\u0000\u00e2\u00e4"+
		"\u0003&\u0013\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005"+
		"\u0013\u0000\u0000\u00e6%\u0001\u0000\u0000\u0000\u00e7\u00ec\u0003\u0010"+
		"\b\u0000\u00e8\u00e9\u0005\u0016\u0000\u0000\u00e9\u00eb\u0003\u0010\b"+
		"\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\'\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0007\u0001\u0000\u0000\u00f0)\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f3\u0005\u0014\u0000\u0000\u00f2\u00f4\u00030\u0018\u0000\u00f3\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0015\u0000\u0000\u00f6+\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005\u0014\u0000\u0000\u00f8\u00fd\u0003"+
		".\u0017\u0000\u00f9\u00fa\u0005\u0017\u0000\u0000\u00fa\u00fc\u0003.\u0017"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000"+
		"\u0000\u0100\u0101\u0005\u0015\u0000\u0000\u0101-\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u00030\u0018\u0000\u0103/\u0001\u0000\u0000\u0000\u0104\u0109"+
		"\u0003\u0010\b\u0000\u0105\u0106\u0005\u0016\u0000\u0000\u0106\u0108\u0003"+
		"\u0010\b\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010b\u0001\u0000"+
		"\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000"+
		"\u0000\u0000\u010a1\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000"+
		"\u0000\u00195<@DHLOoz\u0080\u0087\u0093\u0095\u00a4\u00a6\u00ae\u00b5"+
		"\u00c4\u00ca\u00de\u00e3\u00ec\u00f3\u00fd\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}