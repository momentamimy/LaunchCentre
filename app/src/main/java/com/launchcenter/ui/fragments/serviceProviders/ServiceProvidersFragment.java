package com.launchcenter.ui.fragments.serviceProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.addService.AddServiceFragment;

public class ServiceProvidersFragment extends Fragment {

    private ServiceProvidersViewModel mViewModel;
    RecyclerView service_providers_rv;
    ServiceProvidersAdapter serviceProvidersAdapter;

    ImageView add_service_btn;

    public static ServiceProvidersFragment newInstance() {
        return new ServiceProvidersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.service_providers_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        getActivity().findViewById(R.id.newsFeedBtn).setVisibility(View.GONE);
        service_providers_rv=view.findViewById(R.id.service_providers_rv);
        serviceProvidersAdapter =new ServiceProvidersAdapter(getActivity());
        service_providers_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        service_providers_rv.setAdapter(serviceProvidersAdapter);


        add_service_btn=view.findViewById(R.id.add_service_btn);
        add_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddServiceFragment addServiceFragment= new AddServiceFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, addServiceFragment, "AddServiceFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}