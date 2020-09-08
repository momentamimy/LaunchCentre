package com.launchcenter.ui.activities.login;

import android.util.Log;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.models.User;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> UserName = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();
    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onLoginBtnClick(View view) {

        User user= new User();
        user.setUsername(UserName.getValue());
        user.setPassword(Password.getValue());

        userMutableLiveData.setValue(user);
    }

    public void LoginUser(){
    }
}
