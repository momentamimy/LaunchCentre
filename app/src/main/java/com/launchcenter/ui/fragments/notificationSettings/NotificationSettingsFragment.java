package com.launchcenter.ui.fragments.notificationSettings;

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

public class NotificationSettingsFragment extends Fragment {

    private NotificationSettingsViewModel mViewModel;

    SwitchCompat notificationSwitch, vibrateSwitch, incomingCallsSwitch;

    public static NotificationSettingsFragment newInstance() {
        return new NotificationSettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view= inflater.inflate(R.layout.notification_settings_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        notificationSwitch=view.findViewById(R.id.notificationSwitch);
        vibrateSwitch=view.findViewById(R.id.vibrateSwitch);
        incomingCallsSwitch=view.findViewById(R.id.incomingCallsSwitch);

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    notificationSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    notificationSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    notificationSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    notificationSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));

                }
            }
        });


        vibrateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    vibrateSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    vibrateSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    vibrateSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    vibrateSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));

                }
            }
        });



        incomingCallsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    incomingCallsSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    incomingCallsSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    incomingCallsSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    incomingCallsSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));

                }
            }
        });

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NotificationSettingsViewModel.class);
        // TODO: Use the ViewModel
    }

}