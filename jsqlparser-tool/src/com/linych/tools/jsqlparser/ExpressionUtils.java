package com.linych.tools.jsqlparser;

import org.slf4j.Logger;

import com.linych.tools.common.LogUtils;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Parenthesis;

/**
 * ExpressionUtils
 * @author linych
 * @version 1.0
 *
 */
public class ExpressionUtils {
    
    private static final Logger LOG = LogUtils.getLogger();
   
    private ExpressionUtils(){
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * 为表达式添加括号
     * @return
     */
    public static Expression addParenthesis(Expression where){
        return addParenthesis(where, false);
    }

    /**
     * 为表达式添加括号
     * @return
     */
    public static Expression addParenthesis(Expression where, boolean not){
        Parenthesis parenthesis = new Parenthesis(where);
        if(not){
            parenthesis.setNot();
        }
        return parenthesis;
    }
}
