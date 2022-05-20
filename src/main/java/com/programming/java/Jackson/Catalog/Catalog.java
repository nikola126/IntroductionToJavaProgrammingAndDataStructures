package com.programming.java.Jackson.Catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
    @JacksonXmlElementWrapper(useWrapping = false, localName = "book")
    @JacksonXmlProperty(localName = "book")
    @XmlElement(name = "book")
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
