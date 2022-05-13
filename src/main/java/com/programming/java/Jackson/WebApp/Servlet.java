package com.programming.java.Jackson.WebApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Servlet {
    @JsonProperty("servlet-name")
    private String servletName;
    @JsonProperty("servlet-class")
    private String servletClass;
    @JsonProperty("init-param")
    private InitParam initParam;
}
