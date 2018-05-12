package com.terry.sample.ioc.cache;

import com.terry.sample.ioc.exception.BeansReplicatedException;
import com.terry.sample.ioc.exception.BeansUndefinedException;
import com.terry.sample.ioc.exception.TypePluralException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author terry
 * @date 18-5-11
 */
public class BeanCacheImpl implements BeanCache {

    private Map<String, Object> cache = new ConcurrentHashMap<>();

    @Override
    public void saveBean(String name, Object bean) {
        cache.putIfAbsent(name, bean);
    }

    @Override
    public Object getBean(String name) {
        return cache.get(name);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws TypePluralException {
        List<T> collect = cache.values().stream()
                .filter(requiredType::isInstance)
                .map(requiredType::cast)
                .collect(Collectors.toList());
        if (collect.size() == 0) {
            return null;
        }
        if (collect.size() > 1) {
            throw new TypePluralException();
        }
        return collect.get(0);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return requiredType.cast(cache.get(name));
    }
}
