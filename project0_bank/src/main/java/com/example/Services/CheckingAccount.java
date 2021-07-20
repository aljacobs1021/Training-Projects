package com.example.Services;

import com.example.Models.Account;

public class CheckingAccount extends Account {
    private double checkingBal;
    // private double amount;

    public CheckingAccount(int accNum, String user, double bal, String type, double checkingBal) {
        super(accNum, user, bal, type);
        this.checkingBal = checkingBal;
    }

    public CheckingAccount(double bal) {
        this.checkingBal = bal;
    }

    public double getCheckingBal() {
        return checkingBal;
    }

    public void setCheckingBal(double checkingBal) {
        this.checkingBal = checkingBal;
    }

}
