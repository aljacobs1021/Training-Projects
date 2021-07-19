package com.example.Services;

import com.example.Models.Account;

public class CheckingAccount extends Account {

    public CheckingAccount(int accNum, String user, String password, double startBal, String type) {
        super(accNum, user, password, startBal, type);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void makeWithdrawl(double amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void makeDeposit(double amount) {
        // TODO Auto-generated method stub

    }

}
