package com.programming.java.Jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.programming.java.Jackson.Catalog.Catalog;

import javax.xml.stream.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class xmlSerialization {
    public static void main(String[] args) {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";
        File xmlFile = null;
        InputStream inputStream = null;

        try {
            xmlFile = new File(xmlFileLocation);
            inputStream = new FileInputStream(xmlFile);
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
            System.out.println("Error while creating the XML reader!");
            e.printStackTrace();
            return;
        }

        XmlMapper mapper = new XmlMapper();
        Catalog catalog = null;

        try {
            catalog = mapper.readValue(xmlStreamReader, Catalog.class);
        } catch (IOException e) {
            System.out.println("Error while reading the XML file!");
            e.printStackTrace();
            return;
        }

        System.out.println(catalog);

        // Write to file
        String outputFileLocation = "./src/main/resources/xmlFiles/out_books.xml";
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outputFileLocation);
        } catch (IOException e) {
            System.out.println("Error creating output stream!");
            e.printStackTrace();
            return;
        }

        // add indentation
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // prevent dates from being written as Long
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // create and set a custom date format
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        mapper.setDateFormat(df);

        try {
            mapper.writeValue(outputStream, catalog);
        } catch (IOException e) {
            System.out.println("Error while writing XML file!");
            e.printStackTrace();
        }
    }
}
