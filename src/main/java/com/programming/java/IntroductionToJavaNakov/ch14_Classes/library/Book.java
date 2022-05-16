package com.programming.java.IntroductionToJavaNakov.ch14_Classes.library;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String ISBN;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
