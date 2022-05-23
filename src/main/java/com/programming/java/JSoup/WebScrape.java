package com.programming.java.JSoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static int countOccurences(String text, String target) {
        int position = 0;
        int count = 0;
        while ((position = text.indexOf(target, position)) != -1) {
            position = position + 1;
            count++;
        }
        return count;
    }

    public static void parseDirZodiac() {
        final String[] SIGNS = {"oven", "telets", "bliznatsi", "rak", "lav", "deva",
                "vezni", "skorpion", "strelets", "kozirog", "vodoley", "ribi"};
        String URL = "https://zodiac.dir.bg/sign/PLACEHOLDER/dneven-horoskop";

        for (String sign : SIGNS) {
            String urlToParse = URL.replace("PLACEHOLDER", sign);
            DirHoroscope dirHoroscope = new DirHoroscope();

            try {
                final Document document = Jsoup.connect(urlToParse).get();
                Elements elements = null;

                // extract sign
                elements = document.select("#first_row > h2");
                dirHoroscope.setSign(elements.get(0).text());

                // extract text
                elements = document.select("#content > div.article-body.horoscope > p");
                dirHoroscope.setText(elements.get(0).text());

                // extract type (daily, weekly...)
                elements = document.select("#horoscope_nav");
                elements = elements.select("a");

                for (Element element : elements) {
                    if (element.attributes().get("class").equals("active"))
                        dirHoroscope.setHoroscopeType(element.text());
                }

                // extract dates
                LocalDate startDate = null;
                LocalDate endDate = null;

                elements = document.select("#timestamp > span");
                String[] dateTokens = elements.text().split(" ");

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                for (String token : dateTokens) {
                    try {
                        if (startDate == null)
                            startDate = LocalDate.parse(token, dateTimeFormatter);
                        else
                            endDate = LocalDate.parse(token, dateTimeFormatter);
                    } catch (Exception ignored) {}
                }

                dirHoroscope.setHoroscopeStartDate(startDate);
                dirHoroscope.setHoroscopeEndDate(endDate);

                // extract categories
                elements = document.select("#star_rating");
                List<HoroscopeCategory> categoryList = new ArrayList<>();

                elements = elements.select("#star_rating > li");
                for (Element element : elements) {
                    HoroscopeCategory category = new HoroscopeCategory();

                    Elements select = element.select("div.rating_heading");
                    category.setName(select.text());

                    int allStars = countOccurences(element.toString(), "span class=\"star\"");
                    category.setMaxValue(allStars);

                    select = element.select("input");
                    category.setValue(Double.parseDouble(select.attr("value")));
                    categoryList.add(category);
                }
                dirHoroscope.setCategoryList(categoryList);

                 System.out.println(dirHoroscope);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        parseTelegraphStocksOld();
        parseBnbExchangeRates();
        parseDirZodiac();
    }
}
