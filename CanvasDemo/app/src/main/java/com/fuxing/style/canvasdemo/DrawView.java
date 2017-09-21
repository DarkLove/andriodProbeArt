package com.fuxing.style.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by DIY on 2017/8/4.
 */
public class DrawView extends View {

    public static Paint p = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        p.setTextSize(20);

        canvas.drawText("画圆",20,20,p);
        canvas.drawCircle(80,20,10,p);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);//设置填满
        canvas.drawCircle(120,20,20,p);

        canvas.drawText("画线-弧线",20,100,p);
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.FILL);
        canvas.drawLine(120,80,200,80,p);
        canvas.drawLine(120,80,200,100,p);

        //画笑脸弧线
//        p.setStyle(Paint.Style.STROKE);//设置空心
        RectF oval1=new RectF(150,20,180,40);
        canvas.drawArc(oval1, 180, 180, false, p);//小弧形
        oval1.set(190, 20, 220, 40);
        canvas.drawArc(oval1, 180, 180, false, p);//小弧形
        oval1.set(160, 30, 210, 60);
        canvas.drawArc(oval1, 0, 180, false, p);//小弧形


    }
}
