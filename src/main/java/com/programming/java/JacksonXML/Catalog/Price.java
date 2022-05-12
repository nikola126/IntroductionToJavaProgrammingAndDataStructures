package com.programming.java.JacksonXML.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Price {
    @JacksonXmlProperty(isAttribute = true, localName = "currency")
    private String currency;
    private double amount;
}
