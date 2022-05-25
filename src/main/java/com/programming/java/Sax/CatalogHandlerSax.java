package com.programming.java.Sax;

import com.programming.java.BookCatalogTask.Catalog.Author;
import com.programming.java.BookCatalogTask.Catalog.Book;
import com.programming.java.BookCatalogTask.Catalog.Catalog;
import com.programming.java.BookCatalogTask.Catalog.Price;
import com.programming.java.Jackson.CustomDateDeserializer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CatalogHandlerSax extends DefaultHandler {
    // SAX does not keep the entire XML in memory
    // Instead it streams it and calls setters/handler methods at opening/closing XML tags
    //
    // + Saves memory, faster?
    // - Cannot work with the entire XML structure

    // use the StringBuilder to keep tag contents ("buffer")
    private StringBuilder elementValue = new StringBuilder();

    // define expected Java objects
    Catalog catalog;
    Book book;
    List<Book> bookList;
    Author author;
    List<Author> authorList;
    Price price;

    // define expected XML tags/properties
    private final String CATALOG = "catalog";
    private final String BOOK = "book";
    private final String ID = "id";
    private final String COVER = "cover";
    private final String AUTHORS = "authors";
    private final String AUTHOR = "author";
    private final String FIRSTNAME = "first_name";
    private final String LASTNAME = "last_name";
    private final String TITLE = "title";
    private final String GENRE = "genre";
    private final String PRICE = "price";
    private final String CURRENCY = "currency";
    private final String PUBLISHDATE = "publish_date";
    private final String DESCRIPTION = "description";

    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public void startDocument() throws SAXException {
        // initialize nested objects
        catalog = new Catalog();
        book = new Book();
        bookList = new ArrayList<>();
        author = new Author();
        authorList = new ArrayList<>();
        price = new Price();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // clear the stringBuilder
        elementValue.setLength(0);

        // extract XML properties and call setters
        switch (qName.toLowerCase()) {
            case CATALOG: {
                catalog = new Catalog();
                break;
            }
            case BOOK: {
                book = new Book();
                book.setId(attributes.getValue(ID));
                book.setCover(attributes.getValue(COVER));
                break;
            }
            case AUTHORS: {
                authorList = new ArrayList<>();
                break;
            }
            case PRICE: {
                price.setCurrency(attributes.getValue(CURRENCY));
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // call setters with the current values in the stringBuilder
        switch (qName.toLowerCase()) {
            case CATALOG: {
                catalog.setBooks(bookList);
                bookList = new ArrayList<>();
                break;
            }
            case BOOK: {
                bookList.add(book);
                book = new Book();
                return;
            }
            case FIRSTNAME: {
                author.setFirstName(elementValue.toString());
                break;
            }
            case LASTNAME: {
                author.setLastName(elementValue.toString());
                break;
            }
            case AUTHOR: {
                authorList.add(author);
                break;
            }
            case AUTHORS: {
                book.setAuthorsList(authorList);
                authorList = new ArrayList<>();
                break;
            }
            case TITLE: {
                book.setTitle(elementValue.toString());
                break;
            }
            case GENRE: {
                book.setGenre(elementValue.toString());
                break;
            }
            case PRICE: {
                price.setAmount(Double.parseDouble(elementValue.toString()));
                book.setPrice(price);
                price = new Price();
                break;
            }
            case PUBLISHDATE: {
                book.setPublishDate(CustomDateDeserializer.dateParser(elementValue.toString()));
                break;
            }
            case DESCRIPTION: {
                book.setDescription(elementValue.toString());
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue.append(ch, start, length);
    }
}
