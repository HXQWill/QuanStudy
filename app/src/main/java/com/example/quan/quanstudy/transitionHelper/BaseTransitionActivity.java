package com.example.quan.quanstudy.transitionHelper;

import com.example.quan.quanlibrary.transition_helper.TransitionsHeleper;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xq.he on 2017/3/13.
 */

public abstract class BaseTransitionActivity extends BaseActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TransitionsHeleper.unBind(this);
    }

}
