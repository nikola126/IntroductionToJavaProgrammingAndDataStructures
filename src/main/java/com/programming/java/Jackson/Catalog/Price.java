package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@JacksonXmlRootElement(localName = "price")
@XmlRootElement(name = "price")
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {
    public static final double BGNperDollar = 1.859;

    @JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "currency")
    private String currency;

    @JacksonXmlText
    @XmlValue
    private double amount;

    @Override
    public String toString() {
        if (currency.equals("bgn"))
            return amount + " BGN";
        else
            return String.format("%.2f", amount * BGNperDollar) + " BGN";
    }
}
