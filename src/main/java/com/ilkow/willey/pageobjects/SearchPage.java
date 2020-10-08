package com.ilkow.willey.pageobjects;

import com.ilkow.willey.Config;
import com.ilkow.willey.utils.PageUtility;
import com.ilkow.willey.utils.TestUtility;
import org.openqa.selenium.By;

public class SearchPage extends PageUtility {

    public By productItem = By.xpath("//section[@class='product-item']");
    public By searchResultProductContent = By.xpath("//div[@class='product-content']");
    public By searchResultTitle = By.xpath("//section[@class='product-item']//div//h3//a");

    public By addToCartButton = By.xpath("//button[contains(@class, 'small-button add-to-cart-button')]");
    public By viewOnWileyLibrary = By.xpath("//a[contains(@class, 'small-button learn-more-button')]");
    public By oBookTab = By.xpath("//div[text()='O-Book']");

    public void navigateTo() {
        TestUtility.driver.get(Config.baseUrl);
    }

}
