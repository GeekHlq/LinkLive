package cn.link.linklive.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.link.linklive.R;


public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_user,et_pwd;
    private ImageView img_more;
    private Button btn_login;
    private TextView tv_register,tv_fogetPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    @Override
    public void initView() {
        et_user=findViewById(R.id.login_number);
        et_pwd=findViewById(R.id.login_password);
        img_more=findViewById(R.id.login_more_user);
        btn_login=findViewById(R.id.btn_login);
        tv_register=findViewById(R.id.register);
        tv_fogetPwd=findViewById(R.id.forget_password);

        et_user.setOnClickListener(this);
        et_pwd.setOnClickListener(this);
        img_more.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_fogetPwd.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register:
                ActivityManager.goToActivityFromLeft2Right(LoginActivity.this,RegisterActivity.class);
                break;
            case R.id.forget_password:
                ActivityManager.goToActivityFromBottom2Top(LoginActivity.this,ForgetPwdActivity.class);
                break;

        }
    }
}
