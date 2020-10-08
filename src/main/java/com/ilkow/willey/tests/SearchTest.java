package com.ilkow.willey.tests;

import com.ilkow.willey.entities.SearchResult;
import com.ilkow.willey.entities.Suggestion;
import com.ilkow.willey.pageobjects.MainPage;
import com.ilkow.willey.pageobjects.SearchPage;
import com.ilkow.willey.services.api.SearchRequestService;
import com.ilkow.willey.utils.TestUtility;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends TestUtility {
    MainPage mainPage;
    SearchPage searchPage;
    SearchRequestService searchRequestService;

    @BeforeMethod
    void setUp() {
        this.mainPage = new MainPage();
        this.searchPage = new SearchPage();
        this.searchRequestService = new SearchRequestService();

        this.mainPage.navigateTo();

        click(mainPage.dismissModal);
    }

    @Test
    @Parameters({"searchInput"})
    void testSearchAreaIsDisplayed(String searchInput) {
        getElement(mainPage.searchInput).sendKeys(searchInput);
        Assert.assertTrue(isDisplayed(mainPage.searchResults));
    }

    @Test
    @Parameters({"searchInput"})
    void testSearchResults(String searchInput) {
        getElement(mainPage.searchInput).sendKeys(searchInput);
        click(mainPage.searchButton);
        click(mainPage.dismissModal);

        Assert.assertTrue(isDisplayed(searchPage.productItem));

        List<WebElement> searchedProductContent = getAllElements(searchPage.searchResultProductContent);

        Assert.assertTrue(searchedProductContent.stream()
                .allMatch(contentItem -> contentItem.findElement(searchPage.searchResultTitle)
                        .getText().contains("Java")));

        searchedProductContent.forEach(contentItem -> {
            Assert.assertTrue(contentItem.findElement(searchPage.addToCartButton).isDisplayed());

            if (contentItem.findElement(searchPage.oBookTab).isDisplayed()) {
                click(contentItem.findElement(searchPage.oBookTab));
                Assert.assertTrue(contentItem.findElement(searchPage.viewOnWileyLibrary).isDisplayed());
            }

        });
    }

    @Test
    @Parameters({"searchInput"})
    void testSearchApiWorksProperly(String searchedWord) {
        SearchResult searchResult = searchRequestService.getSearchResult();

        searchResult.getSuggestion().forEach(suggestion -> {
            Document termEl = Jsoup.parse(suggestion.getTerm());
            Element termSpan = termEl.select("span").first();

            Assert.assertTrue(termSpan.text().equalsIgnoreCase(searchedWord));
        });

        searchResult.getPages().forEach(page -> {
            Assert.assertTrue(page.getTitle().contains("Wiley"));
        });
        
    }
}
