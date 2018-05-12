package com.terry.sample.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
@Data
@ToString
public class BeanDefinition {

    private String name;

    private String className;

    private String interfaceName;

    private List<ConstructorArg> constructorArgs;

    private List<PropertyArg> propertyArgs;
}
