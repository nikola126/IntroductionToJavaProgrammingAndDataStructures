package com.programming.java.JAXB;

import com.programming.java.Jackson.Catalog.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbSerialization {
    public static void main(String[] args) {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Error creating JAXB Context!");
            return;
        }

        Catalog catalog;
        try {
            catalog = (Catalog) context.createUnmarshaller().unmarshal(new FileReader(xmlFileLocation));
        } catch (JAXBException e) {
            System.out.println("Error creating unmarshaller!");
            return;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + xmlFileLocation);
            return;
        }

        System.out.println(catalog);

    }
}
