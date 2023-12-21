package org.example.food.truck.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * ApplicationContextHolder
 *
 * @author chensheng
 **/
@Configuration
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        applicationContext = appContext;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        checkApplicationContext();
        return applicationContext.getBean(name, clazz);
    }

    public static <T> T getBean(Class<T> clazz) {
        Map<String, T> beanMaps = getBeans(clazz);
        return !CollectionUtils.isEmpty(beanMaps) ? beanMaps.values().iterator().next() : null;
    }

    public static <T> Map<String, T> getBeans(Class<T> clazz) {
        checkApplicationContext();
        return applicationContext.getBeansOfType(clazz);
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext未注入");
        }
    }
}
