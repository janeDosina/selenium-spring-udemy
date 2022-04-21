package com.udemy.spring.springselenium.page.window;

import com.udemy.spring.springselenium.commonConfig.annotation.Window;
import com.udemy.spring.springselenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page A")
public class PageA extends BasePage {

    @FindBy(id = "area")
    private WebElement textArea;
    
    public void addToArea(final String message) {
        textArea.sendKeys(message);
    }

    @Override
    public boolean isLoaded() {
        return webDriverWait.until(e -> textArea.isDisplayed());
    }
}
