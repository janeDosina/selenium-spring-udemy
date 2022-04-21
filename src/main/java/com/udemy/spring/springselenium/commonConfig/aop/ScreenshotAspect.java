package com.udemy.spring.springselenium.commonConfig.aop;

import com.udemy.spring.springselenium.commonConfig.annotation.TakeScreenshot;
import com.udemy.spring.springselenium.commonConfig.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        screenshotService.takeScreenShot();
    }
}
