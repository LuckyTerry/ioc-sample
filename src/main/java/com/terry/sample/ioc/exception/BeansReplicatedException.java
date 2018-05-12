package com.terry.sample.ioc.exception;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeansReplicatedException extends BeansException {

    private static final long serialVersionUID = -1258162543963863907L;

    public BeansReplicatedException() {
        super("Beans重复定义");
    }
}
