package com.launchcenter.data.webService;

import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;

public class AccountResponse {
    @SerializedName("value")
    private Value ValueObject;

    public Value getValue() {
        return ValueObject;
    }

    public void setValue(Value valueObject) {
        this.ValueObject = valueObject;
    }
    public class Value {
        private String sucess;
        private String token;

        public String getSucess() {
            return sucess;
        }

        public String getToken() {
            return token;
        }

        public void setSucess(String sucess) {
            this.sucess = sucess;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}

