package com.launchcenter.ui.activities.forgotPassword;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.launchcenter.models.ForgotPassModel;

public class ForgotPassViewModel  extends ViewModel {

    public MutableLiveData<String> Email = new MutableLiveData<>();


    private MutableLiveData<ForgotPassModel> forgotPassModelMutableLiveData;

    public MutableLiveData<ForgotPassModel> getData() {

        if (forgotPassModelMutableLiveData == null) {
            forgotPassModelMutableLiveData = new MutableLiveData<>();
        }
        return forgotPassModelMutableLiveData;

    }

    public void onUpdateBtnClick(View view) {

        ForgotPassModel forgotPassModel = new ForgotPassModel();
        forgotPassModel.setEmail(Email.getValue());

        forgotPassModelMutableLiveData.setValue(forgotPassModel);
    }

    public void forgotPass() {
    }

}
