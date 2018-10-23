package cn.link.linklive.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.link.linklive.R;
import cn.link.linklive.fragment.GroupFragment;
import cn.link.linklive.fragment.MapFragment;
import cn.link.linklive.fragment.MessageFragment;
import cn.link.linklive.fragment.PersonFragment;
import cn.link.linklive.widget.BottomLayout;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private MapFragment mMapFragment;
    private GroupFragment mGroupFragment;
    private MessageFragment mMessageFragment;
    private PersonFragment mPersonFragment;
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private BottomLayout mMapLayout;
    private BottomLayout mGroupLayout;
    private BottomLayout mMessageLayout;
    private BottomLayout mPersonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再沉浸到状态栏下
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        initList();
        setPagerAdapter();
        mMapLayout.setSelectState();
        setViewPagerListener();
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void initView() {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        mViewPager =findViewById(R.id.view_pager);
        mMapLayout =findViewById(R.id.map_layout);
        mGroupLayout =findViewById(R.id.group_layout);
        mMessageLayout =findViewById(R.id.message_layout);
        mPersonLayout =findViewById(R.id.person_layout);

        mMapLayout.setOnClickListener(this);
        mGroupLayout.setOnClickListener(this);
        mMessageLayout.setOnClickListener(this);
        mPersonLayout.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);



        return true;

    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.more_button:

                Toast.makeText(this, "more", Toast.LENGTH_SHORT).show();

                break;

            case R.id.more_info:

                Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();

                break;

            default:

                break;

        }

        return super.onOptionsItemSelected(item);

    }
    private void setViewPagerListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setBottomState(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setPagerAdapter() {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    private void initList() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(mMapFragment);
        mFragmentList.add(mGroupFragment);
        mFragmentList.add(mMessageFragment);
        mFragmentList.add(mPersonFragment);
    }

    private void initFragment() {
        mMapFragment = new MapFragment();
        mGroupFragment = new GroupFragment();
        mMessageFragment = new MessageFragment();
        mPersonFragment = new PersonFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.map_layout:
                setBottomState(0);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.group_layout:
                setBottomState(1);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.message_layout:
                setBottomState(2);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.person_layout:
                setBottomState(3);
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    private void setBottomState(int position) {
        switch (position) {
            case 0:
                mMapLayout.setSelectState();
                mGroupLayout.setUnSelectState();
                mMessageLayout.setUnSelectState();
                mPersonLayout.setUnSelectState();
                break;
            case 1:
                mMapLayout.setUnSelectState();
                mGroupLayout.setSelectState();
                mMessageLayout.setUnSelectState();
                mPersonLayout.setUnSelectState();
                break;
            case 2:
                mMapLayout.setUnSelectState();
                mGroupLayout.setUnSelectState();
                mMessageLayout.setSelectState();
                mPersonLayout.setUnSelectState();
                break;
            case 3:
                mMapLayout.setUnSelectState();
                mGroupLayout.setUnSelectState();
                mMessageLayout.setUnSelectState();
                mPersonLayout.setSelectState();
                break;
            default:
                break;
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
