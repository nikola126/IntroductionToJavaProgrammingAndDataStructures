package com.programming.java.IntroductionToJavaNakov.ch14_Classes.library;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    private String name;
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (Objects.equals(book.getAuthor(), author))
                result.add(book);
        }

        return result;
    }

    public Book getBook(String title) {
        for (Book book : bookList) {
            if (Objects.equals(book.getTitle(), title))
                return book;
        }

        return null;
    }

    public void deleteBook(int index) {
        bookList.remove(index);
    }
}
