package com.launchcenter.ui.fragments.providerDetails;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.bookProvider.BookProviderFragment;

public class ProviderDetailsFragment extends Fragment {

    private ProviderDetailsViewModel mViewModel;

    RecyclerView providers_details_image_rv;
    ProviderImgsAdapter providerImgsAdapter;

    Button bookBtn;

    public static ProviderDetailsFragment newInstance() {
        return new ProviderDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.provider_details_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        providers_details_image_rv=view.findViewById(R.id.providers_details_image_rv);
        providerImgsAdapter =new ProviderImgsAdapter(getActivity());
        providers_details_image_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        providers_details_image_rv.setAdapter(providerImgsAdapter);

        bookBtn=view.findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookProviderFragment bookProviderFragment= new BookProviderFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, bookProviderFragment, "BookProviderFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProviderDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}