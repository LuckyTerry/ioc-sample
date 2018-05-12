package com.terry.sample.ioc.utils;

import java.io.InputStream;

/**
 * @author terry
 * @date 18-5-12
 */
public class ResourceUtils {

    private ResourceUtils() {
    }

    /**
     *
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path) {
        return ClassUtils.getClassLoader().getResourceAsStream(path);
    }
}
