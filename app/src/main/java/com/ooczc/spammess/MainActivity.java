package com.ooczc.spammess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //通过int型反射，获取控件对象
        //这里的tv_a1必须在setContentView(R.layout.activity_main)的activity_main中.

        //给Button设置监听器
        bt = (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"很好",Toast.LENGTH_LONG).show();
                //第一个参数为MainActicity对象引用,要求为上下文类型（即Activity）


            }
        });




        /*
        TextView tv = (TextView) findViewById(R.id.tv_a1);
        //
        String text = (String) tv.getText();
        //输出日志
        Log.i("zc",text);
        //吐司消息
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
        tv.setText("eeeeeeeeeeee");
        // .java 里这么引用资源，和xml里不同。
        tv.setTextColor(getResources().getColor(R.color.colorPrimary));
        */

    }
}
