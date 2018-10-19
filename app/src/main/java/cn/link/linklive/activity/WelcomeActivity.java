package cn.link.linklive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import cn.link.linklive.R;


public class WelcomeActivity extends BaseActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏设置
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        //初始化动画组件
        iv=(ImageView)findViewById(R.id.start);
        //定义动画效果
        AlphaAnimation animation=new AlphaAnimation(0.1f,1);//渐变效果
        animation.setDuration(2000);
        animation.setInterpolator(this, android.R.interpolator.linear);
        Handler handler=new Handler(){
        };
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        },2000);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}

