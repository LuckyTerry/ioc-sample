package com.terry.sample.ioc.exception;

/**
 * @author terry
 * @date 18-5-12
 */
public class TypePluralException extends BeansException {

    public TypePluralException() {
        super("该类型有多个Bean");
    }

    public TypePluralException(String message) {
        super(message);
    }
}
