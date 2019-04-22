package com.yb.mvpdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yb.mvpdemo.persenter.LoginPersenter;
import com.yb.mvpdemo.view.IBaseView;

public class MainActivity extends AppCompatActivity implements IBaseView{

    private EditText et_user;
    private EditText et_pwd;
    private Button btn_login;

    private LoginPersenter loginPersenter;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initDialog();

        initLinstener();

        initPersenter();
    }

    private void initDialog(){

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//转盘
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("提示");
        dialog.setMessage("正在登录中...");
    }

    private void initPersenter(){
        if(loginPersenter == null){
            loginPersenter = new LoginPersenter(this);
        }
    }
    private void initView(){
        et_user = findViewById(R.id.et_user);
        et_pwd = findViewById(R.id.et_pwd);
        btn_login = findViewById(R.id.btn_login);

    }
    private void initLinstener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(judge() && loginPersenter != null){
                    loginPersenter.login(et_user.getText().toString().trim(),et_pwd.getText().toString().trim());
                }else{
                    if(dialog != null && dialog.isShowing()){
                        dialog.dismiss();
                    }
                }
            }
        });
    }
    private boolean judge(){

        boolean isSucc = true;
        String userName = et_user.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();

        if(TextUtils.isEmpty(userName)){
            isSucc = false;
            showToast("请输入正确的帐号");
        }
        if(TextUtils.isEmpty(pwd)){
            isSucc = false;
            showToast("请输入正确的密码");
        }

        return isSucc;

    }

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog(String content) {

        if(dialog != null){
            dialog.show();
        }
    }

    @Override
    public void showLoginFailMessage(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(msg);
            }
        });
    }

    @Override
    public void dissmissDialog() {

        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void jump() {
        startActivity(new Intent(this,JumpActivity.class));
    }
}
