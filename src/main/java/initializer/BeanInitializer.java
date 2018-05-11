package initializer;

/**
 * @author terry
 * @date 18-5-11
 */
public interface BeanInitializer {

    Object initial();

    <T> T initial(Class<T> requiredType);
}
