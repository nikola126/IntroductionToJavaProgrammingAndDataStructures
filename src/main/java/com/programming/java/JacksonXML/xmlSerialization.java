package com.programming.java.JacksonXML;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.programming.java.JacksonXML.Catalog.Catalog;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class xmlSerialization {
    public static void main(String[] args) {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";
        File initialFile = null;
        InputStream inputStream = null;

        try {
            initialFile = new File(xmlFileLocation);
            inputStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            System.out.println("XML File not found!");
            e.printStackTrace();
            return;
        }

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = null;

        try {
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        } catch (XMLStreamException e) {
            System.out.println("XML Stream exception!");
            e.printStackTrace();
            return;
        }

        XmlMapper mapper = new XmlMapper();
        Catalog catalog = null;

        try {
            catalog = mapper.readValue(xmlStreamReader, Catalog.class);
        } catch (IOException e) {
            System.out.println("IOException!");
            e.printStackTrace();
            return;
        }

        System.out.println(catalog);
    }
}
