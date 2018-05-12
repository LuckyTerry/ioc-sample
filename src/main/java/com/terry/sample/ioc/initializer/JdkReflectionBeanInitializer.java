package com.terry.sample.ioc.initializer;

import com.terry.sample.ioc.bean.BeanDefinition;
import com.terry.sample.ioc.bean.ConstructorArg;
import com.terry.sample.ioc.utils.BeanUtils;
import com.terry.sample.ioc.utils.ClassUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author terry
 * @date 18-5-11
 */
public class JdkReflectionBeanInitializer implements BeanInitializer {

    @Override
    public Object initial(BeanDefinition beanDefinition) {
        String className = beanDefinition.getClassName();

        Class clz = ClassUtils.loadClass(className);

        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs == null) {
            return BeanUtils.instanceByJdkRefection(clz, null, null);
        }

        List<Class> parameterTypes = constructorArgs.stream()
                .map(ConstructorArg::getValue)
                .map(Object::getClass)
                .collect(Collectors.toList());

        List<Object> values = constructorArgs.stream()
                .map(ConstructorArg::getValue)
                .collect(Collectors.toList());

        return BeanUtils.instanceByJdkRefection(clz, parameterTypes, values);
    }

    @Override
    public <T> T initial(BeanDefinition beanDefinition, Class<T> requiredType) {
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();

        List<Class> parameterTypes = constructorArgs.stream()
                .map(constructorArg -> ClassUtils.loadClass(constructorArg.getValue().getClass().getName()))
                .collect(Collectors.toList());

        List<Object> values = constructorArgs.stream()
                .map(ConstructorArg::getValue)
                .collect(Collectors.toList());

        return BeanUtils.instanceByJdkRefection(requiredType, parameterTypes, values);
    }
}
