package com.shenkangyun.pregnantwomen.MainPage;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.shenkangyun.pregnantwomen.R;
import com.shenkangyun.pregnantwomen.UtilFolder.NetworkChangeReceiver;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver changeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.home_orange));
        intentFilter = new IntentFilter();
        changeReceiver = new NetworkChangeReceiver();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(changeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(changeReceiver);
        super.onDestroy();
    }

    @OnClick({R.id.cv_interactive, R.id.cv_knowledge, R.id.cv_axis, R.id.cv_record, R.id.cv_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_interactive:
                break;
            case R.id.cv_knowledge:
                break;
            case R.id.cv_axis:
                break;
            case R.id.cv_record:
                break;
            case R.id.cv_user:
                break;
        }
    }
}
