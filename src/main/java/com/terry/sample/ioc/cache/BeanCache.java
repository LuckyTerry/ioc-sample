package com.terry.sample.ioc.cache;

import com.terry.sample.ioc.exception.TypePluralException;

/**
 * @author terry
 * @date 18-5-11
 */
public interface BeanCache {

    /**
     *
     * @param name
     * @param bean
     */
    void saveBean(String name, Object bean);

    /**
     * @param name
     * @return
     */
    Object getBean(String name);

    /**
     * @param requiredType
     * @param <T>
     * @return
     * @throws
     */
    <T> T getBean(Class<T> requiredType) throws TypePluralException;

    /**
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T getBean(String name, Class<T> requiredType);
}
