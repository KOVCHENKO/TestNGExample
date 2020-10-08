package com.ilkow.willey.pageobjects;

import com.ilkow.willey.utils.PageUtility;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class MainPage extends PageUtility {

    MainMenuPage mainMenuPage;

    public MainPage() {
        this.mainMenuPage = new MainMenuPage();
    }

    public By searchInput = By.xpath("//input[@id='js-site-search-input']");
    public By searchResults = By.xpath("//div[@class='searchresults-item ui-menu-item']");

    public By studentsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/students']");
    public By instructorsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/instructors']");
    public By bookAuthorsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/book-authors']");
    public By professionalsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/professionals']");
    public By researchersLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/researchers']");
    public By institutionsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/institutions']");
    public By librariansLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/librarians']");
    public By corporationsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/corporations']");
    public By journalEditorsLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/journal-editors']");
    public By bookstoresLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/bookstores']");
    public By governmentLink = By.xpath("//li[contains(@class, 'dropdown-submenu')]//a[@href='/en-us/government']");

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

    public MainMenuPage getMainMenu() {
        return mainMenuPage;
    }
}
