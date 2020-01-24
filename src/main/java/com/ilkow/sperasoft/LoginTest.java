package com.ilkow.sperasoft;

import org.openqa.selenium.WebDriver;
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
        System.out.println("This is setup method");
    }
}
