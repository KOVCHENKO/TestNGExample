package com.ilkow.sperasoft;

import com.ilkow.sperasoft.entities.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest {

    private WebDriver driver;

    private Customer customer;

    @BeforeTest
    void setUp() {
        driver = Config.init();
        customer = new Customer();
        customer.setEmail();

        driver.get(Config.baseUrl + "index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email_create")).sendKeys(customer.getEmail());
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @Test(priority=1)
    void testAllFieldsAreAvailable() {
        


    }

    @AfterMethod
    void tearDown() {
//        driver.quit();
    }


}
