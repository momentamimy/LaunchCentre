package com.launchcenter.data.webService;


import com.launchcenter.data.webService.body.LoginBody;
import com.launchcenter.data.webService.body.SignUpBusinessBody;
import com.launchcenter.data.webService.body.SignUpClientBody;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/4/2018.
 */
public interface DataService {


    @POST("Account/ClientAccount?api")
    Observable<AccountResponse> signUpClientAccount(@Body SignUpClientBody signUpBody);

    @POST("Account/BusinessAccount?api")
    Observable<AccountResponse> signUpBusinessAccount(@Body SignUpBusinessBody signUpBody);

    @Headers({"Accept-Type: application/json",
            "Content-Type: application/json",
    })
    @POST("account/Login?api")
    Observable<AccountResponse> Login(@Body LoginBody loginBody);

    @Headers({"Accept-Type: application/json",
            "Content-Type: application/json",
    })
    @FormUrlEncoded
    @POST("account/Login?api")
    Observable<AccountResponse> Login(@Field("Email") String Email,
                                      @Field("Password") String Password);

}
