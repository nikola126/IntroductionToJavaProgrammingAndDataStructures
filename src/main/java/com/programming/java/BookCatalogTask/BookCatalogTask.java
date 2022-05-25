package com.programming.java.BookCatalogTask;

import com.programming.java.JAXB.JaxbSerialization;
import com.programming.java.JSoup.BnbForeignCurrencyRates;
import com.programming.java.JSoup.ExchangeRate;
import com.programming.java.JSoup.WebScrape;
import com.programming.java.Jackson.Catalog.Book;
import com.programming.java.Jackson.Catalog.Catalog;
import com.programming.java.Jackson.JacksonSerialization;
import com.programming.java.Sax.SaxSerialization;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class BookCatalogTask {
    public static void main(String[] args) {
        BnbForeignCurrencyRates bnbForeignCurrencyRates = WebScrape.parseBnbExchangeRates();

        Catalog catalog;
        String xmlFileLocation = "./src/main/resources/xmlFiles/ms_books.xml";

        System.out.println("------Using Jackson------");
        catalog = JacksonSerialization.getCatalog(xmlFileLocation);
        printCatalog(catalog, bnbForeignCurrencyRates);
        System.out.println();

        System.out.println("------  Using JAXB ------");
        catalog = JaxbSerialization.getCatalog(xmlFileLocation);
        catalog.mapAuthorsToList();
        printCatalog(catalog, bnbForeignCurrencyRates);
        System.out.println();

        System.out.println("------  Using SAX  ------");
        catalog = SaxSerialization.getCatalog(xmlFileLocation);
        printCatalog(catalog, bnbForeignCurrencyRates);
        System.out.println();
    }

    public static void printCatalog(Catalog catalog, BnbForeignCurrencyRates foreignCurrencyRates) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        HashMap<String, Double> ratesMap = new HashMap<>();
        ratesMap.put("BGN", 1.00);
        for (ExchangeRate exchangeRate : foreignCurrencyRates.getExchangeRates()) {
            ratesMap.put(exchangeRate.getCurrencySymbol().toUpperCase(), exchangeRate.getSingeUnitPriceInBGN());
        }

        for (Book book : catalog.getBooks()) {
            String title = "Bez zaglavie";
            String price = "Cena po zapitvane";
            String date = "Bez data";

            if (book.getTitle() != null)
                title = book.getTitle();

            if (book.getPrice() != null)
                price = String.format("%.2f BGN", ratesMap.get(book.getPrice().getCurrency().toUpperCase()) * book.getPrice().getAmount());

            if (book.getPublishDate() != null)
                date = book.getPublishDate().format(dtf);

            System.out.printf("%-50s %-25s %10s\n", title, price, date);
        }
    }
}
