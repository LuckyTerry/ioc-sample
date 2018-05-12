package com.terry.sample.ioc.utils;

/**
 * @author terry
 * @date 18-5-11
 */
public class ClassUtils {

    private ClassUtils() {
    }

    /**
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     *
     * @param className
     * @return
     */
    public static Class loadClass(String className) {
        try {
            return getClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
