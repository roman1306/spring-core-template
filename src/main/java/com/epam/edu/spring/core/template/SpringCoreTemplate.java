package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

        ItemRepository itemRepository = context.getBean("itemRepository", ItemRepository.class);
        System.out.println(itemRepository);

        for (int i = 0; i < 3; i++) {
            Color color1 = context.getBean("colorFactory", ColorFactory.class).getColor();
            Color color2 = context.getBean("colorFactory", ColorFactory.class).getColor();
            System.out.println(color1 + " " + color2 + " " + (color1.equals(color2)));
        }

		System.out.println(context.getBean("simpleItemServiceWithConstructor"));
        System.out.println(context.getBean("simpleItemServiceWithSetters"));
    }
}
