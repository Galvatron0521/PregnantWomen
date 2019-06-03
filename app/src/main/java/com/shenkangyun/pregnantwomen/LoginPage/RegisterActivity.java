package com.shenkangyun.pregnantwomen.LoginPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jaeger.library.StatusBarUtil;
import com.shenkangyun.pregnantwomen.BaseFolder.Base;
import com.shenkangyun.pregnantwomen.BeanFolder.RegisterBean;
import com.shenkangyun.pregnantwomen.R;
import com.shenkangyun.pregnantwomen.UtilFolder.GsonCallBack;
import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.ed_userName)
    EditText edUserName;
    @BindView(R.id.ed_passWord)
    EditText edPassWord;
    @BindView(R.id.ed_confirm)
    EditText edConfirm;
    @BindView(R.id.ed_tel)
    EditText edTel;
    @BindView(R.id.ed_idCard)
    EditText edIdCard;

    private String telTv;
    private String userNameTv;
    private String idCardTv;
    private String passWordTv;
    private String confirmTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.home_orange));
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            toolBarTitle.setText("用户注册");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @OnClick({R.id.btn_register, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                getData();
                break;
            case R.id.btn_cancel:
                Intent intent = new Intent();
                intent.putExtra("UserName", "");
                intent.putExtra("PassWord", "");
                setResult(1, intent);
                finish();
                break;
        }
    }

    private void getData() {
        telTv = edTel.getText().toString();
        userNameTv = edUserName.getText().toString();
        idCardTv = edIdCard.getText().toString();
        passWordTv = edPassWord.getText().toString();
        confirmTv = edConfirm.getText().toString();
        if (TextUtils.isEmpty(userNameTv)) {
            Toast.makeText(this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(passWordTv)) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(confirmTv)) {
            Toast.makeText(this, "密码不一致！", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(telTv)) {
            Toast.makeText(this, "手机号不能为空！", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(idCardTv)) {
            Toast.makeText(this, "身份证号不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            initRegister();
        }
    }

    private void initRegister() {
        OkHttpUtils.post()
                .url(Base.URL)
                .addParams("act", "registerPatient")
                .addParams("data", new registerPatient(Base.getMD5Str(), Base.getTimeSpan(), "1", userNameTv,
                        telTv, idCardTv, passWordTv, confirmTv).toJson())
                .build()
                .execute(new GsonCallBack<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean response) throws JSONException {
                        String status = response.getStatus();
                        if ("0".equals(status)) {
                            Intent intent = new Intent();
                            intent.putExtra("UserName", telTv);
                            intent.putExtra("PassWord", passWordTv);
                            setResult(1, intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

        //注册失败会抛出HyphenateException
        try {
            EMClient.getInstance().createAccount(telTv, passWordTv);//同步方法
        } catch (HyphenateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.putExtra("UserName", "");
                intent.putExtra("PassWord", "");
                setResult(1, intent);
                finish();
                break;
        }
        return true;
    }

    static class registerPatient {

        private String appKey;
        private String timeSpan;
        private String mobileType;
        private String loginName;
        private String mobile;
        private String idCard;
        private String password;
        private String passwordCopy;

        public registerPatient(String appKey, String timeSpan, String mobileType, String loginName,
                               String mobile, String idCard, String password, String passwordCopy) {
            this.appKey = appKey;
            this.timeSpan = timeSpan;
            this.mobileType = mobileType;
            this.loginName = loginName;
            this.mobile = mobile;
            this.idCard = idCard;
            this.password = password;
            this.passwordCopy = passwordCopy;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }
}
