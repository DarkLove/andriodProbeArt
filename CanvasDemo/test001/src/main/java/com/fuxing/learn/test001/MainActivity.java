package com.fuxing.learn.test001;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fuxing.learn.test001.service.MyService01;

public class MainActivity extends AppCompatActivity {

    private Intent intent01 ;

    private MyService01.MyBinder binder ;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (MyService01.MyBinder) iBinder;
            binder.test();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.L(Thread.currentThread().getId());
        intent01 = new Intent(this, MyService01.class);
    }

    public void show(View view){
        int id = view.getId();
        switch (id){
            case R.id.start:
                startService(intent01);
                break;
            case R.id.stop:
                stopService(intent01);
                break;
            case R.id.bind:
                bindService(intent01,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService(connection);
        Util.isServiceWork(this,"");
    }
}
