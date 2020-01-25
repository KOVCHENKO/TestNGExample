package com.ilkow.sperasoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest {

    private WebDriver driver;

    @BeforeTest
    void setUp() {
        driver = Config.init();
    }

    @Test(priority=1)
    void setup() {
        driver.get(Config.baseUrl + "index.php?controller=authentication&back=my-account");
        System.out.println("This is setup method");
        driver.findElement(By.id("email_create")).sendKeys("xtest2@xtest.com");
    }


}
