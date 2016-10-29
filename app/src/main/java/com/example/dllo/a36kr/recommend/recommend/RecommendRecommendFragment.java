package com.example.dllo.a36kr.recommend.recommend;

import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.baseclass.BaseFragment;
import com.example.dllo.a36kr.tools.URLValues;
import com.example.dllo.a36kr.volley.GsonRequest;
import com.example.dllo.a36kr.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by xiaoyulu on 16/10/25.
 *
 * 该 Fragment 是 个人 选项中的 推荐 选项
 */
public class RecommendRecommendFragment extends BaseFragment {

    private ListView listView;
    private VolleySingleton volleySingleton;
    private ArrayList<RecommendBean.DataBean.DataBean1> dataBean1ArrayList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend_recommend;
    }

    @Override
    protected void initViews() {

        listView = (ListView) getView().findViewById(R.id.recommend_recommend_listview);

        dataBean1ArrayList = new ArrayList<>();
        volleySingleton = VolleySingleton.getInstance();

        GsonRequest<RecommendBean> gsonRequest = new GsonRequest<RecommendBean>(RecommendBean.class, URLValues.RECOMMEND_LIST, new Response.Listener<RecommendBean>() {
            @Override
            public void onResponse(RecommendBean response) {
                // 请求成功
                dataBean1ArrayList = (ArrayList<RecommendBean.DataBean.DataBean1>) response.getData().getData();

                MyRecommendLvAdapter adapter = new MyRecommendLvAdapter(getActivity());
                adapter.setDataBean1ArrayList(dataBean1ArrayList);
                listView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 请求失败
                Log.d("RecommendRecommendFragm", "请求数据失败!");
            }
        });

        volleySingleton.addRequest(gsonRequest);

    }

    @Override
    protected void initData() {



    }
}
