package com.example.Services;

import com.example.DAO.AccountsDAO;
import com.example.Logging.Logging;
import com.example.Models.Account;
import com.example.Models.User;

import java.sql.SQLException;
import java.util.Random;

public class AccountServices {
    private AccountsDAO aDao;
    private double bal;
    private String user;
    private String type;
    private double amount;
    private User u;
    private Account a;
    Random num = new Random();

    public AccountServices(AccountsDAO aDao) {
        this.aDao = aDao;
    }

    public Account makeNewBankAccount(double bal, User user, String type) throws SQLException {
        Account a = new Account(bal, user, type);
        aDao.createAccount(a);
        Logging.logger.info("aServ: New account type " + type + " has been created.");

        return a;
    }

    public void makeDeposit(double amount, double bal, Account a) {
        bal = a.getBal();
        double newBal = bal + amount;
        Account updatedBal = new Account(a.getAccNum(), a.getUser(), newBal, a.getType());
        aDao.deposit(updatedBal);
    }

    public double makeWithdrawal(double amount) {
        if (amount > bal) {
            bal = 0;
            Logging.logger.info("aServ: " + u.getUsername() + " has made a withdrawal to account " + a.getAccNum()
                    + ", resulting in a balance of zero.");
            aDao.withdraw(a);
            return bal;
        } else {
            bal -= amount;
            aDao.withdraw(a);
            return bal;
        }
    }

    public void makeTransfer(double bal, int accNum, String type, double amount) {
        Account acc1 = new Account(accNum, user, bal, type);
        Account acc2 = new Account(accNum, user, bal, type);

        acc1.setBal((bal -= amount));
        acc2.setBal((bal += amount));
        Logging.logger
                .info("aServ: Current user has made a transfer between account " + acc1 + " and account " + acc2 + ".");
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