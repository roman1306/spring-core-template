package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig({ServiceConfiguration.class, RepositoryConfiguration.class})
class ServiceConfigurationTest {

    @Autowired(required = false)
    @Qualifier("simpleItemServiceWithConstructor")
    SimpleItemService simpleItemServiceWithConstructor;

    @Autowired(required = false)
    @Qualifier("simpleItemServiceWithSetters")
    SimpleItemService simpleItemServiceWithSetters;

    @Nested
    @SpringJUnitConfig({ServiceConfiguration.class, RepositoryConfiguration.class})
    class CreateServiceBeanTest {
        @Test
        void testCreateSimpleItemServiceWithConstructor() {
            assertNotNull(simpleItemServiceWithConstructor);
        }

        @Test
        void testCreateSimpleItemServiceWithSetters() {
            assertNotNull(simpleItemServiceWithSetters);
        }
    }


}