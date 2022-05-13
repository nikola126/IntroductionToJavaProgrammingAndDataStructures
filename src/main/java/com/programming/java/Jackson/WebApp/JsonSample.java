package com.programming.java.Jackson.WebApp;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class JsonSample {
    @JsonAlias("web-app")
    private WebApp webApp;
}
