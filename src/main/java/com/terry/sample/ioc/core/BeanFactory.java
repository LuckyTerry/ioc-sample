package com.terry.sample.ioc.core;

import com.terry.sample.ioc.exception.BeansReplicatedException;
import com.terry.sample.ioc.exception.BeansUndefinedException;
import com.terry.sample.ioc.exception.TypePluralException;

/**
 * @author terry
 * @date 18-5-11
 */
public interface BeanFactory {

    /**
     *
     * @param name
     * @return
     */
    Object getBean(String name) throws BeansUndefinedException;

    /**
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> requiredType) throws BeansUndefinedException, TypePluralException;

    /**
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansUndefinedException;
}
