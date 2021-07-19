package com.example.Models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private List<Customer> customers;
    private List<Employee> employees;

    public User() {
        customers = new ArrayList<Customer>();
        employees = new ArrayList<Employee>();
    }

    // customers
    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.customers = new ArrayList<Customer>();
    }

    // employees
    public User(int employeeID, String firstName, String lastName, String email, String username, String password) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.employees = new ArrayList<Employee>();
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
