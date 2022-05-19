package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class Catalog {
    @JacksonXmlElementWrapper(useWrapping = false, localName = "book")
    @JacksonXmlProperty(localName = "book")
    private List<Book> books;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
