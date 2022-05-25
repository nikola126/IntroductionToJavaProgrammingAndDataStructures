package com.programming.java.BookCatalogTask.Catalog;

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
    @JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "currency")
    private String currency;

    @JacksonXmlText
    @XmlValue
    private double amount;
}
