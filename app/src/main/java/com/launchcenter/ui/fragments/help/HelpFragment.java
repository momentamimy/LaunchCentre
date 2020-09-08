package com.launchcenter.ui.fragments.help;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.launchcenter.R;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.activities.main.MainActivity;

public class HelpFragment extends Fragment {

    private HelpViewModel mViewModel;

    Button helpSendBtn;
    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
       View view= inflater.inflate(R.layout.help_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        helpSendBtn=view.findViewById(R.id.helpSendBtn);
        helpSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

       return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HelpViewModel.class);
        // TODO: Use the ViewModel
    }

    public void openMainActivity(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        getActivity().startActivity(intent);
        ((Activity) getActivity()).finish();
    }

}