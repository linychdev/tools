/*
 * @(#)WhereUtils.java 2018年10月10日下午5:17:32
 * jsqlparser-tool
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lin.tools.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.WithItem;

import org.slf4j.Logger;

import com.lin.tools.log.LogUtils;

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
        Expression where = null;
        try {
            select = (Select) CCJSqlParserUtil.parse(sql);
            PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
            where = plainSelect.getWhere();
        } catch (JSQLParserException e) {
            LOG.error("Parsing sql exceptions...", e);
        }
        return where;
    }
    
    public static Expression getWhere(SelectBody selectBody){
        Expression where = null;
        //普通的select
        if(selectBody instanceof PlainSelect){
            where = ((PlainSelect) selectBody).getWhere();
        }
        
        //whith语句
        if(selectBody instanceof WithItem){
            
        }
        
        //intersect,except,minus,union查询
        if(selectBody instanceof SetOperationList){
            
        }
        
        return null;
    }
}
