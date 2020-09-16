package com.launchcenter.data.webService.body;

public class SignUpClientBody {
    private String Email;
    private String Name;
    private String PhoneNumber;
    private String Password;
    private String ConfirmPassword;
    private String City;

    public SignUpClientBody(String email, String name, String phoneNumber, String password, String confirmPassword, String city) {
        Email = email;
        Name = name;
        PhoneNumber = phoneNumber;
        Password = password;
        ConfirmPassword = confirmPassword;
        City = city;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
