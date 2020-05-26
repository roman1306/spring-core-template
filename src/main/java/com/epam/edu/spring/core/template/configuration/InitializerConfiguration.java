package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class InitializerConfiguration {
    @Bean
    @Scope("prototype")
    public Color color() {
        Color[] colors = Color.values();
        return colors[new Random().nextInt(colors.length)];
}

    @Bean
    @Lazy
    public ColorFactory colorFactory() {
        return new ColorFactory() {
            @Override
            public Color getColor() {
                return color();
            }
        };
    }
}
