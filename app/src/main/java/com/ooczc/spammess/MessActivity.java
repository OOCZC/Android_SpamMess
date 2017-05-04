package com.ooczc.spammess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);
        String str = getIntent().getStringExtra("index2");

        TextView info = (TextView) findViewById(R.id.tv_mess_2);
        info.setText(str);
    }
}
