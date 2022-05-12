package com.programming.java.JacksonXML.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Book {
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "cover")
    private String cover;
    @JacksonXmlProperty(localName = "author")
    private List<Author> authorsList;
    private String title;
    private String genre;
    private Price price;
    private Date publishDate;
    private String description;
}
