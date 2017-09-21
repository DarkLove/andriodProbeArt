package com.fuxing.learn.test05.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.fuxing.learn.test05.R;

/**
 * Created by DIY on 2017/9/11.
 */
public class CustomTitleView extends View {

    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context,null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    int iii = 0 ;

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAGGO","GO");
                mTitleText = "哥哥 "+ (iii++);
                requestLayout();
//                invalidate();
            }
        });
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom, defStyleAttr, 0);
        int n = a.getIndexCount();
        Log.d("xxxxxxxxxxxxxxxxxx000",""+a.getIndexCount());
        for (int i = 0 ; i < n ; i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.custom_titleText:
                    mTitleText = a.getString(attr);
                    Log.d("xxxxxxxxxxxxxxxxxx001",""+a.getString(attr));
                    break;
                case R.styleable.custom_titleTextColor:
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    Log.d("xxxxxxxxxxxxxxxxxx002",""+a.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.custom_titleTextSize:
                    mTitleTextSize = a.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    Log.d("xxxxxxxxxxxxxxxxxx003",""+mTitleTextSize);
                    break;
            }
        }
        a.recycle();
        /**
         * 获得绘制文本的宽和高
//         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);

        mBound = new Rect();
        mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width ;
        int height ;

        //EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
        if (widthMode == MeasureSpec.EXACTLY){
            width = widthSize ;
        }else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            width = getPaddingLeft() + mBound.width() + getPaddingRight();
        }

        if (heightMode == MeasureSpec.EXACTLY){
            height = heightSize ;
        }else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            height = getPaddingTop() + mBound.height() + getPaddingBottom();
        }

        setMeasuredDimension(width ,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText,(getMeasuredWidth() - mBound.width())/2,(getMeasuredHeight() + mBound.height())/2,mPaint);
      }
}
