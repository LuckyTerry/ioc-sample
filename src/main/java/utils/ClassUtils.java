package utils;

/**
 * @author terry
 * @date 18-5-11
 */
public class ClassUtils {

    private ClassUtils() {
    }

    /**
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
}
