package org.sakaiproject.oidc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.Setter;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    @Setter
    private ApplicationContext applicationContext;
}
