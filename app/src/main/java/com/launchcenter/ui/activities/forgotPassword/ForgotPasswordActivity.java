package com.launchcenter.ui.activities.forgotPassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.launchcenter.R;
import com.launchcenter.databinding.ActivityForgotPasswordBinding;
import com.launchcenter.databinding.ActivityLoginBinding;
import com.launchcenter.models.ForgotPassModel;
import com.launchcenter.models.User;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.activities.login.LoginViewModel;
import com.launchcenter.ui.activities.main.MainActivity;

import java.util.Objects;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ForgotPassViewModel forgotViewModel;
    private ActivityForgotPasswordBinding forgotPassBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotViewModel = ViewModelProviders.of(this).get(ForgotPassViewModel.class);
        forgotPassBinding = DataBindingUtil.setContentView(ForgotPasswordActivity.this, R.layout.activity_forgot_password);
        forgotPassBinding.setLifecycleOwner(this);
        forgotPassBinding.setForgotPassViewModel(forgotViewModel);

        forgotViewModel.getData().observe(this, new Observer<ForgotPassModel>() {
            @Override
            public void onChanged(ForgotPassModel forgotPassModel) {
                if (TextUtils.isEmpty(Objects.requireNonNull(forgotPassModel).getEmail())) {
                    forgotPassBinding.emailET.setError(getResources().getString(R.string.enterEmail));
                    forgotPassBinding.emailET.requestFocus();
                }
                else {
                    openMainActivity();
                }


            }
        });
    }

    public void openMainActivity(){
        Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ForgotPasswordActivity.this.startActivity(intent);
        ((Activity) ForgotPasswordActivity.this).finish();
    }
}