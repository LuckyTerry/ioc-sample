package com.terry.sample.ioc.utils;

import com.terry.sample.ioc.bean.BeanDefinition;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
public class XmlUtils {

    private XmlUtils() {
    }

    public static List<BeanDefinition> readValue(InputStream inputStream, Class<BeanDefinition> requiredType) {
        return Collections.emptyList();
    }
}
