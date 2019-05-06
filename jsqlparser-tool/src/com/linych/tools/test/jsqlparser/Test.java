package com.linych.tools.test.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

import com.linych.tools.jsqlparser.WhereUtils;
import com.linych.tools.jsqlparser.common.Operator;

/**
 * Test
 * @author linych
 * @version 1.0
 *
 */
public class Test {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "select a,b,c from db_rsyw.t_fyrs_flzw where c_bh_ry in ('123') limit ? offset ?";
        Select select = (Select) CCJSqlParserUtil.parse(sql);
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        Expression where = plainSelect.getWhere();
        
        EqualsTo et = new EqualsTo();
        et.setLeftExpression(new Column("f_001"));
        et.setRightExpression(new StringValue("qwe"));
        where = WhereUtils.addFilter(where, et, Operator.AND);
        plainSelect.setWhere(where);
        System.out.println(select);
    }
}
