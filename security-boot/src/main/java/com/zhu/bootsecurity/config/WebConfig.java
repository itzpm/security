package com.zhu.bootsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zpm
 * @version 1.0
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String[] RESOURCE_HANDLERS = {"/templates/**", "/META-INF/resources/**",
            "/resources/**", "/static/**", "/public/**"};

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/templates/", "classpath:/META-INF/resources/",
            "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
