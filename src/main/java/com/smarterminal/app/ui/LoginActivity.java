package com.smarterminal.app.ui;

import com.smarterminal.app.MainActivity;
import com.smarterminal.app.util.SystemUiHider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.smarterminal.app.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class LoginActivity extends Activity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        final EditText userNameInput = (EditText) findViewById(R.id.userNameInput);
        final EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
        final CheckBox rememberUserNameCheckBox = (CheckBox) findViewById(R.id.rememberNameCheckBox);
        final CheckBox rememberPasswordCheckBox = (CheckBox) findViewById(R.id.rememberPasswordCheckBox);

        preferences = getSharedPreferences("app.config", Context.MODE_PRIVATE);
        editor = preferences.edit();

        if(preferences.getString("loginUserName", null) != null) {
            userNameInput.setText(preferences.getString("loginUserName", null));
        }

        if(preferences.getString("loginPassword", null) != null) {
            passwordInput.setText(preferences.getString("loginPassword", null));
        }
        rememberUserNameCheckBox.setChecked(preferences.getBoolean("rememberUserName", false));
        rememberPasswordCheckBox.setChecked(preferences.getBoolean("rememPassword", false));

        rememberUserNameCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
                editor.putBoolean("rememberUserName", value);
                editor.commit();
            }
        });

        rememberPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
                editor.putBoolean("rememPassword", value);
                editor.commit();
            }
        });

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if("admin".equals(userName) && "admin".equals(password)) {
                    if(rememberUserNameCheckBox.isChecked()) {
                        editor.putString("loginUserName", userName);
                        editor.commit();
                    }
                    else {
                        editor.remove("loginUserName");
                    }

                    if(rememberPasswordCheckBox.isChecked()) {
                        editor.putString("loginPassword", userName);
                        editor.commit();
                    }
                    else {
                        editor.remove("loginPassword");
                    }

                    startActivity(new Intent(LoginActivity.this, PortalActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, R.string.login_error_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
