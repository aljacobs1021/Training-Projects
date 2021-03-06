package com.example.Models;

import java.util.Random;

public class Account {
    private int accNum;
    private String user; // username
    private String password;
    private String first;
    private String last;
    private String email;
    private double bal;
    private String type;
    Random num = new Random();

    // for customers
    public Account(int accNum, String user, double bal, String type) {
        //this.accNum = num.nextInt(100000) + 9999;
        this.user = user;
        this.bal = bal;
        this.type = type;
    }

    public Account(double bal, User u, String type) {
        this.user = u.getUsername();
        this.first = u.getFirstName();
        this.last = u.getLastName();
        this.email = u.getEmail();
        this.bal = bal;
        this.type = type;
    }

    // for employees
    public Account(int accNum, String first, String last, String user, String email, double bal, String type) {
        this.accNum = accNum;
        this.first = first;
        this.last = last;
        this.user = user;
        this.accNum = accNum;
        this.email = email;
    }

    public Account() {
    }

    public String getUser() {
        return user;
    }

    public int getAccNum() {
        return accNum;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account [accNum=" + accNum + ", bal=" + bal + ", first=" + first + ", last=" + last + ", password="
                + password + ", type=" + type + ", user=" + user + "]";
    }

}
