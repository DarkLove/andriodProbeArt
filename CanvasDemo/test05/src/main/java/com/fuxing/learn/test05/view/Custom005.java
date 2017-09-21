package com.fuxing.learn.test05.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fuxing.learn.test05.myinterface.ChangeListener;

/**
 * Created by DIY on 2017/9/14.
 */
public class Custom005 extends View{

    public ChangeListener listener ;

    public void setListener(ChangeListener listener){
        this.listener = listener ;
    }

    Paint paint ;

    float X = 0 ;

    public Custom005(Context context) {
        this(context,null);
    }

    public Custom005(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Custom005(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        paint.setAntiAlias(true);                       //设置画笔为无锯齿
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth((float) 5);
        canvas.drawLine(0,getHeight()/2,X,getHeight()/2,paint);
        drawCircle(canvas,X,getHeight()/2);

    }

    void drawCircle(Canvas canvas,float x,float y){
        paint.setColor(Color.BLACK);
        canvas.drawLine(X,getHeight()/2,getWidth(),getHeight()/2,paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(x,y,20,paint);
    }

    boolean flag = false ;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int c = getHeight() / 2 ;
        X = event.getX();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://按下
                if (event.getY() > c - 20 && event.getY() < c + 20  && X >= 0 && X <= getWidth()){
                    if (listener != null){
                        listener.onStart(X);
                    }
                    flag = true ;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE://移动
                if (X <= 0){
                    X = 0 ;
                }else if (X >= getWidth()){
                    X = getWidth();
                }
                if (flag && listener != null){
                    listener.onChange(X);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP://离开
                if (X <= 0){
                    X = 0 ;
                }else if (X >= getWidth()){
                    X = getWidth();
                }
                if (flag && listener != null){
                    listener.onStart(X);
                    invalidate();
                }
                flag = false ;
                break;
        }

//        int index = (int)(event.getY() / getHeight() * chars.length) ;
//        switch (event.getAction()){
//            case MotionEvent.ACTION_UP :
////                    setBackgroundColor(Color.WHITE);
//                choose = -1 ;
//                invalidate();
//                if (centerLetterDialog != null){
//                    centerLetterDialog.setVisibility(View.GONE);
//                }
//                break;
//            default:
////                    setBackgroundColor(Color.GRAY);
//                if (index >= 0 && index < chars.length){
//                    listener.onTouchLetterListener(chars[index]);
//                }
//                if (centerLetterDialog != null && index >= 0 && index < chars.length){
//                    centerLetterDialog.setText(chars[index]);
//                    centerLetterDialog.setVisibility(View.VISIBLE);
//                }
//                choose = index ;
//                invalidate();
//                break;
//        }

        return true;
    }
}
