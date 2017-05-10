package com.ooczc.spammess;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class Dialog_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Log.i("zcc","---------Dialog_Activity 111");
        TextView tv = (TextView) findViewById(R.id.tv_dialog);

        Button bt = (Button) findViewById(R.id.buttonReturn);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Dialog_Activity.this,MainActivity.class);
                /*
                Map<String,Object> map =
                        (Map<String, Object>) parent.getItemAtPosition(position);
                intent.putExtra("index",""+position);
                intent.putExtra("index2",""+map.get("mess"));
                */
                startActivity(intent);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Dialog_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
