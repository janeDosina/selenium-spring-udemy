package com.udemy.spring.springselenium.page.flights;

import com.udemy.spring.springselenium.commonConfig.annotation.Page;
import com.udemy.spring.springselenium.commonConfig.annotation.TakeScreenshot;
import com.udemy.spring.springselenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends BasePage {

    @FindBy(css = "nav>div>a")
    private List<WebElement> navElements;

    public void goTo(final String url) {
        driver.get(url);
    }

    @TakeScreenshot
    public List<String> getLabels() {
        return navElements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isLoaded() {
        return webDriverWait.until(e -> !navElements.isEmpty());
    }

    public void close() {
        driver.quit();
    }
}
