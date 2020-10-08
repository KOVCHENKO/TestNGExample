package com.ilkow.willey.tests.ui;

import com.ilkow.willey.pageobjects.MainPage;
import com.ilkow.willey.pageobjects.SearchPage;
import com.ilkow.willey.services.api.SearchRequestService;
import com.ilkow.willey.utils.TestUtility;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends TestUtility {

    private static final Logger LOG = LoggerFactory.getLogger(SearchTest.class);

    MainPage mainPage;
    SearchPage searchPage;
    SearchRequestService searchRequestService;

    @BeforeMethod
    void setUp() {
        this.mainPage = new MainPage();
        this.searchPage = new SearchPage();
        this.searchRequestService = new SearchRequestService();

        this.mainPage.navigateTo();

        click(mainPage.getMainMenu().dismissModal);
    }

    @Test
    @Parameters({"searchInput"})
    void testSearchAreaIsDisplayed(String searchInput) {
        getElement(mainPage.searchInput).sendKeys(searchInput);

        LOG.debug("Verify main page search results are displayed");
        Assert.assertTrue(isDisplayed(mainPage.searchResults));
    }

    @Test
    @Parameters({"searchInput"})
    void testSearchResults(String searchInput) {
        getElement(mainPage.searchInput).sendKeys(searchInput);
        click(mainPage.getMainMenu().searchButton);
        click(mainPage.getMainMenu().dismissModal);

        Assert.assertTrue(isDisplayed(searchPage.productItem));

        List<WebElement> searchedProductContent = getAllElements(searchPage.searchResultProductContent);

        LOG.debug("Verify search results contain java word");
        Assert.assertTrue(searchedProductContent.stream()
                .allMatch(contentItem -> contentItem.findElement(searchPage.searchResultTitle)
                        .getText().contains("Java")));

        searchedProductContent.forEach(contentItem -> {
            LOG.debug("Verify Add To Cart button is displayed");
            Assert.assertTrue(contentItem.findElement(searchPage.addToCartButton).isDisplayed());

            if (contentItem.findElement(searchPage.oBookTab).isDisplayed()) {
                click(contentItem.findElement(searchPage.oBookTab));

                LOG.debug("Verify View On Wiley Library is displayed");
                Assert.assertTrue(contentItem.findElement(searchPage.viewOnWileyLibrary).isDisplayed());
            }

        });
    }
}
