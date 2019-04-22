package com.yb.mvpdemo.persenter;

import com.yb.mvpdemo.model.LoginModel;
import com.yb.mvpdemo.view.IBaseView;

/**
 * Created by Administrator on 2019/4/22.
 */

public class LoginPersenter implements IBasePersenter {
    private IBaseView iBaseView;
    private LoginModel loginModel;
    public LoginPersenter(IBaseView iBaseView){
        this.iBaseView = iBaseView;
        loginModel = new LoginModel(this);
    }
    @Override
    public void login(String userName, String password) {
        loginModel.login(userName,password);
        iBaseView.showDialog("正在登录中...");
    }
    @Override
    public void loginSucc() {

        iBaseView.dissmissDialog();

        iBaseView.jump();
    }
    @Override
    public void loginFail(String msg) {
        iBaseView.dissmissDialog();
        iBaseView.showLoginFailMessage(msg);
    }
}
