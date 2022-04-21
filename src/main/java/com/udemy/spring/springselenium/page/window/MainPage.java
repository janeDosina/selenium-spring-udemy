package com.udemy.spring.springselenium.page.window;

import com.udemy.spring.springselenium.commonConfig.annotation.Page;
import com.udemy.spring.springselenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Page
public class MainPage extends BasePage {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    @Value("https://vins-udemy.s3.amazonaws.com/ds/window/main.html")
    private String url;

    public void goTo() {
        driver.get(url);
    }

    public void lunchAllWindows() {
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(i + 2));
        }
    }

    @Override
    public boolean isLoaded() {
        return webDriverWait.until(e -> !links.isEmpty());
    }
}
