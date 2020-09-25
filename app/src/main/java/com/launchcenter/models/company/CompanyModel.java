package com.launchcenter.models.company;

import java.util.ArrayList;

public class CompanyModel {
    private float id;
    private String companyId;
    Company company;
    private float serviceId;
    Service ServiceObject;
    private float price;
    private float availability;
    private String dateTime;
    private String comments = null;
    ArrayList<Object> rating = new ArrayList<Object>();


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Company getCompany() {
        return company;
    }

    public float getServiceId() {
        return serviceId;
    }

    public Service getService() {
        return ServiceObject;
    }

    public float getPrice() {
        return price;
    }

    public float getAvailability() {
        return availability;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getComments() {
        return comments;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompany(Company companyObject) {
        this.company = companyObject;
    }

    public void setServiceId(float serviceId) {
        this.serviceId = serviceId;
    }

    public void setService(Service serviceObject) {
        this.ServiceObject = serviceObject;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAvailability(float availability) {
        this.availability = availability;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

