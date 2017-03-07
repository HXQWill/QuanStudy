package com.example.quan.quanstudy.MVP_login.model;

/**
 * Created by xingquan.he on 2017/3/7.
 */

public interface IUser {
    public String getName();

    public String getPassword();

    public int checkUserValidity(String name, String passwd);
}
