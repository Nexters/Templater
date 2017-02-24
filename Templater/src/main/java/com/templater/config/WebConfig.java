package com.templater.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	private static final String[] RESOURCE_LOCATIONS = {
	        "classpath:/resources/","classpath:/static/","classpath:/static/web/"
	        };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("web config");
        registry
        .addResourceHandler("/**")
        .addResourceLocations(RESOURCE_LOCATIONS)
        .setCachePeriod(0)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
    }
}