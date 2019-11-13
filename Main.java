package com.helloWorld;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    // eg.
    // Principle: 100000
    // Annual Interest Rate: 3.92
    // Period (Years): 30
    // Mortgage: $472.81

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // Principle
        System.out.print("Principle: ");
        int principle = scanner.nextInt();

        // Annual Interest
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

        // Period (Years)
        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        int months = period * MONTHS_IN_YEAR;

        // MORTGAGE
        // Use this formula to calculate mortgage repayments
        // M = P( r(1+r)^n / (1 + r)^n - 1 )
        double mortgage = principle * (monthlyInterest * Math.pow((1 + monthlyInterest), months))
                / (Math.pow(1 + monthlyInterest, months)) - 1;

        String result = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(result);
    }
}