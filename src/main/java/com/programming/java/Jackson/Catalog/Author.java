package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Author {
    @JacksonXmlProperty(localName = "first_name")
    private String firstName;
    @JacksonXmlProperty(localName = "last_name")
    private String lastName;
}
