package com.example.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private boolean isEmployee;
    private List<Account> accounts;

    public User() {
        accounts = new ArrayList<Account>();
    }

    public User(int id, String firstName, String lastName, String email, String password, boolean isEmployee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
        this.email = email;
        this.password = password;
        this.setEmployee(isEmployee);
        this.accounts = new ArrayList<Account>();
    }

    // Used to send user info to the database because the db auto generates the id
    public User(String firstName, String lastName, String email, String password, boolean isEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
        this.email = email;
        this.password = password;
        this.setEmployee(isEmployee);
        this.accounts = new ArrayList<Account>();
    }

    // User to get user info from the database
    public User(int id, String firstName, String lastName, String username, String email, String password,
            boolean isEmployee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.setEmployee(isEmployee);
        this.accounts = new ArrayList<Account>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
                + ", email=" + email + ", password=" + password + ", accounts=" + accounts + "]";
    }
}

/*
 * customers
 * 
 * // employees public User(int employeeID, String firstName, String lastName,
 * String username, String email, String password) { this.firstName = firstName;
 * this.lastName = lastName; this.username = username; this.email = email;
 * this.password = password; }
 * 
 * public int getEmpID() { return employeeID; }
 * 
 * public void setEmpID(int employeeID) { this.employeeID = employeeID; }
 * 
 * public String getFirstName() { return firstName; }
 * 
 * public void setFirstName(String firstName) { this.firstName = firstName; }
 * 
 * public String getLastName() { return lastName; }
 * 
 * public void setLastName(String lastName) { this.lastName = lastName; }
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * @Override public String toString() { return "User [id=" + employeeID +
 * ", firstName=" + firstName + ", lastName=" + lastName + ", username=" +
 * username + ", email=" + email + ", password=" + password + "]"; }
 * 
 * public User() { }
 * 
 * public User(String firstName, String lastName, String username, String email,
 * String password) { this.firstName = firstName; this.lastName = lastName;
 * this.username = username; this.email = email; this.password = password; }
 * 
 * public int getEmployeeID() { return employeeID; }
 * 
 * public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
 * 
 * public void setFirstName(String firstName) { this.firstName = firstName; }
 * 
 * public void setLastName(String lastName) { this.lastName = lastName; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public String getFirstName() { return firstName; }
 * 
 * public String getLastName() { return lastName; }
 * 
 * public String getUsername() { return username; }
 * 
 * public String getEmail() { return email; }
 * 
 * public String getPassword() { return password; }
 */
