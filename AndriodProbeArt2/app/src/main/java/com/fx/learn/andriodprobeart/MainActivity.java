package com.fx.learn.andriodprobeart;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UI.print("onCreat");
    }

    /**
     * 表示Activity正在重新启动，一般情况下，当Activity从不可见状态重新变为可见状态时
     * onRestart方法就会被调用，比如 home键/打开一个新的activity，然后返回到这个Activity
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        UI.print("onRestart");
    }

    /**
     * 表示Activity正在被启动，即将开始，此时Activity已经可见了，但是还没有出现在前台，无法和用户交互，
     * 可以理解为Activity已经显示出来了，但是我们看不到
     */
    @Override
    protected void onStart() {
        super.onStart();
        UI.print("onStart");
    }

    /**
     * 表示Activity已经可见,并且出现在前台开始活动，
     * 【onStart、onResume都表示Acivity可见  onStart在后台，onResume在前台】
     */
    @Override
    protected void onResume() {
        super.onResume();
        UI.print("onResume");
    }

    /**
     *表示正在停止，一般情况下onStop就会执行了
     * 此时可以做一些存储数据，停止动画等操作，注意不要做耗时操作，会影响到新的Activity的显示
     * onPause必须执行完，新Activity的onResume才会执行
     */
    @Override
    protected void onPause() {
        super.onPause();
        UI.print("onPause");
    }

    /**
     * 表示Activity即将停止，可以做一些稍微重量级的回收工作，同样不能太耗时
     */
    @Override
    protected void onStop() {
        super.onStop();
        UI.print("onStop");
    }

    /**
     * 表示Activity即将被销毁，这是Activity生命周期的最后一个回调，
     * 在这里我们可以做一些回收工作和最终的资源释放
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        UI.print("onDestroy");
    }

    public void show(View view){
        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
    }
}
