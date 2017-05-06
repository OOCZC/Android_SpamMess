package com.ooczc.spammess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        Log.i("zc","---------MyReceiver start");
        if (null != bundle) {
            Object[] smsObj = (Object[]) bundle.get("pdus");
            Log.i("zc","---------MyReceiver 22");
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                Date date = new Date(msg.getTimestampMillis());//时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String receiveTime = format.format(date);
                System.out.println("number:" + msg.getOriginatingAddress()
                        + "   body:" + msg.getDisplayMessageBody() + "  time:"
                        + msg.getTimestampMillis());

                Toast.makeText(context,msg.getDisplayMessageBody(),Toast.LENGTH_SHORT).show();
                Log.i("zc","---------MyReceiver 33");
                //在这里写自己的逻辑
                if (msg.getOriginatingAddress().equals("10086")) {
                    //TODO

                }

            }
        }
    }
//        throw new UnsupportedOperationException("Not yet implemented");
}

