package com.programming.java.LaLigaBetTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import java.io.IOException;

public class WebScrape {
    public static void main(String[] args) {
        // LaLiga Results Tab
        final String URL = "https://www.betexplorer.com/soccer/spain/laliga/results/";

        final String selectorLeagueTitleAndYear = "body > div.wrap-page.wrap-page--advertbg > div.wrap-page__in > div > div > div.columns__item.columns__item--68.columns__item--tab-100 > section > header > h1 > span.tablet-desktop-only";
        final String selectorTableRow = "#js-leagueresults-all > div > div > table > tbody > tr";
        final String selectorTeamsCell = "h-text-left";
        final String selectorScoreCell = "h-text-center";
        final String selectorDateCell = "h-text-right h-text-no-wrap";
        final String selectorOddsCell = "data-odd";
        final String selectorOddsCellColored = "table-main__odds colored";

        try {
            final Document document = Jsoup.connect(URL).get();

            // isolate League Name and Years
            for (Element row : document.select(selectorLeagueTitleAndYear)) {
                System.out.println(row.text());
            }

            int round;

            // parse table rows
            for (Element row : document.select(selectorTableRow)) {
                String nameTeamHome, nameTeamAway;
                int scoreTeamHome, scoreTeamAway;
                double odds1, oddsX, odds2;
                String dateString;

                System.out.println(row.text());
                System.out.println("----------------------------------");

                Elements tableDataCells = row.select("td");
                if (tableDataCells.size() <= 1) {
                    // isolate round row
                    System.out.println("Round cell");
                    round = Integer.parseInt(row.text().split("\\.")[0]);
                    continue;
                }

                for (Element cell : tableDataCells) {
                    if (cell.hasClass(selectorTeamsCell)) {
                        // isolate team names
                        System.out.println("Teams: " + cell.text());
                    }
                    else if (cell.hasClass(selectorScoreCell)) {
                        // isolate score
                        System.out.println("Score: " + cell.text());
                    }
                    else if (cell.hasClass(selectorDateCell)) {
                        // isolate date
                        System.out.println("Date: " + cell.text());
                    }
                    else if (cell.hasAttr("data-odd"))
                    {
                        // isolate odds
                        System.out.println("Odds: " + cell.attr(selectorOddsCell));
                    }
                    // odds are colored and nested in several span elements depending on game result
                    else if (cell.hasClass(selectorOddsCellColored)) {
                        for (Element span : cell.select("span"))
                            if (span.hasAttr(selectorOddsCell))
                                System.out.println("Odds: " + span.attr(selectorOddsCell));
                    }
                }
            }
        } catch (Selector.SelectorParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
