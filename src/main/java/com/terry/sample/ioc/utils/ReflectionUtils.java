package com.terry.sample.ioc.utils;

import java.lang.reflect.Field;

/**
 * @author terry
 * @date 18-5-11
 */
public class ReflectionUtils {

    private ReflectionUtils() {
    }

    /**
     *
     * @param field
     * @param obj
     * @param value
     */
    public static void fieldInjection(Field field, Object obj, Object value) {
        if(field != null) {
            field.setAccessible(true);
            try {
                field.set(obj, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
