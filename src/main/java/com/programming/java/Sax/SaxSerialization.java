package com.programming.java.Sax;

import com.programming.java.BookCatalogTask.Catalog.Catalog;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxSerialization {
    public static void main(String[] args) {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";
        System.out.println(getCatalog(xmlFileLocation));
    }

    public static Catalog getCatalog(String xmlFileLocation) {
        CatalogHandlerSax catalogHandlerSax = new CatalogHandlerSax();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;

        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (SAXException | ParserConfigurationException e) {
            throw new RuntimeException("Error creating SAX Parser!");
        }

        try {
            saxParser.parse(xmlFileLocation, catalogHandlerSax);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + xmlFileLocation);
        } catch (SAXException e) {
            throw new RuntimeException("Error parsing the file " + xmlFileLocation);
        }

        return catalogHandlerSax.getCatalog();
    }
}
