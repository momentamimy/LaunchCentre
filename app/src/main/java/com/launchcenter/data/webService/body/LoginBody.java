package com.launchcenter.data.webService.body;

import com.google.gson.annotations.SerializedName;

public class LoginBody {
    public String Email;
    public String Password;

    public LoginBody(String email, String password) {
        Email = email;
        Password = password;
    }
}
