package com.ilkow.willey.tests;

import com.ilkow.willey.pageobjects.EducationPage;
import com.ilkow.willey.pageobjects.MainPage;
import com.ilkow.willey.utils.TestUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EducationPageTest extends TestUtility {

    MainPage mainPage;
    EducationPage educationPage;

    @BeforeMethod
    void setUp() {
        this.mainPage = new MainPage();
        this.educationPage = new EducationPage();
        this.mainPage.navigateTo();

        click(mainPage.dismissModal);
    }

    @Test
    void testEducationMenuElementDisplayedProperly() {
        hoverElement(mainPage.subjectsDropDown);
        Assert.assertTrue(isDisplayed(mainPage.educationMenuItemBy));
    }

    @Test
    @Parameters({"menuItems"})
    void testEducationSideMenuIsDisplayedProperly(String rawMenuItems) {
        List<String> menuItems = Arrays.asList(rawMenuItems.split(","));

        hoverElement(mainPage.subjectsDropDown);
        click(mainPage.educationMenuItem);
        click(mainPage.dismissModal);

        educationPage.getAllSideMenuElements()
                .forEach(dropDownElement -> {
                    System.out.println(dropDownElement.toString());
                    Assert.assertTrue(isDisplayed(dropDownElement));
                    Assert.assertTrue(menuItems.contains(getElement(dropDownElement).getText()));
                });
    }

}
