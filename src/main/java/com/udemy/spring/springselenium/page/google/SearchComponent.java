package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.commonConfig.annotation.PageFragment;
import com.udemy.spring.springselenium.page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public void search(final String keyword) {
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.TAB);
        searchBtns.stream()
                .filter(el -> el.isDisplayed() && el.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isLoaded() {
        return webDriverWait.until(dr -> searchBox.isDisplayed());
    }
}
