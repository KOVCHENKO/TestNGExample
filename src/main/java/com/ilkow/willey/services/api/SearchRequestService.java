package com.ilkow.willey.services.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ilkow.willey.entities.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class SearchRequestService extends CommonRequestService {
    private static final Logger LOG = LoggerFactory.getLogger(SearchRequestService.class);

    public SearchResult getSearchResult() {
        LOG.debug("Requesting search results");
        return given(getRequestSpecification("https://www.wiley.com"))
                .get("en-us/search/autocomplete/comp_00001H9J?term=Java")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(new TypeReference<SearchResult>(){}.getType());

    }
}
