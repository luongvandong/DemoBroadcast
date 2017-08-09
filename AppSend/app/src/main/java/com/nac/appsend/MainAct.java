package com.nac.appsend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Thanh Nguyen on 3/19/2017.
 */
public class MainAct extends Activity implements View.OnClickListener {
    private static final String ACTION_PLUS = "com.nac.app.ACTION_PLUS";
    private static final String KEY_NUM_A = "KEY_NUM_A";
    private static final String KEY_NUM_B = "KEY_NUM_B";
    private EditText edtA, edtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
    }

    private void initViews() {
        edtA = (EditText)findViewById(R.id.edt_num_a);
        edtB = (EditText)findViewById(R.id.edt_num_b);
        findViewById(R.id.bt_plus).setOnClickListener(this);
        findViewById(R.id.bt_minus).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_plus:
                sendBroadCastPlus();
                break;
            case R.id.bt_minus:
                sendBroadCastMinus();
                break;
        }
    }

    private void sendBroadCastMinus() {

    }

    private void sendBroadCastPlus() {
        Intent intent = new Intent();
        intent.setAction(ACTION_PLUS);
        Bundle data = new Bundle();
        data.putInt(KEY_NUM_A, Integer.parseInt(edtA.getText().toString()));
        data.putInt(KEY_NUM_B, Integer.parseInt(edtA.getText().toString()));
        intent.putExtras(data);

        sendBroadcast(intent);
    }
}
