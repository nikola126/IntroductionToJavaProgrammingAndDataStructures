package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "price")
public class Price {
    public static final double BGNperDollar = 1.859;
    @JacksonXmlProperty(isAttribute = true)
    private String currency;
    @JacksonXmlText
    private double amount;

    @Override
    public String toString() {
        if (currency.equals("bgn"))
            return amount + " BGN";
        else
            return String.format("%.2f", amount * BGNperDollar) + " BGN";
    }
}
