package com.example.Services;

import com.example.DAO.AccountsDAO;
import com.example.DAO.CustomerDB;
import com.example.DAO.CustomersDAO;
import com.example.Models.Account;
import com.example.Models.Customer;
import com.example.Models.User;
import java.util.Random;

public class CustomerServices {
    private CustomersDAO cDao;
    private AccountsDAO aDao;
    private double bal;
    private String user;
    private String type;
    Random num = new Random();

    public CustomerServices(CustomersDAO c, AccountsDAO a) {
        this.cDao = c;
        this.aDao = a;
    }

    public Account makeNewBankAccount(int accNum, String username, double bal, String type) {
        accNum = num.nextInt(1000) + 9999;
        this.user = username;
        this.bal = bal;
        this.type = type;
        aDao.createAccount(a);
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Random getNum() {
        return num;
    }

    public void setNum(Random num) {
        this.num = num;
    }

}

/*
 * public void makeNewAccount(int accNum, String username, String password,
 * double startBal, String type) { Account acc = new Account(accNum, username,
 * password, startBal, type); aDao.createAccount(acc); }
 * 
 * public CustomerServices(double balance, double amount) {
 * 
 * }
 * 
 * private double amount;
 * 
 */
