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


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class DruidSQLBaseListener implements DruidSQLListener {
	@Override public void enterExpression(DruidSQLParser.ExpressionContext ctx) { }
	@Override public void exitExpression(DruidSQLParser.ExpressionContext ctx) { }

	@Override public void enterTimeFilter(DruidSQLParser.TimeFilterContext ctx) { }
	@Override public void exitTimeFilter(DruidSQLParser.TimeFilterContext ctx) { }

	@Override public void enterOrDimFilter(DruidSQLParser.OrDimFilterContext ctx) { }
	@Override public void exitOrDimFilter(DruidSQLParser.OrDimFilterContext ctx) { }

	@Override public void enterGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx) { }
	@Override public void exitGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx) { }

	@Override public void enterAggregate(DruidSQLParser.AggregateContext ctx) { }
	@Override public void exitAggregate(DruidSQLParser.AggregateContext ctx) { }

	@Override public void enterConstant(DruidSQLParser.ConstantContext ctx) { }
	@Override public void exitConstant(DruidSQLParser.ConstantContext ctx) { }

	@Override public void enterAndDimFilter(DruidSQLParser.AndDimFilterContext ctx) { }
	@Override public void exitAndDimFilter(DruidSQLParser.AndDimFilterContext ctx) { }

	@Override public void enterQuery(DruidSQLParser.QueryContext ctx) { }
	@Override public void exitQuery(DruidSQLParser.QueryContext ctx) { }

	@Override public void enterUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx) { }
	@Override public void exitUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx) { }

	@Override public void enterGranularityFn(DruidSQLParser.GranularityFnContext ctx) { }
	@Override public void exitGranularityFn(DruidSQLParser.GranularityFnContext ctx) { }

	@Override public void enterAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx) { }
	@Override public void exitAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx) { }

	@Override public void enterTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx) { }
	@Override public void exitTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx) { }

	@Override public void enterPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx) { }
	@Override public void exitPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx) { }

	@Override public void enterPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx) { }
	@Override public void exitPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx) { }

	@Override public void enterMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx) { }
	@Override public void exitMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx) { }

	@Override public void enterSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx) { }
	@Override public void exitSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx) { }

	@Override public void enterDimFilter(DruidSQLParser.DimFilterContext ctx) { }
	@Override public void exitDimFilter(DruidSQLParser.DimFilterContext ctx) { }

	@Override public void enterTimestamp(DruidSQLParser.TimestampContext ctx) { }
	@Override public void exitTimestamp(DruidSQLParser.TimestampContext ctx) { }

	@Override public void enterSelect_stmt(DruidSQLParser.Select_stmtContext ctx) { }
	@Override public void exitSelect_stmt(DruidSQLParser.Select_stmtContext ctx) { }

	@Override public void enterWhere_stmt(DruidSQLParser.Where_stmtContext ctx) { }
	@Override public void exitWhere_stmt(DruidSQLParser.Where_stmtContext ctx) { }

	@Override public void enterInListDimFilter(DruidSQLParser.InListDimFilterContext ctx) { }
	@Override public void exitInListDimFilter(DruidSQLParser.InListDimFilterContext ctx) { }

	@Override public void enterGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx) { }
	@Override public void exitGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx) { }

	@Override public void enterAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx) { }
	@Override public void exitAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx) { }

	@Override public void enterDatasource(DruidSQLParser.DatasourceContext ctx) { }
	@Override public void exitDatasource(DruidSQLParser.DatasourceContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}