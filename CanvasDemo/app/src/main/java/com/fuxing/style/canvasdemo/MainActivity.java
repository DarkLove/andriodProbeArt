package com.fuxing.style.canvasdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout layout = (FrameLayout) findViewById(R.id.root);
        Log.d("TAGSs",layout.getParent().toString());
        DrawView view = new DrawView(this);
        view.setMinimumHeight(600);
        view.setMinimumWidth(400);
        view.invalidate();
        layout.addView(view);
    }
}
