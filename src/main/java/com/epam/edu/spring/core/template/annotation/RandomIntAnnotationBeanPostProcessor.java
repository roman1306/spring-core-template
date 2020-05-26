package com.epam.edu.spring.core.template.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class RandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(RandomInt.class)) {
                RandomInt annotation = field.getAnnotation(RandomInt.class);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, getRandomInt(annotation));
            }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RandomInt.class)) {
                RandomInt annotation = method.getAnnotation(RandomInt.class);
                method.setAccessible(true);
                ReflectionUtils.invokeMethod(method, bean, getRandomInt(annotation));
            }
        }

        return bean;
    }

    private int getRandomInt(RandomInt annotation) {
        int min = annotation.min();
        int max = annotation.max();
        return min + new Random().nextInt(max - min);
    }
}
