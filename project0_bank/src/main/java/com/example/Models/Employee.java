package com.example.Models;

import java.util.Random;

public class Employee extends User {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private int employeeID;
    Random num = new Random();

    public Employee(int employeeID, String first, String last, String user, String email, String password) {
        this.employeeID = num.nextInt(1000) + 9999;
        this.firstName = first;
        this.lastName = last;
        this.username = user;
        this.email = email;
        this.password = password;
    }

    public Employee() {
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

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee [email=" + email + ", employeeID=" + employeeID + ", firstName=" + firstName + ", lastName="
                + lastName + ", password=" + password + ", username=" + username + "]";
    }

}
