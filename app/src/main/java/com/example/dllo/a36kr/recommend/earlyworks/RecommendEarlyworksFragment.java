package com.example.dllo.a36kr.recommend.earlyworks;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.baseclass.BaseFragment;
import com.example.dllo.a36kr.recommend.earlyworks.EarlyWorksBean;
import com.example.dllo.a36kr.tools.MSGValues;
import com.example.dllo.a36kr.tools.URLValues;
import com.example.dllo.a36kr.volley.GsonRequest;
import com.example.dllo.a36kr.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by xiaoyulu on 16/10/25.
 * <p/>
 * 该 Fragment 是 个人 选项中的 早期项目 选项
 * 所用到的What值 在 MSGValues 类 里
 */
public class RecommendEarlyworksFragment extends BaseFragment {

    private static String earlyWorksUrlString = URLValues.EARLYWORKS_URL; // 接口网址

    private EarlyWorksBean earlyWorksBean;
    private ArrayList<EarlyWorksBean.DataBean.DataBean1> dataBean1ArrayList; // 解析完后得到的所有数据
    private ListView listView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend_earlyworks;
    }

    @Override
    protected void initViews() {

        listView = (ListView) getView().findViewById(R.id.recommend_earlyworks_listview);

        dataBean1ArrayList = new ArrayList<>();

        myGsonMethod();

    }

    /* 将Gson相关的请求代码写在该方法内 */

    private void myGsonMethod() {

        // Gson 操作是否需要放入子线程 ? ?
        // 在子线程操作后, 数据跟新 需要 用Handler 进行传送

        GsonRequest<EarlyWorksBean> gsonRequest = new
                GsonRequest<EarlyWorksBean>(EarlyWorksBean.class,
                earlyWorksUrlString, new Response.Listener<EarlyWorksBean>() {

            @Override
            public void onResponse(EarlyWorksBean response) {

                // 请求成功
                earlyWorksBean = response;
                dataBean1ArrayList = (ArrayList<EarlyWorksBean.DataBean.DataBean1>) response.getData().getData();

                MyEarlyWorksLvAdapter adapter = new MyEarlyWorksLvAdapter(getActivity());
                adapter.setDataBean1ArrayList(dataBean1ArrayList);
                listView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 请求失败
                Log.d("RecommendEarlyworksFrag", "Gson网络请求失败!");
            }
        });
        // 将请求添加到 请求队列中
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }

    @Override
    protected void initData() {

    }

}
