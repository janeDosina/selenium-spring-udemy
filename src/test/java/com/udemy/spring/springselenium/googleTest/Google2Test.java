package com.udemy.spring.springselenium.googleTest;

import com.udemy.spring.springselenium.SpringBaseTestNG;
import com.udemy.spring.springselenium.commonConfig.annotation.LazyAutowired;
import com.udemy.spring.springselenium.commonConfig.service.ScreenshotService;
import com.udemy.spring.springselenium.page.google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNG {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenShotUtil;

    @Test
    public void google2Test() throws IOException {
        googlePage.goTo();
        Assert.assertTrue(googlePage.isLoaded());

        googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(googlePage.getSearchResultComponent().isLoaded());
        Assert.assertTrue(googlePage.getSearchResultComponent().getResultsCount() > 2);
        screenShotUtil.takeScreenShot();
        googlePage.close();
    }
}
