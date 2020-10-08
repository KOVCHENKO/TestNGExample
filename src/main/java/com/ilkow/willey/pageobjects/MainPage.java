package com.ilkow.willey.pageobjects;

import com.ilkow.willey.Config;
import com.ilkow.willey.utils.PageUtility;
import com.ilkow.willey.utils.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class MainPage extends PageUtility {

    @FindBy(xpath = "//div[@id='Level1NavNode1']//..//a[@class='collapsed']")
    public WebElement whoWeServeDropDown;

    @FindBy(xpath = "//div[@id='Level1NavNode2']//..//a[@class='collapsed']")
    public WebElement subjectsDropDown;

    @FindBy(xpath = "//a[@href='/en-us/Education-c-ED00']")
    public WebElement educationMenuItem;

    public By educationMenuItemBy = By.xpath("//a[@href='/en-us/Education-c-ED00']");

    @FindBy(xpath = "//form[@id='country-location-form']//div//button[@class='close']")
    public WebElement dismissModal;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    public By searchInput = By.xpath("//input[@id='js-site-search-input']");
    public By searchResults = By.xpath("//div[@class='searchresults-item ui-menu-item']");

    public By studentsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/students']");
    public By instructorsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/instructors']");
    public By bookAuthorsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/book-authors']");
    public By professionalsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/professionals']");
    public By researchersLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/researchers']");
    public By institutionsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/institutionsLink']");
    public By librariansLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/librariansLink']");
    public By corporationsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/corporations']");
    public By journalEditorsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/journal-editors']");
    public By bookstoresLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/bookstores']");
    public By governmentLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/government']");



    public void navigateTo() {
        TestUtility.driver.get(Config.baseUrl);
    }

    public ArrayList<By> getAllWhoWeServeDropDownElements() {
        return new ArrayList<>(){
            {
                add(studentsLink);
                add(instructorsLink);
                add(bookAuthorsLink);
                add(professionalsLink);
                add(researchersLink);
                add(institutionsLink);
                add(librariansLink);
                add(corporationsLink);
                add(journalEditorsLink);
                add(bookstoresLink);
                add(governmentLink);
            }
        };
    }



}
