package com.nac.appreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Thanh Nguyen on 3/19/2017.
 */
public class CalcReceiver extends BroadcastReceiver {
    public static final String ACTION_PLUS = "com.nac.app.ACTION_PLUS";
    private static final String KEY_NUM_A = "KEY_NUM_A";
    private static final String KEY_NUM_B = "KEY_NUM_B";
    private final MainAct mainAct;

    public CalcReceiver(MainAct mainAct) {
        this.mainAct = mainAct;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case ACTION_PLUS:
                Bundle data = intent.getExtras();
                int numA = data.getInt(KEY_NUM_A);
                int numB = data.getInt(KEY_NUM_B);
                mainAct.setResultCalc(numA + numB);
                Toast.makeText(context,
                        numA + "+" + numB + "=" + (numA + numB),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
