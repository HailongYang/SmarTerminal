package com.smarterminal.app.util;

import android.app.ActionBar;
import android.widget.Button;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.smarterminal.app.R;

/**
 * Created by GuMuFeng on 2014-8-3.
 */
public class UIUtil {
    public static Button getActionButton(Context context) {
        Button btn = new Button(context);
        btn.setBackgroundResource(R.drawable.action_button_background);
        btn.setTextColor(0xFFFFFF);

        return btn;
    }

    public static void customActionBar(ActionBar actionBar, View view, String title) {
        actionBar.setDisplayShowTitleEnabled(false);
        // 关闭actionbar左侧的home返回功能
        actionBar.setDisplayShowHomeEnabled(false);
        //启用自定义的view
        actionBar.setDisplayShowCustomEnabled(true);
        TextView titleText = (TextView) view.findViewById(R.id.titleText);
        titleText.setText("密码修改");
        actionBar.setCustomView(view);
    }

}
