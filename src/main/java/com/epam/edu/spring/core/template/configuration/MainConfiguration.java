package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.annotation.RandomIntAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfiguration.class, InitializerConfiguration.class,
        RandomIntAnnotationBeanPostProcessor.class, ServiceConfiguration.class})
public class MainConfiguration {
}
