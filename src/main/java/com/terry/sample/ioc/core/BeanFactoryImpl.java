package com.terry.sample.ioc.core;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.cache.BeanCache;
import com.terry.sample.ioc.cache.BeanCacheImpl;
import com.terry.sample.ioc.definition.DefinitionProvider;
import com.terry.sample.ioc.definition.DefinitionProviderImpl;
import com.terry.sample.ioc.exception.BeansUndefinedException;
import com.terry.sample.ioc.exception.TypePluralException;
import com.terry.sample.ioc.initializer.BeanInitializer;
import com.terry.sample.ioc.initializer.JdkReflectionBeanInitializer;
import com.terry.sample.ioc.injector.PropertyInjector;
import com.terry.sample.ioc.injector.PropertyInjectorImpl;

import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeanFactoryImpl implements BeanFactory {

    private BeanCache beanCache;

    private DefinitionProvider definitionProvider;

    private BeanInitializer beanInitializer;

    private PropertyInjector propertyInjector;

    public BeanFactoryImpl() {
        this.beanCache = new BeanCacheImpl();
        this.definitionProvider = new DefinitionProviderImpl();
        this.beanInitializer = new JdkReflectionBeanInitializer();
        this.propertyInjector = new PropertyInjectorImpl(this);
    }

    public void setBeanCache(BeanCache beanCache) {
        this.beanCache = beanCache;
    }

    public void setDefinitionProvider(DefinitionProvider definitionProvider) {
        this.definitionProvider = definitionProvider;
    }

    public void setBeanInitializer(BeanInitializer beanInitializer) {
        this.beanInitializer = beanInitializer;
    }

    public void setPropertyInjector(PropertyInjector propertyInjector) {
        this.propertyInjector = propertyInjector;
    }

    @Override
    public Object getBean(String name) throws BeansUndefinedException {
        // 返回缓存
        Object cachedBean = beanCache.getBean(name);
        if (cachedBean != null) {
            return cachedBean;
        }
        // Bean定义
        BeanDefinition beanDefinition = definitionProvider.getBeanDefinition(name);
        // 实例化Bean
        Object newBean = beanInitializer.initial(beanDefinition);
        // Bean属性注入
        propertyInjector.injectProperty(newBean, beanDefinition);
        // 保存缓存
        beanCache.saveBean(name, newBean);
        // 返回bean
        return newBean;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansUndefinedException, TypePluralException {
        // 返回缓存
        T cachedBean = beanCache.getBean(requiredType);
        if (cachedBean != null) {
            return cachedBean;
        }
        // Bean定义
        List<BeanDefinition> beanDefinitions = definitionProvider.getBeanDefinition(requiredType);
        if (beanDefinitions.size() > 1) {
            throw new TypePluralException();
        }
        // 实例化Bean
        T newBean = beanInitializer.initial(beanDefinitions.get(0), requiredType);
        // Bean属性注入
        propertyInjector.injectProperty(newBean, requiredType, beanDefinitions.get(0));
        // 保存缓存
        beanCache.saveBean(beanDefinitions.get(0).getName(), newBean);
        // 返回bean
        return newBean;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansUndefinedException {
        // 返回缓存
        T cachedBean = beanCache.getBean(name, requiredType);
        if (cachedBean != null) {
            return cachedBean;
        }
        // Bean定义
        BeanDefinition beanDefinition = definitionProvider.getBeanDefinition(name);
        // 实例化Bean
        T newBean = beanInitializer.initial(beanDefinition, requiredType);
        // Bean属性注入
        propertyInjector.injectProperty(newBean, requiredType, beanDefinition);
        // 保存缓存
        beanCache.saveBean(name, newBean);
        // 返回bean
        return newBean;
    }
}
