package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.epam.edu.spring.core.template.repository")
public class RepositoryConfiguration {
    @Value("${item.repository.implementation}")
    private String itemRepositoryImplementation;

    @Bean
    public ItemRepository itemRepository(ArrayListItemRepository arrayListItemRepository,
                                  LinkedListItemRepository linkedListItemRepository) {
        if (itemRepositoryImplementation.equalsIgnoreCase("linked")) {
            return linkedListItemRepository;
        } else {
            return arrayListItemRepository;
        }
    }
}
