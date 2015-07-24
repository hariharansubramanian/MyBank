package com.example.hari.mybank;

import android.util.Log;

/**
 * Created by Nicky on 7/24/2015.
 */
public class Savingsaccount extends BankAccount {
    public static final String TAG="Savingsaccount";
    @Override
    public void Withdraw(double amount) {
        Log.d(TAG,"Withdrawing from Savings..");
        if(numberOfNegativeWithdrawals()>=3){
            return;
        }
        super.Withdraw(amount);
    }
}
