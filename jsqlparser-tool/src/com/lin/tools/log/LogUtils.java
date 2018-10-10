package com.lin.tools.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogUtils
 * @author linych
 * @version 1.0
 *
 */
public final class LogUtils {

    /**
     * 构造器
     */
    private LogUtils() {
        throw new AssertionError("no instance for you!");
    }

    /**
     * 获得Logger
     * @return
     */
    public static Logger getLogger() {
        Throwable throwable = new Throwable();
        StackTraceElement stackTraceElement = throwable.getStackTrace()[1];
        String className = stackTraceElement.getClassName();
        return LoggerFactory.getLogger(className);
    }
}
