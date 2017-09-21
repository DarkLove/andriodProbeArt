package com.fuxing.learn.test05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void show(View view){
        int id = view.getId();
        switch (id){
            case R.id.s1:
                go(MainActivity.class);
                break;
            case R.id.s2:
                go(TestActivity001.class);
                break;
            case R.id.s3:
                go(TestActivity002.class);
                break;
            case R.id.s4:
                go(TestActivity003.class);
                break;
            case R.id.s5:
                go(TestActivity004.class);
                break;
        }

    }

    void go(Class clazz){
        startActivity(new Intent(this,clazz));
    }
}
