package com.udemy.spring.springselenium.page.visa;

import com.udemy.spring.springselenium.commonConfig.annotation.Page;
import com.udemy.spring.springselenium.page.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Objects;

@Page
public class VisaRegistrationPage extends BasePage {

    @FindBy(id = "first_4")
    private WebElement firstName;

    @FindBy(id = "last_4")
    private WebElement lastName;

    @FindBy(id = "input_46")
    private WebElement fromCountry;

    @FindBy(id = "input_47")
    private WebElement toCountry;

    @FindBy(id = "input_24_month")
    private WebElement month;

    @FindBy(id = "input_24_day")
    private WebElement day;

    @FindBy(id = "input_24_year")
    private WebElement year;

    @FindBy(id = "input_6")
    private WebElement email;

    @FindBy(id = "input_27_phone")
    private WebElement phone;

    @FindBy(id = "input_45")
    private WebElement comments;

    @FindBy(id = "submitBtn")
    private WebElement submitBtn;

    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    @Value("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html")
    private String url;

    public void goTo() {
        driver.get(url);
    }

    public void setNames(String firstN, String lastN) {
        firstName.sendKeys(firstN);
        lastName.sendKeys(lastN);
    }

    public void setFromToCountry(String countryFrom, String countryTo) {
        new Select(fromCountry).selectByValue(countryFrom);
        new Select(toCountry).selectByValue(countryTo);
    }

    public void setBirthDate(LocalDate date) {
        new Select(day).selectByValue(String.valueOf(date.getDayOfMonth()));
        new Select(month).selectByValue(String.valueOf(date.getMonth()));
        new Select(year).selectByValue(String.valueOf(date.getYear()));
    }

    public void setContactDetails(String emailCont, String phoneCont) {
        email.sendKeys(emailCont);
        phone.sendKeys(phoneCont);
    }

    public void setComments(String comment) {
        comments.sendKeys(Objects.toString(comment, StringUtils.EMPTY));
    }

    public void submitRequest() {
        submitBtn.click();
    }

    public String getConfirmationNumber() {
        webDriverWait.until(e -> requestNumber.isDisplayed());
        return requestNumber.getText();
    }

    @Override
    public boolean isLoaded() {
        return webDriverWait.until(e -> firstName.isDisplayed());
    }
}
