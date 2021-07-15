package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee employee = new Employee();
        Customer customer = new Customer();

        System.out.println("Welcome to Bank of AJ, where we guarantee you keep most of your money!*");
        System.out.println("*Don't read the fine print...");
        System.out.println("Please pick a choice from the menu:");
        System.out.println("a.) Log in \nb.) Sign up \nc.) Forgot Login \nd.) Quit");
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        // NEED TO ADD DO WHILE / WHILE LOOP HERE

        // System.out.println(choice);

        // deciphers between the choices
        if (choice.contains("b") || choice.contains("sign up")) {
            // System.out.println("you picked sign up");
            customer.signUp();
        } else if (choice.contains("a") || choice.contains("log in")) {
            // System.out.println("you picked log in");
            customer.logIn();
        } else if (choice.contains("c") || choice.contains("forgot login")) {
            // System.out.println("you picked log in");
            customer.forgotLogIn();
        } else if (choice.contains("d") || choice.contains("quit")) {
            // System.out.println("you picked log in");
            System.out.println("Thanks for using Bank of AJ! Goodbye!");
        }
    }

}
