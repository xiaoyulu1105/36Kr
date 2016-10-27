package com.example.dllo.a36kr.mine;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.a36kr.R;
import com.example.dllo.a36kr.baseclass.BaseActivity;

public class MinePhoneLoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int getLayout() {
        return R.layout.activity_mine_phone_login;
    }

    @Override
    protected void initViews() {

        ImageButton returnImgBtn = bindView(R.id.mine_phonelogin_returnimgbtn);

        ImageButton getNumPicImgBtn = bindView(R.id.mine_phonelogin_getnumber_picimgbtn);
        TextView getNumPreNumTv = bindView(R.id.mine_phonelogin_getnumber_prenumtv);
        EditText getNumEdt = bindView(R.id.mine_phonelogin_getnumber_numedt);

        EditText getCodeEdt = bindView(R.id.mine_phonelogin_getcode_edt);
        Button getCodeBtn = bindView(R.id.mine_phonelogin_getcode_btn);
        Button getVoiceCodeBtn = bindView(R.id.mine_phonelogin_getvoicecode_btn);

        Button loginBtn = bindView(R.id.mine_phonelogin_login_btn);
        Button loginWeChatBtn = bindView(R.id.mine_phonelogin_login_wechatbtn);
        Button loginKrBtn = bindView(R.id.mine_phonelogin_login_krbtn);

        TextView agreeTv = bindView(R.id.mine_phonelogin_agreementtv);
        TextView secretTv = bindView(R.id.mine_phonelogin_secrettv);

        setClick(this, returnImgBtn);
        setClick(this, getNumPicImgBtn, getNumPreNumTv, getNumEdt);
        setClick(this, getCodeEdt, getCodeBtn, getVoiceCodeBtn);
        setClick(this, loginBtn, loginWeChatBtn, loginKrBtn);
        setClick(this, agreeTv, secretTv);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 返回按钮
            case R.id.mine_phonelogin_returnimgbtn:
                finish();
                break;

            // 第一行: 获取手机号
            case R.id.mine_phonelogin_getnumber_picimgbtn:
                break;

            case R.id.mine_phonelogin_getnumber_prenumtv:
                break;

            case R.id.mine_phonelogin_getnumber_numedt:
                break;

            // 第二行: 获取验证码
            case R.id.mine_phonelogin_getcode_edt:
                break;

            case R.id.mine_phonelogin_getcode_btn:
                break;

            // 第三行: 获取语音验证码
            case R.id.mine_phonelogin_getvoicecode_btn:
                break;

            // 三个登录:
            case R.id.mine_phonelogin_login_btn:
                break;

            case R.id.mine_phonelogin_login_wechatbtn:
                break;

            case R.id.mine_phonelogin_login_krbtn:
                break;

            // 一个协议, 一个隐私
            case R.id.mine_phonelogin_agreementtv:
                break;

            case R.id.mine_phonelogin_secrettv:
                break;

            default:
                Log.d("MinePhoneLoginActivity", "出错啦!");
                break;
        }
    }
}
