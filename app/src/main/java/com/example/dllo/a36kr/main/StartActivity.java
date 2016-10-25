package com.example.dllo.a36kr.main;

import android.content.Intent;
import android.os.CountDownTimer;

import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.baseclass.BaseActivity;

/**
 * Created by xiaoyulu on 16/10/25.
 *
 * 启动页, 倒数两秒, 图片是布局里放好的, 不会变
 */
public class StartActivity extends BaseActivity{

    private CountDownTimer timer;

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initViews() {

        // 3秒的倒计时
        timer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                timer.cancel();
                finish();
            }
        };
        timer.start();

    }

    @Override
    protected void initData() {

    }
}
