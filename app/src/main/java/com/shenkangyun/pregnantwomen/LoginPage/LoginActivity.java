package com.shenkangyun.pregnantwomen.LoginPage;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.jaeger.library.StatusBarUtil;
import com.shenkangyun.pregnantwomen.BaseFolder.AppConst;
import com.shenkangyun.pregnantwomen.BaseFolder.Base;
import com.shenkangyun.pregnantwomen.BeanFolder.LoginBean;
import com.shenkangyun.pregnantwomen.DBFolder.SQLiteDbHelper;
import com.shenkangyun.pregnantwomen.MainPage.MainActivity;
import com.shenkangyun.pregnantwomen.R;
import com.shenkangyun.pregnantwomen.UtilFolder.ClearWriteEditText;
import com.shenkangyun.pregnantwomen.UtilFolder.GsonCallBack;
import com.shenkangyun.pregnantwomen.UtilFolder.NToast;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.de_login_phone)
    ClearWriteEditText deLoginPhone;
    @BindView(R.id.de_login_password)
    ClearWriteEditText deLoginPassword;
    @BindView(R.id.de_img_backgroud)
    ImageView deImgBackgroud;

    private String phoneString;
    private String passwordString;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private SQLiteDbHelper sqLiteDbHelper;

    private String id;
    private String idCard;
    private String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtil.setTranslucent(LoginActivity.this, 55);
        ButterKnife.bind(this);
        sqLiteDbHelper = new SQLiteDbHelper(this);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        editor = sp.edit();
        initView();
    }

    private void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate_anim);
                deImgBackgroud.startAnimation(animation);
            }
        }, 200);
        String oldPhone = sp.getString(AppConst.LOGING_PHONE, "");
        String oldPassword = sp.getString(AppConst.LOGING_PASSWORD, "");

        if (!TextUtils.isEmpty(oldPhone) && !TextUtils.isEmpty(oldPassword)) {
            phoneString = oldPhone;
            passwordString = oldPassword;
            deLoginPhone.setText(oldPhone);
            deLoginPassword.setText(oldPassword);
            goToMain();
        }
    }

    @OnClick({R.id.de_login_sign, R.id.de_login_forgot, R.id.de_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.de_login_sign:
                phoneString = deLoginPhone.getText().toString().trim();
                passwordString = deLoginPassword.getText().toString().trim();
                if (TextUtils.isEmpty(phoneString)) {
                    NToast.shortToast(this, R.string.phone_number_is_null);
                    deLoginPhone.setShakeAnimation();
                    return;
                }
//                if (!AMUtils.isMobile(phoneString)) {
//                    NToast.shortToast(this, R.string.Illegal_phone_number);
//                    deLoginPhone.setShakeAnimation();
//                    return;
//                }
                if (TextUtils.isEmpty(passwordString)) {
                    NToast.shortToast(this, R.string.password_is_null);
                    deLoginPassword.setShakeAnimation();
                    return;
                }
                if (passwordString.contains(" ")) {
                    NToast.shortToast(this, R.string.password_cannot_contain_spaces);
                    deLoginPassword.setShakeAnimation();
                    return;
                }
                goToMain();
                break;
            case R.id.de_login_forgot:
                Intent intentFor = new Intent(this, ForgotActivity.class);
                startActivity(intentFor);
                break;
            case R.id.de_login_register:
                Intent intentReg = new Intent(this, RegisterActivity.class);
                startActivityForResult(intentReg, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String userName = data.getStringExtra("UserName");
        String passWord = data.getStringExtra("PassWord");
        if (requestCode == 0 && resultCode == 1
                && !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord)) {
            deLoginPhone.setText(userName);
            deLoginPassword.setText(passWord);
        }
    }

    private void goToMain() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpUtils.post()
                        .url(Base.URL)
                        .addParams("act", "login")
                        .addParams("data", new Login(Base.getMD5Str(), Base.getTimeSpan(), "1", "1", phoneString, passwordString).toJson())
                        .build()
                        .execute(new GsonCallBack<LoginBean>() {
                            @Override
                            public void onSuccess(LoginBean response) {
                                String status = response.getStatus();
                                if ("0".equals(status)) {
                                    initUserInfo(response);
                                    initEM();
                                    editor.putString(AppConst.LOGING_PHONE, phoneString);
                                    editor.putString(AppConst.LOGING_PASSWORD, passwordString);
                                    editor.commit();

                                    NToast.shortToast(LoginActivity.this, R.string.login_success);
                                    String name = response.getData().getPatient().getName();
                                    if (TextUtils.isEmpty(name)) {
                                        startActivity(new Intent(LoginActivity.this, ConsummateActivity.class));
                                        finish();
                                    } else {
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                        finish();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(Exception e) {

                            }
                        });
            }
        }).start();

    }

    private void initUserInfo(LoginBean response) {

        id = response.getData().getPatient().getId();
        idCard = response.getData().getPatient().getIdCard();
        mobile = response.getData().getPatient().getMobile();

        SQLiteDatabase db = sqLiteDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("userID", id);
        values.put("telNum", mobile);
        values.put("idCard", idCard);

        db.insert("User", null, values);
    }

    private void initEM() {
        EMClient.getInstance().login(phoneString, passwordString, new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
            }
        });
    }

    static class Login {
        private String appKey;
        private String timeSpan;
        private String mobileType;
        private String appType;
        private String username;
        private String password;

        public Login(String appKey, String timeSpan, String mobileType, String appType, String username, String password) {
            this.appKey = appKey;
            this.timeSpan = timeSpan;
            this.mobileType = mobileType;
            this.appType = appType;
            this.username = username;
            this.password = password;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }
}
