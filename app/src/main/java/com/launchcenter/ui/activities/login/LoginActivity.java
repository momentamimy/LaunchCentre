package com.launchcenter.ui.activities.login;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.launchcenter.R;
import com.launchcenter.databinding.ActivityLoginBinding;
import com.launchcenter.models.User;
import com.launchcenter.ui.activities.forgotPassword.ForgotPasswordActivity;
import com.launchcenter.ui.activities.main.MainActivity;
import com.launchcenter.ui.activities.signUp.SignUpActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginBinding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        loginBinding.setLifecycleOwner(this);
        loginBinding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {


                if (TextUtils.isEmpty(Objects.requireNonNull(user).getUsername())) {
                    loginBinding.usernameET.setError(getResources().getString(R.string.enterUsername));
                    loginBinding.usernameET.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(user).getPassword())) {
                    loginBinding.passwordET.setError(getResources().getString(R.string.enterpassword));
                    loginBinding.passwordET.requestFocus();
                }
                else {
                   // loginViewModel.LoginUser();
                    openMainActivity();
                }

            }
        });



        loginBinding.signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });

        loginBinding.forgotPassTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPassActivity();
            }
        });

    }


    public void openMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        LoginActivity.this.startActivity(intent);
        ((Activity) LoginActivity.this).finish();
    }

    public void openSignUpActivity(){
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
       startActivity(intent);
    }

    public void openForgotPassActivity(){
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }




}