package com.launchcenter.data.webService.provider;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.data.webService.DataService;
import com.launchcenter.data.webService.RetrofitInstance;
import com.launchcenter.data.webService.body.LoginBody;

import io.reactivex.Observable;

public class LoginRepositoryProvider {

    public Observable<AccountResponse> Login(LoginBody loginBody){
        DataService dataService = RetrofitInstance.getService();
        return dataService.Login(loginBody);
    }
}
