package com.yb.mvpdemo.view;

/**
 * Created by Administrator on 2019/4/22.
 */

public interface IBaseView {

    void showDialog(String content);

    void showLoginFailMessage(String msg);

    void dissmissDialog();

    void jump();
}
