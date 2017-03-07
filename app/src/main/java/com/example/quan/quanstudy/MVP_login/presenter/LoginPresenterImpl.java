package com.example.quan.quanstudy.MVP_login.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.quan.quanstudy.MVP_login.model.IUser;
import com.example.quan.quanstudy.MVP_login.model.User;
import com.example.quan.quanstudy.MVP_login.view.ILoginView;

/**
 * Created by xingquan.he on 2017/3/7.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView mLoginView;
    private IUser mUser;
    private Handler mHandler;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.mLoginView = iLoginView;
        mUser = new User("mvp","mvp");
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        mLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = mUser.checkUserValidity(name,passwd);
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
