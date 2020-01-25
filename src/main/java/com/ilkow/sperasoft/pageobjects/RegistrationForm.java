package com.ilkow.sperasoft.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationForm {

    private static String URL = "REGISTRATION_URL";

    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement customerTitle;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement customerEmail;

    @FindBy(id = "passwd")
    private WebElement customerPassword;

    // Separate element
    @FindBy(id = "dateOfBirth")
    private WebElement dateOfBirth;

    public RegistrationForm(WebDriver driver) {
        // Check page validity
        if (!driver.getCurrentUrl().contains(URL)) {
            throw new IllegalStateException("This is not a registration page");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void registerUserSuccess() {

    }

    public void registerUserForm() {

    }
}
