package com.yb.mvpdemo.persenter;

/**
 * Created by Administrator on 2019/4/22.
 */

public interface IBasePersenter {

    void login(String userName,String password);

    void loginSucc();

    void loginFail(String msg);
}
