package cn.link.linklive.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import cn.link.linklive.R;


public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                actionBar.setElevation(0);
            }
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:

            default:
                this.finish();
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


}
