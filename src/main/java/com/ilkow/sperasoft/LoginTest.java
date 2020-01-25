package com.ilkow.sperasoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    void setUp() {
        driver = Config.init();
    }

    @Test(priority=1)
    void setup() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signInButton.click();
        System.out.println("This is setup method");
        driver.findElement(By.id("email_create")).sendKeys("xtest@xtest.com");

    }
}
