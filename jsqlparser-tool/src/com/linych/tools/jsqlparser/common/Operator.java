package com.linych.tools.jsqlparser.common;

/**
 * Operator
 * @author linych
 * @version 1.0
 *
 */
public class Operator {
    
    private Operator(){
        throw new IllegalStateException("Utility class");
    }
    
    public static final int OR = 0;

    public static final int AND = 1;
}
