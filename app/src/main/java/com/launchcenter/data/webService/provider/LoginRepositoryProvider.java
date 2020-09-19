package com.launchcenter.data.webService.provider;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.data.webService.DataService;
import com.launchcenter.data.webService.RetrofitInstance;
import com.launchcenter.data.webService.body.LoginBody;
import com.launchcenter.models.User;

import io.reactivex.Observable;

public class LoginRepositoryProvider {

    public Observable<AccountResponse> Login(User user) {
        DataService dataService = RetrofitInstance.getService();
        return dataService.Login(user.getEmail(), user.getPassword());
    }

    public Observable<AccountResponse> signUp(User user) {
        DataService dataService = RetrofitInstance.getService();
        return dataService.signUpClientAccount(user.getUsername(), user.getPhone(), user.getEmail(), user.getPassword(), user.getConfirmPassword());
    }

    public Observable<AccountResponse> signUpBusiness(User user) {
        DataService dataService = RetrofitInstance.getService();
        return dataService.signUpBusinessAccount(user.getUsername(), user.getPhone(), user.getEmail(), user.getPassword(), user.getConfirmPassword());
    }
}
