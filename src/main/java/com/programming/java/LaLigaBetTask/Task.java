package com.programming.java.LaLigaBetTask;

import com.programming.java.LaLigaBetTask.Classes.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        // Task 1
        League league = WebScrape.parseLaLiga();

        // Task 2
        printTeams(league.getTeams());

        // Task 3
        printNoDraws(league);

        // Task 4
        writeLastRoundToExcel(league);
    }

    public static void printTeams(Set<Team> teams) {
        for (Team team : teams) {
            System.out.printf("%s;1x%d;Xx%d;2x%d\n",
                    team.getName(), team.getHomeWins(), team.getDraws(), team.getAwayWins());
        }
    }

    public static void printNoDraws(League league) {
        Map<String, Integer> lastDrawMap = new HashMap<>();
        Map<String, Integer> streakMap = new TreeMap<>();

        System.out.printf("%-20s %-10s %25s\n", "Team", "Round", "Round since last draw");

        for (Round round : league.getRounds()) {
            int currentRound = round.getNumber();

            streakMap.clear();

            for (Game game : round.getGameList()) {
                // Update last time those teams had a draw
                if (game.getGameResult().equals(GameResult.DRAW)) {
                    lastDrawMap.put(game.getNameTeamHome(), currentRound);
                    lastDrawMap.put(game.getNameTeamAway(), currentRound);
                }

                // Calculate streaks
                int lastDrawRoundTeamHome = lastDrawMap.getOrDefault(game.getNameTeamHome(), 0);
                int streakWithoutDrawTeamHome = currentRound - lastDrawRoundTeamHome;

                int lastDrawRoundTeamAway = lastDrawMap.getOrDefault(game.getNameTeamAway(), 0);
                int streakWithoutDrawTeamAway = currentRound - lastDrawRoundTeamAway;

                if (streakWithoutDrawTeamHome > 0)
                    streakMap.put(game.getNameTeamHome(), streakWithoutDrawTeamHome);
                if (streakWithoutDrawTeamAway > 0)
                    streakMap.put(game.getNameTeamAway(), streakWithoutDrawTeamAway);

            }

            // Sort by streaks descending
            List<Map.Entry<String, Integer>> sorted = streakMap.entrySet().stream().sorted(new CustomStreakComparator()).collect(Collectors.toList());

            for (Map.Entry<String, Integer> entry : sorted) {
                System.out.printf("%-20s %-10s %5d\n", entry.getKey(), "Round " + currentRound, entry.getValue());
            }
            System.out.println();
        }
    }

    public static void writeLastRoundToExcel(League league) {
        String outputFileLocation = "./src/main/resources/LaLiga.xlsx";

        Workbook workbook = new XSSFWorkbook();

        // Define Structure
        int lastRoundIndex = league.getRounds().size();
        Sheet sheet = workbook.createSheet(league.getName() + " round " + lastRoundIndex);
        sheet.setColumnWidth(0, 11000);   // Teams
        sheet.setColumnWidth(1, 2500);    // Score
        sheet.setColumnWidth(2, 2500);    // Odds 1
        sheet.setColumnWidth(3, 2500);    // Odds X
        sheet.setColumnWidth(4, 2500);    // Odds 2
        sheet.setColumnWidth(5, 5000);   // Date

        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(25);

        // Define Fonts
        XSSFFont headerFont = ((XSSFWorkbook) workbook).createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 16);
        headerFont.setBold(true);

        XSSFFont contentFont = ((XSSFWorkbook) workbook).createFont();
        contentFont.setFontName("Arial");
        contentFont.setFontHeightInPoints((short) 12);
        contentFont.setBold(false);

        XSSFFont correctOddFont = ((XSSFWorkbook) workbook).createFont();
        correctOddFont.setFontName("Arial");
        correctOddFont.setFontHeightInPoints((short) 12);
        correctOddFont.setBold(true);

        // Define Styles
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setFont(headerFont);

        CellStyle contentStyle = workbook.createCellStyle();
        contentStyle.setAlignment(HorizontalAlignment.CENTER);
        contentStyle.setBorderBottom(BorderStyle.THIN);
        contentStyle.setBorderTop(BorderStyle.THIN);
        contentStyle.setBorderLeft(BorderStyle.THIN);
        contentStyle.setBorderRight(BorderStyle.THIN);
        contentStyle.setFont(contentFont);

        CellStyle correctOddStyle = workbook.createCellStyle();
        correctOddStyle.setAlignment(HorizontalAlignment.CENTER);
        correctOddStyle.setBorderBottom(BorderStyle.THIN);
        correctOddStyle.setBorderTop(BorderStyle.THIN);
        correctOddStyle.setBorderLeft(BorderStyle.THIN);
        correctOddStyle.setBorderRight(BorderStyle.THIN);
        correctOddStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        correctOddStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        correctOddStyle.setFont(correctOddFont);

        // Fill header
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Teams");
        headerCell.setCellStyle(headerStyle);

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Score");
        headerCell.setCellStyle(headerStyle);

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("1");
        headerCell.setCellStyle(headerStyle);

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("X");
        headerCell.setCellStyle(headerStyle);

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("2");
        headerCell.setCellStyle(headerStyle);

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Date");
        headerCell.setCellStyle(headerStyle);

        // Fill data
        int rowIndex = 1;
        Round lastRound = league.getRounds().get(lastRoundIndex - 1);

        for (Game game : lastRound.getGameList()) {
            Row row = sheet.createRow(rowIndex);
            row.setHeightInPoints(20);

            Cell cell = row.createCell(0);
            cell.setCellValue(game.getNameTeamHome() + " - " + game.getNameTeamAway());
            cell.setCellStyle(contentStyle);

            cell = row.createCell(1);
            cell.setCellValue(game.getScoreTeamHome() + ":" + game.getScoreTeamAway());
            cell.setCellStyle(contentStyle);

            cell = row.createCell(2);
            cell.setCellValue(game.getOdds1());
            if (game.getGameResult().equals(GameResult.HOME))
                cell.setCellStyle(correctOddStyle);
            else
                cell.setCellStyle(contentStyle);

            cell = row.createCell(3);
            cell.setCellValue(game.getOddsX());
            if (game.getGameResult().equals(GameResult.DRAW))
                cell.setCellStyle(correctOddStyle);
            else
                cell.setCellStyle(contentStyle);

            cell = row.createCell(4);
            cell.setCellValue(game.getOdds2());
            if (game.getGameResult().equals(GameResult.AWAY))
                cell.setCellStyle(correctOddStyle);
            else
                cell.setCellStyle(contentStyle);

            cell = row.createCell(5);
            cell.setCellValue(game.getGameDate().toString());
            cell.setCellStyle(contentStyle);

            rowIndex += 1;
        }

        // Save to File
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(outputFileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Exception writing to Excel file!");
        }
    }
}
