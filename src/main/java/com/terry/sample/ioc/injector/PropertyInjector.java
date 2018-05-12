package com.terry.sample.ioc.injector;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.exception.BeansUndefinedException;

/**
 * @author terry
 * @date 18-5-12
 */
public interface PropertyInjector {

    /**
     *
     * @param obj
     * @param beanDefinition
     */
    void injectProperty(Object obj, BeanDefinition beanDefinition) throws BeansUndefinedException;

    /**
     *
     * @param obj
     * @param requiredType
     * @param beanDefinition
     * @param <T>
     */
    <T> void injectProperty(T obj, Class<T> requiredType, BeanDefinition beanDefinition) throws BeansUndefinedException;
}
