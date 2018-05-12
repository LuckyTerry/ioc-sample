package com.terry.sample.ioc.resource;

import com.terry.sample.ioc.bean.BeanDefinition;

import java.util.List;
import java.util.Map;

/**
 * @author terry
 * @date 18-5-11
 */
public interface ResourceLoader {

    /**
     *
     * @return
     */
    List<BeanDefinition> loadBeanDefinition();
}
