package com.example.dllo.a36kr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dllo.a36kr.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RadioButton radioRecommend;
    private RadioButton radioFollow;
    private RadioButton radioDiscover;
    private RadioButton radioMain;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        radioRecommend = (RadioButton) findViewById(R.id.main_radio_recommend);
        radioFollow = bindView(R.id.main_radio_follow);
        radioDiscover = bindView(R.id.main_radio_discover);
        radioMain = bindView(R.id.main_radio_mine);

        radioRecommend.setChecked(true);
        showFirstFragment();

        // 监听四个RadioButton的点击事件
        judgeRadioButtonIsChecked();
//        setClick(this, radioRecommend, radioFollow, radioDiscover, radioMain);
    }

    private void judgeRadioButtonIsChecked() {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        if (radioRecommend.isChecked()) {
            transaction.replace(R.id.main_view, new RecommendFragment());

        } else if (radioFollow.isChecked()) {
            transaction.replace(R.id.main_view, new FollowFragment());

        } else if (radioDiscover.isChecked()) {
            transaction.replace(R.id.main_view, new DiscoverFragment());

        } else if (ra)
    }

    private void showFirstFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_view, new RecommendFragment());
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (v.getId()) {
            case R.id.main_radio_recommend:
                transaction.replace(R.id.main_view, new RecommendFragment());

                break;
            case R.id.main_radio_follow:
                transaction.replace(R.id.main_view, new FollowFragment());

                break;

            case R.id.main_radio_discover:
                transaction.replace(R.id.main_view, new DiscoverFragment());

                break;
            case R.id.main_radio_mine:
                transaction.replace(R.id.main_view, new MineFragment());

                break;
            default:
                break;
        }
        transaction.commit();
    }
}
