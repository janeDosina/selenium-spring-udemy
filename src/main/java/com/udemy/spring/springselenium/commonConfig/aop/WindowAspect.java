package com.udemy.spring.springselenium.commonConfig.aop;

import com.udemy.spring.springselenium.commonConfig.annotation.Window;
import com.udemy.spring.springselenium.commonConfig.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.udemy.spring.springselenium..*)")
    public void before(Window window) {
        switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.udemy.spring.springselenium..*)")
    public void after(Window window) {
        switchService.switchByIndex(0);
    }
}
