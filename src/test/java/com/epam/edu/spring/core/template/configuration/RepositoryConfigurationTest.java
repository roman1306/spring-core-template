package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(RepositoryConfiguration.class)
class RepositoryConfigurationTest {

    @Autowired(required = false)
    ArrayListItemRepository arrayListItemRepository;

    @Autowired(required = false)
    LinkedListItemRepository linkedListItemRepository;

    @Autowired(required = false)
    @Qualifier("itemRepository")
    ItemRepository itemRepository;

    @Nested
    @SpringJUnitConfig(RepositoryConfiguration.class)
    class CreateRepositoryBeanTest {
        @Test
        void testCreateArrayListItemRepository() {
            assertNotNull(arrayListItemRepository);
        }

        @Test
        void testCreateLinkedListItemRepository() {
            assertNotNull(linkedListItemRepository);
        }

        @Test
        void testCreateImplementsItemRepository() {
            assertNotNull(itemRepository);
        }
    }
}