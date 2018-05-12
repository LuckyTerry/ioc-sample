package com.terry.sample.ioc.initializer;

import com.terry.sample.ioc.bean.BeanDefinition;

/**
 * @author terry
 * @date 18-5-11
 */
public interface BeanInitializer {

    /**
     *
     * @param beanDefinition
     * @return
     */
    Object initial(BeanDefinition beanDefinition);

    /**
     *
     * @param beanDefinition
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T initial(BeanDefinition beanDefinition, Class<T> requiredType);
}
