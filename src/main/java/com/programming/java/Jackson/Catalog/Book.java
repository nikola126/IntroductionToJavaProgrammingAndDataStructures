package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.programming.java.JAXB.LocalDateAdapter;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Data
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    @XmlAttribute(name = "id")
    private String id;

    @JacksonXmlProperty(isAttribute = true, localName = "cover")
    @XmlAttribute(name = "cover")
    private String cover;

    @JacksonXmlElementWrapper(useWrapping = true, localName = "authors")
    @JacksonXmlProperty(localName = "author")
    private List<Author> authorsList;

    // used when parsing with JAXB, must be ignored by Jackson to avoid errors
    @JsonIgnore
    @XmlElement(name = "authors")
    private Authors authors;

    private String title;

    private String genre;

    private Price price;

    @JacksonXmlProperty(localName = "publish_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @XmlElement(name = "publish_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate publishDate;

    private String description;
}
