package com.example.dllo.a36kr.recommend.earlyworks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.volley.VolleySingleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by XiaoyuLu on 16/10/27.
 *
 * 早期项目的 ListView 的适配器
 */
public class MyEarlyWorksLvAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<EarlyWorksBean.DataBean.DataBean1> dataBean1ArrayList;

    public MyEarlyWorksLvAdapter(Context context) {
        this.context = context;
    }

    public void setDataBean1ArrayList(ArrayList<EarlyWorksBean.DataBean.DataBean1> dataBean1ArrayList) {
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
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recommend_earlyworks, parent, false);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        // 获取到集合中需要进行铺建的 数据
        // 没有找到所属标签, 例如: 文娱, ! ! !
        String imgUrl = dataBean1ArrayList.get(position).getFeatureImg();
        String title = dataBean1ArrayList.get(position).getTitle();
        String tag = dataBean1ArrayList.get(position).getColumnName();
        long time = dataBean1ArrayList.get(position).getPublishTime();

        // 将 时间戳 格式进行修改
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finalTime = sdf.format(new Date(time));

        // 使用Volley请求图片, 并进行铺建
        // Title 铺建 不成功
        VolleySingleton.getInstance().getImage(imgUrl, viewHolder.imageView);
        viewHolder.titleTv.setText(title);
        viewHolder.tagTv.setText(tag);
        viewHolder.timeTv.setText(finalTime);

        return convertView;
    }

    /* 自定义内部类 */
    private class MyViewHolder{

        private final ImageView imageView;
        private final TextView titleTv;
        private final TextView tagTv;
        private final TextView timeTv;

        public MyViewHolder(View convertView) {
            imageView = (ImageView) convertView.findViewById(R.id.item_recommend_earlyworks_iv);
            titleTv = (TextView) convertView.findViewById(R.id.item_recommend_earlyworks_timetv);
            tagTv = (TextView) convertView.findViewById(R.id.item_recommend_earlyworks_tagtv);
            timeTv = (TextView) convertView.findViewById(R.id.item_recommend_earlyworks_timetv);

        }
    }
}
