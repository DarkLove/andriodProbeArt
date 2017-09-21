package com.fuxing.style.test03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
            JSONArray arr = getData();
            for (int i = 0 ;i < arr.length() ;i++){
                LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.root, null);
                final TextView tv = (TextView) layout.findViewById(R.id.length);
                final MySeekbarView seek = (MySeekbarView) layout.findViewById(R.id.seek);
                seek.setTag(arr.getJSONObject(i).getString("jsonkey"));
                seek.setMax(arr.getJSONObject(i).getInt("sum"));
                final String seekname = arr.getJSONObject(i).getString("seekname");
                seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        tv.setText(seekname+": "+seekBar.getProgress());
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Log.d("aaasssdddd ",seek.getTag().toString()+"  "+seekBar.getProgress());
                    }
                });
                seek.setProgress(arr.getJSONObject(i).getInt("default"));
                seek.notifyDraws(arr.getJSONObject(i));
                linearLayout.addView(layout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONArray getData(){
        String json = "[\n" +
                "    {\n" +
                "        \"default\": 60,\n" +
                "        \"jsonkey\": \"key01\",\n" +
                "        \"node\": [\n" +
                "            {\n" +
                "                \"nodename\": \"略低01\",\n" +
                "                \"nodenumber\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"平均01\",\n" +
                "                \"nodenumber\": 40\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"略高01\",\n" +
                "                \"nodenumber\": 60\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"特高01\",\n" +
                "                \"nodenumber\": 100\n" +
                "            }\n" +
                "        ],\n" +
                "        \"seekname\": \"商业指数\",\n" +
                "        \"sum\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"default\": 20,\n" +
                "        \"jsonkey\": \"key02\",\n" +
                "        \"node\": [\n" +
                "            {\n" +
                "                \"nodename\": \"略低02\",\n" +
                "                \"nodenumber\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"平均02\",\n" +
                "                \"nodenumber\": 40\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"略高02\",\n" +
                "                \"nodenumber\": 60\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"特高02\",\n" +
                "                \"nodenumber\": 80\n" +
                "            }\n" +
                "        ],\n" +
                "        \"seekname\": \"交通指数\",\n" +
                "        \"sum\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"default\": 0,\n" +
                "        \"jsonkey\": \"key03\",\n" +
                "        \"node\": [\n" +
                "            {\n" +
                "                \"nodename\": \"略低03\",\n" +
                "                \"nodenumber\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"平均03\",\n" +
                "                \"nodenumber\": 600\n" +
                "            },\n" +
                "            {\n" +
                "                \"nodename\": \"特高03\",\n" +
                "                \"nodenumber\": 1000\n" +
                "            }\n" +
                "        ],\n" +
                "        \"seekname\": \"高端指数\",\n" +
                "        \"sum\": 1000\n" +
                "    }\n" +
                "]";
        JSONArray arr = null ;
        try {
            arr = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arr ;
    }
}

