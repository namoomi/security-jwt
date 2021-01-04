package com.example.security.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    private static final String[] CLASS_RESOURCE_LOCATIONS={
            "classpath:/static/", "classpath:/public/", "classpath:/",
            "classpath:/resources/", "classpath:/META-INF/resources/"
    };

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 강제로 이동
        registry.addViewController("/").setViewName("forward:/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASS_RESOURCE_LOCATIONS);
    }
}
