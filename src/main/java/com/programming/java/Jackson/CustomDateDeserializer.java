package com.programming.java.Jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomDateDeserializer extends StdDeserializer<LocalDate> {
    protected CustomDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext context) throws IOException {
        // JsonParser.currentToken(), .getText(), .nextToken()
        // can be used to advance the parser and build the full object

        // Date is single field, DO NOT LOOP FORWARD
        return dateParser(p.getText());
    }

    public static LocalDate dateParser(String text) {
        LocalDate date = null;

        DateTimeFormatter[] acceptedFormats = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"),
        };

        for (DateTimeFormatter dtf : acceptedFormats) {
            try {
                date = LocalDate.parse(text, dtf);
            } catch (DateTimeParseException ignored) {}
        }

        return date;
    }
}
