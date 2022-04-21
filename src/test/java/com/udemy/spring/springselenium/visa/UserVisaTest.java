package com.udemy.spring.springselenium.visa;

import com.udemy.spring.springselenium.SpringBaseTestNG;
import com.udemy.spring.springselenium.entity.User;
import com.udemy.spring.springselenium.page.visa.VisaRegistrationPage;
import com.udemy.spring.springselenium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;

public class UserVisaTest extends SpringBaseTestNG {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VisaRegistrationPage registrationPage;

    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Test
    public void userVisaTestByFirstName() {
        List<User> users = userRepository.findByFirstNameStartingWith("Mi").stream()
                .limit(3).toList();

        users.forEach(user -> {
            registrationPage.goTo();
            registrationPage.setNames(user.getFirstName(), user.getLastName());
            registrationPage.setFromToCountry(user.getFromCountry(), user.getToCountry());
            registrationPage.setBirthDate(user.getDob().toLocalDate());
            registrationPage.setContactDetails(user.getEmail(), user.getPhone());
            registrationPage.setComments(user.getComments());
            registrationPage.submitRequest();
            System.out.println("Confirmation number: " + registrationPage.getConfirmationNumber());
        });
    }

    @Test(dataProvider = "getData")
    public void userVisaTestByDob(User user) {
        registrationPage.goTo();
        registrationPage.setNames(user.getFirstName(), user.getLastName());
        registrationPage.setFromToCountry(user.getFromCountry(), user.getToCountry());
        registrationPage.setBirthDate(user.getDob().toLocalDate());
        registrationPage.setContactDetails(user.getEmail(), user.getPhone());
        registrationPage.setComments(user.getComments());
        registrationPage.submitRequest();
        logger.info("Confirmation number: " + registrationPage.getConfirmationNumber());
    }

    @DataProvider
    private Object[][] getData(ITestContext context) {
        Object[] array = userRepository.findByDobBetween(
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))).stream()
                .limit(3).toArray();
        return new Object[][]{{array[0]}, {array[1]}, {array[2]}};
    }
}
