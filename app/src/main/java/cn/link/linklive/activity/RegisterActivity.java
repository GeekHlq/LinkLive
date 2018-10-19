package cn.link.linklive.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import cn.link.linklive.R;


public class RegisterActivity extends BaseActivity {
    private EditText et_username,et_phone,et_code,et_pwd,et_email;
    private Button btn_getCode,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initView() {
        et_username=findViewById(R.id.username_edit);
        et_phone=findViewById(R.id.phone_edit);
        et_code=findViewById(R.id.verify_code);
        et_pwd=findViewById(R.id.password_login_edit);
        et_email=findViewById(R.id.et_email);
        btn_getCode=findViewById(R.id.get_code);
        btn_register=findViewById(R.id.register_button);

    }

    @Override
    public void initData() {

    }
}
