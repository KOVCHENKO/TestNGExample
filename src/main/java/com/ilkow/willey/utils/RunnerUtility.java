package com.ilkow.willey.utils;

import com.ilkow.willey.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

public class RunnerUtility {

    private static final int DEFAULT_WAIT_TIME = 100;
    static WebDriver driver = Config.init();

    public static void click(WebElement element) {
        waitForElementToBeClickable(element, DEFAULT_WAIT_TIME).click();
    }

    private static WebElement waitForElementToBeClickable(WebElement element, int timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isDisplayed(By element) {
        Optional<WebElement> optionalElement = getWebElementOptional(element);
        return optionalElement.map(WebElement::isDisplayed).orElse(false);
    }

    public static Optional<WebElement> getWebElementOptional(By element) {
        try {
            WebElement webElement = new WebDriverWait(driver, DEFAULT_WAIT_TIME)
                    .until(ExpectedConditions.presenceOfElementLocated(element));
            return Optional.of(webElement);
        } catch (StaleElementReferenceException | TimeoutException e) {
            return Optional.empty();
        }
    }

}
