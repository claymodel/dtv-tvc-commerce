// Generated from com/metamx/druid/sql/antlr4/DruidSQL.g4 by ANTLR 4.0
package com.metamx.druid.sql.antlr4;

import com.metamx.druid.aggregation.post.*;
import com.metamx.druid.aggregation.*;
import com.metamx.druid.query.filter.*;
import com.metamx.druid.query.dimension.*;
import com.metamx.druid.*;

import com.google.common.base.*;
import com.google.common.collect.Lists;
import org.joda.time.*;

import java.text.*;
import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DruidSQLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, AND=9, 
		OR=10, SUM=11, MIN=12, MAX=13, COUNT=14, AS=15, OPEN=16, CLOSE=17, STAR=18, 
		NOT=19, PLUS=20, MINUS=21, DIV=22, COMMA=23, EQ=24, NEQ=25, MATCH=26, 
		GROUP=27, IDENT=28, QUOTED_STRING=29, ESC=30, NUMBER=31, EXPONENT=32, 
		LINE_COMMENT=33, COMMENT=34, WS=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'from'", "'select'", "'in'", "'by'", "'timestamp'", "'where'", "'granularity'", 
		"'between'", "'and'", "'or'", "'sum'", "'min'", "'max'", "'count'", "'as'", 
		"'('", "')'", "'*'", "'!'", "'+'", "'-'", "'/'", "','", "'='", "'!='", 
		"'~'", "'group'", "IDENT", "QUOTED_STRING", "ESC", "NUMBER", "EXPONENT", 
		"LINE_COMMENT", "COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "AND", 
		"OR", "SUM", "MIN", "MAX", "COUNT", "AS", "OPEN", "CLOSE", "STAR", "NOT", 
		"PLUS", "MINUS", "DIV", "COMMA", "EQ", "NEQ", "MATCH", "GROUP", "IDENT", 
		"QUOTED_STRING", "ESC", "NUMBER", "EXPONENT", "DIGIT", "LETTER", "LINE_COMMENT", 
		"COMMENT", "WS"
	};


	public DruidSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DruidSQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 34: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 35: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 36: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4%\u0118\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\7\35\u00c1\n\35\f\35\16\35\u00c4\13\35\3\36\3\36\3\36\7\36"+
		"\u00c9\n\36\f\36\16\36\u00cc\13\36\3\36\3\36\3\37\3\37\3\37\3 \7 \u00d4"+
		"\n \f \16 \u00d7\13 \3 \5 \u00da\n \3 \6 \u00dd\n \r \16 \u00de\3 \5 "+
		"\u00e2\n \3!\3!\5!\u00e6\n!\3!\6!\u00e9\n!\r!\16!\u00ea\3\"\3\"\3#\3#"+
		"\3$\3$\3$\3$\7$\u00f5\n$\f$\16$\u00f8\13$\3$\5$\u00fb\n$\3$\3$\3$\3$\3"+
		"%\3%\3%\3%\7%\u0105\n%\f%\16%\u0108\13%\3%\3%\3%\3%\3%\3&\3&\3&\3&\6&"+
		"\u0113\n&\r&\16&\u0114\3&\3&\5\u00ca\u00f6\u0106\'\3\3\1\5\4\1\7\5\1\t"+
		"\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1"+
		"\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32"+
		"\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C\2\1E\2\1G#\2I$\3"+
		"K%\4\3\2\7\3))\4--//\4C\\c|\4\13\13\"\"\4\f\f\17\17\u0126\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2"+
		"\5R\3\2\2\2\7Y\3\2\2\2\t\\\3\2\2\2\13_\3\2\2\2\ri\3\2\2\2\17o\3\2\2\2"+
		"\21{\3\2\2\2\23\u0083\3\2\2\2\25\u0087\3\2\2\2\27\u008a\3\2\2\2\31\u008e"+
		"\3\2\2\2\33\u0092\3\2\2\2\35\u0096\3\2\2\2\37\u009c\3\2\2\2!\u009f\3\2"+
		"\2\2#\u00a1\3\2\2\2%\u00a3\3\2\2\2\'\u00a5\3\2\2\2)\u00a7\3\2\2\2+\u00a9"+
		"\3\2\2\2-\u00ab\3\2\2\2/\u00ad\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2"+
		"\2\65\u00b4\3\2\2\2\67\u00b6\3\2\2\29\u00bc\3\2\2\2;\u00c5\3\2\2\2=\u00cf"+
		"\3\2\2\2?\u00d5\3\2\2\2A\u00e3\3\2\2\2C\u00ec\3\2\2\2E\u00ee\3\2\2\2G"+
		"\u00f0\3\2\2\2I\u0100\3\2\2\2K\u0112\3\2\2\2MN\7h\2\2NO\7t\2\2OP\7q\2"+
		"\2PQ\7o\2\2Q\4\3\2\2\2RS\7u\2\2ST\7g\2\2TU\7n\2\2UV\7g\2\2VW\7e\2\2WX"+
		"\7v\2\2X\6\3\2\2\2YZ\7k\2\2Z[\7p\2\2[\b\3\2\2\2\\]\7d\2\2]^\7{\2\2^\n"+
		"\3\2\2\2_`\7v\2\2`a\7k\2\2ab\7o\2\2bc\7g\2\2cd\7u\2\2de\7v\2\2ef\7c\2"+
		"\2fg\7o\2\2gh\7r\2\2h\f\3\2\2\2ij\7y\2\2jk\7j\2\2kl\7g\2\2lm\7t\2\2mn"+
		"\7g\2\2n\16\3\2\2\2op\7i\2\2pq\7t\2\2qr\7c\2\2rs\7p\2\2st\7w\2\2tu\7n"+
		"\2\2uv\7c\2\2vw\7t\2\2wx\7k\2\2xy\7v\2\2yz\7{\2\2z\20\3\2\2\2{|\7d\2\2"+
		"|}\7g\2\2}~\7v\2\2~\177\7y\2\2\177\u0080\7g\2\2\u0080\u0081\7g\2\2\u0081"+
		"\u0082\7p\2\2\u0082\22\3\2\2\2\u0083\u0084\7c\2\2\u0084\u0085\7p\2\2\u0085"+
		"\u0086\7f\2\2\u0086\24\3\2\2\2\u0087\u0088\7q\2\2\u0088\u0089\7t\2\2\u0089"+
		"\26\3\2\2\2\u008a\u008b\7u\2\2\u008b\u008c\7w\2\2\u008c\u008d\7o\2\2\u008d"+
		"\30\3\2\2\2\u008e\u008f\7o\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091"+
		"\32\3\2\2\2\u0092\u0093\7o\2\2\u0093\u0094\7c\2\2\u0094\u0095\7z\2\2\u0095"+
		"\34\3\2\2\2\u0096\u0097\7e\2\2\u0097\u0098\7q\2\2\u0098\u0099\7w\2\2\u0099"+
		"\u009a\7p\2\2\u009a\u009b\7v\2\2\u009b\36\3\2\2\2\u009c\u009d\7c\2\2\u009d"+
		"\u009e\7u\2\2\u009e \3\2\2\2\u009f\u00a0\7*\2\2\u00a0\"\3\2\2\2\u00a1"+
		"\u00a2\7+\2\2\u00a2$\3\2\2\2\u00a3\u00a4\7,\2\2\u00a4&\3\2\2\2\u00a5\u00a6"+
		"\7#\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7-\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7"+
		"/\2\2\u00aa,\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac.\3\2\2\2\u00ad\u00ae\7"+
		".\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7?\2\2\u00b0\62\3\2\2\2\u00b1\u00b2"+
		"\7#\2\2\u00b2\u00b3\7?\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7\u0080\2\2\u00b5"+
		"\66\3\2\2\2\u00b6\u00b7\7i\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7q\2\2\u00b9"+
		"\u00ba\7w\2\2\u00ba\u00bb\7r\2\2\u00bb8\3\2\2\2\u00bc\u00c2\5E#\2\u00bd"+
		"\u00c1\5E#\2\u00be\u00c1\5C\"\2\u00bf\u00c1\7a\2\2\u00c0\u00bd\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3:\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00ca\7)\2\2\u00c6\u00c9\5=\37\2\u00c7\u00c9\n\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00cb\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7)"+
		"\2\2\u00ce<\3\2\2\2\u00cf\u00d0\7)\2\2\u00d0\u00d1\7)\2\2\u00d1>\3\2\2"+
		"\2\u00d2\u00d4\5C\"\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00da\7\60\2\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00dd\5C\"\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00e2\5A"+
		"!\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2@\3\2\2\2\u00e3\u00e5"+
		"\7g\2\2\u00e4\u00e6\t\3\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e9\4\62;\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ebB\3\2\2\2\u00ec\u00ed"+
		"\4\62;\2\u00edD\3\2\2\2\u00ee\u00ef\t\4\2\2\u00efF\3\2\2\2\u00f0\u00f1"+
		"\7/\2\2\u00f1\u00f2\7/\2\2\u00f2\u00f6\3\2\2\2\u00f3\u00f5\13\2\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb\7\17\2\2\u00fa"+
		"\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\f"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b$\2\2\u00ffH\3\2\2\2\u0100\u0101"+
		"\7\61\2\2\u0101\u0102\7,\2\2\u0102\u0106\3\2\2\2\u0103\u0105\13\2\2\2"+
		"\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0107\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7,\2\2\u010a"+
		"\u010b\7\61\2\2\u010b\u010c\3\2\2\2\u010c\u010d\b%\3\2\u010dJ\3\2\2\2"+
		"\u010e\u0113\t\5\2\2\u010f\u0110\7\17\2\2\u0110\u0113\7\f\2\2\u0111\u0113"+
		"\t\6\2\2\u0112\u010e\3\2\2\2\u0112\u010f\3\2\2\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\b&\4\2\u0117L\3\2\2\2\22\2\u00c0\u00c2\u00c8\u00ca\u00d5"+
		"\u00d9\u00de\u00e1\u00e5\u00ea\u00f6\u00fa\u0106\u0112\u0114";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}