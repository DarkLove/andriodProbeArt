package com.fuxing.learn.test002.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.fuxing.learn.test002.Util;

/**
 * Created by DIY on 2017/9/15.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action){
            case "com.fuxing.style":
                Util.L(intent.getStringExtra("msg"));
                break;
        }
    }
}
