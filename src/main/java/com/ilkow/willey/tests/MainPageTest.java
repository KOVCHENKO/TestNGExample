package com.ilkow.willey.tests;

import com.ilkow.willey.pageobjects.MainPage;
import com.ilkow.willey.utils.TestUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class MainPageTest extends TestUtility {

    MainPage mainPage;

    @BeforeMethod
    void setUp() {
        this.mainPage = new MainPage();
        this.mainPage.navigateTo();

        click(mainPage.dismissModal);
    }

    @Test
    @Parameters({"menuItems"})
    void testAllDropDownElementsAreAvailable(String rawMenuItems) {
        List<String> menuItems = Arrays.asList(rawMenuItems.split(","));

        click(mainPage.whoWeServeDropDown);

        mainPage.getAllWhoWeServeDropDownElements()
            .forEach(dropDownElement -> {
                Assert.assertTrue(isDisplayed(dropDownElement));
                Assert.assertTrue(menuItems.contains(getElement(dropDownElement).getText()));
            });
    }

}
