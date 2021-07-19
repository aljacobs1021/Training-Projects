package com.example.Models;

import java.util.ArrayList;
import java.util.List;

import com.example.DAO.AccountsDAO;
import com.example.DAO.CustomersDAO;

public abstract class Account {
    private int accNum;
    private String user; // username
    private String password;
    private String first;
    private String last;
    private double bal;
    private String type;
    private CustomersDAO cDao;
    private AccountsDAO aDao;
    private List<Account> accounts;
    // private double balance;
    // private double amount;

    // for employees

    public Account() {
        accounts = new ArrayList<Account>();
    }

    public Account(int accNum, String first, String last, String user, double bal, String type) {
        this.user = user;
        this.accNum = accNum;
        this.accounts = new ArrayList<Account>();

    }

    // for customers
    public Account(int accNum, String user, String password, double startBal, String type) {
        this.accNum = accNum;
        this.user = user;
        this.password = password;
    }

    public abstract void makeWithdrawl(double amount);

    public abstract void makeDeposit(double amount);

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

    @Override
    public String toString() {
        return "Account [accNum=" + accNum + ", bal=" + bal + ", first=" + first + ", last=" + last + ", password="
                + password + ", type=" + type + ", user=" + user + "]";
    }

}

// private double totalAccBal; // all accounts together
// private double startBal; // specific account balance
// this.startBal = startBal;
// this.totalAccBal = totalAccBal;
