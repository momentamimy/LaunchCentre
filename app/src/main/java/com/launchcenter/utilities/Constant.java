package com.launchcenter.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.data.webService.RetrofitInstance;


public final class Constant {

    public static String BASE_URL = "http://102.46.127.76/";
    public static final String SHARED_PREFERENCE = "mSharedPreference";
    public static final String SHARED_PREFERENCE_LOGIN = "mSharedPreferenceLogin";
    public static final String SHARED_PREFERENCE_TOKEN = "TOKEN";
    public static final String SHARED_PREFERENCE_ROLE = "ROLE";
    public static final String IMAGE_BASE_URL = BASE_URL+"uploads/";

    public static void hideStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = activity.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }



}
