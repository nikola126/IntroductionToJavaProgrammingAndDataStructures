package com.programming.java.Sax;

import com.programming.java.Jackson.Catalog.Catalog;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxSerialization {
    public static void main(String[] args) {
        CatalogHandlerSax catalogHandlerSax = new CatalogHandlerSax();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;

        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (SAXException | ParserConfigurationException e) {
            System.out.println("Error creating SAX Parser!");
            return;
        }

        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";
        Catalog catalog;

        try {
            saxParser.parse(xmlFileLocation, catalogHandlerSax);
        } catch (IOException e) {
            System.out.println("Error reading file " + xmlFileLocation);
            return;
        } catch (SAXException e) {
            System.out.println("Error parsing the file " + xmlFileLocation);
            return;
        }

        catalog = catalogHandlerSax.getCatalog();
        System.out.println(catalog);
    }
}
