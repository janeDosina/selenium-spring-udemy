package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.commonConfig.annotation.PageFragment;
import com.udemy.spring.springselenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResultComponent extends BasePage {

    @FindBy(css = "#rso>div")
    private List<WebElement> results;

    public int getResultsCount() {
        return results.size();
    }

    @Override
    public boolean isLoaded() {
        return webDriverWait.until(dr -> !results.isEmpty());
    }
}
