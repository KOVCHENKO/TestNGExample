package com.ilkow.sperasoft.pageobjects;

import com.ilkow.sperasoft.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationForm {

    private static String URL = Config.baseUrl + "index.php?controller=authentication&back=my-account";

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
    @FindBy(id = "days")
    private WebElement dayOfBirth;

    @FindBy(id = "month")
    private WebElement monthOfBirth;

    @FindBy(id = "years")
    private WebElement yearOfBirth;

    // Separate element
    @FindBy(id = "firstname")
    private WebElement firstNameAddress;

    @FindBy(id = "lastname")
    private WebElement lastNameAddress;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "other")
    private WebElement additionalInformation;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement addressAlias;

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
