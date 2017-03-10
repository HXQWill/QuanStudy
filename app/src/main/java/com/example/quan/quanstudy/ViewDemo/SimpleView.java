package com.example.quan.quanstudy.ViewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/9.
 * Mr.Quan
 */

public class SimpleView extends View {

    private Paint mPaint;

    public SimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(getResources().getDimensionPixelSize(R.dimen.dd_dimen_26px));
        String text = "Hello View";
        canvas.drawText(text, 0, getHeight() / 2, mPaint);
    }
}
