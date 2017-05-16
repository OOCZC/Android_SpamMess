package com.ooczc.spammess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class MessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //去除标题栏
        setContentView(R.layout.activity_mess);
        String num = getIntent().getStringExtra("index");
        Log.i("zcc","---------MessActivity   000 " + num);
        String mess = getIntent().getStringExtra("index2");
        Log.i("zcc","---------MessActivity   111" + mess);

        TextView info = (TextView) findViewById(R.id.tv_mess_2);
        info.setText(mess);
        Log.i("zcc","---------MessActivity   222");
    }
}
