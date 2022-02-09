package com.hubo.cloud.util;


import java.util.Collection;
import java.util.Map;

public class AssertUtils {

    public static void state(boolean expression, String message) {
        org.springframework.util.Assert.state(expression,message);
    }

    public static void isTrue(boolean expression, String message) {
        org.springframework.util.Assert.isTrue(expression,message);
    }

    public static void isNull(Object object, String message) {
        org.springframework.util.Assert.isNull(object,message);
    }

    public static void notNull(Object object, String message) {
        org.springframework.util.Assert.notNull(object,message);
    }

    public static void notEmpty(Object[] array, String message) {
        org.springframework.util.Assert.notEmpty(array,message);
    }


    public static void notEmpty(Collection<?> collection, String message) {
        org.springframework.util.Assert.notEmpty(collection,message);
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        org.springframework.util.Assert.notEmpty(map,message);
    }
}
