package com.fx.learn.project001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fx.learn.project001.one.OneActivity2A;
import com.fx.learn.project001.three.ThreeActivity2A;
import com.fx.learn.project001.two.TwoActivity2A;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        int id = view.getId();
        switch (id){
            case R.id.standard:
                go(OneActivity2A.class);
                break;
            case R.id.singleTop:
                go(TwoActivity2A.class);
                break;
            case R.id.singleTask:
                go(ThreeActivity2A.class);
                break;
        }
    }

    public void go(Class clazz){
        startActivity(new Intent(this,clazz));
    }
}
