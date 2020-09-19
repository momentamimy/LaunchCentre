package com.launchcenter.ui.activities.signUp;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.models.User;
import com.launchcenter.repository.RepositoryLogin;

public class SignUpViewModel  extends ViewModel {

    private RepositoryLogin repositoryLogin= new RepositoryLogin();

    public MutableLiveData<String> Name = new MutableLiveData<>();
    public MutableLiveData<String> Phone = new MutableLiveData<>();
    public MutableLiveData<String> City = new MutableLiveData<>();
    public MutableLiveData<String> Email = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();
    public MutableLiveData<String> ConfirmPassword = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onSignUpnBtnClick(View view) {

        User user = new User();
        user.setUsername(Name.getValue());
        user.setPassword(Password.getValue());
        user.setEmail(Email.getValue());
        user.setPhone(Phone.getValue());
        user.setConfirmPassword(ConfirmPassword.getValue());

        userMutableLiveData.setValue(user);
    }

    public MutableLiveData<AccountResponse.Value> SignUpUser() {
        return repositoryLogin.signUp(getUser().getValue());
    }

    public MutableLiveData<AccountResponse.Value> SignUpUserBusiness() {
        return repositoryLogin.signUpBusiness(getUser().getValue());
    }

}
