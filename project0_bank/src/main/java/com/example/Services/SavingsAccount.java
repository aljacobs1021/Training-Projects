package com.example.Services;

import com.example.Models.Account;

public class SavingsAccount extends Account {
    private double savingsBal;
    // private double amount;

    public SavingsAccount(int accNum, String user, double bal, String type, double savingsBal) {
        super(accNum, user, bal, type);
        this.savingsBal = savingsBal;
    }

    public SavingsAccount(double bal) {
        this.savingsBal = bal;
    }

    public double getSavingsBal() {
        return savingsBal;
    }

    public void setSavingsBal(double savingsBal) {
        this.savingsBal = savingsBal;
    }
}
