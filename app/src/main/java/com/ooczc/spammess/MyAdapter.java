package com.ooczc.spammess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by ooc on 17-5-3.
 */

public class MyAdapter extends BaseAdapter{

    List<Map<String,Object>> list;
    LayoutInflater inflater;

    // alt+insert(fn), 插入代码
    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);

    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size(); //返回多少个list
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);// 返回一个map
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.item,null);
        TextView num = (TextView) view.findViewById(R.id.tv_num);
        TextView mess = (TextView) view.findViewById(R.id.tv_mess);

        Map map = list.get(position);
        num.setText((String) map.get("num"));
        mess.setText((String)map.get("mess"));

        return view;
    }
}
