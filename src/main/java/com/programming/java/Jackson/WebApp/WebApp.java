package com.programming.java.Jackson.WebApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WebApp {
    @JsonProperty("servlet")
    private List<Servlet> servlets;
    @JsonProperty("servlet-mapping")
    private ServletMapping servletMapping;
    private Taglib taglib;
}
