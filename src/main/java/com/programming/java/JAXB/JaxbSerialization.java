package com.programming.java.JAXB;

import com.programming.java.BookCatalogTask.Catalog.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbSerialization {
    public static void main(String[] args) {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";

        System.out.println(getCatalog(xmlFileLocation));
    }

    public static Catalog getCatalog(String xmlFileLocation) {
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Error creating JAXB Context!");
        }

        Catalog catalog;

        try {
            catalog = (Catalog) context.createUnmarshaller().unmarshal(new FileReader(xmlFileLocation));
        } catch (JAXBException e) {
            throw new RuntimeException("Error creating unmarshaller!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not find file " + xmlFileLocation);
        }

        return catalog;
    }
}
