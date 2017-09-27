package com.fx.learn.project001.three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fx.learn.project001.R;

/**
 * singleTask【栈内复用模式】
 * 这是一种单实例模式，在这种模式下，只要Activity在一个栈中存在，
 * 那么多次启动这个Activity都不会重新创建实例，和singleTop一样，会回调onNewIntent
 * 当一个具有singleTask的Activity A 请求启动时，系统会寻找是否存在A想要的任务栈，
 * 【1.没有：就创建任务栈，在创建A的实例】
 * 【2.有：在寻找栈中是否有A的实例存在，
 *          没有：就创建并压入栈顶，
 *          有：将A调到栈顶，并且回调onNewItent方法】
 *
 *
 *  还有一种singleInstance的模式，他具有所有sinleTask的特性，除此之外，还有一点，
 *  此种模式的Activity只能单独位于一个任务栈中，后续请求均不会重新创建，除非这个独特的任务栈被系统销毁了
 *
 */

public class ThreeActivity2A extends AppCompatActivity {
    int i = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_activity2);
        Toast.makeText(this,"onCreate "+(i++),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart "+(i++),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume "+(i++),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this,"onNewIntent ",Toast.LENGTH_SHORT).show();
    }

    public void show(View view){
        startActivity(new Intent(this,ThreeActivity2A.class));
    }

}
