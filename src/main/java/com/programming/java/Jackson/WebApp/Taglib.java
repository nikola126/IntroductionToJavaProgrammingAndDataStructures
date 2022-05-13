package com.programming.java.Jackson.WebApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Taglib {
    @JsonProperty("taglib-uri")
    private String taglibUri;
    @JsonProperty("taglib-location")
    private String taglibLocation;
}
