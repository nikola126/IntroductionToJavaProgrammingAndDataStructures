package com.programming.java.JAXB;

import com.programming.java.Jackson.CustomDateDeserializer;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return CustomDateDeserializer.dateParser(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
