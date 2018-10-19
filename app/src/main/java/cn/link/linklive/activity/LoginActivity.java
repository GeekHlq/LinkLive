package cn.link.linklive.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.link.linklive.R;


public class LoginActivity extends BaseActivity {
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
    }

    @Override
    public void initData() {

    }
}
