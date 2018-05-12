package com.terry.sample.ioc.resource.impl;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.resource.ResourceLoader;
import com.terry.sample.ioc.utils.JsonUtils;
import com.terry.sample.ioc.utils.ResourceUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
public class JsonResourceLoader implements ResourceLoader {

    private static final String APPLICATION_JSON = "application.json";

    @Override
    public List<BeanDefinition> loadBeanDefinition() {
        InputStream inputStream = ResourceUtils.getResourceAsStream(APPLICATION_JSON);
        return JsonUtils.readValue(inputStream, BeanDefinition.class);
    }
}
