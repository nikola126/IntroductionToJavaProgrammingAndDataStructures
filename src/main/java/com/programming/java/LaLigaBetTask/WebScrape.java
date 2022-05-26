package com.programming.java.LaLigaBetTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;

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

        // Initialize fields
        League league = new League();
        Set<Team> teamSet = new TreeSet<>(new CustomTeamComparator());
        Round currentRound = new Round();
        List<Game> gameList = new ArrayList<>();
        List<Round> roundList = new ArrayList<>();
        Game currentGame;

        try {
            final Document document = Jsoup.connect(URL).get();


            // isolate League Name and Years
            for (Element row : document.select(selectorLeagueTitleAndYear)) {

                String titleText = row.text();
                int yearIndex = titleText.length() - 9;
                String leagueName = titleText.substring(0, yearIndex).trim();

                // TODO These can be extracted from the first/last game played
                String startYearText = titleText.substring(titleText.length() - 9, titleText.length() - 5);
                String endYearText = titleText.substring(titleText.length() - 4);
                LocalDate startDate = LocalDate.of(Integer.parseInt(startYearText), 1, 1);
                LocalDate endDate = LocalDate.of(Integer.parseInt(endYearText), 1, 1);

                league.setName(leagueName);
                league.setStartYear(startDate);
                league.setEndYear(endDate);
            }

            int currentRoundNumber = 0;

            // parse table rows
            for (Element row : document.select(selectorTableRow)) {
                String nameTeamHome = null, nameTeamAway = null;
                int scoreTeamHome = 0, scoreTeamAway = 0;
                double[] oddsArray = new double[3];
                int oddsIndex = 0;
                LocalDate gameDate = LocalDate.now();

                Elements tableDataCells = row.select("td");

                if (tableDataCells.size() <= 1) {
                    // isolate round row

                    if (currentRoundNumber != 0) {
                        // add the completed round to the list
                        currentRound.setNumber(currentRoundNumber);
                        currentRound.setGameList(gameList);
                        roundList.add(currentRound);

                        currentRound = new Round();
                        gameList = new ArrayList<>();
                    }

                    currentRoundNumber = Integer.parseInt(row.text().split("\\.")[0]);
                    continue;
                }

                currentGame = new Game();

                for (Element cell : tableDataCells) {
                    if (cell.hasClass(selectorTeamsCell)) {
                        // isolate team names
                        String[] teams = cell.text().split(" - ");
                        if (teams.length != 2)
                            throw new IllegalArgumentException("Error parsing " + cell.text());
                        nameTeamHome = teams[0].trim();
                        nameTeamAway = teams[1].trim();
                    } else if (cell.hasClass(selectorScoreCell)) {
                        // isolate score
                        String[] scores = cell.text().split(":");
                        if (scores.length != 2)
                            throw new IllegalArgumentException("Error parsing " + cell.text());
                        scoreTeamHome = Integer.parseInt(scores[0]);
                        scoreTeamAway = Integer.parseInt(scores[1]);
                    } else if (cell.hasClass(selectorDateCell)) {
                        // isolate date
                        String dateText = cell.text();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        try {
                            gameDate = LocalDate.parse(dateText, dtf);
                        } catch (DateTimeParseException e) {
                            // if game is played in the current year, the year is not shown
                            dateText = dateText + gameDate.get(ChronoField.YEAR);
                            gameDate = LocalDate.parse(dateText, dtf);
                        }
                    } else if (cell.hasAttr("data-odd")) {
                        // isolate odds
                        oddsArray[oddsIndex++] = Double.parseDouble(cell.attr(selectorOddsCell));
                    }
                    // odds are colored and nested in several span elements depending on game result
                    else if (cell.hasClass(selectorOddsCellColored)) {
                        for (Element span : cell.select("span"))
                            if (span.hasAttr(selectorOddsCell)) {
                                oddsArray[oddsIndex++] = Double.parseDouble(span.attr(selectorOddsCell));
                            }
                    }

                }

                // Add game to the list
                currentGame.setNameTeamHome(nameTeamHome);
                currentGame.setNameTeamAway(nameTeamAway);
                currentGame.setScoreTeamHome(scoreTeamHome);
                currentGame.setScoreTeamAway(scoreTeamAway);
                currentGame.setOdds1(oddsArray[0]);
                currentGame.setOddsX(oddsArray[1]);
                currentGame.setOdds2(oddsArray[2]);
                currentGame.setGameDate(gameDate);

                GameResult currentGameResult;
                if (scoreTeamHome > scoreTeamAway)
                    currentGameResult = GameResult.HOME;
                else if (scoreTeamHome < scoreTeamAway)
                    currentGameResult = GameResult.AWAY;
                else
                    currentGameResult = GameResult.DRAW;

                currentGame.setGameResult(currentGameResult);

                gameList.add(currentGame);

                // TODO Extract in method, CLEAN PLS
                // Update Team statistics
                // Update Team statistics - Home team
                Iterator<Team> iterator = teamSet.iterator();
                Team teamInSet = null;
                boolean setContainsTeam = false;

                Team homeTeam = new Team();
                homeTeam.setName(nameTeamHome);

                while (iterator.hasNext()) {
                    teamInSet = iterator.next();

                    if (Objects.equals(teamInSet.getName(), homeTeam.getName())) {
                        homeTeam.setHomeWins(teamInSet.getHomeWins());
                        homeTeam.setDraws(teamInSet.getDraws());
                        homeTeam.setAwayWins(teamInSet.getAwayWins());
                        // Team is already in the set
                        if (currentGameResult.equals(GameResult.HOME))
                            homeTeam.setHomeWins(teamInSet.getHomeWins() + 1);
                        else if (currentGameResult.equals(GameResult.DRAW))
                            homeTeam.setDraws(teamInSet.getDraws() + 1);

                        setContainsTeam = true;
                        break;
                    }
                }
                if (!setContainsTeam) {
                    // add team to the set
                    if (currentGameResult.equals(GameResult.HOME))
                        homeTeam.setHomeWins(1);
                    else if (currentGameResult.equals(GameResult.DRAW))
                        homeTeam.setDraws(1);
                    teamSet.add(homeTeam);
                } else {
                    teamSet.remove(teamInSet);
                    teamSet.add(homeTeam);
                }

                // Update Team statistics - Away team
                // TODO this avoids ConcurrentModificationException, unnecessary?
                iterator = teamSet.iterator();
                teamInSet = new Team();

                Team awayTeam = new Team();
                awayTeam.setName(nameTeamAway);

                setContainsTeam = false;

                while (iterator.hasNext()) {
                    teamInSet = iterator.next();

                    if (Objects.equals(teamInSet.getName(), awayTeam.getName())) {
                        awayTeam.setHomeWins(teamInSet.getHomeWins());
                        awayTeam.setDraws(teamInSet.getDraws());
                        awayTeam.setAwayWins(teamInSet.getAwayWins());
                        // Team is already in the set
                        if (currentGameResult.equals(GameResult.AWAY))
                            awayTeam.setAwayWins(teamInSet.getAwayWins() + 1);
                        else if (currentGameResult.equals(GameResult.DRAW))
                            awayTeam.setDraws(teamInSet.getDraws() + 1);

                        setContainsTeam = true;
                        break;
                    }
                }

                if (!setContainsTeam) {
                    // add team to set
                    if (currentGameResult.equals(GameResult.AWAY))
                        awayTeam.setAwayWins(1);
                    else if (currentGameResult.equals(GameResult.DRAW))
                        awayTeam.setDraws(1);
                    teamSet.add(awayTeam);
                } else {
                    teamSet.remove(teamInSet);
                    teamSet.add(awayTeam);
                }
            }

            // add the completed round to the list
            if (gameList.size() != 0) {
                currentRound.setNumber(currentRoundNumber);
                currentRound.setGameList(gameList);
                roundList.add(currentRound);
            }
        } catch (Selector.SelectorParseException | IOException e) {
            e.printStackTrace();
        }

        league.setRounds(roundList);
        league.setTeams(teamSet);
        System.out.println(league);
    }
}
