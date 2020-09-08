package com.launchcenter.ui.fragments.home;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.launchcenter.R;
import com.launchcenter.utilities.Constant;

public class HomeFragment extends Fragment {

    private  View view;
    private HomeViewModel mViewModel;
    RecyclerView home_services_rv;
    HomeServicesAdapter homeServicesAdapter;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        view= inflater.inflate(R.layout.home_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        home_services_rv=view.findViewById(R.id.home_providers_rv);
        homeServicesAdapter =new HomeServicesAdapter(getActivity());
        home_services_rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        home_services_rv.setAdapter(homeServicesAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}