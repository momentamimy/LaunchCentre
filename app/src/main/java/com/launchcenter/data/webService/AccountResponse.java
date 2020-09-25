package com.launchcenter.data.webService;

import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import com.launchcenter.models.ServiceModel;

import java.util.List;

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
        private String role;

        private List<ServiceModel> data;

        public List<ServiceModel> getServiceModels() {
            return data;
        }

        public void setServiceModels(List<ServiceModel> serviceModels) {
            this.data = serviceModels;
        }

        public String getSucess() {
            return sucess;
        }

        public String getToken() {
            return token;
        }

        public String getRole() {
            return role;
        }

        public void setSucess(String sucess) {
            this.sucess = sucess;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}

