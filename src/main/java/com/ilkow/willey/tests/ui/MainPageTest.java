package com.ilkow.willey.tests.ui;

import com.ilkow.willey.pageobjects.MainPage;
import com.ilkow.willey.utils.TestUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class MainPageTest extends TestUtility {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageTest.class);
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
                LOG.debug("Verify drop down element [{}] is displayed", dropDownElement);
                Assert.assertTrue(isDisplayed(dropDownElement));
                Assert.assertTrue(menuItems.contains(getElement(dropDownElement).getText()));
            });
    }

}
