package com.terry.sample.ioc.initializer;

import com.terry.sample.ioc.bean.BeanDefinition;

/**
 * @author terry
 * @date 18-5-12
 */
public class CglibReflectionBeanInitializer implements BeanInitializer {

    @Override
    public Object initial(BeanDefinition beanDefinition) {
        return null;
    }

    @Override
    public <T> T initial(BeanDefinition beanDefinition, Class<T> requiredType) {
        return null;
    }
}
