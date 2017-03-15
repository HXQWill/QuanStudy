package com.example.quan.quanstudy.objectAnimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 * 项目实战：浅谈属性动画（2）-动画监听事件，消失的按钮，酷炫Path2.0
 */

public class PathActivity extends BaseActivity {

    private int res[] = {R.id.a_iv_path,R.id.b_iv_path,R.id.c_iv_path,R.id.d_iv_path,R.id.e_iv_path,
            R.id.f_iv_path,R.id.g_iv_path,R.id.h_iv_path};
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private ImageView tempImageView;
    private boolean flag = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_animator_path;
    }

    @Override
    public void initView() {
        for (int i = 0;i < res.length;i++){
            tempImageView = (ImageView) findViewById(res[i]);
            tempImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.a_iv_path:
                            if (flag){
                                startAnim();
                            }else {
                                closeAnim();
                            }
                            break;
                        default:
                            Toast.makeText(PathActivity.this,"Click-" + v.getId(),Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            imageViewList.add(tempImageView);
        }
    }

    private void closeAnim() {
        for (int i = 1;i < res.length;i++){
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY",i*300f,0f);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationX",i*300f,0f);
            AnimatorSet set = new AnimatorSet();
            set.playTogether(animator1,animator2);
            set.setDuration(700);
            set.setInterpolator(new BounceInterpolator());//设置差值器，重力加速度
            set.setStartDelay(i*300);
            set.start();
        }
        flag = true;
    }

    private void startAnim() {
        for (int i = 1;i < res.length;i++){
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY",0f,10f + i*50f);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationX",0f,400f - i*50f);
            AnimatorSet set = new AnimatorSet();
            set.playTogether(animator1,animator2);
            set.setDuration(700);
            set.setInterpolator(new BounceInterpolator());//设置差值器，重力加速度
            set.setStartDelay(i*300);
            set.start();
        }
        flag = false;
    }
}
