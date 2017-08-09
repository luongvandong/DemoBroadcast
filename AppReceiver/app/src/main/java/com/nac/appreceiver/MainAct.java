package com.nac.appreceiver;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Thanh Nguyen on 3/19/2017.
 */
public class MainAct extends Activity {
    private CalcReceiver calcReceiver;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
    }

    private void initViews() {
        tvResult = (TextView)findViewById(R.id.tv_result);
        calcReceiver = new CalcReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CalcReceiver.ACTION_PLUS);
        //register local receiver
        registerReceiver(calcReceiver, intentFilter);
    }

    public void setResultCalc(int result) {
        tvResult.setText(result+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(calcReceiver);
    }
}
