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

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface DruidSQLListener extends ParseTreeListener {
	void enterExpression(DruidSQLParser.ExpressionContext ctx);
	void exitExpression(DruidSQLParser.ExpressionContext ctx);

	void enterTimeFilter(DruidSQLParser.TimeFilterContext ctx);
	void exitTimeFilter(DruidSQLParser.TimeFilterContext ctx);

	void enterOrDimFilter(DruidSQLParser.OrDimFilterContext ctx);
	void exitOrDimFilter(DruidSQLParser.OrDimFilterContext ctx);

	void enterGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx);
	void exitGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx);

	void enterAggregate(DruidSQLParser.AggregateContext ctx);
	void exitAggregate(DruidSQLParser.AggregateContext ctx);

	void enterConstant(DruidSQLParser.ConstantContext ctx);
	void exitConstant(DruidSQLParser.ConstantContext ctx);

	void enterAndDimFilter(DruidSQLParser.AndDimFilterContext ctx);
	void exitAndDimFilter(DruidSQLParser.AndDimFilterContext ctx);

	void enterQuery(DruidSQLParser.QueryContext ctx);
	void exitQuery(DruidSQLParser.QueryContext ctx);

	void enterUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx);
	void exitUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx);

	void enterGranularityFn(DruidSQLParser.GranularityFnContext ctx);
	void exitGranularityFn(DruidSQLParser.GranularityFnContext ctx);

	void enterAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx);
	void exitAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx);

	void enterTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx);
	void exitTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx);

	void enterPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx);
	void exitPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx);

	void enterPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx);
	void exitPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx);

	void enterMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx);
	void exitMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx);

	void enterSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx);
	void exitSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx);

	void enterDimFilter(DruidSQLParser.DimFilterContext ctx);
	void exitDimFilter(DruidSQLParser.DimFilterContext ctx);

	void enterTimestamp(DruidSQLParser.TimestampContext ctx);
	void exitTimestamp(DruidSQLParser.TimestampContext ctx);

	void enterSelect_stmt(DruidSQLParser.Select_stmtContext ctx);
	void exitSelect_stmt(DruidSQLParser.Select_stmtContext ctx);

	void enterWhere_stmt(DruidSQLParser.Where_stmtContext ctx);
	void exitWhere_stmt(DruidSQLParser.Where_stmtContext ctx);

	void enterInListDimFilter(DruidSQLParser.InListDimFilterContext ctx);
	void exitInListDimFilter(DruidSQLParser.InListDimFilterContext ctx);

	void enterGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx);
	void exitGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx);

	void enterAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx);
	void exitAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx);

	void enterDatasource(DruidSQLParser.DatasourceContext ctx);
	void exitDatasource(DruidSQLParser.DatasourceContext ctx);
}