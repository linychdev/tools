package com.linych.tools.jsqlparser;

import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Column;

/**
 * ComparisonOperatorUtils
 * @author linych
 * @version 1.0
 *
 */
public class ComparisonOperatorUtils {
    
    private ComparisonOperatorUtils(){
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * 获取等于某个值的表达式
     * @param columnName
     * @param stringValue
     * @return
     */
    public static EqualsTo getEqualsToValue(String columnName, String stringValue){
        return getEqualsToValue(new Column(columnName), new StringValue(stringValue));
    }

    /**
     * 获取等于某个值的表达式
     * @param columnName
     * @param stringValue
     * @return
     */
    public static EqualsTo getEqualsToValue(String columnName, StringValue stringValue){
        return getEqualsToValue(new Column(columnName), stringValue);
    }
    
    /**
     * 获取等于某个值的表达式
     * @param columnName
     * @param stringValue
     * @return
     */
    public static EqualsTo getEqualsToValue(Column column, String stringValue){
        return getEqualsToValue(column, new StringValue(stringValue));
    }
    
    /**
     * 获取等于某个值的表达式
     * @param column
     * @param stringValue
     * @return
     */
    public static EqualsTo getEqualsToValue(Column column, StringValue stringValue){
        EqualsTo et = new EqualsTo();
        et.setLeftExpression(column);
        et.setRightExpression(stringValue);
        return et;
    }
    
    /**
     * 获取等于某个值的表达式
     * @param columnName
     * @param numberValue
     * @return
     */
    public static <T extends Number> EqualsTo getEqualsToValue(String columnName, T numberValue){
        return getEqualsToValue(new Column(columnName), numberValue);
    }

    /**
     * 获取等于某个值的表达式
     * @param column
     * @param numberValue
     * @return
     */
    public static <T extends Number> EqualsTo getEqualsToValue(Column column, T numberValue){
        EqualsTo et = new EqualsTo();
        et.setLeftExpression(column);
        et.setRightExpression(new DoubleValue(String.valueOf(numberValue)));
        return et;
    }
    
    /**
     * 获取不等于某个值的表达式
     * @param columnName
     * @param stringValue
     * @return
     */
    public static NotEqualsTo getNotEqualsToValue(String columnName, String stringValue){
        return getNotEqualsToValue(new Column(columnName), stringValue);
    }
    
    /**
     * 获取不等于某个值的表达式
     * @param column
     * @param stringValue
     * @return
     */
    public static NotEqualsTo getNotEqualsToValue(Column column, String stringValue){
        return getNotEqualsToValue(column, new StringValue(stringValue));
    }

    /**
     * 获取不等于某个值的表达式
     * @param column
     * @param stringValue
     * @return
     */
    public static NotEqualsTo getNotEqualsToValue(String column, StringValue stringValue){
        return getNotEqualsToValue(new Column(column), stringValue);
    }

    /**
     * 获取不等于某个值的表达式
     * @param column
     * @param stringValue
     * @return
     */
    public static NotEqualsTo getNotEqualsToValue(Column column, StringValue stringValue){
        NotEqualsTo et = new NotEqualsTo();
        et.setLeftExpression(column);
        et.setRightExpression(stringValue);
        return et;
    }
    
    /**
     * 获取不等于某个值的表达式
     * @param columnName
     * @param numberValue
     * @return
     */
    public static <T extends Number> NotEqualsTo getNotEqualsToValue(String columnName, T numberValue){
        return getNotEqualsToValue(new Column(columnName), numberValue);
    }

    /**
     * 获取不等于某个值的表达式
     * @param column
     * @param numberValue
     * @return
     */
    public static <T extends Number> NotEqualsTo getNotEqualsToValue(Column column, T numberValue){
        NotEqualsTo et = new NotEqualsTo();
        et.setLeftExpression(column);
        et.setRightExpression(new DoubleValue(String.valueOf(numberValue)));
        return et;
    }
    
    /**
     * 获取大于某个值的表达式
     * @param column
     * @param numberValue
     * @return
     */
    public static <T extends Number> GreaterThan getGreaterThanValue(Column column, T numberValue){
        GreaterThan gt = new GreaterThan();
        gt.setLeftExpression(column);
        gt.setRightExpression(new DoubleValue(String.valueOf(numberValue)));
        return gt;
    }

    public static <T extends Number> GreaterThan getGreaterThanValue(String column, T numberValue){
        return getGreaterThanValue(new Column(column), numberValue);
    }
    
    public static GreaterThan getGreaterThanValue(Column column, String stringValue){
        GreaterThan gt = new GreaterThan();
        gt.setLeftExpression(column);
        gt.setRightExpression(new StringValue(stringValue));
        return gt;
    }

    public static GreaterThan getGreaterThanValue(String column, String stringValue){
        return getGreaterThanValue(new Column(column), stringValue);
    }
}
