package com.ilkow.sperasoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

class Config {

    public static WebDriver init() {
        File file = new File("src/main/resources/chromedriver.exe");
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");

        return driver;
    }

}
