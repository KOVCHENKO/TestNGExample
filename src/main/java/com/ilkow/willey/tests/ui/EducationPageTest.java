package com.ilkow.willey.tests.ui;

import com.ilkow.willey.pageobjects.EducationPage;
import com.ilkow.willey.utils.TestUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EducationPageTest extends TestUtility {

    private static final Logger LOG = LoggerFactory.getLogger(EducationPageTest.class);

    EducationPage educationPage;

    @BeforeMethod
    void setUp() {
        this.educationPage = new EducationPage();
        this.educationPage.navigateTo();

        click(this.educationPage.getMainMenu().dismissModal);
    }

    @Test
    @Parameters({"menuItems"})
    void testEducationSideMenuIsDisplayedProperly(String rawMenuItems) {
        List<String> menuItems = Arrays.asList(rawMenuItems.split(","));

        hoverElement(educationPage.getMainMenu().subjectsDropDown);

        LOG.debug("Verify that education menu element is displayed");
        Assert.assertTrue(isDisplayed(educationPage.getMainMenu().educationMenuItemBy));

        click(educationPage.getMainMenu().educationMenuItem);
        click(educationPage.getMainMenu().dismissModal);

        educationPage.getAllSideMenuElements()
                .forEach(dropDownElement -> {
                    LOG.debug("Verify drop down element [{}] is displayed", dropDownElement);
                    Assert.assertTrue(isDisplayed(dropDownElement));
                    Assert.assertTrue(menuItems.contains(getElement(dropDownElement).getText()));
                });
    }

}
