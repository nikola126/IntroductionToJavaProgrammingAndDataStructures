package com.programming.java.BookCatalogTask.Catalog;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "authors")
@XmlAccessorType(XmlAccessType.FIELD)
public class Authors {
    // Used exclusively by JAXB to map Author object to array of Authors
    @XmlElement(name = "author")
    private List<Author> authors;
}
