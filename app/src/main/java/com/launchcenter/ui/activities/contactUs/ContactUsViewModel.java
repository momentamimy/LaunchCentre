package com.launchcenter.ui.activities.contactUs;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.launchcenter.models.ContactUsModel;
import com.launchcenter.models.ForgotPassModel;

public class ContactUsViewModel extends ViewModel {

    public MutableLiveData<String> Name = new MutableLiveData<>();
    public MutableLiveData<String> Email = new MutableLiveData<>();
    public MutableLiveData<String> Message = new MutableLiveData<>();

    private MutableLiveData<ContactUsModel> contactUsModelMutableLiveData;

    public MutableLiveData<ContactUsModel> getData() {

        if (contactUsModelMutableLiveData == null) {
            contactUsModelMutableLiveData = new MutableLiveData<>();
        }
        return contactUsModelMutableLiveData;

    }

    public void onSendBtnClick(View view) {

        ContactUsModel contactUsModel = new ContactUsModel();
        contactUsModel.setName(Name.getValue());
        contactUsModel.setEmail(Email.getValue());
        contactUsModel.setMessage(Message.getValue());

        contactUsModelMutableLiveData.setValue(contactUsModel);
    }

    public void contactUs() {
    }

}
