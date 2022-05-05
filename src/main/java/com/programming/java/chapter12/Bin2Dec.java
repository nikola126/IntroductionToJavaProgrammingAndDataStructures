package com.programming.java.chapter12;

import com.programming.java.chapter12.customExceptions.BinaryFormatException;

import java.util.Scanner;

public class Bin2Dec {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a binary number: ");
        String bin = input.nextLine();

        int decimal = 0;

        try {
            decimal = binToDecimal(bin.toUpperCase());
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("The decimal value for bin number "
                + bin + " is " + decimal);
    }

    public static int binToDecimal(String bin) throws BinaryFormatException {
        int power = 0;
        int decimalValue = 0;

        for (int i = bin.length() - 1; i >= 0; i--) {
            char binChar = bin.charAt(i);
            if (binChar == '0' || binChar == '1') {
                decimalValue += Integer.parseInt(String.valueOf(binChar)) * Math.pow(2, power);
                power += 1;
            } else
                throw new BinaryFormatException("Invalid symbol found in binary string!");
        }

        return decimalValue;
    }
}
