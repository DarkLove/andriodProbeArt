package com.fuxing.learn.test05.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.fuxing.learn.test05.R;

/**
 * Created by DIY on 2017/9/12.
 */
public class Custom004 extends View {

    /**
     * 第一圈的颜色
     */
    private int mFirstColor;
    /**
     * 第二圈的颜色
     */
    private int mSecondColor;
    /**
     * 圈的宽度
     */
    private int mCircleWidth;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 当前进度
     */
    private int mProgress;

    /**
     * 速度
     */
    private int mSpeed;

    /**
     * 是否应该开始下一个
     */
    private boolean isNext = false;

    public Custom004(Context context) {
        this(context,null);
    }

    public Custom004(Context context, AttributeSet attrs) {
       this(context,attrs,0);
    }

    public Custom004(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.custom_firstColor:
                    mFirstColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.custom_secondColor:
                    mSecondColor = a.getColor(attr, Color.RED);
                    break;
                case R.styleable.custom_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.custom_speed:
                    mSpeed = a.getInt(attr,40);
                    break;
            }
        }
        a.recycle();

        mPaint = new Paint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(mSpeed);
                        mProgress++;
                        if (mProgress == 360) {
                            mProgress = 0;
                            if (!isNext)
                                isNext = true;
                            else
                                isNext = false;
                        }
                        postInvalidate();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(Color.BLACK);
//        mPaint.setTextSize(50);
//        canvas.drawText(mProgress+"",canvas.getWidth() / 2, canvas.getHeight() / 2,mPaint);

        int centreX = getWidth() / 2; // 获取圆心的x坐标
        int centreY = getHeight() / 2; // 获取圆心的x坐标
        int radius = centreX - mCircleWidth / 2;// 半径
        mPaint.setStrokeWidth(mCircleWidth); // 设置圆环的宽度
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setStyle(Paint.Style.STROKE); // 设置空心
        RectF oval = new RectF(centreX - radius, centreY - radius, centreX + radius, centreY+radius); // 用于定义的圆弧的形状和大小的界限
        if (!isNext) {// 第一颜色的圈完整，第二颜色跑
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawCircle(centreX, centreY, radius, mPaint); // 画出圆环
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint); // 根据进度画圆弧
        } else {
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawCircle(centreX, centreY, radius, mPaint); // 画出圆环
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint); // 根据进度画圆弧
        }


//        mPaint.setAntiAlias(true);                       //设置画笔为无锯齿
//        mPaint.setColor(Color.BLACK);                    //设置画笔颜色
//        canvas.drawColor(Color.WHITE);                  //白色背景
//        mPaint.setStrokeWidth((float) 3.0);              //线宽
//        mPaint.setStyle(Paint.Style.STROKE);
//        RectF oval = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
//        canvas.drawArc(oval, -90, 350, true, mPaint); // 根据进度画圆弧

//        mPaint.setAntiAlias(true);                       //设置画笔为无锯齿
//        mPaint.setColor(Color.BLACK);                    //设置画笔颜色
//        canvas.drawColor(Color.WHITE);                  //白色背景
//        mPaint.setStrokeWidth((float) 100);              //线宽
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawLine(0,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight()/2,mPaint);
//        mPaint.setColor(Color.WHITE);
//        mPaint.setStrokeWidth((float) 3);
//        canvas.drawLine(0,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight()/2,mPaint);

    }
}
