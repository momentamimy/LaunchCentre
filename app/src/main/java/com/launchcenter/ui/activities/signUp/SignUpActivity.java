package com.launchcenter.ui.activities.signUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.launchcenter.R;
import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.databinding.ActivitySignUpBinding;
import com.launchcenter.models.User;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.activities.main.MainActivity;

import java.io.File;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private SignUpViewModel signUpViewModel;
    private ActivitySignUpBinding signUpBinding;

    private ProgressDialog dialog;

    private boolean isBusinessAccount = false;

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
                } else if (TextUtils.isEmpty(Objects.requireNonNull(user).getPhone())) {
                    signUpBinding.phoneET.setError(getResources().getString(R.string.enterPhone));
                    signUpBinding.phoneET.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(user).getEmail())) {
                    signUpBinding.emailET.setError(getResources().getString(R.string.enterEmail));
                    signUpBinding.emailET.requestFocus();
                } else if (!user.isEmailValid()) {
                    signUpBinding.emailET.setError(getResources().getString(R.string.emailNotValid));
                    signUpBinding.emailET.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(user).getPassword())) {
                    signUpBinding.passwordET.setError(getResources().getString(R.string.enterpassword));
                    signUpBinding.passwordET.requestFocus();
                } else if (!user.isPasswordLengthGreaterThan6()) {
                    signUpBinding.passwordET.setError(getResources().getString(R.string.passwordTooShort));
                    signUpBinding.passwordET.requestFocus();
                } else if (!user.isPasswordEqualConfirm()) {
                    signUpBinding.confirmPasswordET.setError(getResources().getString(R.string.ConfirmPasswordNotEqual));
                    signUpBinding.confirmPasswordET.requestFocus();
                } else {
                    showProgressDialog(getResources().getString(R.string.Sign_up_progress));
                    if (!isBusinessAccount) {
                        signUpViewModel.SignUpUser().observe(SignUpActivity.this, value -> {
                            if (value.getSucess().equals("Account created successfully, check your mail for confirmation")) {
                                hideProgressDialog();
                                openAlertDialog();
                            } else {
                                hideProgressDialog();
                                Toast.makeText(getApplicationContext(), value.getSucess(), Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                        signUpViewModel.SignUpUserBusiness().observe(SignUpActivity.this, value -> {
                            if (value.getSucess().equals("Account created successfully, check your mail for confirmation")) {
                                hideProgressDialog();
                                openAlertDialog();
                            } else {
                                hideProgressDialog();
                                Toast.makeText(getApplicationContext(), value.getSucess(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }

            }
        });


        signUpBinding.signInTV.setOnClickListener(v -> openLoginActivity());

        signUpBinding.createAccountTV.setOnClickListener(v -> {
            if (isBusinessAccount) {
                changeToClient();
            } else {
                changeToBusiness();
            }
        });

    }

    private void changeToBusiness() {
        signUpBinding.createAccountAskTV.setText(getResources().getString(R.string.client_account));
        signUpBinding.outlinedTextField.setHint(getResources().getString(R.string.company_name));
        //signUpBinding.UplaodBusinessLayout.setVisibility(View.VISIBLE);
        isBusinessAccount = true;
    }

    private void changeToClient() {
        signUpBinding.createAccountAskTV.setText(getResources().getString(R.string.business_account));
        signUpBinding.outlinedTextField.setHint(getResources().getString(R.string.Name));
        //signUpBinding.UplaodBusinessLayout.setVisibility(View.GONE);
        isBusinessAccount = false;
    }

    private void openAlertDialog() {
        new AlertDialog.Builder(this)
                .setMessage(getResources().getString(R.string.AccountCreatedSuccessfully))

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        openLoginActivity();
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    public void openMainActivity() {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        SignUpActivity.this.startActivity(intent);
        ((Activity) SignUpActivity.this).finish();
    }

    public void openLoginActivity() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void showProgressDialog(String message) {
        dialog = new ProgressDialog(this);
        dialog.setMessage(message);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hideProgressDialog() {
        dialog.dismiss();
    }
}