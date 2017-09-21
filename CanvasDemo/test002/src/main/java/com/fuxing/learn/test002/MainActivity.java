package com.fuxing.learn.test002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        int id = view.getId();
        switch (id){
            /************************************静态广播*****************************************/
            case R.id.b01:
            {
                Intent intent = new Intent();
                //设置Action
                intent.setAction("com.fuxing.style");
                intent.putExtra("msg","静态普通广播来啦！");
                //发送普通广播
                sendBroadcast(intent);
            }
                break;
            case R.id.b02:
            {
                Intent intent = new Intent();
                //设置Action
                intent.setAction("com.fuxing.test");
                intent.putExtra("msg","优先级高的有序广播来啦！");
                //发送有序广播
                sendOrderedBroadcast(intent,null);
            }
                break;
            /************************************************************************************************/
        }

    }
}
