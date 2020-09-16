package com.launchcenter.ui.activities.signUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.launchcenter.R;
import com.launchcenter.databinding.ActivitySignUpBinding;
import com.launchcenter.models.User;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.activities.main.MainActivity;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private SignUpViewModel signUpViewModel;
    private ActivitySignUpBinding signUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        signUpBinding = DataBindingUtil.setContentView(SignUpActivity.this, R.layout.activity_sign_up);
        signUpBinding.setLifecycleOwner(this);
        signUpBinding.setSignUpViewModel(signUpViewModel);

        signUpViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {


                if (TextUtils.isEmpty(Objects.requireNonNull(user).getUsername())) {
                    signUpBinding.nameET.setError(getResources().getString(R.string.enterUsername));
                    signUpBinding.nameET.requestFocus();
                }else if (TextUtils.isEmpty(Objects.requireNonNull(user).getPhone())) {
                    signUpBinding.phoneET.setError(getResources().getString(R.string.enterPhone));
                    signUpBinding.phoneET.requestFocus();
                }else if (TextUtils.isEmpty(Objects.requireNonNull(user).getEmail())) {
                    signUpBinding.emailET.setError(getResources().getString(R.string.enterEmail));
                    signUpBinding.emailET.requestFocus();
                }else if (!user.isEmailValid()) {
                    signUpBinding.emailET.setError(getResources().getString(R.string.emailNotValid));
                    signUpBinding.emailET.requestFocus();
                }else if (TextUtils.isEmpty(Objects.requireNonNull(user).getPassword())) {
                    signUpBinding.passwordET.setError(getResources().getString(R.string.enterpassword));
                    signUpBinding.passwordET.requestFocus();
                }else if (!user.isPasswordLengthGreaterThan6()) {
                    signUpBinding.passwordET.setError(getResources().getString(R.string.passwordTooShort));
                    signUpBinding.passwordET.requestFocus();
                } else {
                    // signUpViewModel.SignUpUser();
                    openMainActivity();
                }

            }
        });



        signUpBinding.signInTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });


    }


    public void openMainActivity(){
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        SignUpActivity.this.startActivity(intent);
        ((Activity) SignUpActivity.this).finish();
    }

    public void openLoginActivity(){
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}