package com.programming.java.IntroductionToJavaNakov.ch14_Classes.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    public LibraryTest() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("IT", "Stephen King"));
        bookList.add(new Book("Dune", "Frank Herbert"));
        bookList.add(new Book("The Shining", "Stephen King"));

        Library library = new Library("My Library", bookList);

        for (Book book : library.getBookList())
            System.out.println(book);

        int booksToDelete = 0;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().equals("Stephen King"))
                booksToDelete += 1;
        }

        while (booksToDelete > 0) {
            for (int i = 0; i < bookList.size(); i++) {
                Book book = bookList.get(i);
                if (book.getAuthor().equals("Stephen King")) {
                    library.deleteBook(i);
                    booksToDelete--;
                    break;
                }
            }
            bookList = library.getBookList();
        }


        System.out.println("After removing all books by Stephen King:");
        for (Book book : library.getBookList())
            System.out.println(book);
    }
}
