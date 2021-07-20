package com;

//import java.beans.Transient;
import java.util.Scanner;

import com.example.Models.Customer;
import com.example.Models.Employee;
import com.example.Models.User;
import com.example.Services.UserServices;

//import org.apache.logging.log4j.core.layout.SyslogLayout;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee employee = new Employee();
        Customer customer = new Customer();
        User u = new User();
        UserServices uServ = new UserServices();
        boolean done = false;

        System.out.println("Welcome to Bank of AJ, where we guarantee you keep most of your money!*");
        System.out.println("*Don't read the fine print...");

        // deciphers between the choices
        while (!done) {
            System.out.println("Please pick a choice from the menu:");
            System.out.println("a.) Log in \nb.) Sign up \nc.) Quit");
            String choice = input.nextLine();
            choice = choice.toLowerCase();

            if (choice.contains("b") || choice.contains("sign up")) {
                // System.out.println("you picked sign up");
                System.out.println("Please enter your first name: ");
                String first = input.nextLine();
                System.out.println("Please enter your last name: ");
                String last = input.nextLine();
                System.out.println("Please enter your email: ");
                String email = input.nextLine().toLowerCase();
                while (!email.contains("@") || !email.contains(".")) {
                    System.out.println("Please enter a valid email");
                    email = input.nextLine().toLowerCase();
                }
                System.out.println("Please enter a username: ");
                String user = input.nextLine();
                System.out.println("Please enter a password: ");
                String pass = input.nextLine();
                int ID = employee.getEmployeeID();
                if (email.contains("bankofAJ.com")) {
                    try {
                        u = uServ.employeeSignUp(ID, first, last, email, user, pass);
                        System.out.println("Welcome to the workforce, " + first
                                + "! Please login with your new username: " + u.getUsername());
                    } catch (Exception e) {
                        System.out.println("Sorry, we could not process your request");
                        System.out.println("Please try again later");
                        done = true;
                    }
                } else {
                    try {
                        u = uServ.customerSignUp(first, last, email, user, pass);
                        System.out.println("Congrats! Please login with your new username: " + u.getUsername());
                    } catch (Exception e) {
                        System.out.println("Sorry, we could not process your request");
                        System.out.println("Please try again later");
                        done = true;
                    }
                }
            } else if (choice.contains("a") || choice.contains("log in")) {
                int attempts = 0;
                while (attempts < 3) {
                    System.out.print("Please enter your username: ");
                    String username = input.nextLine();
                    System.out.print("Please enter your password: ");
                    String password = input.nextLine();
                    try {
                        customer = uServ.login(username, password);
                        System.out.println("Welcome " + u.getFirstName());
                    } catch (Exception e) {
                        System.out.println("Username or password was incorect, please try again.");
                        attempts++;
                    }
                    if (attempts >= 3) {
                        System.out.println("Sorry, you've tried to login too many times. Goodbye!");
                        done = true;
                    } else {

                    }
                }

            } // else if (choice.contains("c") || choice.contains("forgot login")) {
              // System.out.println("you picked log in");
              // customer.forgotLogIn();
              // }
            else if (choice.contains("c") || choice.contains("quit")) {
                // System.out.println("you picked log in");
                System.out.println("Thanks for using Bank of AJ! Goodbye!");
                done = true;
                input.close();
            } else {
                System.out.println("Please pick a valid choice, or type 'quit' to exit");
                System.out.println("");
            }
        }
    }

}
