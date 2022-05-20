package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import javax.xml.bind.annotation.*;


@Data
@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
    @JacksonXmlProperty(localName = "first_name")
    @XmlElement(name = "first_name")
    private String firstName;

    @JacksonXmlProperty(localName = "last_name")
    @XmlElement(name = "last_name")
    private String lastName;
}
