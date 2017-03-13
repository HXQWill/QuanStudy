package com.example.quan.quanstudy.ViewDemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.Toast;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xingquan.he on 2017/3/9.
 * Mr.Quan
 * LayoutInflater http://blog.csdn.net/hxqneuq2012/article/details/53580042
 * 绘制流程 http://blog.csdn.net/hxqneuq2012/article/details/60970595
 */

public class ViewActivity extends BaseActivity {

    private SimpleLayout mViewSimpleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewSimpleLayout = (SimpleLayout) findViewById(R.id.view_sl_inflater);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View simpleViewLayout = layoutInflater.inflate(R.layout.simple_view_layout,null);
        mViewSimpleLayout.addView(simpleViewLayout);

        ViewParent viewParent = mViewSimpleLayout.getParent();
        Toast.makeText(this , viewParent.toString() , Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_view;
    }
}
