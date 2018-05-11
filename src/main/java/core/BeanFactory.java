package core;

import exception.BeanUndefinedException;

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
    Object getBean(String name) throws BeanUndefinedException;

    /**
     *
     * @param t
     * @param <T>
     * @return
     */
    <T extends Class<T>> T getBean(T t);

    /**
     *
     * @param name
     * @param t
     * @param <T>
     * @return
     */
    <T extends Class<T>> T getBean(String name, T t);
}
