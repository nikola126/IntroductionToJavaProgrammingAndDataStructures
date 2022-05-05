package com.programming.java.IntroductionToJavaLiang.ch12_ExceptionHandlingTextIO;

import com.programming.java.IntroductionToJavaLiang.ch12_ExceptionHandlingTextIO.customExceptions.HexFormatException;

import java.util.Scanner;

public class Hex2Dec {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();

        int decimal = 0;

        try {
            decimal = hexToDecimal(hex.toUpperCase());
        } catch (HexFormatException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("The decimal value for hex number "
                + hex + " is " + decimal);
    }

    public static int hexToDecimal(String hex) throws HexFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) throws HexFormatException {
        if (ch >= 'F')
            throw new HexFormatException("Non-hex character found!");

        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0', '1', ..., or '9'
            return ch - '0';
    }
}