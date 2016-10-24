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

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        RadioButton radioRecommend = (RadioButton) findViewById(R.id.main_radio_recommend);
        RadioButton radioFollow = bindView(R.id.main_radio_follow);
        RadioButton radioDiscover = bindView(R.id.main_radio_discover);
        RadioButton radioMain = bindView(R.id.main_radio_mine);

        radioRecommend.setChecked(true);
        showFirstFragment();

        // 为四个RadioButton设置点击监听事件
        setClick(this, radioRecommend, radioFollow, radioDiscover, radioMain);
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
