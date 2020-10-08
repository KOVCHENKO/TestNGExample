package com.ilkow.willey.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {

    @JsonProperty
    private List<Suggestion> suggestions;

    @JsonProperty List<Page> pages;

    public List<Suggestion> getSuggestion() {
        return suggestions;
    }

    public List<Page> getPages() {
        return pages;
    }
}
