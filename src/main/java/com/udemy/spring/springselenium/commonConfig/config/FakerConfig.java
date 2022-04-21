package com.udemy.spring.springselenium.commonConfig.config;

import com.github.javafaker.Faker;
import com.udemy.spring.springselenium.commonConfig.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
