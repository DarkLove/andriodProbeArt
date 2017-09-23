package com.fx.learn.andriodprobeart;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/21.
 */

public class UI {

    public static void print(String str){
        Log.d("ZZZZZZF",str);
    }

    public static void toast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
