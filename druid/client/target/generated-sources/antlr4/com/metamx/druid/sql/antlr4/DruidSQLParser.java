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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DruidSQLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, AND=9, 
		OR=10, SUM=11, MIN=12, MAX=13, COUNT=14, AS=15, OPEN=16, CLOSE=17, STAR=18, 
		NOT=19, PLUS=20, MINUS=21, DIV=22, COMMA=23, EQ=24, NEQ=25, MATCH=26, 
		GROUP=27, IDENT=28, QUOTED_STRING=29, ESC=30, NUMBER=31, EXPONENT=32, 
		LINE_COMMENT=33, COMMENT=34, WS=35;
	public static final String[] tokenNames = {
		"<INVALID>", "'from'", "'select'", "'in'", "'by'", "'timestamp'", "'where'", 
		"'granularity'", "'between'", "'and'", "'or'", "'sum'", "'min'", "'max'", 
		"'count'", "'as'", "'('", "')'", "'*'", "'!'", "'+'", "'-'", "'/'", "','", 
		"'='", "'!='", "'~'", "'group'", "IDENT", "QUOTED_STRING", "ESC", "NUMBER", 
		"EXPONENT", "LINE_COMMENT", "COMMENT", "WS"
	};
	public static final int
		RULE_query = 0, RULE_select_stmt = 1, RULE_where_stmt = 2, RULE_groupby_stmt = 3, 
		RULE_groupByExpression = 4, RULE_datasource = 5, RULE_aliasedExpression = 6, 
		RULE_expression = 7, RULE_additiveExpression = 8, RULE_multiplyExpression = 9, 
		RULE_unaryExpression = 10, RULE_primaryExpression = 11, RULE_aggregate = 12, 
		RULE_constant = 13, RULE_timeAndDimFilter = 14, RULE_dimFilter = 15, RULE_orDimFilter = 16, 
		RULE_andDimFilter = 17, RULE_primaryDimFilter = 18, RULE_selectorDimFilter = 19, 
		RULE_inListDimFilter = 20, RULE_timeFilter = 21, RULE_granularityFn = 22, 
		RULE_timestamp = 23;
	public static final String[] ruleNames = {
		"query", "select_stmt", "where_stmt", "groupby_stmt", "groupByExpression", 
		"datasource", "aliasedExpression", "expression", "additiveExpression", 
		"multiplyExpression", "unaryExpression", "primaryExpression", "aggregate", 
		"constant", "timeAndDimFilter", "dimFilter", "orDimFilter", "andDimFilter", 
		"primaryDimFilter", "selectorDimFilter", "inListDimFilter", "timeFilter", 
		"granularityFn", "timestamp"
	};

	@Override
	public String getGrammarFileName() { return "DruidSQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	    public Map<String, AggregatorFactory> aggregators = new LinkedHashMap<String, AggregatorFactory>();
	    public List<PostAggregator> postAggregators = new LinkedList<PostAggregator>();
	    public DimFilter filter;
	    public List<org.joda.time.Interval> intervals;
	    public List<String> fields = new LinkedList<String>();
	    public QueryGranularity granularity = QueryGranularity.ALL;
	    public Map<String, DimensionSpec> groupByDimensions = new LinkedHashMap<String, DimensionSpec>();
	    
	    String dataSourceName = null;
	    
	    public String getDataSource() {
	        return dataSourceName;
	    }
	    
	    public String unescape(String quoted) {
	        String unquote = quoted.trim().replaceFirst("^'(.*)'$", "$1");
	        return unquote.replace("''", "'");
	    }

	    AggregatorFactory evalAgg(String name, int fn) {
	        switch (fn) {
	            case SUM: return new DoubleSumAggregatorFactory("sum("+name+")", name);
	            case MIN: return new MinAggregatorFactory("min("+name+")", name);
	            case MAX: return new MaxAggregatorFactory("max("+name+")", name);
	            case COUNT: return new CountAggregatorFactory(name);
	        }
	        throw new IllegalArgumentException("Unknown function [" + fn + "]"); 
	    }
	    
	    PostAggregator evalArithmeticPostAggregator(PostAggregator a, List<Token> ops, List<PostAggregator> b) {
	        if(b.isEmpty()) return a;
	        else {            
	            int i = 0;
	            
	            PostAggregator root = a;
	            while(i < ops.size()) {
	                List<PostAggregator> list = new LinkedList<PostAggregator>();
	                List<String> names = new LinkedList<String>();

	                names.add(root.getName());
	                list.add(root);
	                
	                Token op = ops.get(i);
	                
	                while(i < ops.size() && ops.get(i).getType() == op.getType()) {
	                    PostAggregator e = b.get(i);
	                    list.add(e);
	                    names.add(e.getName());
	                    i++;
	                }
	                
	                root = new ArithmeticPostAggregator("("+Joiner.on(op.getText()).join(names)+")", op.getText(), list);
	            }
	            
	            return root;
	        }
	    }

	public DruidSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public Groupby_stmtContext groupby_stmt() {
			return getRuleContext(Groupby_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Where_stmtContext where_stmt() {
			return getRuleContext(Where_stmtContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); select_stmt();
			setState(49); where_stmt();
			setState(51);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(50); groupby_stmt();
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

	public static class Select_stmtContext extends ParserRuleContext {
		public AliasedExpressionContext aliasedExpression;
		public List<AliasedExpressionContext> e = new ArrayList<AliasedExpressionContext>();
		public DatasourceContext datasource;
		public AliasedExpressionContext aliasedExpression(int i) {
			return getRuleContext(AliasedExpressionContext.class,i);
		}
		public List<AliasedExpressionContext> aliasedExpression() {
			return getRuleContexts(AliasedExpressionContext.class);
		}
		public DatasourceContext datasource() {
			return getRuleContext(DatasourceContext.class,0);
		}
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitSelect_stmt(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(2);
			setState(54); ((Select_stmtContext)_localctx).aliasedExpression = aliasedExpression();
			((Select_stmtContext)_localctx).e.add(((Select_stmtContext)_localctx).aliasedExpression);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(55); match(COMMA);
				setState(56); ((Select_stmtContext)_localctx).aliasedExpression = aliasedExpression();
				((Select_stmtContext)_localctx).e.add(((Select_stmtContext)_localctx).aliasedExpression);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62); match(1);
			setState(63); ((Select_stmtContext)_localctx).datasource = datasource();

			        for(AliasedExpressionContext a : ((Select_stmtContext)_localctx).e) { 
			            postAggregators.add(a.p);
			            fields.add(a.p.getName());
			        }
			        this.dataSourceName = (((Select_stmtContext)_localctx).datasource!=null?_input.getText(((Select_stmtContext)_localctx).datasource.start,((Select_stmtContext)_localctx).datasource.stop):null);
			    
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

	public static class Where_stmtContext extends ParserRuleContext {
		public TimeAndDimFilterContext f;
		public TimeAndDimFilterContext timeAndDimFilter() {
			return getRuleContext(TimeAndDimFilterContext.class,0);
		}
		public Where_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterWhere_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitWhere_stmt(this);
		}
	}

	public final Where_stmtContext where_stmt() throws RecognitionException {
		Where_stmtContext _localctx = new Where_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_where_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(6);
			setState(67); ((Where_stmtContext)_localctx).f = timeAndDimFilter();

			        if(((Where_stmtContext)_localctx).f.filter != null) this.filter = ((Where_stmtContext)_localctx).f.filter;
			        this.intervals = Lists.newArrayList(((Where_stmtContext)_localctx).f.interval);
			    
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

	public static class Groupby_stmtContext extends ParserRuleContext {
		public GroupByExpressionContext groupByExpression(int i) {
			return getRuleContext(GroupByExpressionContext.class,i);
		}
		public TerminalNode GROUP() { return getToken(DruidSQLParser.GROUP, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(DruidSQLParser.COMMA, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DruidSQLParser.COMMA); }
		public List<GroupByExpressionContext> groupByExpression() {
			return getRuleContexts(GroupByExpressionContext.class);
		}
		public Groupby_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupby_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterGroupby_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitGroupby_stmt(this);
		}
	}

	public final Groupby_stmtContext groupby_stmt() throws RecognitionException {
		Groupby_stmtContext _localctx = new Groupby_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_groupby_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(GROUP);
			setState(71); match(4);
			setState(72); groupByExpression();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(73); match(COMMA);
				setState(74); groupByExpression();
				}
				}
				setState(79);
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

	public static class GroupByExpressionContext extends ParserRuleContext {
		public GranularityFnContext gran;
		public Token dim;
		public TerminalNode IDENT() { return getToken(DruidSQLParser.IDENT, 0); }
		public GranularityFnContext granularityFn() {
			return getRuleContext(GranularityFnContext.class,0);
		}
		public GroupByExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterGroupByExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitGroupByExpression(this);
		}
	}

	public final GroupByExpressionContext groupByExpression() throws RecognitionException {
		GroupByExpressionContext _localctx = new GroupByExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_groupByExpression);
		try {
			setState(85);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(80); ((GroupByExpressionContext)_localctx).gran = granularityFn();
				this.granularity = ((GroupByExpressionContext)_localctx).gran.granularity;
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); ((GroupByExpressionContext)_localctx).dim = match(IDENT);
				 this.groupByDimensions.put((((GroupByExpressionContext)_localctx).dim!=null?((GroupByExpressionContext)_localctx).dim.getText():null), new DefaultDimensionSpec((((GroupByExpressionContext)_localctx).dim!=null?((GroupByExpressionContext)_localctx).dim.getText():null), (((GroupByExpressionContext)_localctx).dim!=null?((GroupByExpressionContext)_localctx).dim.getText():null))); 
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

	public static class DatasourceContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(DruidSQLParser.IDENT, 0); }
		public DatasourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datasource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterDatasource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitDatasource(this);
		}
	}

	public final DatasourceContext datasource() throws RecognitionException {
		DatasourceContext _localctx = new DatasourceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_datasource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(IDENT);
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

	public static class AliasedExpressionContext extends ParserRuleContext {
		public PostAggregator p;
		public ExpressionContext expression;
		public Token name;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(DruidSQLParser.AS, 0); }
		public TerminalNode IDENT() { return getToken(DruidSQLParser.IDENT, 0); }
		public AliasedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterAliasedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitAliasedExpression(this);
		}
	}

	public final AliasedExpressionContext aliasedExpression() throws RecognitionException {
		AliasedExpressionContext _localctx = new AliasedExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_aliasedExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); ((AliasedExpressionContext)_localctx).expression = expression();
			setState(92);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(90); match(AS);
				setState(91); ((AliasedExpressionContext)_localctx).name = match(IDENT);
				}
			}


			        if(((AliasedExpressionContext)_localctx).name != null) {
			            postAggregators.add(((AliasedExpressionContext)_localctx).expression.p);
			            ((AliasedExpressionContext)_localctx).p =  new FieldAccessPostAggregator((((AliasedExpressionContext)_localctx).name!=null?((AliasedExpressionContext)_localctx).name.getText():null), ((AliasedExpressionContext)_localctx).expression.p.getName());
			        }
			        else ((AliasedExpressionContext)_localctx).p =  ((AliasedExpressionContext)_localctx).expression.p;
			    
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
		public PostAggregator p;
		public AdditiveExpressionContext additiveExpression;
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); ((ExpressionContext)_localctx).additiveExpression = additiveExpression();
			 ((ExpressionContext)_localctx).p =  ((ExpressionContext)_localctx).additiveExpression.p; 
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public PostAggregator p;
		public MultiplyExpressionContext a;
		public Token PLUS;
		public List<Token> ops = new ArrayList<Token>();
		public Token MINUS;
		public MultiplyExpressionContext multiplyExpression;
		public List<MultiplyExpressionContext> b = new ArrayList<MultiplyExpressionContext>();
		public TerminalNode MINUS(int i) {
			return getToken(DruidSQLParser.MINUS, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(DruidSQLParser.PLUS); }
		public List<TerminalNode> MINUS() { return getTokens(DruidSQLParser.MINUS); }
		public MultiplyExpressionContext multiplyExpression(int i) {
			return getRuleContext(MultiplyExpressionContext.class,i);
		}
		public TerminalNode PLUS(int i) {
			return getToken(DruidSQLParser.PLUS, i);
		}
		public List<MultiplyExpressionContext> multiplyExpression() {
			return getRuleContexts(MultiplyExpressionContext.class);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); ((AdditiveExpressionContext)_localctx).a = multiplyExpression();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(102);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(100); ((AdditiveExpressionContext)_localctx).PLUS = match(PLUS);
					((AdditiveExpressionContext)_localctx).ops.add(((AdditiveExpressionContext)_localctx).PLUS);
					}
					break;
				case MINUS:
					{
					setState(101); ((AdditiveExpressionContext)_localctx).MINUS = match(MINUS);
					((AdditiveExpressionContext)_localctx).ops.add(((AdditiveExpressionContext)_localctx).MINUS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(104); ((AdditiveExpressionContext)_localctx).multiplyExpression = multiplyExpression();
				((AdditiveExpressionContext)_localctx).b.add(((AdditiveExpressionContext)_localctx).multiplyExpression);
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        List<PostAggregator> rhs = new LinkedList<PostAggregator>();
			        for(MultiplyExpressionContext e : ((AdditiveExpressionContext)_localctx).b) rhs.add(e.p);
			        ((AdditiveExpressionContext)_localctx).p =  evalArithmeticPostAggregator(((AdditiveExpressionContext)_localctx).a.p, ((AdditiveExpressionContext)_localctx).ops, rhs);
			    
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

	public static class MultiplyExpressionContext extends ParserRuleContext {
		public PostAggregator p;
		public UnaryExpressionContext a;
		public Token STAR;
		public List<Token> ops = new ArrayList<Token>();
		public Token DIV;
		public UnaryExpressionContext unaryExpression;
		public List<UnaryExpressionContext> b = new ArrayList<UnaryExpressionContext>();
		public List<TerminalNode> STAR() { return getTokens(DruidSQLParser.STAR); }
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public List<TerminalNode> DIV() { return getTokens(DruidSQLParser.DIV); }
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode DIV(int i) {
			return getToken(DruidSQLParser.DIV, i);
		}
		public TerminalNode STAR(int i) {
			return getToken(DruidSQLParser.STAR, i);
		}
		public MultiplyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterMultiplyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitMultiplyExpression(this);
		}
	}

	public final MultiplyExpressionContext multiplyExpression() throws RecognitionException {
		MultiplyExpressionContext _localctx = new MultiplyExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multiplyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); ((MultiplyExpressionContext)_localctx).a = unaryExpression();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR || _la==DIV) {
				{
				{
				setState(115);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(113); ((MultiplyExpressionContext)_localctx).STAR = match(STAR);
					((MultiplyExpressionContext)_localctx).ops.add(((MultiplyExpressionContext)_localctx).STAR);
					}
					break;
				case DIV:
					{
					setState(114); ((MultiplyExpressionContext)_localctx).DIV = match(DIV);
					((MultiplyExpressionContext)_localctx).ops.add(((MultiplyExpressionContext)_localctx).DIV);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(117); ((MultiplyExpressionContext)_localctx).unaryExpression = unaryExpression();
				((MultiplyExpressionContext)_localctx).b.add(((MultiplyExpressionContext)_localctx).unaryExpression);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        List<PostAggregator> rhs = new LinkedList<PostAggregator>();
			        for(UnaryExpressionContext e : ((MultiplyExpressionContext)_localctx).b) rhs.add(e.p);
			        ((MultiplyExpressionContext)_localctx).p =  evalArithmeticPostAggregator(((MultiplyExpressionContext)_localctx).a.p, ((MultiplyExpressionContext)_localctx).ops, rhs);
			    
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

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PostAggregator p;
		public UnaryExpressionContext e;
		public PrimaryExpressionContext primaryExpression;
		public TerminalNode PLUS() { return getToken(DruidSQLParser.PLUS, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(DruidSQLParser.MINUS, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unaryExpression);
		try {
			setState(136);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); match(MINUS);
				setState(126); ((UnaryExpressionContext)_localctx).e = unaryExpression();

				        if(((UnaryExpressionContext)_localctx).e.p instanceof ConstantPostAggregator) {
				            ConstantPostAggregator c = (ConstantPostAggregator)((UnaryExpressionContext)_localctx).e.p;
				            double v = c.getConstantValue().doubleValue() * -1;
				            ((UnaryExpressionContext)_localctx).p =  new ConstantPostAggregator(Double.toString(v), v);
				        } else {
				            ((UnaryExpressionContext)_localctx).p =  new ArithmeticPostAggregator(
				                "-"+((UnaryExpressionContext)_localctx).e.p.getName(),
				                "*",
				                Lists.newArrayList(((UnaryExpressionContext)_localctx).e.p, new ConstantPostAggregator("-1", -1.0))
				            );
				        }
				    
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); match(PLUS);
				setState(130); ((UnaryExpressionContext)_localctx).e = unaryExpression();
				 ((UnaryExpressionContext)_localctx).p =  ((UnaryExpressionContext)_localctx).e.p; 
				}
				break;
			case SUM:
			case MIN:
			case MAX:
			case COUNT:
			case OPEN:
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(133); ((UnaryExpressionContext)_localctx).primaryExpression = primaryExpression();
				 ((UnaryExpressionContext)_localctx).p =  ((UnaryExpressionContext)_localctx).primaryExpression.p; 
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PostAggregator p;
		public ConstantContext constant;
		public AggregateContext aggregate;
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(DruidSQLParser.OPEN, 0); }
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(DruidSQLParser.CLOSE, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primaryExpression);
		try {
			setState(149);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); ((PrimaryExpressionContext)_localctx).constant = constant();
				 ((PrimaryExpressionContext)_localctx).p =  ((PrimaryExpressionContext)_localctx).constant.c; 
				}
				break;
			case SUM:
			case MIN:
			case MAX:
			case COUNT:
				enterOuterAlt(_localctx, 2);
				{
				setState(141); ((PrimaryExpressionContext)_localctx).aggregate = aggregate();

				        aggregators.put(((PrimaryExpressionContext)_localctx).aggregate.agg.getName(), ((PrimaryExpressionContext)_localctx).aggregate.agg);
				        ((PrimaryExpressionContext)_localctx).p =  new FieldAccessPostAggregator(((PrimaryExpressionContext)_localctx).aggregate.agg.getName(), ((PrimaryExpressionContext)_localctx).aggregate.agg.getName());
				    
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(144); match(OPEN);
				setState(145); ((PrimaryExpressionContext)_localctx).e = expression();
				setState(146); match(CLOSE);
				 ((PrimaryExpressionContext)_localctx).p =  ((PrimaryExpressionContext)_localctx).e.p; 
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

	public static class AggregateContext extends ParserRuleContext {
		public AggregatorFactory agg;
		public Token fn;
		public Token name;
		public TerminalNode OPEN() { return getToken(DruidSQLParser.OPEN, 0); }
		public TerminalNode MAX() { return getToken(DruidSQLParser.MAX, 0); }
		public TerminalNode IDENT() { return getToken(DruidSQLParser.IDENT, 0); }
		public TerminalNode STAR() { return getToken(DruidSQLParser.STAR, 0); }
		public TerminalNode COUNT() { return getToken(DruidSQLParser.COUNT, 0); }
		public TerminalNode MIN() { return getToken(DruidSQLParser.MIN, 0); }
		public TerminalNode CLOSE() { return getToken(DruidSQLParser.CLOSE, 0); }
		public TerminalNode SUM() { return getToken(DruidSQLParser.SUM, 0); }
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitAggregate(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aggregate);
		int _la;
		try {
			setState(161);
			switch (_input.LA(1)) {
			case SUM:
			case MIN:
			case MAX:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				((AggregateContext)_localctx).fn = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUM) | (1L << MIN) | (1L << MAX))) != 0)) ) {
					((AggregateContext)_localctx).fn = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(152); match(OPEN);
				setState(153);
				((AggregateContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==COUNT || _la==IDENT) ) {
					((AggregateContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(154); match(CLOSE);
				 ((AggregateContext)_localctx).agg =  evalAgg((((AggregateContext)_localctx).name!=null?((AggregateContext)_localctx).name.getText():null), (((AggregateContext)_localctx).fn!=null?((AggregateContext)_localctx).fn.getType():0)); 
				}
				break;
			case COUNT:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); ((AggregateContext)_localctx).fn = match(COUNT);
				setState(157); match(OPEN);
				setState(158); match(STAR);
				setState(159); match(CLOSE);
				 ((AggregateContext)_localctx).agg =  evalAgg("count(*)", (((AggregateContext)_localctx).fn!=null?((AggregateContext)_localctx).fn.getType():0)); 
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

	public static class ConstantContext extends ParserRuleContext {
		public ConstantPostAggregator c;
		public Token value;
		public TerminalNode NUMBER() { return getToken(DruidSQLParser.NUMBER, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); ((ConstantContext)_localctx).value = match(NUMBER);
			 double v = Double.parseDouble((((ConstantContext)_localctx).value!=null?((ConstantContext)_localctx).value.getText():null)); ((ConstantContext)_localctx).c =  new ConstantPostAggregator(Double.toString(v), v); 
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

	public static class TimeAndDimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public org.joda.time.Interval interval;
		public DimFilterContext f1;
		public TimeFilterContext t;
		public DimFilterContext f2;
		public TimeFilterContext timeFilter() {
			return getRuleContext(TimeFilterContext.class,0);
		}
		public List<TerminalNode> AND() { return getTokens(DruidSQLParser.AND); }
		public DimFilterContext dimFilter(int i) {
			return getRuleContext(DimFilterContext.class,i);
		}
		public TerminalNode AND(int i) {
			return getToken(DruidSQLParser.AND, i);
		}
		public List<DimFilterContext> dimFilter() {
			return getRuleContexts(DimFilterContext.class);
		}
		public TimeAndDimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeAndDimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterTimeAndDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitTimeAndDimFilter(this);
		}
	}

	public final TimeAndDimFilterContext timeAndDimFilter() throws RecognitionException {
		TimeAndDimFilterContext _localctx = new TimeAndDimFilterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_timeAndDimFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << NOT) | (1L << IDENT))) != 0)) {
				{
				setState(166); ((TimeAndDimFilterContext)_localctx).f1 = dimFilter();
				setState(167); match(AND);
				}
			}

			setState(171); ((TimeAndDimFilterContext)_localctx).t = timeFilter();
			setState(174);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(172); match(AND);
				setState(173); ((TimeAndDimFilterContext)_localctx).f2 = dimFilter();
				}
			}


			        if(((TimeAndDimFilterContext)_localctx).f1 != null || ((TimeAndDimFilterContext)_localctx).f2 != null) {
			            if(((TimeAndDimFilterContext)_localctx).f1 != null && ((TimeAndDimFilterContext)_localctx).f2 != null) {
			                ((TimeAndDimFilterContext)_localctx).filter =  new AndDimFilter(Lists.newArrayList(((TimeAndDimFilterContext)_localctx).f1.filter, ((TimeAndDimFilterContext)_localctx).f2.filter));
			            } else if(((TimeAndDimFilterContext)_localctx).f1 != null) {
			                ((TimeAndDimFilterContext)_localctx).filter =  ((TimeAndDimFilterContext)_localctx).f1.filter;
			            } else {
			                ((TimeAndDimFilterContext)_localctx).filter =  ((TimeAndDimFilterContext)_localctx).f2.filter;
			            }
			        }
			        ((TimeAndDimFilterContext)_localctx).interval =  ((TimeAndDimFilterContext)_localctx).t.interval;
			    
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

	public static class DimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public OrDimFilterContext e;
		public OrDimFilterContext orDimFilter() {
			return getRuleContext(OrDimFilterContext.class,0);
		}
		public DimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitDimFilter(this);
		}
	}

	public final DimFilterContext dimFilter() throws RecognitionException {
		DimFilterContext _localctx = new DimFilterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dimFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); ((DimFilterContext)_localctx).e = orDimFilter();
			 ((DimFilterContext)_localctx).filter =  ((DimFilterContext)_localctx).e.filter; 
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

	public static class OrDimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public AndDimFilterContext a;
		public AndDimFilterContext andDimFilter;
		public List<AndDimFilterContext> b = new ArrayList<AndDimFilterContext>();
		public List<AndDimFilterContext> andDimFilter() {
			return getRuleContexts(AndDimFilterContext.class);
		}
		public TerminalNode OR(int i) {
			return getToken(DruidSQLParser.OR, i);
		}
		public AndDimFilterContext andDimFilter(int i) {
			return getRuleContext(AndDimFilterContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(DruidSQLParser.OR); }
		public OrDimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orDimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterOrDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitOrDimFilter(this);
		}
	}

	public final OrDimFilterContext orDimFilter() throws RecognitionException {
		OrDimFilterContext _localctx = new OrDimFilterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_orDimFilter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181); ((OrDimFilterContext)_localctx).a = andDimFilter();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(182); match(OR);
					setState(183); ((OrDimFilterContext)_localctx).andDimFilter = andDimFilter();
					((OrDimFilterContext)_localctx).b.add(((OrDimFilterContext)_localctx).andDimFilter);
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}

			        if(((OrDimFilterContext)_localctx).b.isEmpty()) ((OrDimFilterContext)_localctx).filter =  ((OrDimFilterContext)_localctx).a.filter;
			        else {
			            List<DimFilter> rest = new ArrayList<DimFilter>();
			            for(AndDimFilterContext e : ((OrDimFilterContext)_localctx).b) rest.add(e.filter);
			            ((OrDimFilterContext)_localctx).filter =  new OrDimFilter(Lists.asList(((OrDimFilterContext)_localctx).a.filter, rest.toArray(new DimFilter[]{})));
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

	public static class AndDimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public PrimaryDimFilterContext a;
		public PrimaryDimFilterContext primaryDimFilter;
		public List<PrimaryDimFilterContext> b = new ArrayList<PrimaryDimFilterContext>();
		public List<TerminalNode> AND() { return getTokens(DruidSQLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(DruidSQLParser.AND, i);
		}
		public List<PrimaryDimFilterContext> primaryDimFilter() {
			return getRuleContexts(PrimaryDimFilterContext.class);
		}
		public PrimaryDimFilterContext primaryDimFilter(int i) {
			return getRuleContext(PrimaryDimFilterContext.class,i);
		}
		public AndDimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andDimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterAndDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitAndDimFilter(this);
		}
	}

	public final AndDimFilterContext andDimFilter() throws RecognitionException {
		AndDimFilterContext _localctx = new AndDimFilterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_andDimFilter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191); ((AndDimFilterContext)_localctx).a = primaryDimFilter();
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(192); match(AND);
					setState(193); ((AndDimFilterContext)_localctx).primaryDimFilter = primaryDimFilter();
					((AndDimFilterContext)_localctx).b.add(((AndDimFilterContext)_localctx).primaryDimFilter);
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}

			        if(((AndDimFilterContext)_localctx).b.isEmpty()) ((AndDimFilterContext)_localctx).filter =  ((AndDimFilterContext)_localctx).a.filter;
			        else {
			            List<DimFilter> rest = new ArrayList<DimFilter>();
			            for(PrimaryDimFilterContext e : ((AndDimFilterContext)_localctx).b) rest.add(e.filter);
			            ((AndDimFilterContext)_localctx).filter =  new AndDimFilter(Lists.asList(((AndDimFilterContext)_localctx).a.filter, rest.toArray(new DimFilter[]{})));
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

	public static class PrimaryDimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public SelectorDimFilterContext e;
		public InListDimFilterContext l;
		public DimFilterContext f;
		public TerminalNode OPEN() { return getToken(DruidSQLParser.OPEN, 0); }
		public TerminalNode NOT() { return getToken(DruidSQLParser.NOT, 0); }
		public TerminalNode CLOSE() { return getToken(DruidSQLParser.CLOSE, 0); }
		public InListDimFilterContext inListDimFilter() {
			return getRuleContext(InListDimFilterContext.class,0);
		}
		public DimFilterContext dimFilter() {
			return getRuleContext(DimFilterContext.class,0);
		}
		public SelectorDimFilterContext selectorDimFilter() {
			return getRuleContext(SelectorDimFilterContext.class,0);
		}
		public PrimaryDimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryDimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterPrimaryDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitPrimaryDimFilter(this);
		}
	}

	public final PrimaryDimFilterContext primaryDimFilter() throws RecognitionException {
		PrimaryDimFilterContext _localctx = new PrimaryDimFilterContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_primaryDimFilter);
		try {
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201); ((PrimaryDimFilterContext)_localctx).e = selectorDimFilter();
				 ((PrimaryDimFilterContext)_localctx).filter =  ((PrimaryDimFilterContext)_localctx).e.filter; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); ((PrimaryDimFilterContext)_localctx).l = inListDimFilter();
				 ((PrimaryDimFilterContext)_localctx).filter =  ((PrimaryDimFilterContext)_localctx).l.filter; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207); match(NOT);
				setState(208); ((PrimaryDimFilterContext)_localctx).f = dimFilter();
				 ((PrimaryDimFilterContext)_localctx).filter =  new NotDimFilter(((PrimaryDimFilterContext)_localctx).f.filter); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211); match(OPEN);
				setState(212); ((PrimaryDimFilterContext)_localctx).f = dimFilter();
				setState(213); match(CLOSE);
				 ((PrimaryDimFilterContext)_localctx).filter =  ((PrimaryDimFilterContext)_localctx).f.filter; 
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

	public static class SelectorDimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public Token dimension;
		public Token op;
		public Token value;
		public TerminalNode IDENT() { return getToken(DruidSQLParser.IDENT, 0); }
		public TerminalNode MATCH() { return getToken(DruidSQLParser.MATCH, 0); }
		public TerminalNode QUOTED_STRING() { return getToken(DruidSQLParser.QUOTED_STRING, 0); }
		public TerminalNode NEQ() { return getToken(DruidSQLParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(DruidSQLParser.EQ, 0); }
		public SelectorDimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorDimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterSelectorDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitSelectorDimFilter(this);
		}
	}

	public final SelectorDimFilterContext selectorDimFilter() throws RecognitionException {
		SelectorDimFilterContext _localctx = new SelectorDimFilterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_selectorDimFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); ((SelectorDimFilterContext)_localctx).dimension = match(IDENT);
			setState(219);
			((SelectorDimFilterContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << MATCH))) != 0)) ) {
				((SelectorDimFilterContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(220); ((SelectorDimFilterContext)_localctx).value = match(QUOTED_STRING);

			        String dim = (((SelectorDimFilterContext)_localctx).dimension!=null?((SelectorDimFilterContext)_localctx).dimension.getText():null);
			        String val = unescape((((SelectorDimFilterContext)_localctx).value!=null?((SelectorDimFilterContext)_localctx).value.getText():null));
			        switch((((SelectorDimFilterContext)_localctx).op!=null?((SelectorDimFilterContext)_localctx).op.getType():0)) {
			            case(EQ): ((SelectorDimFilterContext)_localctx).filter =  new SelectorDimFilter(dim, val); break;
			            case(NEQ): ((SelectorDimFilterContext)_localctx).filter =  new NotDimFilter(new SelectorDimFilter(dim, val)); break;
			            case(MATCH): ((SelectorDimFilterContext)_localctx).filter =  new RegexDimFilter(dim, val); break;
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

	public static class InListDimFilterContext extends ParserRuleContext {
		public DimFilter filter;
		public Token dimension;
		public Token QUOTED_STRING;
		public List<Token> list = new ArrayList<Token>();
		public TerminalNode OPEN() { return getToken(DruidSQLParser.OPEN, 0); }
		public TerminalNode IDENT() { return getToken(DruidSQLParser.IDENT, 0); }
		public List<TerminalNode> QUOTED_STRING() { return getTokens(DruidSQLParser.QUOTED_STRING); }
		public TerminalNode COMMA(int i) {
			return getToken(DruidSQLParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(DruidSQLParser.CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DruidSQLParser.COMMA); }
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(DruidSQLParser.QUOTED_STRING, i);
		}
		public InListDimFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inListDimFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterInListDimFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitInListDimFilter(this);
		}
	}

	public final InListDimFilterContext inListDimFilter() throws RecognitionException {
		InListDimFilterContext _localctx = new InListDimFilterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inListDimFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); ((InListDimFilterContext)_localctx).dimension = match(IDENT);
			setState(224); match(3);
			{
			setState(225); match(OPEN);
			{
			{
			setState(226); ((InListDimFilterContext)_localctx).QUOTED_STRING = match(QUOTED_STRING);
			((InListDimFilterContext)_localctx).list.add(((InListDimFilterContext)_localctx).QUOTED_STRING);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(227); match(COMMA);
				setState(228); ((InListDimFilterContext)_localctx).QUOTED_STRING = match(QUOTED_STRING);
				((InListDimFilterContext)_localctx).list.add(((InListDimFilterContext)_localctx).QUOTED_STRING);
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
			setState(234); match(CLOSE);
			}

			        List<DimFilter> filterList = new LinkedList<DimFilter>();
			        for(Token e : ((InListDimFilterContext)_localctx).list) filterList.add(new SelectorDimFilter((((InListDimFilterContext)_localctx).dimension!=null?((InListDimFilterContext)_localctx).dimension.getText():null), unescape(e.getText())));
			        ((InListDimFilterContext)_localctx).filter =  new OrDimFilter(filterList);
			    
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

	public static class TimeFilterContext extends ParserRuleContext {
		public org.joda.time.Interval interval;
		public QueryGranularity granularity;
		public TimestampContext s;
		public TimestampContext e;
		public List<TimestampContext> timestamp() {
			return getRuleContexts(TimestampContext.class);
		}
		public TerminalNode AND() { return getToken(DruidSQLParser.AND, 0); }
		public TimestampContext timestamp(int i) {
			return getRuleContext(TimestampContext.class,i);
		}
		public TimeFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterTimeFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitTimeFilter(this);
		}
	}

	public final TimeFilterContext timeFilter() throws RecognitionException {
		TimeFilterContext _localctx = new TimeFilterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_timeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); match(5);
			setState(239); match(8);
			setState(240); ((TimeFilterContext)_localctx).s = timestamp();
			setState(241); match(AND);
			setState(242); ((TimeFilterContext)_localctx).e = timestamp();

			        ((TimeFilterContext)_localctx).interval =  new org.joda.time.Interval(((TimeFilterContext)_localctx).s.t, ((TimeFilterContext)_localctx).e.t);
			    
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

	public static class GranularityFnContext extends ParserRuleContext {
		public QueryGranularity granularity;
		public Token str;
		public TerminalNode OPEN() { return getToken(DruidSQLParser.OPEN, 0); }
		public TerminalNode QUOTED_STRING() { return getToken(DruidSQLParser.QUOTED_STRING, 0); }
		public TerminalNode CLOSE() { return getToken(DruidSQLParser.CLOSE, 0); }
		public GranularityFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_granularityFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterGranularityFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitGranularityFn(this);
		}
	}

	public final GranularityFnContext granularityFn() throws RecognitionException {
		GranularityFnContext _localctx = new GranularityFnContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_granularityFn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(7);
			setState(246); match(OPEN);
			setState(247); match(5);
			setState(248); match(COMMA);
			setState(249); ((GranularityFnContext)_localctx).str = match(QUOTED_STRING);
			setState(250); match(CLOSE);

			        String granStr = unescape((((GranularityFnContext)_localctx).str!=null?((GranularityFnContext)_localctx).str.getText():null));
			        try {
			            ((GranularityFnContext)_localctx).granularity =  QueryGranularity.fromString(granStr);
			        } catch(IllegalArgumentException e) {
			            ((GranularityFnContext)_localctx).granularity =  new PeriodGranularity(new Period(granStr), null, null);
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

	public static class TimestampContext extends ParserRuleContext {
		public DateTime t;
		public Token NUMBER;
		public Token QUOTED_STRING;
		public TerminalNode QUOTED_STRING() { return getToken(DruidSQLParser.QUOTED_STRING, 0); }
		public TerminalNode NUMBER() { return getToken(DruidSQLParser.NUMBER, 0); }
		public TimestampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).enterTimestamp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DruidSQLListener ) ((DruidSQLListener)listener).exitTimestamp(this);
		}
	}

	public final TimestampContext timestamp() throws RecognitionException {
		TimestampContext _localctx = new TimestampContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_timestamp);
		try {
			setState(257);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(253); ((TimestampContext)_localctx).NUMBER = match(NUMBER);

				        String str = (((TimestampContext)_localctx).NUMBER!=null?((TimestampContext)_localctx).NUMBER.getText():null).trim();
				        try {
				            ((TimestampContext)_localctx).t =  new DateTime(NumberFormat.getInstance().parse(str));
				        }
				        catch(ParseException e) {
				            throw new IllegalArgumentException("Unable to parse number [" + str + "]");
				        }
				    
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(255); ((TimestampContext)_localctx).QUOTED_STRING = match(QUOTED_STRING);
				 ((TimestampContext)_localctx).t =  new DateTime(unescape((((TimestampContext)_localctx).QUOTED_STRING!=null?((TimestampContext)_localctx).QUOTED_STRING.getText():null))); 
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

	public static final String _serializedATN =
		"\2\3%\u0106\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\3\2\3\2\3\2\5\2\66\n\2\3\3\3\3\3\3\3\3\7\3<\n\3\f"+
		"\3\16\3?\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5"+
		"N\n\5\f\5\16\5Q\13\5\3\6\3\6\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\b\3\b\3\b"+
		"\5\b_\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5\ni\n\n\3\n\7\nl\n\n\f\n\16"+
		"\no\13\n\3\n\3\n\3\13\3\13\3\13\5\13v\n\13\3\13\7\13y\n\13\f\13\16\13"+
		"|\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008b"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a4\n\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\5\20\u00ac\n\20\3\20\3\20\3\20\5\20\u00b1\n\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\7\22\u00bb\n\22\f\22\16\22\u00be"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\7\23\u00c5\n\23\f\23\16\23\u00c8\13\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00db\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\7\26\u00e8\n\26\f\26\16\26\u00eb\13\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0104\n\31\3\31\2\32\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\5\3\r\17\4\20\20\36\36\3\32\34"+
		"\u0104\2\62\3\2\2\2\4\67\3\2\2\2\6D\3\2\2\2\bH\3\2\2\2\nW\3\2\2\2\fY\3"+
		"\2\2\2\16[\3\2\2\2\20b\3\2\2\2\22e\3\2\2\2\24r\3\2\2\2\26\u008a\3\2\2"+
		"\2\30\u0097\3\2\2\2\32\u00a3\3\2\2\2\34\u00a5\3\2\2\2\36\u00ab\3\2\2\2"+
		" \u00b4\3\2\2\2\"\u00b7\3\2\2\2$\u00c1\3\2\2\2&\u00da\3\2\2\2(\u00dc\3"+
		"\2\2\2*\u00e1\3\2\2\2,\u00f0\3\2\2\2.\u00f7\3\2\2\2\60\u0103\3\2\2\2\62"+
		"\63\5\4\3\2\63\65\5\6\4\2\64\66\5\b\5\2\65\64\3\2\2\2\65\66\3\2\2\2\66"+
		"\3\3\2\2\2\678\7\4\2\28=\5\16\b\29:\7\31\2\2:<\5\16\b\2;9\3\2\2\2<?\3"+
		"\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\3\2\2AB\5\f\7\2BC\b"+
		"\3\1\2C\5\3\2\2\2DE\7\b\2\2EF\5\36\20\2FG\b\4\1\2G\7\3\2\2\2HI\7\35\2"+
		"\2IJ\7\6\2\2JO\5\n\6\2KL\7\31\2\2LN\5\n\6\2MK\3\2\2\2NQ\3\2\2\2OM\3\2"+
		"\2\2OP\3\2\2\2P\t\3\2\2\2QO\3\2\2\2RS\5.\30\2ST\b\6\1\2TX\3\2\2\2UV\7"+
		"\36\2\2VX\b\6\1\2WR\3\2\2\2WU\3\2\2\2X\13\3\2\2\2YZ\7\36\2\2Z\r\3\2\2"+
		"\2[^\5\20\t\2\\]\7\21\2\2]_\7\36\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a"+
		"\b\b\1\2a\17\3\2\2\2bc\5\22\n\2cd\b\t\1\2d\21\3\2\2\2em\5\24\13\2fi\7"+
		"\26\2\2gi\7\27\2\2hf\3\2\2\2hg\3\2\2\2ij\3\2\2\2jl\5\24\13\2kh\3\2\2\2"+
		"lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\b\n\1\2q\23\3\2\2"+
		"\2rz\5\26\f\2sv\7\24\2\2tv\7\30\2\2us\3\2\2\2ut\3\2\2\2vw\3\2\2\2wy\5"+
		"\26\f\2xu\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~"+
		"\b\13\1\2~\25\3\2\2\2\177\u0080\7\27\2\2\u0080\u0081\5\26\f\2\u0081\u0082"+
		"\b\f\1\2\u0082\u008b\3\2\2\2\u0083\u0084\7\26\2\2\u0084\u0085\5\26\f\2"+
		"\u0085\u0086\b\f\1\2\u0086\u008b\3\2\2\2\u0087\u0088\5\30\r\2\u0088\u0089"+
		"\b\f\1\2\u0089\u008b\3\2\2\2\u008a\177\3\2\2\2\u008a\u0083\3\2\2\2\u008a"+
		"\u0087\3\2\2\2\u008b\27\3\2\2\2\u008c\u008d\5\34\17\2\u008d\u008e\b\r"+
		"\1\2\u008e\u0098\3\2\2\2\u008f\u0090\5\32\16\2\u0090\u0091\b\r\1\2\u0091"+
		"\u0098\3\2\2\2\u0092\u0093\7\22\2\2\u0093\u0094\5\20\t\2\u0094\u0095\7"+
		"\23\2\2\u0095\u0096\b\r\1\2\u0096\u0098\3\2\2\2\u0097\u008c\3\2\2\2\u0097"+
		"\u008f\3\2\2\2\u0097\u0092\3\2\2\2\u0098\31\3\2\2\2\u0099\u009a\t\2\2"+
		"\2\u009a\u009b\7\22\2\2\u009b\u009c\t\3\2\2\u009c\u009d\7\23\2\2\u009d"+
		"\u00a4\b\16\1\2\u009e\u009f\7\20\2\2\u009f\u00a0\7\22\2\2\u00a0\u00a1"+
		"\7\24\2\2\u00a1\u00a2\7\23\2\2\u00a2\u00a4\b\16\1\2\u00a3\u0099\3\2\2"+
		"\2\u00a3\u009e\3\2\2\2\u00a4\33\3\2\2\2\u00a5\u00a6\7!\2\2\u00a6\u00a7"+
		"\b\17\1\2\u00a7\35\3\2\2\2\u00a8\u00a9\5 \21\2\u00a9\u00aa\7\13\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00b0\5,\27\2\u00ae\u00af\7\13\2\2\u00af\u00b1\5 \21\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\20"+
		"\1\2\u00b3\37\3\2\2\2\u00b4\u00b5\5\"\22\2\u00b5\u00b6\b\21\1\2\u00b6"+
		"!\3\2\2\2\u00b7\u00bc\5$\23\2\u00b8\u00b9\7\f\2\2\u00b9\u00bb\5$\23\2"+
		"\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\b\22\1\2"+
		"\u00c0#\3\2\2\2\u00c1\u00c6\5&\24\2\u00c2\u00c3\7\13\2\2\u00c3\u00c5\5"+
		"&\24\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\b\23"+
		"\1\2\u00ca%\3\2\2\2\u00cb\u00cc\5(\25\2\u00cc\u00cd\b\24\1\2\u00cd\u00db"+
		"\3\2\2\2\u00ce\u00cf\5*\26\2\u00cf\u00d0\b\24\1\2\u00d0\u00db\3\2\2\2"+
		"\u00d1\u00d2\7\25\2\2\u00d2\u00d3\5 \21\2\u00d3\u00d4\b\24\1\2\u00d4\u00db"+
		"\3\2\2\2\u00d5\u00d6\7\22\2\2\u00d6\u00d7\5 \21\2\u00d7\u00d8\7\23\2\2"+
		"\u00d8\u00d9\b\24\1\2\u00d9\u00db\3\2\2\2\u00da\u00cb\3\2\2\2\u00da\u00ce"+
		"\3\2\2\2\u00da\u00d1\3\2\2\2\u00da\u00d5\3\2\2\2\u00db\'\3\2\2\2\u00dc"+
		"\u00dd\7\36\2\2\u00dd\u00de\t\4\2\2\u00de\u00df\7\37\2\2\u00df\u00e0\b"+
		"\25\1\2\u00e0)\3\2\2\2\u00e1\u00e2\7\36\2\2\u00e2\u00e3\7\5\2\2\u00e3"+
		"\u00e4\7\22\2\2\u00e4\u00e9\7\37\2\2\u00e5\u00e6\7\31\2\2\u00e6\u00e8"+
		"\7\37\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2"+
		"\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed"+
		"\7\23\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b\26\1\2\u00ef+\3\2\2\2\u00f0"+
		"\u00f1\7\7\2\2\u00f1\u00f2\7\n\2\2\u00f2\u00f3\5\60\31\2\u00f3\u00f4\7"+
		"\13\2\2\u00f4\u00f5\5\60\31\2\u00f5\u00f6\b\27\1\2\u00f6-\3\2\2\2\u00f7"+
		"\u00f8\7\t\2\2\u00f8\u00f9\7\22\2\2\u00f9\u00fa\7\7\2\2\u00fa\u00fb\7"+
		"\31\2\2\u00fb\u00fc\7\37\2\2\u00fc\u00fd\7\23\2\2\u00fd\u00fe\b\30\1\2"+
		"\u00fe/\3\2\2\2\u00ff\u0100\7!\2\2\u0100\u0104\b\31\1\2\u0101\u0102\7"+
		"\37\2\2\u0102\u0104\b\31\1\2\u0103\u00ff\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\61\3\2\2\2\25\65=OW^hmuz\u008a\u0097\u00a3\u00ab\u00b0\u00bc\u00c6\u00da"+
		"\u00e9\u0103";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}