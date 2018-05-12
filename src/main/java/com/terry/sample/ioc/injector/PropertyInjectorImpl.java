package com.terry.sample.ioc.injector;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.bean.PropertyArg;
import com.terry.sample.ioc.core.BeanFactory;
import com.terry.sample.ioc.exception.BeansUndefinedException;
import com.terry.sample.ioc.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author terry
 * @date 18-5-12
 */
public class PropertyInjectorImpl implements PropertyInjector {

    private BeanFactory beanFactory;

    public PropertyInjectorImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void injectProperty(Object obj, BeanDefinition beanDefinition) throws BeansUndefinedException {
        List<PropertyArg> propertyArgs = beanDefinition.getPropertyArgs();
        if (propertyArgs != null) {
            Map<String, PropertyArg> propertyArgMap = propertyArgs.stream()
                    .collect(Collectors.toMap(PropertyArg::getName, Function.identity()));
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            inject(obj, propertyArgMap, declaredFields);
        }
    }

    @Override
    public <T> void injectProperty(T obj, Class<T> requiredType, BeanDefinition beanDefinition) throws BeansUndefinedException {
        List<PropertyArg> propertyArgs = beanDefinition.getPropertyArgs();
        if (propertyArgs != null) {
            Map<String, PropertyArg> propertyArgMap = propertyArgs.stream()
                    .collect(Collectors.toMap(PropertyArg::getName, Function.identity()));
            Field[] declaredFields = requiredType.getDeclaredFields();
            inject(obj, propertyArgMap, declaredFields);
        }
    }

    private void inject(Object obj, Map<String, PropertyArg> propertyArgMap, Field[] declaredFields) throws BeansUndefinedException {
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field declaredField : declaredFields) {
                String name = declaredField.getName();
                PropertyArg propertyArg = propertyArgMap.get(name);
                if (propertyArg != null) {
                    Object value = propertyArg.getValue();
                    if (value != null) {
                        ReflectionUtils.fieldInjection(declaredField, obj, value);
                    } else {
                        ReflectionUtils.fieldInjection(declaredField, obj, beanFactory.getBean(propertyArg.getReference()));
                    }
                }
            }
        }
    }
}
