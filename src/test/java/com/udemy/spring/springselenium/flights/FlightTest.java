package com.udemy.spring.springselenium.flights;

import com.udemy.spring.springselenium.SpringBaseTestNG;
import com.udemy.spring.springselenium.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNG {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails flightAppDetails;

    @Test
    public void flightTest() {
        flightPage.goTo(flightAppDetails.getUrl());
        Assert.assertTrue(flightPage.isLoaded());
        Assert.assertEquals(flightPage.getLabels(), flightAppDetails.getLabels());
        flightPage.close();
    }
}
