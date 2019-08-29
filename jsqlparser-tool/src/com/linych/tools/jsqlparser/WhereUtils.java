package com.linych.tools.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.WithItem;

import org.slf4j.Logger;

import com.linych.tools.common.LogUtils;
import com.linych.tools.jsqlparser.common.Operator;

/**
 * WhereUtils
 * @author linych
 * @version 1.0
 *
 */
public class WhereUtils {
    private static final Logger LOG = LogUtils.getLogger();
    private WhereUtils(){
        throw new IllegalStateException("Utility class");
    }
    
    public static Expression getWhere(String sql){
        Select select;
        try {
            select = (Select) CCJSqlParserUtil.parse(sql);
            return getWhere(select.getSelectBody());
        } catch (JSQLParserException e) {
            LOG.error("Parsing sql exceptions...", e);
            return null;
        }
    }
    
    public static Expression getWhere(SelectBody selectBody){
        Expression where = null;
        //普通的select
        if(selectBody instanceof PlainSelect){
            where = ((PlainSelect) selectBody).getWhere();
        }
        
        //whith语句
        if(selectBody instanceof WithItem){
            LOG.info("selectBody instanceof WithItem, temporary does not support:{}", selectBody);
        }
        
        //intersect,except,minus,union查询
        if(selectBody instanceof SetOperationList){
            LOG.info("selectBody instanceof SetOperationList, temporary does not support:{}", selectBody);
        }
        return where;
    }
    
    public static Expression addFilter(String sql, Expression expression, int operator, boolean isnot){
        Expression where = getWhere(sql);
        return addFilter(where, expression, operator, isnot);
    }

    public static Expression addFilter(String sql, Expression expression, int operator){
        Expression where = getWhere(sql);
        return addFilter(where, expression, operator, false);
    }
    
    public static Expression addFilter(Expression where, Expression expression, int operator){
        return addFilter(where, expression, operator, false);
    }

    public static Expression addFilter(Expression where, Expression expression, int operator, boolean isnot){
        if(where == null){
            return expression;
        }
        BinaryExpression binaryExpression = null;
        if(operator == Operator.AND){
            binaryExpression = new AndExpression(where, expression);
            if(isnot){
                binaryExpression.setNot();
            }
        }

        if(operator == Operator.OR){
            binaryExpression = new OrExpression(where, expression);
            if(isnot){
                binaryExpression.setNot();
            }
        }
        return binaryExpression == null ? where : binaryExpression;
    }
}
