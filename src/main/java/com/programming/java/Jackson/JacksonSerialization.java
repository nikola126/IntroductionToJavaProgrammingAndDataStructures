package com.programming.java.Jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.programming.java.Jackson.Catalog.Catalog;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class JacksonSerialization {
    public static void main(String[] args) {
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";

        Catalog catalog = getCatalog(xmlFileLocation);

        // Write to file
        String outputFileLocation = "./src/main/resources/xmlFiles/out_books.xml";
        writeCatalogToFile(outputFileLocation, catalog);
    }

    public static Catalog getCatalog(String xmlFileLocation) {
        File xmlFile;
        InputStream inputStream;

        try {
            xmlFile = new File(xmlFileLocation);
            inputStream = new FileInputStream(xmlFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("XML File not found!");
        }

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader;

        try {
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        } catch (XMLStreamException e) {
            throw new RuntimeException("Error while creating the XML reader!");
        }

        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        Catalog catalog = null;

        final SimpleModule module = new SimpleModule("configModule", com.fasterxml.jackson.core.Version.unknownVersion());
        module.addDeserializer(LocalDate.class, new CustomDateDeserializer());
        mapper.registerModule(module);

        try {
            catalog = mapper.readValue(xmlStreamReader, Catalog.class);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the XML file!");
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Error while parsing date!");
        }

        return catalog;
    }

    public static void writeCatalogToFile(String outputFileLocation, Catalog catalog) {
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(outputFileLocation);
        } catch (IOException e) {
            throw new RuntimeException("Error creating output stream!");
        }

        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());

        final SimpleModule module = new SimpleModule("configModule", com.fasterxml.jackson.core.Version.unknownVersion());
        module.addDeserializer(LocalDate.class, new CustomDateDeserializer());
        mapper.registerModule(module);

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
            throw new RuntimeException("Error while writing XML file!");
        }
    }
}
