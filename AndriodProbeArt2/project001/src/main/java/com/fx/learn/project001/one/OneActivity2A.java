package com.fx.learn.project001.one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fx.learn.project001.R;

/**
 * standard标准模式，每次启动一个新的activity都会重新创建一个新的实例，
 * 不管这个实例是否已经存在，生命周期就是典型的情况，
 * 这是一种典型的多实例实现，
 *
 * 一个任务栈中可以有多个实例，每个实例也可以属于不同的任务栈，
 * 在这种模式下，谁启动了Activity，name这个Activity就运行在启动它的那个任务栈
 * eg:A启动B(B是标准模式),那么B就会进入A所在的栈中
 *
 * 实例就不写了啊，哈哈哈
 */
public class OneActivity2A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_activity2);
    }
}
