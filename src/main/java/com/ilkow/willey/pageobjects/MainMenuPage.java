package com.ilkow.willey.pageobjects;

import com.ilkow.willey.utils.PageUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuPage extends PageUtility {

    @FindBy(xpath = "//div[@id='Level1NavNode1']//..//a[@class='collapsed']")
    public WebElement whoWeServeDropDown;

    @FindBy(xpath = "//div[@id='Level1NavNode2']//..//a[@class='collapsed']")
    public WebElement subjectsDropDown;

    @FindBy(xpath = "//li//a[@href='/en-us/Education-c-ED00']")
    public WebElement educationMenuItem;

    @FindBy(xpath = "//form[@id='country-location-form']//div//button[@class='close']")
    public WebElement dismissModal;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    public By educationMenuItemBy = By.xpath("//a[@href='/en-us/Education-c-ED00']");

}
