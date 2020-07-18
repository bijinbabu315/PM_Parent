package com.sba.pm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@PropertySource({"classpath:${spring.profiles.active}/application.properties"})
public class Config extends WebMvcConfigurationSupport{

}
