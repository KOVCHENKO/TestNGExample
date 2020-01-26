package com.ilkow.sperasoft.pageobjects;

import com.ilkow.sperasoft.Config;
import com.ilkow.sperasoft.entities.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegistrationForm {

    private static String URL = Config.baseUrl + "index.php?controller=authentication&back=my-account";

    private WebDriver driver;

    @FindBy(id = "uniform-id_gender1")
    private WebElement customerTitleMr;

    @FindBy(id = "uniform-id_gender2")
    private WebElement customerTitleMrs;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement customerEmail;

    @FindBy(id = "passwd")
    private WebElement customerPassword;

    // Separate element
    @FindBy(id = "uniform-days")
    private WebElement dayOfBirth;

    @FindBy(id = "uniform-months")
    private WebElement monthOfBirth;

    @FindBy(id = "uniform-years")
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

    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "uniform-id_country")
    private WebElement country;

    @FindBy(id = "other")
    private WebElement additionalInformation;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    @FindBy(className = "alert-danger")
    private WebElement validationErrors;

    public boolean validationErrorsAreDisplayed() {
        return this.validationErrors.isDisplayed();
    }

    public RegistrationForm(WebDriver driver) {
        // Check page validity
        if (!driver.getCurrentUrl().contains(URL)) {
            throw new IllegalStateException("This is not a registration page");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage registerCustomerSuccess(Customer customer) {

        customerFirstName.sendKeys(customer.getFirstName());
        customerLastName.sendKeys(customer.getLastName());
        homePhone.sendKeys(customer.getHomePhone());
        customerPassword.sendKeys(customer.getPassword());
        address1.sendKeys(customer.getAddress1());
        city.sendKeys(customer.getCity());
        postCode.sendKeys(customer.getPostCode());

        Select select = new Select(state);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals("Alabama")) {
                option.click();
                break;
            }
        }

        submitButton.click();

        return new MyAccountPage(driver);
    }

    public void registerCustomerFailed(Customer customer) {
        customerFirstName.sendKeys(customer.getFirstName());
        customerLastName.sendKeys(customer.getLastName());
        homePhone.sendKeys(customer.getHomePhone());
        customerPassword.sendKeys(customer.getPassword());
        address1.sendKeys(customer.getAddress1());
        city.sendKeys(customer.getCity());
        postCode.sendKeys(customer.getPostCode());

        submitButton.click();
    }

    public List<WebElement> getAllElementsOfThePage() {
        String attribute = dayOfBirth.getAttribute("opacity");
        System.out.println(attribute);

        List<WebElement> registrationFormElements = new ArrayList<WebElement>();
        registrationFormElements.add(customerTitleMr);
        registrationFormElements.add(customerTitleMrs);
        registrationFormElements.add(customerFirstName);
        registrationFormElements.add(customerLastName);
        registrationFormElements.add(customerEmail);
        registrationFormElements.add(customerPassword);
        registrationFormElements.add(dayOfBirth);
        registrationFormElements.add(monthOfBirth);
        registrationFormElements.add(yearOfBirth);
        registrationFormElements.add(firstNameAddress);
        registrationFormElements.add(lastNameAddress);
        registrationFormElements.add(company);
        registrationFormElements.add(address1);
        registrationFormElements.add(address2);
        registrationFormElements.add(city);
        registrationFormElements.add(postCode);
        registrationFormElements.add(country);
        registrationFormElements.add(additionalInformation);
        registrationFormElements.add(homePhone);
        registrationFormElements.add(mobilePhone);
        registrationFormElements.add(addressAlias);
        registrationFormElements.add(submitButton);

        return registrationFormElements;
    }
}
