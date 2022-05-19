package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
public class Book {
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute = true, localName = "cover")
    private String cover;
    @JacksonXmlElementWrapper(useWrapping = true, localName = "authors")
    @JacksonXmlProperty(localName = "author")
    private List<Author> authorsList;
    private String title;
    private String genre;
    private Price price;
    @JacksonXmlProperty(localName = "publish_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
    private String description;

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return title + " "
                + (price == null ? ("Cena po zapitvane") : (price)) + " "
                + (publishDate == null ? ("Bez data") : (dtf.format(publishDate)));
    }
}
