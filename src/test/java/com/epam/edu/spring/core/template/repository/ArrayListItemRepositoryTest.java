package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListItemRepositoryTest {
    private static ArrayListItemRepository arrayListItemRepository;
    private static Item item;

    @BeforeAll
    static void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryConfiguration.class);
        arrayListItemRepository = context.getBean("arrayListItemRepository", ArrayListItemRepository.class);
        item = new Item(1, "Axe", 25.5, Color.BLUE);
    }

    @Test
    public void testCreateItem() {
        arrayListItemRepository.createItem(item);
        assertEquals(item, arrayListItemRepository.holder.get(0));
    }

    @Test
    public void testCreateItemNull() {
        assertFalse(arrayListItemRepository.createItem(null));
    }

    @Test
    public void testGetById() {
        arrayListItemRepository.holder.add(item);
        assertEquals(item, arrayListItemRepository.getById(1));
    }

    @Test
    public void testGetByIdNotFound() {
        arrayListItemRepository.createItem(item);
        assertNull(arrayListItemRepository.getById(2));
    }

    @Test
    public void testGetByIdHolderIsEmpty() {
        assertNull(arrayListItemRepository.getById(1));
    }
}