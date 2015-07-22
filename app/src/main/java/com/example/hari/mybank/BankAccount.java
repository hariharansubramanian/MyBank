package com.example.hari.mybank;

/**
 * Created by Nicky on 7/22/2015.
 */
public class BankAccount {
    private double mBalance;
    public static final double OVERDRAFT_FEE = 30;

    public void Withdraw(double amount) {
         mBalance -= amount;
        if (mBalance < 0) {                                 //If Negative balance then deduct Overdraft Fee
            mBalance -=OVERDRAFT_FEE;
        }
    }

    public void Deposit(double amount) {
        mBalance += amount;

    }

    public double getmBalance() {
        return mBalance;
    }
}
