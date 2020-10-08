package com.ilkow.willey.services.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ilkow.willey.entities.SearchResult;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class SearchRequestService {
    private static final Logger LOG = LoggerFactory.getLogger(SearchRequestService.class);

    private RequestSpecification userRequestSpecification() {
        return new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter(LogDetail.URI))
                .addFilter(new ResponseLoggingFilter(LogDetail.STATUS))
                .addFilter(new ResponseLoggingFilter(LogDetail.BODY))
                .setBaseUri("https://www.wiley.com")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    public SearchResult getSearchResult() {

        LOG.debug("Requesting Users with the following params : {}", "THis is it");
        return given(userRequestSpecification())
                .get("en-us/search/autocomplete/comp_00001H9J?term=Java")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(new TypeReference<SearchResult>(){}.getType());

    }
}
