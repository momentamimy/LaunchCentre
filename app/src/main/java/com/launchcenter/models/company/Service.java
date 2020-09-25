package com.launchcenter.models.company;

import java.util.ArrayList;

public class Service {
    private float id;
    private String name;
    private String logo;
    private float parent;
    private String description;
    private String dateTime;
    ArrayList<Object> serviceCompanies = new ArrayList<Object>();
    private String bookServiceCompanies = null;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public float getParent() {
        return parent;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getBookServiceCompanies() {
        return bookServiceCompanies;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setParent(float parent) {
        this.parent = parent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setBookServiceCompanies(String bookServiceCompanies) {
        this.bookServiceCompanies = bookServiceCompanies;
    }
}
