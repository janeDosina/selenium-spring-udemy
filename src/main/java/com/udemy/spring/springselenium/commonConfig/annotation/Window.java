package com.udemy.spring.springselenium.commonConfig.annotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

@Page
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Window {
    String value() default StringUtils.EMPTY;
}
