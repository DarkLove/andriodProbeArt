package com.fuxing.style.test03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DIY on 2017/8/18.
 */
public class MySeekbarView extends SeekBar {
    private float fontSize = getResources().getDimensionPixelSize(R.dimen.default_font_size);
    public int DEFULT = 0 ;

    // 定义画笔
    private Paint paint;

    public MySeekbarView(Context context) {
        super(context);
        init();
    }

    public MySeekbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySeekbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int l = getPaddingLeft();
        int t = getPaddingTop();
        int r = getPaddingRight();
        int b = getPaddingBottom();
//        setPadding(0,0,0,0);
        DEFULT = l ;
        Log.d("xxxxxxx"," left= "+l+"   top= "+t+"   right= "+r+"   bottom= "+b);

    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int h = canvas.getHeight();
            int w = canvas.getWidth();
            if (!obj.isNull("node")){
                JSONArray array = obj.getJSONArray("node");
                for (int i = 0 ;i < array.length() ;i++ ){
                    draws(canvas,h,w,array.getJSONObject(i).getString("nodename"),array.getJSONObject(i).getInt("nodenumber"),obj.getInt("sum"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param canvas
     * @param h 控件的高
     * @param w 控件的宽
     * @param name 标示的名字
     * @param anchor 标示的坐标
     * @param sum 控件设置的总长度
     */
    private void draws(Canvas canvas,int h ,int w ,String name ,float anchor,float sum){
        canvas.save();
        paint.setTextSize(fontSize);
        paint.setColor(Color.parseColor("#FE4C40"));
        float length = name.length();
        float x = DEFULT + anchor/sum * (w - 2 * DEFULT) ;
        canvas.drawCircle(x, h/2, 3, paint);
        paint.setColor(Color.parseColor("#7D7D7D"));
        canvas.drawText(name, x - (length * fontSize) / 2, h, paint);
        canvas.restore();
    }

    public void notifyDraws(JSONObject obj){
        this.obj = obj;
        invalidate();
    }

    public JSONObject obj = new JSONObject();
}
