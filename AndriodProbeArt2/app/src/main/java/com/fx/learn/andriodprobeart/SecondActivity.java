package com.fx.learn.andriodprobeart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        UI.print("onCreate Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        UI.print("onRestart Second");
    }

    @Override
    protected void onStart() {
        super.onStart();
        UI.print("onStart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UI.print("onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        UI.print("onPause Second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        UI.print("onStop Second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UI.print("onDestroy Second");
    }
}
