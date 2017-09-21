package com.fuxing.learn.test05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.fuxing.learn.test05.myinterface.ChangeListener;
import com.fuxing.learn.test05.view.Custom005;

public class TestActivity004 extends AppCompatActivity implements ChangeListener {

    TextView tv ;

    public static final String str = "贱人的贱值为 : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test004);
        Custom005 c = (Custom005) findViewById(R.id.custom005);
        c.setListener(this);
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onStart(float x) {
        Log.d("TAG-TEST","onStart  "+x);
        tv.setText(str+x);
    }

    @Override
    public void onChange(float x) {
        Log.d("TAG-TEST","onChange  "+x);
        tv.setText(str+x);
    }

    @Override
    public void onStop(float x) {
        Log.d("TAG-TEST","onStop  "+x);
        tv.setText(str+x);
    }
}
