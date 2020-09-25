package com.launchcenter.ui.fragments.serviceProviders;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.models.ServiceModel;
import com.launchcenter.repository.RepositoryServices;

import java.util.List;

public class ServiceProvidersViewModel extends ViewModel {
    private MutableLiveData<ServiceModel> serviceModelMutableLiveData=new MutableLiveData<>();
    RepositoryServices repositoryServices= new RepositoryServices();
    public MutableLiveData<List<ServiceModel>> getSubServices(int id) {
        return repositoryServices.getSubServices(id);
    }
}