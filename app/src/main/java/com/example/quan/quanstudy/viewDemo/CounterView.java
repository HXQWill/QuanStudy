package com.example.quan.quanstudy.viewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.util.Utils;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 * 响应用户的点击事件，并自动记录一共点击了多少次。
 * 自绘控件 onDraw
 */

public class CounterView extends View implements View.OnClickListener {

    private Paint mPaint;

    private Rect mBounds;

    private int mCount;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(getResources().getDimensionPixelSize(R.dimen.dd_dimen_26px));
        String text = String.valueOf(mCount);
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text, (float)getWidth() / 2 - textWidth / 2, (float)getHeight() / 2
                + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(View v) {
        Utils.isFastClick();
        mCount++;
        invalidate();
    }
}
