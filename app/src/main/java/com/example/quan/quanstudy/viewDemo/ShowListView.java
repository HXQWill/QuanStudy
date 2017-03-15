package com.example.quan.quanstudy.viewDemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ListView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 * 继承控件 滑动进删除ListView
 */

public class ShowListView extends ListView implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private GestureDetector mGestureDetector;

    private OnDeleteListener mDeleteListener;

    private View mDeleteButton;

    private ViewGroup mItemLayout;

    private int mSelectedItem;

    private boolean isDeleteShow;

    public ShowListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context, this);
        setOnTouchListener(this);
    }

    public void setOnDeleteListener(OnDeleteListener l) {
        mDeleteListener = l;
    }

    public interface OnDeleteListener {

        void onDelete(int index);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isDeleteShow) {
            mItemLayout.removeView(mDeleteButton);
            mDeleteButton = null;
            isDeleteShow = false;
            return false;
        } else {
            mSelectedItem = pointToPosition((int) event.getX(), (int) event.getY());
            return mGestureDetector.onTouchEvent(event);
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!isDeleteShow && Math.abs(velocityX) > Math.abs(velocityY)) {
            mDeleteButton = LayoutInflater.from(getContext()).inflate(
                    R.layout.delete_button, null);
            mDeleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemLayout.removeView(mDeleteButton);
                    mDeleteButton = null;
                    isDeleteShow = false;
                    mDeleteListener.onDelete(mSelectedItem);
                }
            });
            mItemLayout = (ViewGroup) getChildAt(mSelectedItem
                    - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            mItemLayout.addView(mDeleteButton, params);
            isDeleteShow = true;
        }
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
