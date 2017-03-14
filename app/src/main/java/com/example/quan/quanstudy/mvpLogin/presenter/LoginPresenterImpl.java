package com.example.quan.quanstudy.mvpLogin.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.quan.quanstudy.mvpLogin.model.User;
import com.example.quan.quanstudy.mvpLogin.view.ILoginView;

/**
 * Created by xingquan.he on 2017/3/7.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView mLoginView;
    private User mUser;
    private Handler mHandler;//模拟登录耗时操作

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.mLoginView = iLoginView;
        mUser = new User("xq.he","mvp");
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        mLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        Boolean isLoginSuccess = true;
        final int code = mUser.checkUserValidity(name,password);
        if (code != 0) {
            isLoginSuccess = false;
        }
        final Boolean result = isLoginSuccess;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.onLoginResult(result, code);
            }
        }, 4000);
    }

}
