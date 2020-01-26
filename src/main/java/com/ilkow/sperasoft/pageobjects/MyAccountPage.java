package com.ilkow.sperasoft.pageobjects;

import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;

    private static String TITLE = "My account - My Store";

    MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private String getTitle() {
        return driver.getTitle();
    }

    public boolean checkTitle() {
        return TITLE.equals(getTitle());
    }

}
