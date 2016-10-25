package com.example.dllo.a36kr;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.dllo.a36kr.base.BaseFragment;

/**
 * Created by xiaoyulu on 16/10/24.
 */
public class RecommendFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initViews() {
        tabLayout = bindView(R.id.recommend_tablayout);
        viewPager = bindView(R.id.recommend_viewpager);

        // 为 ViewPager 添加 Fragment 集合 和 FragmentPagerAdapter 适配器

    }

    @Override
    protected void initData() {

    }
}
