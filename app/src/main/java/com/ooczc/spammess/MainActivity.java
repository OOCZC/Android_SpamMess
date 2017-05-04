package com.ooczc.spammess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    Button bt;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除标题栏
        setContentView(R.layout.listview);
        //通过int型反射，获取控件对象
        //这里的tv_a1必须在setContentView(R.layout.activity_main)的activity_main中.

        ListView listView = (ListView) findViewById(R.id.lv_main);



        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("num","234333124");
        map.put("mess","大幅上升1");
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","234000004");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","3143124");
        map.put("mess","大幅上升");
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","333143124");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","23242443124");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","1111143124");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("num","234000004");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","3143124");
        map.put("mess","大幅上升");
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","333143124");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","23242443124");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

        map = new HashMap<String,Object>();
        map.put("num","1111143124");
        map.put("mess",getResources().getString(R.string.mess));
        list.add(map);

//        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.item,
//                new String[]{"num","mess"},new int[]{R.id.tv_num,R.id.tv_mess}
//                );
        MyAdapter adapter = new MyAdapter(this);
        adapter.setList(list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(this);



//        String[] data = {"大大","大法师","更改","个地方","(･ｪ-)","哈根","统一","发改","的点点滴滴"
//                ,"大大","大法师","更改","个地方","(･ｪ-)","哈根","统一","发改","的点点滴滴"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,android.R.layout.simple_list_item_1,data
//        );
//        listView.setAdapter(adapter);
        /*
        et = (EditText) findViewById(R.id.et_1);

        //给Button设置监听器
        bt = (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et.getText().toString();
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
                //第一个参数为MainActicity对象引用,要求为上下文类型（即Activity）

            }
        });


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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"点击"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"长按"+position,Toast.LENGTH_SHORT).show();
        return true; //false表示不消化事件，事件继续传递下去,传给点击事件
    }
}
