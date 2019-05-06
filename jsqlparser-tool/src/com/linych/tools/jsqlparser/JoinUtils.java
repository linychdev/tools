package com.linych.tools.jsqlparser;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Join;

/**
 * JoinUtils
 * @author linych
 * @version 1.0
 *
 */
public class JoinUtils {

    private JoinUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取Jsqlparser中的右连接
     * @param tableName
     * @param alias
     * @return
     */
    public static Join getRightJoin(String tableName, String alias) {
        Join rightJoin = new Join();
        rightJoin.setRight(true);
        Table table = TableUtils.getTableWithAlias(tableName, alias, false);
        rightJoin.setRightItem(table);
        return rightJoin;
    }

    /**
     * 获取Jsqlparser中的左连接
     * @param tableName
     * @param alias
     * @return
     */
    public static Join getLeftJoin(String tableName, String alias) {
        Join leftJoin = new Join();
        leftJoin.setLeft(true);
        Table table = TableUtils.getTableWithAlias(tableName, alias, false);
        leftJoin.setRightItem(table);
        return leftJoin;
    }

    /**
     * 获取Jsqlparser中的内连接
     * @param tableName
     * @param alias
     * @return
     */
    public static Join getInnerJoin(String tableName, String alias) {
        Join innerJoin = new Join();
        innerJoin.setInner(true);
        Table table = TableUtils.getTableWithAlias(tableName, alias, false);
        innerJoin.setRightItem(table);
        return innerJoin;
    }

    /**
     * 获取Jsqlparser中的内连接
     * @param tableName
     * @param alias
     * @return
     */
    public static Join getFullJoin(String tableName, String alias) {
        Join fullJoin = new Join();
        fullJoin.setFull(true);
        Table table = TableUtils.getTableWithAlias(tableName, alias, false);
        fullJoin.setRightItem(table);
        return fullJoin;
    }

    /**
     * 设置join on 的内容
     * @param join
     * @param expression
     */
    public static void setJoinOn(Join join, Expression expression) {
        if (join == null) {
            return;
        }
        join.setOnExpression(expression);
    }

    /**
     * 设置join on 的内容
     * @param join
     * @param leftExp 左表达式
     * @param rightExp 右表达式
     * @param relExp 关系表达式
     * @param not 是否取反
     *            默认为否
     */
    public static void setJoinOn(Join join, Expression leftExp, Expression rightExp, Expression relExp, boolean not) {
        if (join == null) {
            return;
        }
        if (relExp == null) {
            return;
        }
        if (relExp instanceof EqualsTo) {
            ((EqualsTo) relExp).setLeftExpression(leftExp);
            ((EqualsTo) relExp).setRightExpression(rightExp);
        }
        if (relExp instanceof NotEqualsTo) {
            ((NotEqualsTo) relExp).setLeftExpression(leftExp);
            ((NotEqualsTo) relExp).setRightExpression(rightExp);
        }
        if (relExp instanceof AndExpression) {
            ((AndExpression) relExp).setLeftExpression(leftExp);
            ((AndExpression) relExp).setRightExpression(rightExp);
            if (not) {
                ((AndExpression) relExp).setNot();
            }
        }
        if (relExp instanceof OrExpression) {
            ((OrExpression) relExp).setLeftExpression(leftExp);
            ((OrExpression) relExp).setRightExpression(rightExp);
            if (not) {
                ((OrExpression) relExp).setNot();
            }
        }
        if (relExp instanceof IsNullExpression) {
            ((IsNullExpression) relExp).setLeftExpression(leftExp);
            ((IsNullExpression) relExp).setNot(not);
        }
        if (relExp instanceof LikeExpression) {
            ((LikeExpression) relExp).setLeftExpression(leftExp);
            ((LikeExpression) relExp).setRightExpression(rightExp);
            ((LikeExpression) relExp).setNot(not);
        }
        join.setOnExpression(relExp);
    }

    /**
     * 设置join on 的内容
     * @param join
     * @param leftExp 左表达式
     * @param relExp 关系表达式
     * @param not 是否取反
     *            默认为否
     */
    public static void setJoinOn(Join join, Expression leftExp, Expression relExp, boolean not) {
        setJoinOn(join, leftExp, null, relExp, not);
    }

    /**
     * 设置join on 的内容
     * @param join
     * @param leftExp 左表达式
     * @param relExp 关系表达式
     * @param not 是否取反
     *            默认为否
     */
    public static void setJoinOn(Join join, Expression leftExp, Expression relExp) {
        setJoinOn(join, leftExp, null, relExp, false);
    }

    /**
     * 设置join on 的内容
     * @param join
     * @param leftExp 左表达式
     * @param rightExp 右表达式
     * @param relExp 关系表达式
     * @param not 是否取反
     *            默认为否
     */
    public static void setJoinOn(Join join, Expression leftExp, Expression rightExp, Expression relExp) {
        setJoinOn(join, leftExp, rightExp, relExp, false);
    }

}
