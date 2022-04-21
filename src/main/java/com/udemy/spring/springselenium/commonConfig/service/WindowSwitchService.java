package com.udemy.spring.springselenium.commonConfig.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowSwitchService {

    @Autowired
    private ApplicationContext context;

    public void switchByTitle(final String title) {
        WebDriver driver = context.getBean(WebDriver.class);
        driver.getWindowHandles().stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(t -> t.startsWith(title))
                .findFirst().orElseThrow(() -> new RuntimeException("No such window"));
    }

    public void switchByIndex(final int index) {
        WebDriver driver = context.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }
}
