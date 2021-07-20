package com.example.Services;

import com.example.DAO.AccountsDAO;
// import com.example.DAO.CustomerDB;
import com.example.DAO.CustomersDAO;
import com.example.Logging.Logging;
import com.example.Models.Account;
// import com.example.Models.Customer;
// import com.example.Models.User;

import java.sql.SQLException;
import java.util.Random;

public class CustomerServices {
    // private CustomersDAO cDao;
    private AccountsDAO aDao;
    private double bal;
    private String user;
    private String type;
    private double amount;
    Random num = new Random();

    public CustomerServices(CustomersDAO c, AccountsDAO a) {
        // this.cDao = c;
        this.aDao = a;
    }

    public void makeNewBankAccount(int accNum, String username, double bal, String type) throws SQLException {
        Account a = new Account(accNum, username, bal, type);
        aDao.createAccount(a);
        Logging.logger.info("New account type " + type + " has been created.");
    }

    public double makeDeposit(double bal, String type, double amount) {
        this.type = type;
        bal += amount;
        Logging.logger.info("Current user has made a deposit to an account.");
        return bal;
    }

    public double makeWithdrawal(double bal, String type, double amount) {
        this.type = type;
        if (amount > bal) {
            bal = 0;
            Logging.logger.info("Current user has made a withdrawal to an account resulting in a balance of zero.");
            return bal;
        } else {
            bal -= amount;
            Logging.logger.info("Current user has made a withdrawal to an account.");
            return bal;
        }
    }

    public void makeTransfer(double bal, int accNum, String type, double amount) {
        Account acc1 = new Account(accNum, user, bal, type);
        Account acc2 = new Account(accNum, user, bal, type);

        acc1.setBal((bal -= amount));
        acc2.setBal((bal += amount));
        Logging.logger.info("Current user has made a transfer between account " + acc1 + " and account " + acc2 + ".");
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
