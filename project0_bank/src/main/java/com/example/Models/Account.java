package com.example.Models;

public class Account {
    private int accNum;
    private String user;
    private double accBal;

    public Account(int accNum, String user, double accBal) {
        this.user = user;
        this.accNum = accNum;
        this.accBal = accBal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAccNum() {
        return accNum;
    }

    public double getAccBal() {
        return accBal;
    }

    @Override
    public String toString() {
        return "Account [accNum=" + accNum + ", accBal=" + accBal + ", user=" + user + "]";
    }
}
