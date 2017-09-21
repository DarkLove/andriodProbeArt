package com.fuxing.learn.test001.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fuxing.learn.test001.Util;

/**
 * Created by DIY on 2017/9/14.
 */
public class MyService01 extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Util.TAG,"onCreate() "+Thread.currentThread().getId());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Util.TAG,"onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Util.TAG,"onDestroy()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    MyBinder binder = new MyBinder();

    public class MyBinder extends Binder{
        public void test(){
            Util.L("test");
        }
    }
}
