package com.udemy.spring.springselenium.commonConfig.annotation;

import java.lang.annotation.*;

@Page
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TakeScreenshot {
}
