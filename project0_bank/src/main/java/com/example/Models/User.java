package com.example.Models;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    // private int employeeID;

    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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
 */
