package com.launchcenter.repository;

import androidx.lifecycle.MutableLiveData;

import com.launchcenter.data.webService.provider.ServicesRepositoryProvider;
import com.launchcenter.models.company.CompanyModel;
import com.launchcenter.models.ServiceModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RepositoryServices {
    private MutableLiveData<List<ServiceModel>> servicesLiveData = new MutableLiveData<>();
    private MutableLiveData<List<ServiceModel>> subServicesLiveData = new MutableLiveData<>();

    private MutableLiveData<List<CompanyModel>> companiesMutableLiveData = new MutableLiveData<>();

    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    ServicesRepositoryProvider repositoryProvider = new ServicesRepositoryProvider();

    public MutableLiveData<List<ServiceModel>> getAllServices(){

        compositeDisposable.add(repositoryProvider.getAllServices().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<List<ServiceModel>>() {
                    @Override
                    public void onNext(List<ServiceModel> serviceModels) {
                        servicesLiveData.postValue(serviceModels);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));

        return servicesLiveData;
    }

    public MutableLiveData<List<ServiceModel>> getSubServices(int id) {
        compositeDisposable.add(repositoryProvider.getSubServices(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(accountResponse -> accountResponse.getValue().getServiceModels())
                .subscribeWith(new DisposableObserver<List<ServiceModel>>() {
                    @Override
                    public void onNext(List<ServiceModel> serviceModels) {
                        subServicesLiveData.postValue(serviceModels);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
        return subServicesLiveData;
    }

    public MutableLiveData<List<CompanyModel>> getSubscribedCompanies(int id) {
        compositeDisposable.add(repositoryProvider.getSubscribedCompanies(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<CompanyModel>>() {
                    @Override
                    public void onNext(List<CompanyModel> serviceModels) {
                        companiesMutableLiveData.postValue(serviceModels);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
        return companiesMutableLiveData;
    }
}
