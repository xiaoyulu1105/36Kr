package com.example.dllo.a36kr.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dllo.a36kr.mine.MineFragment;
import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.recommend.RecommendFragment;
import com.example.dllo.a36kr.baseclass.BaseActivity;
import com.example.dllo.a36kr.discover.DiscoverFragment;
import com.example.dllo.a36kr.follow.FollowFragment;

public class MainActivity extends BaseActivity  {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RadioButton radioRecommend;
    private RadioButton radioFollow;
    private RadioButton radioDiscover;
    private RadioButton radioMine;
    private RadioGroup radioGroup;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        radioGroup = (RadioGroup) findViewById(R.id.main_radiogroup);
        radioRecommend = bindView(R.id.main_radio_recommend);
        radioFollow = bindView(R.id.main_radio_follow);
        radioDiscover = bindView(R.id.main_radio_discover);
        radioMine = bindView(R.id.main_radio_mine);

        showFirstFragment();

        // 监听四个RadioButton的点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                judgeRadioButtonIsChecked(checkedId);
            }
        });

    }

    /* 判断哪个 RadioButton 被选中, 对其进行相应的操作 */

    private void judgeRadioButtonIsChecked(int checkedId) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (checkedId) {
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
                Log.d("MainActivity", "出错啦! RadioButton 居然一个没有选中!");
                break;
        }
        transaction.commit();
    }

    /* 默认选中第一个RadioButton */

    private void showFirstFragment() {
        radioRecommend.setChecked(true);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_view, new RecommendFragment());
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

}
