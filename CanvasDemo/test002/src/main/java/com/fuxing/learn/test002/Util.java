package com.fuxing.learn.test002;

import android.util.Log;

/**
 * Created by DIY on 2017/9/14.
 */
public class Util {

    public static final String TAG = "BROAD-TAG";

    public static void L(Object info){
        Log.d(TAG,String.valueOf(info));
    }
}
