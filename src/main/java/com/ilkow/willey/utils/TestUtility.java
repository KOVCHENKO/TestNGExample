package com.ilkow.willey.utils;

import com.ilkow.willey.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.util.List;
import java.util.Optional;

public class TestUtility {

    public static WebDriver driver = Config.init();
    private static final int DEFAULT_WAIT_TIME = 10;

    public static void click(WebElement element) {
        waitForElementToBeClickable(element).click();
    }

    private static WebElement waitForElementToBeClickable(WebElement element) {
        return new WebDriverWait(driver, TestUtility.DEFAULT_WAIT_TIME)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isDisplayed(By element) {
        Optional<WebElement> optionalElement = getWebElementOptional(element);
        return optionalElement.map(WebElement::isDisplayed).orElse(false);
    }

    public static WebElement getElement(By element) {
        return getWebElementOptional(element).get();
    }

    private static Optional<WebElement> getWebElementOptional(By element) {
        try {
            WebElement webElement = new WebDriverWait(driver, DEFAULT_WAIT_TIME)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            return Optional.of(webElement);
        } catch (StaleElementReferenceException | TimeoutException e) {
            return Optional.empty();
        }
    }

    public static List<WebElement> getAllElements(By locator) {
        return (new WebDriverWait(driver, DEFAULT_WAIT_TIME))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void hoverElement(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    @AfterTest
    void tearDown() {
        driver.close();
        driver.quit();
    }

}
