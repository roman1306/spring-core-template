package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleItemService implements ItemService {
    private ItemService itemService;
    private ItemValidator itemValidator;

    @Autowired
    public ItemRepository itemRepository;

    public SimpleItemService() {
    }

    public SimpleItemService(ItemService itemService, ItemValidator itemValidator) {
        this.itemService = itemService;
        this.itemValidator = itemValidator;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public ItemValidator getItemValidator() {
        return itemValidator;
    }

    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return itemRepository.createItem(item);
    }
}
