package com.smarterminal.app.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;

import com.smarterminal.app.R;
import com.smarterminal.app.util.UIUtil;

public class AppSettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewGroup actionBarView = (ViewGroup) inflateView(R.layout.custome_action_bar);
        UIUtil.customActionBar(getActionBar(), actionBarView, "密码修改");
        setContentView(R.layout.activity_app_setting);
    }

    private View inflateView(int id) {
        return LayoutInflater.from(AppSettingActivity.this).inflate(id, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}
