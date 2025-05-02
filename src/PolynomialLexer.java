// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PolynomialLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, NUM=20, ID=21, WS=22, COMMENT=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "NUM", "ID", "WS", "COMMENT"
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


	public PolynomialLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Polynomial.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017\u0089\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0004\u0013e\b\u0013\u000b\u0013\f\u0013f\u0001\u0013\u0001\u0013\u0004"+
		"\u0013k\b\u0013\u000b\u0013\f\u0013l\u0003\u0013o\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0005\u0014s\b\u0014\n\u0014\f\u0014v\t\u0014\u0001\u0015"+
		"\u0004\u0015y\b\u0015\u000b\u0015\f\u0015z\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0083\b\u0016\n"+
		"\u0016\f\u0016\u0086\t\u0016\u0001\u0016\u0001\u0016\u0000\u0000\u0017"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"\u0001\u0000\u0005\u0001\u000009\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u008e\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0001/\u0001\u0000\u0000\u0000\u0003"+
		"7\u0001\u0000\u0000\u0000\u00059\u0001\u0000\u0000\u0000\u0007;\u0001"+
		"\u0000\u0000\u0000\tB\u0001\u0000\u0000\u0000\u000bD\u0001\u0000\u0000"+
		"\u0000\rI\u0001\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000\u0011"+
		"M\u0001\u0000\u0000\u0000\u0013O\u0001\u0000\u0000\u0000\u0015Q\u0001"+
		"\u0000\u0000\u0000\u0017S\u0001\u0000\u0000\u0000\u0019U\u0001\u0000\u0000"+
		"\u0000\u001bW\u0001\u0000\u0000\u0000\u001dY\u0001\u0000\u0000\u0000\u001f"+
		"[\u0001\u0000\u0000\u0000!]\u0001\u0000\u0000\u0000#_\u0001\u0000\u0000"+
		"\u0000%a\u0001\u0000\u0000\u0000\'d\u0001\u0000\u0000\u0000)p\u0001\u0000"+
		"\u0000\u0000+x\u0001\u0000\u0000\u0000-~\u0001\u0000\u0000\u0000/0\u0005"+
		"p\u0000\u000001\u0005o\u0000\u000012\u0005l\u0000\u000023\u0005y\u0000"+
		"\u000034\u0005n\u0000\u000045\u0005o\u0000\u000056\u0005m\u0000\u0000"+
		"6\u0002\u0001\u0000\u0000\u000078\u0005,\u0000\u00008\u0004\u0001\u0000"+
		"\u0000\u00009:\u0005;\u0000\u0000:\u0006\u0001\u0000\u0000\u0000;<\u0005"+
		"n\u0000\u0000<=\u0005u\u0000\u0000=>\u0005m\u0000\u0000>?\u0005b\u0000"+
		"\u0000?@\u0005e\u0000\u0000@A\u0005r\u0000\u0000A\b\u0001\u0000\u0000"+
		"\u0000BC\u0005=\u0000\u0000C\n\u0001\u0000\u0000\u0000DE\u0005s\u0000"+
		"\u0000EF\u0005h\u0000\u0000FG\u0005o\u0000\u0000GH\u0005w\u0000\u0000"+
		"H\f\u0001\u0000\u0000\u0000IJ\u0005[\u0000\u0000J\u000e\u0001\u0000\u0000"+
		"\u0000KL\u0005]\u0000\u0000L\u0010\u0001\u0000\u0000\u0000MN\u0005*\u0000"+
		"\u0000N\u0012\u0001\u0000\u0000\u0000OP\u0005/\u0000\u0000P\u0014\u0001"+
		"\u0000\u0000\u0000QR\u0005%\u0000\u0000R\u0016\u0001\u0000\u0000\u0000"+
		"ST\u0005+\u0000\u0000T\u0018\u0001\u0000\u0000\u0000UV\u0005-\u0000\u0000"+
		"V\u001a\u0001\u0000\u0000\u0000WX\u0005(\u0000\u0000X\u001c\u0001\u0000"+
		"\u0000\u0000YZ\u0005)\u0000\u0000Z\u001e\u0001\u0000\u0000\u0000[\\\u0005"+
		"<\u0000\u0000\\ \u0001\u0000\u0000\u0000]^\u0005>\u0000\u0000^\"\u0001"+
		"\u0000\u0000\u0000_`\u0005x\u0000\u0000`$\u0001\u0000\u0000\u0000ab\u0005"+
		"^\u0000\u0000b&\u0001\u0000\u0000\u0000ce\u0007\u0000\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000gn\u0001\u0000\u0000\u0000hj\u0005.\u0000\u0000"+
		"ik\u0007\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000"+
		"\u0000\u0000nh\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o(\u0001"+
		"\u0000\u0000\u0000pt\u0007\u0001\u0000\u0000qs\u0007\u0002\u0000\u0000"+
		"rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000u*\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000wy\u0007\u0003\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0006\u0015\u0000\u0000},\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005/\u0000\u0000\u007f\u0080\u0005/\u0000\u0000\u0080"+
		"\u0084\u0001\u0000\u0000\u0000\u0081\u0083\b\u0004\u0000\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0006\u0016\u0000\u0000\u0088.\u0001\u0000\u0000\u0000\u0007\u0000fl"+
		"ntz\u0084\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}