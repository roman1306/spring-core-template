package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(InitializerConfiguration.class)
class InitializerConfigurationTest {
    @Autowired
    AbstractApplicationContext context;

    @Autowired(required = false)
    Color color;

    @Autowired(required = false)
    ColorFactory colorFactory;

    @Autowired(required = false)
    ColorFactory colorFactory2;

    @Nested
    @SpringJUnitConfig(InitializerConfiguration.class)
    class CreateInitializerBeanTest{
        @Test
        void testCreateColor() {
            assertNotNull(color);
        }

        @Test
        void testCreateColorFactory() {
            assertNotNull(colorFactory);
        }
    }

    @Nested
    @SpringJUnitConfig(InitializerConfiguration.class)
    class ScopeInitializerBeanTest{
        @Test
        void testBeanColorFactoryIsSingleton() {
            assertEquals(colorFactory, context.getBean("colorFactory"));
        }

        @Test
        void testBeanColorIsPrototype() {
            ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
            assertEquals("prototype", beanFactory.getBeanDefinition("color").getScope());
        }
    }

}