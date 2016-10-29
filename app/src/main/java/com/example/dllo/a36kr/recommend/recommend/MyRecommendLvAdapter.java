package com.example.dllo.a36kr.recommend.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/29.
 */
public class MyRecommendLvAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<RecommendBean.DataBean.DataBean1> dataBean1ArrayList;

    public MyRecommendLvAdapter(Context context) {
        this.context = context;
    }

    public void setDataBean1ArrayList(ArrayList<RecommendBean.DataBean.DataBean1> dataBean1ArrayList) {
        this.dataBean1ArrayList = dataBean1ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBean1ArrayList == null ? 0 : dataBean1ArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBean1ArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_recommend_recommend_list, parent, false);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        // 获取 图片网址, 标题, 所属标签
        String imgUrl = dataBean1ArrayList.get(position).getFeatureImg();
        String title = dataBean1ArrayList.get(position).getTitle();
        String tag = dataBean1ArrayList.get(position).getColumnName();

        VolleySingleton.getInstance().getAnimImage(imgUrl, viewHolder.imageView);
        viewHolder.tvTitle.setText(title);
        viewHolder.tvTag.setText(tag);

        return convertView;
    }

    private class MyViewHolder{

        private final ImageView imageView;
        private final TextView tvTitle;
        private final TextView tvTag;

        public MyViewHolder(View convertView) {
            imageView = (ImageView) convertView.findViewById(R.id.item_recommend_recommend_iv);
            tvTitle = (TextView) convertView.findViewById(R.id.item_recommend_recommend_titletv);
            tvTag = (TextView) convertView.findViewById(R.id.item_recommend_recommend_tagtv);
        }
    }
}
