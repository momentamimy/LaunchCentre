package com.launchcenter.data.webService.body;

public class SignUpBusinessBody {
    private String Email;
    private String Name;
    private String PhoneNumber;
    private String Password;
    private String Documentation;
    private String Descraption;
    private String ConfirmPassword;
    private String City;

    public SignUpBusinessBody(String email, String name, String phoneNumber, String password, String documentation, String descraption, String confirmPassword, String city) {
        Email = email;
        Name = name;
        PhoneNumber = phoneNumber;
        Password = password;
        Documentation = documentation;
        Descraption = descraption;
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

    public String getDocumentation() {
        return Documentation;
    }

    public void setDocumentation(String documentation) {
        Documentation = documentation;
    }

    public String getDescraption() {
        return Descraption;
    }

    public void setDescraption(String descraption) {
        Descraption = descraption;
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
