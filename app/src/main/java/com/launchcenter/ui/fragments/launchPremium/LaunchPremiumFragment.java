package com.launchcenter.ui.fragments.launchPremium;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.launchPremiumAdd.LaunchPremiumAddFragment;

public class LaunchPremiumFragment extends Fragment {

    private LaunchPremiumViewModel mViewModel;

    Button startServiceBtn;

    public static LaunchPremiumFragment newInstance() {
        return new LaunchPremiumFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        View view= inflater.inflate(R.layout.launch_premium_fragment, container, false);


        startServiceBtn=view.findViewById(R.id.startServiceBtn);
        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchPremiumAddFragment LPRegisterFragment= new LaunchPremiumAddFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, LPRegisterFragment, "LaunchPremiunRegisterFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });


        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LaunchPremiumViewModel.class);
        // TODO: Use the ViewModel
    }

}