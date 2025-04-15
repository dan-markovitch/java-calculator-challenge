package com.calculator_challenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers (e.g., 1,2):");
        String input = scanner.nextLine();
        Calculator calculator = new Calculator();
        try {
            int result = calculator.add(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}