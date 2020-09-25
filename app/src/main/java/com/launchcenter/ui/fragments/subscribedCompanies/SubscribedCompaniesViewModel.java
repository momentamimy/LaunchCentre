package com.launchcenter.ui.fragments.subscribedCompanies;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.models.company.CompanyModel;
import com.launchcenter.repository.RepositoryServices;

import java.util.List;

public class SubscribedCompaniesViewModel extends ViewModel {

    private RepositoryServices repositoryServices= new RepositoryServices();
    public MutableLiveData<List<CompanyModel>> getSubscribedCompanies(int id) {
        return repositoryServices.getSubscribedCompanies(id);
    }
}