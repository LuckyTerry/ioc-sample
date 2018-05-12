package com.terry.sample.ioc.exception;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeansException extends Exception {

    private static final long serialVersionUID = -6311838359939224718L;

    public BeansException() {
        super("Beans错误");
    }

    public BeansException(String message) {
        super(message);
    }
}
