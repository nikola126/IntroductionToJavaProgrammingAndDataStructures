package com.programming.java.JacksonXML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.programming.java.JacksonXML.Catalog.Catalog;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class xmlSerialization {
    public static void main(String[] args) throws XMLStreamException, IOException {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";

        File initialFile = new File(xmlFileLocation);
        InputStream inputStream = new FileInputStream(initialFile);

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);

        XmlMapper mapper = new XmlMapper();
        Catalog catalog = mapper.readValue(xmlStreamReader, Catalog.class);
    }
}
