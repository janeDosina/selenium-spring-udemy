package com.udemy.spring.springselenium.window;

import com.udemy.spring.springselenium.SpringBaseTestNG;
import com.udemy.spring.springselenium.page.window.MainPage;
import com.udemy.spring.springselenium.page.window.PageA;
import com.udemy.spring.springselenium.page.window.PageB;
import com.udemy.spring.springselenium.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WindowSwitchTest extends SpringBaseTestNG {

    @Autowired
    private MainPage mainPage;
    @Autowired
    private PageA pageA;
    @Autowired
    private PageB pageB;
    @Autowired
    private PageC pageC;

    @BeforeClass
    public void setUp() {
        mainPage.goTo();
        mainPage.isLoaded();
        mainPage.lunchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index) {
        pageA.addToArea(index + "\n");
        pageB.addToArea((index * 2) + "\n");
        pageC.addToArea((index * 3) + "\n");
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {1},{2},{3},{4},{5},{6},{7},{8}
        };
    }
}
