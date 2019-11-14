package com.helloWorld;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Calls the readNumber method to get the user input for the principal, annual interest and period

        int principal = (int)readNumber("Princple: ", 1000, 1000000);
        float annualInterest = (float)readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte)readNumber("Period (Years): ", 1, 30);

        // Calls the calculateMortgage method to work out the monthly repayments

        double mortgage = calculateMortgage(principal, annualInterest, years);

        // Formats the monthly repayments to currency

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }


    public static double readNumber(String prompt, double min, double max){

        // Prompts the user to input a value for the principal, annual interest and period
        // Will re-prompt the user if the value is not within the min and max

        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }


    public static double calculateMortgage(int principal, float annualInterest, byte years) {

        // Calculates monthly repayment amounts by:
        // M = P( r(1+r)^n  /   (1 + r)^n - 1 )

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}
