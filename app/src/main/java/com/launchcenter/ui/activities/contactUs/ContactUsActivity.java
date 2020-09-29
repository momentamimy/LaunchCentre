package com.launchcenter.ui.activities.contactUs;

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
import android.widget.Toast;

import com.launchcenter.R;
import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.databinding.ActivityContactUsBinding;
import com.launchcenter.databinding.ActivityForgotPasswordBinding;
import com.launchcenter.models.ContactUsModel;
import com.launchcenter.ui.activities.forgotPassword.ForgotPassViewModel;
import com.launchcenter.ui.activities.forgotPassword.ForgotPasswordActivity;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.activities.main.MainActivity;
import com.launchcenter.ui.activities.signUp.SignUpActivity;

import java.util.Objects;

public class ContactUsActivity extends AppCompatActivity {

    private ContactUsViewModel contactUsViewModel;
    private ActivityContactUsBinding contactUsBinding;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        contactUsViewModel = ViewModelProviders.of(this).get(ContactUsViewModel.class);
        contactUsBinding = DataBindingUtil.setContentView(ContactUsActivity.this, R.layout.activity_contact_us);
        contactUsBinding.setLifecycleOwner(this);
        contactUsBinding.setContactUsViewModel(contactUsViewModel);


        contactUsViewModel.getData().observe(this, new Observer<ContactUsModel>() {
            @Override
            public void onChanged(ContactUsModel contactUsModel) {
                if (TextUtils.isEmpty(Objects.requireNonNull(contactUsModel).getName())) {
                    contactUsBinding.nameET.setError(getResources().getString(R.string.enterUsername));
                    contactUsBinding.nameET.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(contactUsModel).getEmail())) {
                    contactUsBinding.emailET.setError(getResources().getString(R.string.enterEmail));
                    contactUsBinding.emailET.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(contactUsModel).getMessage())) {
                    contactUsBinding.messageET.setError(getResources().getString(R.string.enterMessage));
                    contactUsBinding.messageET.requestFocus();
                } else {
                    showProgressDialog(getResources().getString(R.string.login_progress));
                    contactUsViewModel.contactUs().observe(ContactUsActivity.this, new Observer<AccountResponse.Value>() {
                        @Override
                        public void onChanged(AccountResponse.Value value) {
                            hideProgressDialog();
                            if (value.getSucess().equals("success")) {
                                openAlertDialog();
                            } else {
                                Toast.makeText(getApplicationContext(), value.getSucess(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    openMainActivity();
                }

            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(ContactUsActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ContactUsActivity.this.startActivity(intent);
        ((Activity) ContactUsActivity.this).finish();
    }

    private void openAlertDialog() {
        new AlertDialog.Builder(this)
                .setMessage(getResources().getString(R.string.PleaseCheckYourMail))

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        openLoginActivity();
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
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