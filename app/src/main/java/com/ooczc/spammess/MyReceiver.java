package com.ooczc.spammess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static android.R.attr.filter;

public class MyReceiver extends BroadcastReceiver {
//    public MyReceiver() {
//    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        Log.i("zcc","---------MyReceiver start");
        if (null != bundle) {
            Object[] smsObj = (Object[]) bundle.get("pdus");
            Log.i("zcc","---------MyReceiver 22");
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                Date date = new Date(msg.getTimestampMillis());//时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String receiveTime = format.format(date);
                System.out.println("number:" + msg.getOriginatingAddress()
                        + "   body:" + msg.getDisplayMessageBody() + "  time:"
                        + msg.getTimestampMillis());

//                Toast.makeText(context,msg.getDisplayMessageBody(),Toast.LENGTH_SHORT).show();
                Log.i("zcc","---------MyReceiver 33");

            }
        }
        String mess = msg.getDisplayMessageBody();
        String anw = ""; int flag;
        try{
            Log.i("zcc","MyReceiver ********* 111"+mess);
            NetClient netclient = new NetClient();
            Log.i("zcc","MyReceiver ********* 222"+mess);
            anw = netclient.isSpamMess(mess);
            Log.i("zcc","MyReceiver ********* 333  "+anw);
        } catch (Exception e){
//            Toast.makeText(context,"网络连接错误!",Toast.LENGTH_SHORT).show();
            Log.i("zcc","---------MyReceiver 网络连接错误");
            e.printStackTrace();
        }

        if(anw.charAt(0)  == '1') {
            flag = 1;
            Log.i("zcc","---------MyReceiver  flag == 1");
        }
        else{
            flag = 0;
            Log.i("zcc","---------MyReceiver  flag == 0 or else");
        }


        Intent intent1 = new Intent();
        intent1.setClass(context,Dialog_Activity.class);

        Log.i("zcc","---------MyReceiver 555");
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("number", "" + msg.getOriginatingAddress());
        intent1.putExtra("body", "" + mess);
        intent1.putExtra("flag", flag);
        this.abortBroadcast();
        context.startActivity(intent1);
        Log.i("zcc","---------MyReceiver 444");


    }
//        throw new UnsupportedOperationException("Not yet implemented");
}

