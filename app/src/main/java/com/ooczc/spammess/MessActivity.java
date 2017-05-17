package com.ooczc.spammess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MessActivity extends AppCompatActivity {

    String mess1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //去除标题栏
        setContentView(R.layout.activity_mess);
        String num = getIntent().getStringExtra("index");
        Log.i("zcc","---------MessActivity   000 " + num);
        String mess = getIntent().getStringExtra("index2");
        mess1 = mess;
        Log.i("zcc","---------MessActivity   111" + mess); //垃圾短信内容

        TextView info = (TextView) findViewById(R.id.tv_mess_2);
        info.setText(mess);
        Log.i("zcc","---------MessActivity   222");

        Button button = (Button) findViewById(R.id.mess_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    NetClient n = new NetClient();
                    n.addMess(mess1);
                    Toast.makeText(MessActivity.this,"已发送", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    e.printStackTrace();
                    Log.i("zcc","---------MessActivity  addMess Exception");
                }

            }
        });

    }
}
