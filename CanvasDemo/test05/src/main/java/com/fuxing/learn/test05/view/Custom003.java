package com.fuxing.learn.test05.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
 * Created by DIY on 2017/9/12.
 */
public class Custom003 extends View {
    /**
     * 控件的宽
     */
    private int mWidth;
    /**
     * 控件的高
     */
    private int mHeight;

    public Bitmap mImage ;

    Paint mPaint ;

    /**
     * 控制整体布局
     */
    private Rect rect;

    public Custom003(Context context) {
        this(context,null,0);
    }

    public Custom003(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public Custom003(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.custom_image:
                    mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
                    break;
//                case R.styleable.custom_imageScaleType:
//                    mImageScale = a.getInt(attr, 0);
//                    break;
//                case R.styleable.custom_titleText:
//                    mTitle = a.getString(attr);
//                    break;
//                case R.styleable.custom_titleTextColor:
//                    mTextColor = a.getColor(attr, Color.BLACK);
//                    break;
//                case R.styleable.custom_titleTextSize:
//                    mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
//                            16, getResources().getDisplayMetrics()));
//                    break;
            }
        }

        a.recycle();

        mPaint = new Paint();
        rect = new Rect();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            mWidth = specSize ;
            Log.d("xxxxxascaxaa","MeasureSpec.EXACTLY  "+mWidth);
        }else {
            mWidth = getPaddingLeft() + mImage.getWidth() + getPaddingRight() ;
            Log.d("xxxxxascaxaa","NO  MeasureSpec.EXACTLY "+mWidth);
        }

        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            mHeight = specSize ;
        }else {
            mHeight = getPaddingTop() + mImage.getHeight() + getPaddingBottom() ;
        }
        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        Log.d("TAGfuxing",""+getPaddingLeft()+"     "+getPaddingTop()+"    "+getPaddingRight()+"    "+getPaddingBottom()) ;
        rect.left = getPaddingLeft();
        rect.top = getPaddingTop();
        rect.right = mWidth - getPaddingRight();
        rect.bottom = mHeight - getPaddingBottom();

        mPaint.setColor(Color.RED);
        canvas.drawRect(rect,mPaint);

        rect.left = (mWidth - mImage.getWidth()) / 2 ;
        rect.right = (mWidth + mImage.getWidth()) / 2 ;
        rect.top = (mHeight - mImage.getHeight()) / 2 ;
        rect.bottom = (mHeight + mImage.getHeight()) / 2 ;

        canvas.drawBitmap(mImage,null,rect,mPaint);
    }

}
