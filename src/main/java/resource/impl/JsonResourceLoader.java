package resource.impl;

import bean.BeanDefinition;
import resource.ResourceLoader;
import utils.ClassUtils;
import utils.JsonUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @author terry
 * @date 18-5-11
 */
public class JsonResourceLoader implements ResourceLoader {

    @Override
    public List<BeanDefinition> loadBeanDefinition(String classPath) {
        InputStream inputStream = ClassUtils.getClassLoader()
                .getResourceAsStream(classPath);
        return JsonUtils.readValue(inputStream, BeanDefinition.class);
    }
}
