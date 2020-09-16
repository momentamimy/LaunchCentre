package com.launchcenter.ui.activities.login;

import android.util.Log;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.models.User;
import com.launchcenter.repository.RepositoryLogin;

public class LoginViewModel extends ViewModel {
    private RepositoryLogin repositoryLogin= new RepositoryLogin();

    public MutableLiveData<String> UserName = new MutableLiveData<>();
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
        user.setUsername(UserName.getValue());
        user.setPassword(Password.getValue());

        userMutableLiveData.setValue(user);


    }

    public MutableLiveData<AccountResponse.Value> LoginUser(User user){
        return repositoryLogin.login(user);
    }
}
