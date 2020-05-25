package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }

    @Bean
    public ItemService itemService() {
        return new SimpleItemService();
    }

    @Bean
    public SimpleItemService simpleItemServiceWithConstructor() {
        return new SimpleItemService(itemService(), itemValidator());
    }

    @Bean
    public SimpleItemService simpleItemServiceWithSetters() {
        SimpleItemService simpleItemService = new SimpleItemService();
        simpleItemService.setItemValidator(itemValidator());
        simpleItemService.setItemService(itemService());
        return simpleItemService;
    }
}
