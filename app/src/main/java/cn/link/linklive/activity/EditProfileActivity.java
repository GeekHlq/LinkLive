package cn.link.linklive.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;

import java.util.Calendar;

import cn.link.linklive.R;


public class EditProfileActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener{
    private EditText editAvatar,editSex,editLocation,editBirth;
    private TextView sex,birth;
    private static final int RESULT_CHOOSE_LOCATION = 1;
    private static final int RESULT_CHOOSE_PHOTO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initView();
    }

    @Override
    public void initView() {
        editAvatar=findViewById(R.id.edit_avatar);
        editSex=findViewById(R.id.edit_sex);
        editLocation=findViewById(R.id.edit_location);
        editBirth=findViewById(R.id.edit_birth);
        sex=findViewById(R.id.sex);
        birth=findViewById(R.id.birth);
        editAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        editSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSexChoose();
            }
        });

        editLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseLocationActivity.actionStart(EditProfileActivity.this, RESULT_CHOOSE_LOCATION);
            }
        });

        editBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        EditProfileActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        String date = Integer.toString(year) + "-"
                + Integer.toString(monthOfYear + 1) + "-"
                + Integer.toString(dayOfMonth);

        birth.setText(date);
    }

    private void showSexChoose(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileActivity.this);
        final String[] sexs = {getString(R.string.sex_man), getString(R.string.sex_woman)};
        builder.setTitle("请选择性别");
        int defaultWhich;
        if(sex.getText().toString().equals(sexs[1])) {
            defaultWhich = 1;
        } else{
            defaultWhich = 0;
        }
        builder.setSingleChoiceItems(sexs, defaultWhich,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sex.setText(sexs[which]);
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }


}
