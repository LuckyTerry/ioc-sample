package cache;

import exception.BeansReplicatedException;

/**
 * @author terry
 * @date 18-5-11
 */
public interface BeanCache {

    /**
     * @param name
     * @return
     */
    Object getBean(String name);

    /**
     * @param requiredType
     * @param <T>
     * @return
     * @throws
     */
    <T> T getBean(Class<T> requiredType) throws BeansReplicatedException;

    /**
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> T getBean(String name, Class<T> requiredType);
}
