package com.fx.learn.andriodprobeart;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    EditText et ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et = (EditText) findViewById(R.id.et);

        UI.print("onCreate Second");
        UI.toast(this,"Second onCreate");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("et",et.getText().toString());
        UI.print("onSaveInstanceState");
        UI.toast(this,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String et_string = savedInstanceState.getString("et");
        et.setText(et_string);
        UI.print("onRestoreInstanceState");
        UI.toast(this,"onRestoreInstanceState");
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
