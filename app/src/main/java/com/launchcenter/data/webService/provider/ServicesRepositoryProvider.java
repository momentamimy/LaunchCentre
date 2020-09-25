package com.launchcenter.data.webService.provider;

import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.data.webService.RetrofitInstance;
import com.launchcenter.data.webService.ServicesDataService;
import com.launchcenter.models.company.CompanyModel;
import com.launchcenter.models.ServiceModel;

import java.util.List;

import io.reactivex.Observable;

public class ServicesRepositoryProvider {
    public Observable<List<ServiceModel>> getAllServices() {
        ServicesDataService dataService = RetrofitInstance.getServicesData();
        return dataService.getAllServices();
    }

    public Observable<AccountResponse> getSubServices(int id) {
        ServicesDataService dataService = RetrofitInstance.getServicesData();
        return dataService.getSubServices(id);
    }

    public Observable<List<CompanyModel>> getSubscribedCompanies(int id) {
        ServicesDataService dataService = RetrofitInstance.getServicesData();
        return dataService.getSubscribedCompanies(id);
    }
}
