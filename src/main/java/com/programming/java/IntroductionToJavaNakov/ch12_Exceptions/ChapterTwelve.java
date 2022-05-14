package com.programming.java.IntroductionToJavaNakov.ch12_Exceptions;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class ChapterTwelve {

    public static final String HOME = "./src/main/resources/textFiles/";

    public static String fileToString(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder stringBuilder = new StringBuilder();

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append('\n');
        }

        bufferedReader.close();
        fileInputStream.close();

        return stringBuilder.toString();
    }

    public static void taskEight() {
        String fileName = HOME + "text.txt";

        try {
            System.out.println(fileToString(fileName));
        } catch (IOException e) {
            System.out.println("Exception while reading the file.");
        }
    }

    public static void copyBinaryFile(String binaryFilename) throws IOException {
        String outputFilename = HOME + "output.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            fileInputStream = new FileInputStream(binaryFilename);
            fileOutputStream = new FileOutputStream(outputFilename);
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] data = new byte[10];
            int bytesRead = 0;

            while (bytesRead != -1) {
                bytesRead = fileInputStream.read(data, 0, 10);
                fileOutputStream.write(data);
            }
        } catch (IOException ignored) {
        } finally {
            if (fileInputStream != null)
                fileInputStream.close();
            if (fileOutputStream != null)
                fileOutputStream.close();
            if (byteArrayOutputStream != null)
                byteArrayOutputStream.close();
        }
    }

    public static void taskNine() {
        String fileName = HOME + "text.txt";

        try {
            copyBinaryFile(fileName);
        } catch (IOException e) {
            System.out.println("Exception while reading the file.");
        }
    }

    public static void parseFile() throws FileParseException, IOException {
        String fileName = HOME + "numbers.txt";

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int lineNumber = 0;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                lineNumber += 1;
                Integer.parseInt(line);
            }
        } catch (NumberFormatException e) {
            throw new FileParseException("Text encountered when number is expected", fileName, lineNumber);
        } finally {
            if (fileReader != null)
                fileReader.close();
            if (bufferedReader != null)
                bufferedReader.close();
        }
    }

    public static void taskTen() {
        try {
            parseFile();
        } catch (FileParseException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        taskEight();
        taskNine();
        taskTen();
    }
}
