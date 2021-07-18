package com.example.Models;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public Customer(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    @Override
    public String toString() {
        return "Customer [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", pass=" + password
                + ", user=" + username + "]";
    }

}

/*
 * public void signUp() { System.out.println("Please enter your full name: ");
 * fullName = input.nextLine(); System.out.
 * println("Please enter your email. Note that emails are case-sensitive: ");
 * newEmail = input.nextLine(); System.out.println("Please enter a username: ");
 * newUser = input.nextLine(); System.out.println("Please enter a password: ");
 * newPass = input.nextLine();
 * 
 * if (new user = exists) { Sysout
 * ("sorry that username already exists. Please pick another one: "); }
 * 
 * else if (new email = exists) { Sysout
 * ("That email already belongs to an account. please sign up with a new email."
 * " +
 * "\nif you've forgotten your username or password, please head to the login screen to reset."
 * ) } }
 * 
 * public void logIn() { System.out.println("logIn called!");
 * 
 * /* int i = 0;
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
 * if (i = 3) { forgotLogIn(); } }
 * 
 * public void forgotLogIn() { System.out.println("forgotLogIn called!");
 * 
 * /* sysout
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