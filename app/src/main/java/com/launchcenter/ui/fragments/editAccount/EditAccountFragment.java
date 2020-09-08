package com.launchcenter.ui.fragments.editAccount;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.launchcenter.R;

public class EditAccountFragment extends Fragment {

    private EditAccountViewModel mViewModel;

    public static EditAccountFragment newInstance() {
        return new EditAccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        return inflater.inflate(R.layout.edit_account_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditAccountViewModel.class);
        // TODO: Use the ViewModel
    }

}