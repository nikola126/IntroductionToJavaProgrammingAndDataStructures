package com.programming.java.IntroductionToJavaNakov.ch12_Exceptions;

public class FileParseException extends Exception {
    private String msg;
    private String filename;
    private int line;

    public FileParseException(String msg, String filename, int line) {
        this.msg = msg;
        this.filename = filename;
        this.line = line;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File: ").append(filename).append("\n");
        stringBuilder.append("At line ").append(String.valueOf(line)).append(": ");
        stringBuilder.append(msg);

        return stringBuilder.toString();
    }
}
