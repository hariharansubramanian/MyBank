package com.example.hari.mybank;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BankAccount mBank = new BankAccount();
        final EditText mAmountInput = (EditText) findViewById(R.id.userinput);
        Button mBtnWithdraw = (Button) findViewById(R.id.withdraw);
        Button mBtnDeposit = (Button) findViewById(R.id.deposit);
        final TextView mAmountDisplay = (TextView) findViewById(R.id.amount);
        Log.d(TAG,"Overdraft Fee is"+BankAccount.OVERDRAFT_FEE);
        mBtnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mBank.Withdraw(Double.parseDouble(amount));
                mAmountDisplay.setText("Your Account's balance is :" + mBank.getmBalance());
            }
        });
        mBtnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mBank.Deposit(Double.parseDouble(amount));
                mAmountDisplay.setText("Your Account's balance is :" + mBank.getmBalance());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
