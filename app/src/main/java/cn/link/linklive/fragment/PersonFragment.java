package cn.link.linklive.fragment;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.link.linklive.R;
import cn.link.linklive.activity.AboutActivity;
import cn.link.linklive.activity.ActivityManager;
import cn.link.linklive.activity.ProfileActivity;
import cn.link.linklive.utils.ToastManager;


public class PersonFragment extends BaseFragment implements View.OnClickListener{
    private LinearLayout profile,plugin,about,feedback,share,draft,chatting,setting;
    private TextView txt_nickname,txt_email;

    public PersonFragment() {

    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initView() {
        profile=bind(R.id.person_profile);
        plugin=bind(R.id.person_plugin);
        about=bind(R.id.person_about);
        feedback=bind(R.id.person_feedback);
        share=bind(R.id.person_share);
        draft=bind(R.id.person_draft);
        chatting=bind(R.id.person_chatting);
        setting=bind(R.id.person_setting);

        profile.setOnClickListener(this);
        plugin.setOnClickListener(this);
        about.setOnClickListener(this);
        feedback.setOnClickListener(this);
        share.setOnClickListener(this);
        draft.setOnClickListener(this);
        chatting.setOnClickListener(this);
        setting.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person_profile:
                ActivityManager.goToActivityFromRight2Left(getActivity(), ProfileActivity.class);
                break;
            case R.id.person_plugin:
                ToastManager.makeToast(getContext(),"插件尚待开发...");
                break;
            case R.id.person_about:
                ActivityManager.goToActivityFromRight2Left(getContext(), AboutActivity.class);
                break;
            case R.id.person_feedback:
                break;
            case R.id.person_share:
                break;
            case R.id.person_draft:
                break;
            case R.id.person_chatting:
                break;
            case R.id.person_setting:
                break;
            default:
                break;
        }
    }
}
