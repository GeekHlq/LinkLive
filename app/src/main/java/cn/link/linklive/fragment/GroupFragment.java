package cn.link.linklive.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import cn.link.linklive.R;
import cn.link.linklive.utils.ToastManager;
import cn.link.linklive.widget.sidebar.CustomEditText;
import cn.link.linklive.widget.sidebar.SideBar;


public class GroupFragment extends BaseFragment implements View.OnClickListener, SideBar.OnTouchingLetterChangedListener, TextWatcher {
    private SwipeRefreshLayout refresher;
    private CustomEditText searchInput;
    private ListView groupList;
    private TextView groupDialog;
    private SideBar groupSideBar;

    public GroupFragment() {
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_group;
    }

    @Override
    protected void initView() {
        refresher=bind(R.id.refresher);
        searchInput=bind(R.id.search_input);
        groupList=bind(R.id.group_list);
        groupDialog=bind(R.id.group_dialog);
        groupSideBar=bind(R.id.group_sidebar);

        refresher.setColorSchemeResources(R.color.colorPrimary);
        refresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }


        });


        groupSideBar.setTextView(groupDialog);
        groupSideBar.setOnTouchingLetterChangedListener(this);

        searchInput.addTextChangedListener(this);

    }
    private void refreshData() {
        refresher.setRefreshing(true);
        ToastManager.makeToast(getContext(),"正在刷新数据中...");
    }
    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onTouchingLetterChanged(String s) {

    }
}
