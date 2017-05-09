package com.ooczc.spammess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

//                Toast.makeText(context,msg.getDisplayMessageBody(),Toast.LENGTH_SHORT).show();
                Log.i("zc","---------MyReceiver 33");

            }
        }
        Intent intent1 = new Intent();
        intent1.setClass(context,Dialog_Activity.class);

        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("number", "" + msg.getOriginatingAddress());
        intent1.putExtra("body", "" + msg.getDisplayMessageBody());
        this.abortBroadcast();
        context.startActivity(intent1);
        Log.i("zc","---------MyReceiver 444");


    }
//        throw new UnsupportedOperationException("Not yet implemented");
}

