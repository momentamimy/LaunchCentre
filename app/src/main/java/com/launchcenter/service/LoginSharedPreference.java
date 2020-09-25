package com.launchcenter.service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.launchcenter.MyApplication;
import com.launchcenter.data.webService.AccountResponse;
import com.launchcenter.utilities.Constant;

public class LoginSharedPreference {

    public static void saveLoginValue(AccountResponse.Value value) {
        SharedPreferences pref = MyApplication.getAppContext().getSharedPreferences(Constant.SHARED_PREFERENCE_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constant.SHARED_PREFERENCE_TOKEN,value.getToken());
        editor.putString(Constant.SHARED_PREFERENCE_ROLE,value.getRole());
        editor.apply();
    }
    public static boolean isLogin(){
        SharedPreferences pref = MyApplication.getAppContext().getSharedPreferences(Constant.SHARED_PREFERENCE_LOGIN, Context.MODE_PRIVATE);

        if(pref.getString(Constant.SHARED_PREFERENCE_TOKEN,"").equals("")){
            return false;
        }
        else {
            return true;
        }
    }
}
