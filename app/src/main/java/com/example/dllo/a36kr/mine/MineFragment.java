package com.example.dllo.a36kr.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.baseclass.BaseFragment;

/**
 * Created by xiaoyulu on 16/10/24.
 *
 * 36氪 我的 对应的 Fragment 类
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        ImageButton loginImgBtn = (ImageButton) getView().findViewById(R.id.mine_login_imgbtn);
        Button loginBtn = (Button) getView().findViewById(R.id.mine_login_btn);
        loginImgBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_login_imgbtn:
                Intent intent = new Intent(getActivity(), MinePhoneLoginActivity.class);
                startActivity(intent);

                break;
            case R.id.mine_login_btn:
                Intent intent1 = new Intent(getActivity(), MinePhoneLoginActivity.class);
                startActivity(intent1);

                break;

        }
    }
}
