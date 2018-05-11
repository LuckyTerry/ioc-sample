package core;

import exception.BeansUndefinedException;

/**
 * @author terry
 * @date 18-5-11
 */
public interface BeanFactory {

    /**
     *
     * @param name
     * @return
     */
    Object getBean(String name) throws BeansUndefinedException;

    /**
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> requiredType);

    /**
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T getBean(String name, Class<T> requiredType);
}
