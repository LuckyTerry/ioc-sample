package com.terry.sample.ioc.definition;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.exception.BeansUndefinedException;
import com.terry.sample.ioc.resource.impl.JsonResourceLoader;
import com.terry.sample.ioc.utils.ClassUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author terry
 * @date 18-5-12
 */
public class DefinitionProviderImpl implements DefinitionProvider {

    private Map<String, BeanDefinition> beanNameMap;

    private Map<Class, List<BeanDefinition>> beanTypeMap;

    public DefinitionProviderImpl() {
        List<BeanDefinition> beanDefinitions = new JsonResourceLoader().loadBeanDefinition();

        this.beanNameMap = beanDefinitions.stream()
                .collect(Collectors.toMap(BeanDefinition::getName, Function.identity()));

        this.beanTypeMap = beanDefinitions.stream()
                .collect(Collectors.groupingBy(o -> ClassUtils.loadClass(o.getClassName())));
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) throws BeansUndefinedException {
        BeanDefinition beanDefinition = beanNameMap.get(name);
        if (beanDefinition == null) {
            throw new BeansUndefinedException();
        }
        return beanDefinition;
    }

    @Override
    public List<BeanDefinition> getBeanDefinition(Class requiredType) throws BeansUndefinedException {
        List<BeanDefinition> beanDefinitions = beanTypeMap.get(requiredType);
        if (beanDefinitions == null) {
            throw new BeansUndefinedException();
        }
        return beanDefinitions;
    }
}
