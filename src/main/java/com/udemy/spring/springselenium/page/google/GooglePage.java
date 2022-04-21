package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.commonConfig.annotation.Page;
import com.udemy.spring.springselenium.page.BasePage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Page
public class GooglePage extends BasePage {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResultComponent searchResultComponent;

    @Value("${application.url}")
    private String url;

    public void goTo() {
        driver.get(url);
    }

    @Override
    public boolean isLoaded() {
        return searchComponent.isLoaded();
    }

    public void close() {
        driver.quit();
    }
}
