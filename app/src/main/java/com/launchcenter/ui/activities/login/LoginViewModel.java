package com.launchcenter.ui.activities.login;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.models.User;
import com.launchcenter.repository.RepositoryLogin;
import com.launchcenter.service.LoginSharedPreference;

public class LoginViewModel extends ViewModel {
    private RepositoryLogin repositoryLogin= new RepositoryLogin();

    public MutableLiveData<String> Email = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();
    private MutableLiveData<User> userMutableLiveData;

    private MutableLiveData<AccountResponse.Value> loginSuccessMutableLiveData;

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onLoginBtnClick(View view) {

        User user= new User();
        user.setEmail(Email.getValue());
        user.setPassword(Password.getValue());

        userMutableLiveData.setValue(user);


    }

    public MutableLiveData<AccountResponse.Value> LoginUser(){
        return repositoryLogin.login(getUser().getValue());
    }

    public void saveLoginData(AccountResponse.Value value) {
        LoginSharedPreference.saveLoginValue(value);
    }
}
