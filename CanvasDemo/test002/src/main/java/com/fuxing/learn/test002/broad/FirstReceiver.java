package com.fuxing.learn.test002.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fuxing.learn.test002.Util;

/**
 * Created by DIY on 2017/9/15.
 */
public class FirstReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.fuxing.test".equals(action)){
            Util.L("FirstReceiver   "+action);
            Bundle bundle = new Bundle();
            bundle.putString("message","我是在优先级高的地方加进来的信息....");
            setResultExtras(bundle);
//            abortBroadcast();
        }
    }
}
