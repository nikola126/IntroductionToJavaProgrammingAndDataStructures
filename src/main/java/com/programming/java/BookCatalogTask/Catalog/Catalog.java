package com.programming.java.BookCatalogTask.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
    @JacksonXmlElementWrapper(useWrapping = false, localName = "book")
    @JacksonXmlProperty(localName = "book")
    @XmlElement(name = "book")
    private List<Book> books;

    public void mapAuthorsToList() {
        // maps the Authors object (used by JAXB) to list of Author objects
        // aligns representation between JAXB and other parsers
        // to be used after parsing with JAXB
        for (Book book : books) {
            List<Author> authorList = new ArrayList<>(book.getAuthors().getAuthors());
            book.setAuthorsList(authorList);
        }
    }
}
