package resource;

import bean.BeanDefinition;

import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
public interface ResourceLoader {

    /**
     *
     * @param classPath
     * @return
     */
    List<BeanDefinition> loadBeanDefinition(String classPath);
}
