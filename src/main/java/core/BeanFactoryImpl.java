package core;

import exception.BeanUndefinedException;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeanFactoryImpl implements BeanFactory {

    public Object getBean(String name) throws BeanUndefinedException {
        return null;
    }

    public <T extends Class<T>> T getBean(T t) {
        return null;
    }

    public <T extends Class<T>> T getBean(String name, T t) {
        return null;
    }
}
