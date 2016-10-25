package com.example.dllo.a36kr.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by xiaoyulu on 16/10/25.
 */
public class MyRecommendVpAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> fragmentArrayList;
    String[] titles = new String[]{"快讯", "推荐", "早期项目"};

    public MyRecommendVpAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        this.fragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList == null ? 0 : fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
