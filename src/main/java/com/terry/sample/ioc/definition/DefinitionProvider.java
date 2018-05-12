package com.terry.sample.ioc.definition;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.exception.BeansUndefinedException;

import java.util.List;

/**
 * @author terry
 * @date 18-5-12
 */
public interface DefinitionProvider {

    /**
     *
     * @param name
     * @return
     * @throws
     */
    BeanDefinition getBeanDefinition(String name) throws BeansUndefinedException;

    /**
     *
     * @param requiredType
     * @return
     * @throws
     */
    List<BeanDefinition> getBeanDefinition(Class requiredType) throws BeansUndefinedException;
}
