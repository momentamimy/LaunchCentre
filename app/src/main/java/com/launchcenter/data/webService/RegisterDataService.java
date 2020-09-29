package com.launchcenter.data.webService;


import com.launchcenter.data.webService.body.LoginBody;
import com.launchcenter.data.webService.body.SignUpBusinessBody;
import com.launchcenter.data.webService.body.SignUpClientBody;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/4/2018.
 */
public interface RegisterDataService {

    @FormUrlEncoded
    @POST("Account/ClientAccount?api")
    Observable<AccountResponse> signUpClientAccount(@Field(value = "Name") String Name,
                                                    @Field(value = "PhoneNumber") String PhoneNumber,
                                                    @Field(value = "Email") String Email,
                                                    @Field(value = "Password") String Password,
                                                    @Field(value = "ConfirmPassword") String ConfirmPassword);

    @FormUrlEncoded
    @POST("Account/BusinessAccount?api")
    Observable<AccountResponse> signUpBusinessAccount(@Field(value = "CompanyName") String CompanyName,
                                                      @Field(value = "PhoneNumber") String PhoneNumber,
                                                      @Field(value = "Email") String Email,
                                                      @Field(value = "Password") String Password,
                                                      @Field(value = "ConfirmPassword") String ConfirmPassword);

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
    })
    @POST("account/Login?api")
    Observable<AccountResponse> Login(@Body LoginBody loginBody);


    @FormUrlEncoded
    @POST("account/Login?api")
    Observable<AccountResponse> Login(@Field(value = "Email") String Email,
                                      @Field(value = "Password") String Password);

    @FormUrlEncoded
    @POST("Home/ContactUs?api")
    Observable<AccountResponse> ContactUs(@Field(value = "Name") String Name,
                                          @Field(value = "Email") String Email,
                                          @Field(value = "Notes") String Notes);
}
