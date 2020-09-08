package com.launchcenter.ui.fragments.providerBookDetails;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.launchcenter.R;

public class ProviderBookingDetailsFragment extends Fragment {

    private ProviderBookingDetailsViewModel mViewModel;

    public static ProviderBookingDetailsFragment newInstance() {
        return new ProviderBookingDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        return inflater.inflate(R.layout.provider_booking_details_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProviderBookingDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}