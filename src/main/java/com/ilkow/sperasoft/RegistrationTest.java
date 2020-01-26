package com.ilkow.sperasoft;

import com.ilkow.sperasoft.entities.Customer;
import com.ilkow.sperasoft.pageobjects.MyAccountPage;
import com.ilkow.sperasoft.pageobjects.RegistrationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver driver;

    private Customer customer;

    @BeforeMethod
    @Parameters({"registrationUrl"})
    void setUp(String registrationUrl) {
        driver = Config.init();
        customer = new Customer();
        customer.setEmail();

        driver.get(Config.baseUrl + registrationUrl);
        driver.findElement(By.id("email_create")).sendKeys(customer.getEmail());
        driver.findElement(By.id("SubmitCreate")).click();

        // Wait until all elements will be rendered on page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    void testAllFieldsAreAvailable() {
        RegistrationForm registrationForm = new RegistrationForm(driver);
        List<WebElement> registrationFormElements = registrationForm.getAllElementsOfThePage();

        for (WebElement registrationEl: registrationFormElements) {
            System.out.println(registrationEl.getTagName());
            Assert.assertTrue(registrationEl.isDisplayed());
        }
    }

    @Test
    void testRegistrationSucceeded() {
        customer.createValid();

        RegistrationForm registrationForm = new RegistrationForm(driver);
        MyAccountPage myAccountPage = registrationForm.registerCustomerSuccess(customer);

        Assert.assertTrue(myAccountPage.checkTitle());
    }

    @Test
    void testRegistrationFailed() {
        customer.createInvalid();
        RegistrationForm registrationForm = new RegistrationForm(driver);
        registrationForm.registerCustomerFailed(customer);

        Assert.assertTrue(registrationForm.validationErrorsAreDisplayed());
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }


}
