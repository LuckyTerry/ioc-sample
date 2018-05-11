package cache;

import exception.BeansReplicatedException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeanCacheImpl implements BeanCache {

    private Map<String, Object> cache = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return cache.get(name);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansReplicatedException {
        List<T> collect = cache.values().stream()
                .filter(requiredType::isInstance)
                .map(requiredType::cast)
                .collect(Collectors.toList());
        if (collect.size() != 1) {
            throw new BeansReplicatedException();
        }
        return collect.get(0);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return requiredType.cast(cache.get(name));
    }
}
