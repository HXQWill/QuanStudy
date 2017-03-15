package com.example.quan.quanstudy.viewDemo;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 */

public class ThreeDiyViewActivity extends BaseActivity {

    private ShowListView mShowListView;

    private ShowAdapter mShowAdapter;

    private List<String> mContentList = new ArrayList<String>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_view_diy;
    }

    @Override
    public void initView() {
        initList();
        mShowListView = (ShowListView) findViewById(R.id.show_slv_diy);
        mShowListView.setOnDeleteListener(new ShowListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                mContentList.remove(index);
                mShowAdapter.notifyDataSetChanged();
            }
        });
        mShowAdapter = new ShowAdapter(this, 0, mContentList);
        mShowListView.setAdapter(mShowAdapter);
    }

    private void initList() {
        for (int i = 0;i < 101;i++){
            mContentList.add("权兴权意 Content Item-" + i);
        }
    }
}
