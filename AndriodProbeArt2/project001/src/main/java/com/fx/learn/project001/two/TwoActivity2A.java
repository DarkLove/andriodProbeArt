package com.fx.learn.project001.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fx.learn.project001.R;

/**
 * singleTop[栈顶复用模式]
 *
 *
 *
 */
public class TwoActivity2A extends AppCompatActivity {
    public static final String TAG = "FXTAG";
    int i = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_activity2);
//        Log.d(TAG,"A onCreate "+(i++));
        Toast.makeText(this,"onCreate "+(i++),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Log.d(TAG,"A onStart "+(i++));
        Toast.makeText(this,"onStart "+(i++),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.d(TAG,"A onResume "+(i++));
        Toast.makeText(this,"onResume "+(i++),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);///////////////////////////////////////////////////////
    }

    public void show(View view){
        startActivity(new Intent(this,TwoActivity2A.class));
    }



}
