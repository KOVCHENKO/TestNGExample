package com.ilkow.willey.tests.api;

import com.ilkow.willey.entities.SearchResult;
import com.ilkow.willey.services.api.SearchRequestService;
import com.ilkow.willey.utils.TestUtility;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends TestUtility {
    SearchRequestService searchRequestService;

    public SearchTest() {
        this.searchRequestService = new SearchRequestService();
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

        searchResult.getPages().forEach(page -> Assert.assertTrue(page.getTitle().contains("Wiley")));
        
    }
}
