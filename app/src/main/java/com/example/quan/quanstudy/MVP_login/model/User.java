package com.example.quan.quanstudy.MVP_login.model;

/**
 * Created by xingquan.he on 2017/3/7.
 */

public class User {

    private String mName;
    private String mPassword;

    public User(String name, String password) {
        this.mName = name;
        this.mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public String getPassword() {
        return mPassword;
    }

    public int checkUserValidity(String name, String password) {
        if ( name == null || password == null || !name.equals(getName()) || !password.equals(getPassword()) ){
            return -1;
        }
        return 0;
    }
}
