package com.example.dllo.a36kr.recommend;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.baseclass.BaseFragment;
import com.example.dllo.a36kr.recommend.newsflash.RecommendNewsflashFragment;
import com.example.dllo.a36kr.recommend.recommend.RecommendRecommendFragment;
import com.example.dllo.a36kr.recommend.earlyworks.RecommendEarlyworksFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyulu on 16/10/24.
 *
 * 36氪 首页 对应的Fragment类
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
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new RecommendNewsflashFragment());
        fragmentArrayList.add(new RecommendRecommendFragment());
        fragmentArrayList.add(new RecommendEarlyworksFragment());

        MyRecommendVpAdapter adapter = new MyRecommendVpAdapter(getActivity().getSupportFragmentManager());
        adapter.setFragmentArrayList(fragmentArrayList);

        viewPager.setAdapter(adapter);
        // 设置选用第二个标题
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);

        // 设置 tabLayout 文字的大小, 在布局文件中实现
        // 设置 tabLayout 的下划线的 颜色和长度, 还需添加动态效果
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorRecommendTabIsSelected));

    }

    @Override
    protected void initData() {

    }
}
