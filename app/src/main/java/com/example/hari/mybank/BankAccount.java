package com.example.hari.mybank;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nicky on 7/22/2015.
 */
public abstract class BankAccount {
    private double mBalance;
    private ArrayList<Double> mTransactions;
    public static final double OVERDRAFT_FEE = 30;


/*    BankAccount() {
        mTransactions = new ArrayList<Double>();
    }*/

    public BankAccount() {
        mTransactions = new ArrayList<Double>();
    }


    public void Withdraw(double amount) {
        mTransactions.add(-amount);
        if (getmBalance() < 0) {                                 //If Negative balance then deduct Overdraft Fee
            mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    public void Deposit(double amount) {
        mTransactions.add(amount);

    }

    protected int numberOfNegativeWithdrawals() {
        int count = 0;
        for (int i = 0; i < mTransactions.size(); i++) {


            if (mTransactions.get(i) < 0) {
                count++;
            }
        }
        return count;
    }

    public double getmBalance() {
        double total = 0;
        for (int i = 0; i < mTransactions.size(); i++) {
            total += mTransactions.get(i);
        }
        return total;
    }
}
