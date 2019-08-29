package com.linych.tools.test.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

import com.linych.tools.jsqlparser.ComparisonOperatorUtils;
import com.linych.tools.jsqlparser.ExpressionUtils;
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
//        String sql = "select a,b,c from db_rsyw.t_fyrs_flzw where c_bh_ry in ('123') and ajlb = 5 limit ? offset ?";
        String sql = "SELECT * FROM DB_XCSPJX..I_AJ_ALL_V";
        Select select = (Select) CCJSqlParserUtil.parse(sql);
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        Expression where = plainSelect.getWhere();
        
        EqualsTo et1 = ComparisonOperatorUtils.getEqualsToValue("f_001", "qwe");
        EqualsTo et2 = ComparisonOperatorUtils.getEqualsToValue("f_002", -3.33);
        NotEqualsTo et3 = ComparisonOperatorUtils.getNotEqualsToValue("f_003", 56);
        
        GreaterThan gt1 = ComparisonOperatorUtils.getGreaterThanValue("f_004", 4);
        GreaterThan gt2 = ComparisonOperatorUtils.getGreaterThanValue("f_005::int", "4");
        
        Expression or = new OrExpression(et1, et2);
        or = ExpressionUtils.addParenthesis(or);
        where = WhereUtils.addFilter(where, or, Operator.AND);
        Expression or1 = new OrExpression(et3, gt1);
        or1 = ExpressionUtils.addParenthesis(or1);
        where = WhereUtils.addFilter(where, or1, Operator.AND);
//        where = WhereUtils.addFilter(where, et1, Operator.AND);
//        where = WhereUtils.addFilter(where, et2, Operator.OR);
//        where = ExpressionUtils.addParenthesis(where);
//        where = WhereUtils.addFilter(where, et3, Operator.AND);
//        where = WhereUtils.addFilter(where, gt1, Operator.AND);
//        where = ExpressionUtils.addParenthesis(where);
//        where = WhereUtils.addFilter(where, gt2, Operator.AND);
        
        plainSelect.setWhere(where);
        System.out.println(select);
    }
}
