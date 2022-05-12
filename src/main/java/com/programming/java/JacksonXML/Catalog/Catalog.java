package com.programming.java.JacksonXML.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.ToString;

import java.util.List;

@ToString
public class Catalog {
    @JacksonXmlElementWrapper(useWrapping = false, localName = "book")
    @JacksonXmlProperty(localName = "book")
    private List<Book> books;

    public Catalog(List<Book> books) {
        this.books = books;
    }

    public Catalog() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
