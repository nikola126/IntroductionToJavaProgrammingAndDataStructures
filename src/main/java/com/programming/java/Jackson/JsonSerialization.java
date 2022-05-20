package com.programming.java.Jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.programming.java.Jackson.WebApp.JsonSample;

import java.io.*;

public class JsonSerialization {
    public static void main(String[] args) {
        String jsonFileLocation = "./src/main/resources/jsonFiles/web_app.json";

        JsonMapper mapper = new JsonMapper();
        JsonSample jsonSample = null;

        try {
            jsonSample = mapper.readValue(new FileInputStream(jsonFileLocation), JsonSample.class);
        } catch (IOException e) {
            System.out.println("Error while reading the XML file!");
            e.printStackTrace();
            return;
        }

        System.out.println(jsonSample);

        // Write to file
        String outputFileLocation = "./src/main/resources/jsonFiles/out_web_app.json";
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

        try {
            //TODO Writes ALL fields, most initialized as NULL as they are missing from original file
            mapper.writeValue(outputStream, jsonSample);
        } catch (IOException e) {
            System.out.println("Error while writing XML file!");
            e.printStackTrace();
        }
    }
}
