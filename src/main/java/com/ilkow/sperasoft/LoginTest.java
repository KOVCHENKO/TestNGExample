package com.ilkow.sperasoft;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeTest
    void setUp() {
        Config.init();
    }

    @Test(priority=1)
    void setup() {
        System.out.println("This is setup method");
    }
}
