package com.terry.sample.ioc.utils;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeanUtils {

    private BeanUtils() {
    }

    /**
     *
     * @param clz
     * @param parameterTypes
     * @param values
     * @param <T>
     * @return
     */
    public static <T> T instanceByJdkRefection(Class<T> clz, List<Class> parameterTypes, List<Object> values) {
        try {
            if (parameterTypes == null) {
                return clz.newInstance();
            }
            Constructor<T> constructor = clz.getConstructor(parameterTypes.toArray(new Class[]{}));
            return constructor.newInstance(values.toArray(new Object[]{}));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
