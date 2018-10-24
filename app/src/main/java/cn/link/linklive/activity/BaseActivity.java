package cn.link.linklive.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import cn.link.linklive.R;

public abstract class BaseActivity extends AppCompatActivity{

    protected static final String TAG = "Link";
    private boolean mAllowFullScreen=true;  //是否允许全屏
    /***是否显示标题栏*/
    private  boolean isshowtitle = true;
    /***是否显示标题栏*/
    private  boolean isshowstate = true;
    public Context mContext;

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 把actvity放到application栈中管理
        ActivityManager.addActivity(this);
        mContext = this;
        if(!isshowtitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if(isshowstate){
            getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        }
        setImmersive(true); // 沉浸式布局

    }
    /**     * 是否设置标题栏     *     * @return     */
    public void setTitle(boolean ishow) {
        isshowtitle=ishow;
    }
    /**
     *  设置是否显示状态栏
     *  @param ishow
     *  */
    public void setState(boolean ishow) {
        isshowstate=ishow;
    }


    /**
     * 封装一个方法 通过Class跳转界面
     * @param clas
     */
    protected  void startActivity(Class<?> clas) {
        Intent intent = new Intent();
        intent.setClass(this, clas);
        startActivity(intent);

    }

    /**
     * 通过Class跳转界面，有返回值时调用
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面,有返回值时调用
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    /** * 隐藏软件盘 */
    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
    /** * 点击软键盘之外的空白处，隐藏软件盘 * @param ev * @return */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if (ToolUtil.isShouldHideInput(v, ev)) {
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm != null) {
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                }
//            }
//            return super.dispatchTouchEvent(ev);
//        }
//        // 必不可少，否则所有的组件都不会有TouchEvent了
//         if (getWindow().superDispatchTouchEvent(ev)) {
//         return true;
//         }    return onTouchEvent(ev);
//    }
    /** * 显示软键盘 */
    public void showInputMethod(){
        if (getCurrentFocus() != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),0);
        }
    }

    /**
     * 防止快速点击
     */
    private boolean fastclick(){
        long lastclick=0;
        if(System.currentTimeMillis()-lastclick<=1000){
            return false;
        }
        lastclick=System.currentTimeMillis();
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(BaseActivity.this, getString(R.string.toast_exit),
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                ActivityManager.finishAll();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();
}
