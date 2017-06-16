package com.gladiator.code.merchant.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gladiator.code.merchant.R;
import com.gladiator.code.merchant.Utils.SharedPreferenceStore;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_LOAD_OFFLINE = 10;
    private TextView tvOfflineAmount;
    private TextView tvOnlineAmount;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        mContext = getBaseContext();
        tvOfflineAmount = (TextView) findViewById(R.id.tvOfflineAmount);
        tvOnlineAmount = (TextView) findViewById(R.id.tvOnlineAmount);
        Button btnLoadOnlineAmount = (Button) findViewById(R.id.btnLoadOnlineAmount);
        Button btnLoadOfflineAmount = (Button) findViewById(R.id.btnLoadOfflineAmount);
        Button btnPayOffline = (Button) findViewById(R.id.btnPayOffline);
        btnLoadOfflineAmount.setOnClickListener(this);
        btnLoadOnlineAmount.setOnClickListener(this);
        btnPayOffline.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLoadOfflineAmount:
                startActivityForResult(new Intent(DashBoardActivity.this, LoadOffLineAmountActivity.class), REQUEST_LOAD_OFFLINE);
                break;
            case R.id.btnLoadOnlineAmount:
                break;
            case R.id.btnPayOffline:
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateAmount();
    }

    private void updateAmount() {
        try {
            tvOfflineAmount.setText(""+ SharedPreferenceStore.getValue(mContext, SharedPreferenceStore.KEY_OFFLINE_AMOUNT, 0));
            tvOnlineAmount.setText("" + SharedPreferenceStore.getValue(mContext, SharedPreferenceStore.KEY_ONLINE_AMOUNT, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
