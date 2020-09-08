package com.launchcenter.ui.fragments.providerLiveService;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.launchcenter.R;

public class ProviderLiveServiceFragment extends Fragment {

    private ProviderLiveViewModel mViewModel;

    public static ProviderLiveServiceFragment newInstance() {
        return new ProviderLiveServiceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        return inflater.inflate(R.layout.provider_live_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProviderLiveViewModel.class);
        // TODO: Use the ViewModel
    }

}