package com.launchcenter.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.data.webService.body.LoginBody;
import com.launchcenter.data.webService.provider.LoginRepositoryProvider;
import com.launchcenter.models.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RepositoryLogin {
    MutableLiveData<AccountResponse.Value> valueLoginMutableLiveData = new MutableLiveData<>();

    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    LoginRepositoryProvider repositoryProvider = new LoginRepositoryProvider();

    public MutableLiveData<AccountResponse.Value> login(User user) {
        LoginBody loginBody = new LoginBody("tamimy@gmail.com", "123456m");
        compositeDisposable.add(repositoryProvider.Login(loginBody).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<AccountResponse>() {
                    @Override
                    public void onNext(AccountResponse accountResponse) {
                        Log.d("LALALALALALALALALAL","ne "+accountResponse.getValue().getSucess());
                        valueLoginMutableLiveData.postValue(accountResponse.getValue());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LALALALALALALALALAL","er "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("LALALALALALALALALAL","comp: "+"complete");
                    }
                }));
        return valueLoginMutableLiveData;
    }

}
