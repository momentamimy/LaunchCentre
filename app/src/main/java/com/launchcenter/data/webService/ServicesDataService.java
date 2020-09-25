package com.launchcenter.data.webService;


import com.launchcenter.models.company.CompanyModel;
import com.launchcenter.models.ServiceModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/4/2018.
 */
public interface ServicesDataService {

    @GET("Service/Services?api")
    Observable<List<ServiceModel>> getAllServices();

    @GET("Service/SubServices?api")
    Observable<AccountResponse> getSubServices(@Query(value = "Id") int serviceId);

    /*@GET("Company/ClientProfile?api")
    Observable<ServiceInfo> getClientProfile();
*/
    @GET("Company/Index?api")
    Observable<List<CompanyModel>> getSubscribedCompanies(@Query("Id")int subserviceId);

    @GET("Company/ServiceProvider/{companyId}?api")
    Observable<CompanyModel> getCompanyInfo(@Path("companyId") int subserviceId);
}
