package com.lin.tools.jsqlparser;

import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.schema.Table;

import org.apache.commons.lang.StringUtils;

/**
 * JsqlparserUtils
 * @author linych
 * @version 1.0
 *
 */
public class TableUtils {

    private TableUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param schema schema名
     * @param tableName 表名
     * @param alias 别名
     * @param useAs 是否使用as关键字
     * @return
     */
    private static Table getTable(String schema, String tableName, String alias, boolean useAs) {
        Table table = new Table();
        if (StringUtils.isNotBlank(schema)) {
            table.setSchemaName(schema);
        }
        if (StringUtils.isNotBlank(tableName)) {
            table.setName(tableName);
        }
        if (StringUtils.isNotBlank(alias)) {
            Alias as = new Alias(alias);
            as.setUseAs(useAs);
            table.setAlias(as);
        }
        return table;
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param tableName 表名
     * @param alias 别名
     * @param useAs 是否使用as关键字
     * @return
     */
    public static Table getTableWithAlias(String tableName, String alias, boolean useAs) {
        return getTable(null, tableName, alias, useAs);
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param schema schema名
     * @param tableName 表名
     * @param alias 别名
     * @param useAs 是否使用as关键字
     * @return
     */
    public static Table getTableWithSchema(String schema, String tableName, String alias, boolean useAs) {
        return getTable(schema, tableName, alias, useAs);
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param schema schema名
     * @param tableName 表名
     * @param alias 别名
     * @param useAs 是否使用as关键字
     * @return
     */
    public static Table getTableWithSchema(String schema, String tableName, String alias) {
        return getTable(schema, tableName, alias, true);
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param schema schema名
     * @param tableName 表名
     * @param alias 别名
     * @param useAs 是否使用as关键字
     * @return
     */
    public static Table getTableWithSchema(String schema, String tableName) {
        return getTable(schema, tableName, null, true);
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param tableName 表名
     * @param alias 别名
     *                  默认使用as关键字
     * @return
     */
    public static Table getTableWithAlias(String tableName, String alias) {
        return getTable(null, tableName, alias, true);
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param tableName 表名
     * @return
     */
    public static Table getTable(String tableName) {
        return getTable(null, tableName, null, true);
    }

    /**
     * 获取Jsqlparser中的Table,不适用于Sybase,SqlServer
     * @param schema schema名
     * @param tableName 表名
     * @return
     */
    public static Table getTable(String schema, String tableName) {
        return getTable(schema, tableName, null, true);
    }
}
