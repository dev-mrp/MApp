package com.gladiator.code.merchant.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.gladiator.code.merchant.R;
import com.gladiator.code.merchant.Utils.SharedPreferenceStore;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPhoneNo;
    private EditText etPinCode;
    private Button btnLoad;
    private ProgressDialog mProgressBar;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mContext = getBaseContext();

        etName = (EditText) findViewById(R.id.et_name);
        etPhoneNo = (EditText) findViewById(R.id.et_phone);
        etPinCode = (EditText) findViewById(R.id.et_pin_code);
        btnLoad = (Button) findViewById(R.id.btn_load);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mProgressBar = new ProgressDialog(RegistrationActivity.this);
        mProgressBar.setMessage("Registering...");
    }

    class RegisterUser extends AsyncTask<Void, Void, Boolean> {

        private final int amount;

        public RegisterUser(int amount) {
            this.amount = amount;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                Thread.sleep(2000L);
                // Register user
                // set Username, phone, macAddress of user

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            mProgressBar.dismiss();
            int currentAmount = SharedPreferenceStore.getValue(mContext, SharedPreferenceStore.KEY_OFFLINE_AMOUNT, 0);
            SharedPreferenceStore.storeValue(mContext, SharedPreferenceStore.KEY_OFFLINE_AMOUNT, amount + currentAmount);
            finish();
        }
    }
}
