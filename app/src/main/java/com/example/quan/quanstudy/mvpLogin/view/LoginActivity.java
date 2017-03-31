package com.example.quan.quanstudy.mvpLogin.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quan.quanstudy.mvpLogin.presenter.ILoginPresenter;
import com.example.quan.quanstudy.mvpLogin.presenter.LoginPresenterImpl;
import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xingquan.he on 2017/3/7.
 */

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {

    private EditText mEditUser;
    private EditText mEditPass;
    private Button mBtnLogin;
    private Button mBtnClear;
    private ProgressBar mProgressBarLogin;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();

        mLoginPresenter = new LoginPresenterImpl(this);
        mProgressBarLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mvp_login;
    }

    @Override
    public void initView() {
        mEditUser = (EditText) this.findViewById(R.id.et_login_username);
        mEditPass = (EditText) this.findViewById(R.id.et_login_password);
        mBtnLogin = (Button) this.findViewById(R.id.btn_login_login);
        mBtnClear = (Button) this.findViewById(R.id.btn_login_clear);
        mProgressBarLogin = (ProgressBar) this.findViewById(R.id.progressbar_login);
    }

    private void initOnClickListener() {
        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_clear:
                mLoginPresenter.clear();
                break;
            case R.id.btn_login_login:
                mProgressBarLogin.setVisibility(View.VISIBLE);
                mBtnLogin.setEnabled(false);
                mBtnClear.setEnabled(false);
                mLoginPresenter.doLogin(mEditUser.getText().toString(), mEditPass.getText().toString());
                break;
            default:
                Toast.makeText(LoginActivity.this,"Default Click.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClearText() {
        mEditUser.setText("");
        mEditPass.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mProgressBarLogin.setVisibility(View.INVISIBLE);
        mBtnLogin.setEnabled(true);
        mBtnClear.setEnabled(true);
        if (result) {
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
