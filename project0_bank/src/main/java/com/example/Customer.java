package com.example;

import java.util.Scanner;

public class Customer {
    Scanner input = new Scanner(System.in);
    private String fullName;
    private String newEmail;
    private String newUser;
    private String newPass;
    private String email;
    private String user;
    private String pass;

    public void signUp() {
        System.out.println("Please enter your full name: ");
        fullName = input.nextLine();
        System.out.println("Please enter your email. Note that emails are case-sensitive: ");
        newEmail = input.nextLine();
        System.out.println("Please enter a username: ");
        newUser = input.nextLine();
        System.out.println("Please enter a password: ");
        newPass = input.nextLine();

        /*
         * if (new user = exists) { Sysout
         * ("sorry that username already exists. Please pick another one: "); }
         * 
         * else if (new email = exists) { Sysout
         * ("That email already belongs to an account. please sign up with a new email."
         * " +
         * "\nif you've forgotten your username or password, please head to the login screen to reset."
         * ) }
         */
    }

    public void logIn() {
        System.out.println("logIn called!");

        /*
         * int i = 0;
         * 
         * while (i < 3) { System.out.println("Please enter your username: "); user =
         * input.nextLine(); System.out.println("Please enter your password: "); pass =
         * input.nextLine();
         * 
         * if (user != exists) { sysout ("sorry, incorrect username, try again"); i++; }
         * 
         * else if (pass != userPassCombo) { sysout
         * ("sorry, incorrect password, try again") i++;}
         * 
         * }
         * 
         * if (i = 3) { forgotLogIn(); }
         */

    }

    public void forgotLogIn() {
        System.out.println("forgotLogIn called!");

        /*
         * sysout
         * ("Seems you're having trouble logging in. What would you like to do?");
         * 
         * sysout ("a.) Retrieve username \nb.) Reset password"); String choice =
         * input.toLowerCase().nextLine();
         * 
         * if (choice.contains("b") || choice.contains("reset password")) {
         * System.out.println("Please enter your username: "); user = input.nextLine();
         * 
         * sysout ("Enter your new password: "); newPass = input.nextLine(); pass =
         * newPass; sysout ("Your password has been changed. Please login."); } else if
         * (choice.contains("b") || choice.contains("retrieve username")) {
         * sysout("Please enter your email: "); email = input.nextLine();} else { sysout
         * ("Please enter a valid choice."); }
         */
    }

}