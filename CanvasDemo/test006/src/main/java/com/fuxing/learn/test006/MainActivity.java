package com.fuxing.learn.test006;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void one(View view){
        ObjectAnimator
                .ofFloat(view,"rotationX",0,20F)
                .setDuration(3000)
                .start();
    }
}
