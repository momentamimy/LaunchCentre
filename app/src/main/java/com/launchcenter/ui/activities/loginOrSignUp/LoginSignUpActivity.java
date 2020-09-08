package com.launchcenter.ui.activities.loginOrSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.launchcenter.R;
import com.launchcenter.ui.activities.contactUs.ContactUsActivity;
import com.launchcenter.ui.activities.forgotPassword.ForgotPasswordActivity;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.activities.signUp.SignUpActivity;

public class LoginSignUpActivity extends AppCompatActivity implements View.OnClickListener{

    Button loginBtn, signUpBtn;
    TextView forgotPass, contactUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);

        loginBtn=findViewById(R.id.loginBtn);
        signUpBtn=findViewById(R.id.signUpBtn);
        forgotPass=findViewById(R.id.forgotPass);
        contactUs=findViewById(R.id.contactUs);

        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
        forgotPass.setOnClickListener(this);
        contactUs.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.loginBtn:
                openNextActivity(LoginActivity.class);
                break;

            case R.id.signUpBtn:
                openNextActivity(SignUpActivity.class);
                break;

            case R.id.forgotPass:
                openNextActivity(ForgotPasswordActivity.class);
                break;

            case R.id.contactUs:
                openNextActivity(ContactUsActivity.class);
                break;

            default:
                break;
        }
    }

    public void openNextActivity( Class<?> activity){
        Intent intent=new Intent(LoginSignUpActivity.this, activity);
        startActivity(intent);
    }

}