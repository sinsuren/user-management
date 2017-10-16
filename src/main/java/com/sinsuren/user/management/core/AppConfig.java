package com.sinsuren.user.management.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * Created by surender.s on 15/10/17.
 */

@Configuration
@EnableTransactionManagement
@PropertySources({
        @PropertySource("classpath:application.yml")})
public class AppConfig {

    @Bean
    public Validator localValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        return bean;
    }
}
