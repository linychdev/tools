package com.lin.tools.jsqlparser;

import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;

import org.apache.commons.lang.StringUtils;

/**
 * ColumnUtils
 * @author linych
 * @version 1.0
 *
 */
public class ColumnUtils {

    private ColumnUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取Jsqlparser的Column
     * @param tableName
     * @param columnName
     * @return
     */
    public static Column getColumn(String tableName, String columnName) {
        Column column = new Column();
        if (StringUtils.isNotBlank(tableName)) {
            Table table = new Table(tableName);
            column.setTable(table);
        }
        if (StringUtils.isNotBlank(columnName)) {
            column.setColumnName(columnName);
        }
        return column;
    }

    /**
     * 获取Jsqlparser的Column
     * @param tableName
     * @param columnName
     * @return
     */
    public static Column getColumn(String columnName) {
        return getColumn(null, columnName);
    }
}
