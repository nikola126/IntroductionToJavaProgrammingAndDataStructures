package com.programming.java.JSoup;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class WebScrape {
    public static void parseTelegraphStocksOld() {
        // https://www.youtube.com/watch?v=PF0iyeDmu9E
        final String URL = "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";

        try {
            final Document document = Jsoup.connect(URL).get();

            for (Element row : document.select("table.tablesorter.full tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    // header row with no data
                    System.out.println(row);
                } else {
                    String ticker = row.select("td:nth-of-type(1)").text();
                    String name = row.select("td:nth-of-type(2)").text();
                    String priceAsString = row.select("td:nth-of-type(3)").text();

                    // Comma in thousands leads to parsing errors
                    priceAsString = priceAsString.replace(",", "");
                    double price = Double.parseDouble(priceAsString);

                    System.out.println(ticker + " " + name + " " + price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseBnbExchangeRates() {
        final String URL = "https://bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/index.htm";

        BnbForeignCurrencyRates bnbForeignCurrencyRates = new BnbForeignCurrencyRates();

        try {
            final Document document = Jsoup.connect(URL).get();

            // isolate date
            // <h2>Курсове на българския лев към отделни чуждестранни валути и цена на златото, валидни за 17.05.2022</h2>
            Date date;
            for (Element row : document.select("#Exchange_Rate_Search > h2")) {
                String[] tokens = row.text().split(" ");

                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    date = formatter.parse(tokens[tokens.length - 1]);
                    bnbForeignCurrencyRates.setDate(date);
                    break;
                } catch (ParseException e) {
                    System.out.println("Could not parse date!");
                    System.out.println("Tokens: " + Arrays.toString(tokens));
                }
            }

            // Fill the exchange rates
            List<ExchangeRate> exchangeRateList = new ArrayList<>();

            // Copy Selector in Edge
            for (Element row : document.select("#Exchange_Rate_Search > div.table_box > table > tbody > tr")) {
                System.out.println(row);

                try {
                    String bgFullName = row.select("td:nth-child(1)").text();
                    String enSymbol = row.select("td:nth-child(2)").text();
                    int amountForeignCurrency = Integer.parseInt(row.select("td:nth-child(3)").text());
                    double priceInBGN = Double.parseDouble(row.select("td:nth-child(4)").text());
                    double singleUnitPriceInBGN = priceInBGN / amountForeignCurrency;

                    // System.out.println(bgFullName + " " + enSymbol + " " + amountForeignCurrency + " " + priceInBGN);

                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setCurrencyNameBG(bgFullName);
                    exchangeRate.setCurrencySymbol(enSymbol);
                    exchangeRate.setAmountForeignUnits(amountForeignCurrency);
                    exchangeRate.setPriceInBGN(priceInBGN);
                    exchangeRate.setSingeUnitPriceInBGN(singleUnitPriceInBGN);

                    exchangeRateList.add(exchangeRate);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing row: ");
                    System.out.println(row);
                }
            }

            bnbForeignCurrencyRates.setExchangeRates(exchangeRateList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(bnbForeignCurrencyRates);
    }

    public static void main(String[] args) {
//        parseTelegraphStocksOld();
        parseBnbExchangeRates();
    }
}
