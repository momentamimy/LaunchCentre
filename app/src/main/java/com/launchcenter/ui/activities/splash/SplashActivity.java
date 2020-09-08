package com.launchcenter.ui.activities.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.launchcenter.R;
import com.launchcenter.ui.activities.loginOrSignUp.LoginSignUpActivity;
import com.launchcenter.ui.activities.main.MainActivity;
import com.launchcenter.utilities.Constant;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Constant.hideStatusBar(this);
        init();
    }



    public void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences mSharedPreferences = getSharedPreferences(Constant.SHARED_PREFERENCE, MODE_PRIVATE);

                if(mSharedPreferences.getString(Constant.TOKEN,"").equals("")){
                    Intent intent = new Intent(SplashActivity.this, LoginSignUpActivity.class);
                    SplashActivity.this.startActivity(intent);
                }else{
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(intent);
                }
                SplashActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }





}