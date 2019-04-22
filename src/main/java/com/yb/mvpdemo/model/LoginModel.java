package com.yb.mvpdemo.model;

import com.yb.mvpdemo.persenter.IBasePersenter;

/**
 * Created by Administrator on 2019/4/22.
 */

public class LoginModel implements IBaseModel{
    private IBasePersenter basePersenter;
    public LoginModel(IBasePersenter basePersenter){
        this.basePersenter = basePersenter;
    }
    @Override
    public void login(final String userName,final String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                    if(userName.equals("qqq") && password.equals("111111")){
                        basePersenter.loginSucc();
                    }else{
                        if(!userName.equals("qqq")){
                            basePersenter.loginFail("帐号错误");
                        }else if(!password.equals("111111")){
                            basePersenter.loginFail("密码错误");
                        }else{
                            basePersenter.loginFail("帐号密码错误");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
