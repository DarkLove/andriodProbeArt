package com.fuxing.learn.test002.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fuxing.learn.test002.Util;

/**
 * Created by DIY on 2017/9/15.
 */
public class SecondReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.fuxing.test".equals(action)){
            Bundle bundle = getResultExtras(true);
            Util.L("SecondReceiver  "+action+"    "+bundle.getString("message"));
        }
    }
}
