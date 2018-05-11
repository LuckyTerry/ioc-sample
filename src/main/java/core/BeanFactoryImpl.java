package core;

import exception.BeansUndefinedException;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeanFactoryImpl implements BeanFactory {

    public Object getBean(String name) throws BeansUndefinedException {
        return null;
    }

    public <T> T getBean(Class<T> requiredType) {
        return null;
    }

    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }
}
