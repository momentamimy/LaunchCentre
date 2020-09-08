package com.launchcenter.ui.fragments.securitySettings;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.launchcenter.R;

public class SecuritySettingsFragment extends Fragment {

    private SecuritySettingsViewModel mViewModel;

    SwitchCompat cameraSwitch, mapsSwitch, cookiesSwitch;

    public static SecuritySettingsFragment newInstance() {
        return new SecuritySettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        View view = inflater.inflate(R.layout.security_settings_fragment, container, false);

        cameraSwitch=view.findViewById(R.id.cameraSwitch);
        mapsSwitch=view.findViewById(R.id.mapsSwitch);
        cookiesSwitch=view.findViewById(R.id.cookiesSwitch);

        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cameraSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    cameraSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    cameraSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    cameraSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));

                }
            }
        });


        mapsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mapsSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    mapsSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    mapsSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    mapsSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));

                }
            }
        });


        cookiesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cookiesSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    cookiesSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    cookiesSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    cookiesSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));

                }
            }
        });





        return view ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SecuritySettingsViewModel.class);
        // TODO: Use the ViewModel
    }

}