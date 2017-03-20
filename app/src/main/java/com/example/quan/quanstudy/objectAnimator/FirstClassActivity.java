package com.example.quan.quanstudy.objectAnimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 * 属性动画第一课
 * 项目实战：浅谈属性动画（1）-探索新玩法 http://blog.csdn.net/hxqneuq2012/article/details/52301791
 */

public class FirstClassActivity extends BaseActivity {

    private ImageView mImageAnimator;

    @Override
    public int getLayoutId() {
        return R.layout.activity_animator_first;
    }

    @Override
    public void initView() {
        mImageAnimator = (ImageView) findViewById(R.id.click_iv_animator);
    }

    public void click(View view){
        Toast.makeText(this,"Clickd.",Toast.LENGTH_SHORT).show();
    }

    public void move(View view){
//        ObjectAnimator.ofFloat(image_iv_main,"translationX",0F,200F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(image_iv_main,"translationY",0F,200F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(image_iv_main,"rotation",0F,360F).setDuration(1000).start();

//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation",0F,360F);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY",0F,200F);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationX",0F,200F);
//        ObjectAnimator.ofPropertyValuesHolder(image_iv_main,p1,p2,p3).setDuration(2000).start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageAnimator,"translationX",0F,200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageAnimator,"translationY",0F,200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageAnimator,"rotation",0F,360F);
        AnimatorSet set = new AnimatorSet();
        //set.playTogether(animator1,animator2,animator3);
        //set.playSequentially(animator1,animator2,animator3);
        set.play(animator1).with(animator2);
        set.play(animator3).after(animator2);
        set.setDuration(1000);
        set.start();
    }

    public void dismiass(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"alpha",0f,1f);
        animator.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(FirstClassActivity.this,"onAnimationEnd.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();
    }
}
