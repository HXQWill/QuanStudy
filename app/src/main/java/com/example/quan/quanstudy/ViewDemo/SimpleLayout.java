package com.example.quan.quanstudy.ViewDemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xingquan.he on 2017/3/9.
 * Mr.Quan
 * 绘制流程 http://blog.csdn.net/hxqneuq2012/article/details/60970595
 * 包含一个子视图，并且让子视图正常显示
 */

public class SimpleLayout extends ViewGroup {


    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }
    //measure() getMeasureWidth():setMeasuredDimension()

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            childView.layout(0, 0, childView.getMeasuredWidth(), childView.getMeasuredHeight());
        }
    }
    //layout() getWidth():视图右边的坐标减去左边的坐标
}
