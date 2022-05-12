package com.programming.java.JacksonXML.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
public class Catalog {
    @JacksonXmlProperty(localName = "book")
    private List<Book> books;
}
