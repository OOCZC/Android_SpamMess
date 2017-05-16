package com.ooczc.spammess;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    Button bt;
    EditText et;
    List<Map<String,Object>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除标题栏
        setContentView(R.layout.listview);
        //通过int型反射，获取控件对象
        //这里的tv_a1必须在setContentView(R.layout.activity_main)的activity_main中.

        ListView listView = (ListView) findViewById(R.id.lv_main);



        list = new ArrayList<Map<String,Object>>();

        getSmsFromPhone();


        Log.i("zcc","---------MainActivity  111");

//        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.item,
//                new String[]{"num","mess"},new int[]{R.id.tv_num,R.id.tv_mess}
//                );
        MyAdapter adapter = new MyAdapter(this);
        adapter.setList(list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(this);


        Log.i("zcc","---------MainActivity  222");

//       String[] data = {"大大","大法师","更改","个地方","(･ｪ-)"
//       ,"大大","大法师","更改","个地方","(･ｪ-)","哈根","统一","发改","的点点滴滴"};
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
    private Uri SMS_INBOX = Uri.parse("content://sms/");
    public void getSmsFromPhone() {
        ContentResolver cr = getContentResolver();
        String[] projection = new String[] {"_id", "address", "person",
                "body", "date", "type" };//"_id", "address", "person",, "date", "type
//        String where = " address = '106632133' AND date >  "
//                + (System.currentTimeMillis() - 10 * 60 * 1000);
//        String where = "date >"+(System.currentTimeMillis() - 10 * 60 * 1000);
//        String test = String.valueOf(System.currentTimeMillis() - 10 * 60 * 1000);
//        Log.i("zc",test+"**********");
        Cursor cur = cr.query(SMS_INBOX, projection, null, null, "date desc");
        Log.i("zcc","---------getSmsFromPhone  111");
        if (null == cur) {
//            Log.i("zc","---------333333333");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("num","110");
            map.put("mess","读取短信出错！");
            list.add(map);
            return;
        }
//        Log.i("zc","---------4444444444");
        while(cur.moveToNext()) {
            String number = cur.getString(cur.getColumnIndex("address"));//手机号
            String name = cur.getString(cur.getColumnIndex("person"));//联系人姓名列表
            String body = cur.getString(cur.getColumnIndex("body"));
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("num",number);
            map.put("mess",body);
            list.add(map);
//            Log.i("zc","---------222222222");
            //这里我是要获取自己短信服务号码中的验证码~~
//            Pattern pattern = Pattern.compile(" [a-zA-Z0-9]{10}");
//            Matcher matcher = pattern.matcher(body);
//            if (matcher.find()) {
//                String res = matcher.group().substring(1, 11);
//                mobileText.setText(res);
//            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent,
                            View view, int position, long id) {
//        Toast.makeText(this,"点击"+position,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setClass(this,MessActivity.class);

        Map<String,Object> map =
                (Map<String, Object>) parent.getItemAtPosition(position);
        intent.putExtra("index",""+map.get("num"));
        intent.putExtra("index2",""+map.get("mess"));
        startActivity(intent);


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent,
                                   View view, int position, long id) {

//        Toast.makeText(this,"长按"+position,Toast.LENGTH_SHORT).show();

//        final AdapterView a = parent;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.people);
        builder.setTitle("个性化过滤");
        builder.setMessage("是否把当前短信发送至服务器，实现个性化过滤？");
        builder.setNegativeButton("不发送", null);
        builder.setPositiveButton("发送", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "已发送", Toast.LENGTH_SHORT).show();

//                String str = (String)list.get(which).get("mess");

//                Log.i("zcc", "---------onItemLongClick  000 " + list.get(which).get("mess"));

//                Map<String, Object> map =
//                        (Map<String, Object>) a.getItemAtPosition(which);
//                intent.putExtra("index",""+position);
//                Log.i("zcc", "---------onItemLongClick  111 " + map.get("mess"));
//                map.get("mess");
            }
        });
        builder.create().show();

        return true; //false表示不消化事件，事件继续传递下去,传给点击事件
    }
}

/*
public void onClick(DialogInterface dialog, int which) {
                Toast.makeText (MainActivity.this,
                        "已发送",Toast.LENGTH_SHORT).show();
                Map<String,Object> map =
                        (Map<String, Object>) parent.getItemAtPosition(position);
//                intent.putExtra("index",""+position);
                map.get("mess");

 */