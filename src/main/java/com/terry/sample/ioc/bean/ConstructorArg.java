package com.terry.sample.ioc.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author terry
 * @date 18-5-11
 */
@Data
@ToString
public class ConstructorArg {

    private int index;

    private String name;

    private Object value;

    private String reference;
}
