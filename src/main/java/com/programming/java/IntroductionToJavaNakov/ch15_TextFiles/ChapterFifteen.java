package com.programming.java.IntroductionToJavaNakov.ch15_TextFiles;

import com.programming.java.IntroductionToJavaNakov.ch7_Arrays.ChapterSeven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class ChapterFifteen {
    public static final String HOME = "./src/main/resources/textFiles/";

    public static void taskOne() {
        String fileName = "sample2.txt";
        String file = HOME + fileName;
        Scanner fileReader = null;
        int lineNumber = 0;
        try {
            fileReader = new Scanner(new File(file));
            System.out.println("File " + fileName + " opened.");

            while (fileReader.hasNextLine()) {
                lineNumber++;
                if (lineNumber % 2 == 0)
                    System.out.printf("Line %d:%s%n",
                            lineNumber, fileReader.nextLine());
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + fileName + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    public static void taskTwo() {
        String namesFile = "names.txt";
        String sortedFile = "sortedNames.txt";

        String file = HOME + namesFile;
        Scanner fileReader = null;

        List<String> names = new ArrayList<>();
        try {
            fileReader = new Scanner(new File(file));
            System.out.println("File " + namesFile + " opened.");

            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine().trim();
                names.add(name);
            }

            Collections.sort(names);

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + namesFile + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        file = HOME + sortedFile;
        PrintStream fileWriter = null;

        try {
            fileWriter = new PrintStream(file);
            System.out.println("File " + sortedFile + " opened.");

            for (String name : names) {
                fileWriter.println(name);
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + sortedFile + " could not be created");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public static void taskThree() {
        String matrixFile = "matrix.txt";
        String outputFile = "sum2x2.txt";

        String file = HOME + matrixFile;
        Scanner fileReader = null;

        int size = 0;
        int[][] matrix = new int[0][];
        try {
            fileReader = new Scanner(new File(file));
            System.out.println("File " + matrixFile + " opened.");

            int currentLine = 0;
            while (fileReader.hasNextLine()) {
                currentLine += 1;

                if (currentLine == 1) {
                    size = Integer.parseInt(fileReader.nextLine());
                    matrix = new int[size][size];
                }
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        try {
                            matrix[row][col] = fileReader.nextInt();
                        } catch (NoSuchElementException ignored) {
                        }
                    }
                }
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + matrixFile + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        int maxSum = ChapterSeven.maxPlatform2x2(matrix);

        file = HOME + outputFile;
        PrintStream fileWriter = null;

        try {
            fileWriter = new PrintStream(file);
            System.out.println("File " + outputFile + " opened.");

            fileWriter.println("Max 2x2 sum: " + maxSum);

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + outputFile + " could not be created");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public static String replaceStart(String line) {
        // TODO REGEX THIS
        StringBuilder sb = new StringBuilder();
        StringBuilder buffer;

        int N = line.length();

        for (int i = 0; i < N; i++) {
            char c = line.charAt(i);

            if (c == 's' || c == 'S') {
                // try to form start
                if (i + 4 < N) {
                    // there's enough place left for start
                    buffer = new StringBuilder();
                    buffer.append(line, i, i + 5);

                    if (buffer.toString().equals("start") || buffer.toString().equals("Start")) {
                        if (!Character.isAlphabetic(line.charAt(i + 5))) {
                            // start is NOT part of a longer word
                            // replace start with finish and increment the current index
                            if (Character.isUpperCase(c))
                                sb.append("Finish");
                            else
                                sb.append("finish");
                            sb.append(line.charAt(i + 5));
                            i += 5;
                        } else {
                            // it's a longer word, append and continue
                            sb.append(c);
                        }
                    } else {
                        // it's not start, append and continue
                        sb.append(c);
                    }
                    continue;
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static void taskFour() {
        String inputFileName = "article.txt";
        String outputFileName = "replaced.txt";

        String inputFile = HOME + inputFileName;
        String outputFile = HOME + outputFileName;

        Scanner fileReader = null;
        PrintStream fileOutput = null;

        try {
            fileReader = new Scanner(new File(inputFile));
            fileOutput = new PrintStream(outputFile);
            System.out.println("File " + inputFileName + " opened.");

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                line = replaceStart(line);
                fileOutput.println(line);
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileOutput != null) {
                fileOutput.close();
            }
        }
    }

    public static HashMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer> > list = new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // LinkedHashMap preserves iteration order!
        HashMap<String, Integer> ordered = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            ordered.put(entry.getKey(), entry.getValue());
        }
        return ordered;
    }

    public static void taskFive() {
        String wordsFileName = "words.txt";
        String textFileName = "text.txt";
        String resultFileName = "result.txt";

        String wordsFile = HOME + wordsFileName;
        String textFile = HOME + textFileName;
        String resultFile = HOME + resultFileName;

        Scanner fileReader = null;
        PrintStream fileWriter = null;

        HashMap<String, Integer> dictionary = new HashMap<>();

        try {
            fileReader = new Scanner(new File(wordsFile));

            while (fileReader.hasNext()) {
                dictionary.put(fileReader.next(), 0);
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        try {
            fileReader = new Scanner(new File(textFile));

            while (fileReader.hasNext()) {
                String word = fileReader.next();

                if (dictionary.containsKey(word)) {
                    dictionary.put(word, dictionary.get(word) + 1);
                }
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        HashMap<String, Integer> sorted = sortMapByValue(dictionary);

        try {
            fileWriter = new PrintStream(resultFile);

            fileWriter.println("Word - Occurrences");
            for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
                fileWriter.println(entry.getKey() + " - " + entry.getValue());
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found.");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public static void printAll() {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
    }

    public static void main(String[] args) {
        printAll();
    }
}
