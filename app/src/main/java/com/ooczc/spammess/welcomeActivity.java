package com.ooczc.spammess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Map;

public class welcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(welcomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }).start();
    }
}
