package com.ilkow.willey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Config {

    public static String baseUrl = "https://www.wiley.com/en-us";

    public static WebDriver init() {
        File file = new File("src/main/resources/chromedriver.exe");
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        return new ChromeDriver();
    }

}
