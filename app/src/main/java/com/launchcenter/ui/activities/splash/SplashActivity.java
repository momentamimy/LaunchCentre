package com.launchcenter.ui.activities.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.launchcenter.R;
import com.launchcenter.service.LoginSharedPreference;
import com.launchcenter.ui.activities.loginOrSignUp.LoginSignUpActivity;
import com.launchcenter.ui.activities.main.MainActivity;
import com.launchcenter.utilities.Constant;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Constant.hideStatusBar(this);
        init();
    }



    public void init() {
        new Handler().postDelayed(() -> {


            if(!LoginSharedPreference.isLogin()){
                Intent intent = new Intent(SplashActivity.this, LoginSignUpActivity.class);
                SplashActivity.this.startActivity(intent);
            }else{
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
            }
            SplashActivity.this.finish();

        }, SPLASH_DISPLAY_LENGTH);
    }





}