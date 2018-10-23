package cn.link.linklive.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.link.linklive.R;
import cn.link.linklive.widget.citypicker.CityPicker;


public class ChooseLocationActivity extends BaseActivity {

    private Toolbar toolbar;
    private CityPicker cityPicker;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);


        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = cityPicker.GetProvince()
                        + " " + cityPicker.GetCity()
                        + " " + cityPicker.GetCounty();
                Intent intent = new Intent();
                intent.putExtra("location", location);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void initView() {
        toolbar=findViewById(R.id.toolbar);
        cityPicker=findViewById(R.id.city_picker);
        fab=findViewById(R.id.fab);
    }

    @Override
    public void initData() {

    }

    public static void actionStart(Activity activity, int resultCode){
        Intent intent = new Intent(activity, ChooseLocationActivity.class);
        activity.startActivityForResult(intent, resultCode);
    }



}
