package com.launchcenter.ui.fragments.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.models.ServiceModel;
import com.launchcenter.repository.RepositoryServices;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private RepositoryServices repositoryServices = new RepositoryServices();

    public MutableLiveData<List<ServiceModel>> getAllServices() {
        return repositoryServices.getAllServices();
    }
}