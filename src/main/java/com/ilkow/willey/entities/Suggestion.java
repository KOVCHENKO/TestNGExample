package com.ilkow.willey.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestion {

    @JsonProperty
    String term;

    public String getTerm() {
        return term;
    }
}
