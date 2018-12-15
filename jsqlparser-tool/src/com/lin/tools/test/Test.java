package com.lin.tools.test;

import com.lin.tools.jsqlparser.WhereUtils;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

/**
 * Test
 * @author linych
 * @version 1.0
 *
 */
public class Test {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "select count(*) from db_rsyw.t_fyrs_flzw where c_bh_ry in ('123') limit ? offset ?";
        Select select = (Select) CCJSqlParserUtil.parse(sql);
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        Expression where = plainSelect.getWhere();
        
        EqualsTo et = new EqualsTo();
        et.setLeftExpression(new Column("f_001"));
        et.setRightExpression(new StringValue("qwe"));
        where = WhereUtils.addFilter(where, et, "and");
        System.out.println(where);
    }
}
