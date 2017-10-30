package com.nsa.charitystarter.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RequestRouter extends WebMvcConfigurerAdapter {

    //add this class to map URLs to static pages.
    //just add a line for each page URL
    //no need to do this for APIs.

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/charity/**").setViewName("forward:/charity.html");
    }
}