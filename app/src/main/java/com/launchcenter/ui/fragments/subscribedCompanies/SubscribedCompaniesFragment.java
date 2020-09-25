package com.launchcenter.ui.fragments.subscribedCompanies;

import androidx.lifecycle.Observer;
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

import com.launchcenter.R;
import com.launchcenter.models.company.CompanyModel;
import com.launchcenter.ui.fragments.serviceProviders.ServiceProvidersAdapter;

import java.util.List;

public class SubscribedCompaniesFragment extends Fragment {

    private SubscribedCompaniesViewModel mViewModel;
    int subserviceId;
    RecyclerView companyRecycler;
    SubscribedCompaniesAdapter subscribedCompaniesAdapter;

    public SubscribedCompaniesFragment(int subserviceId) {
        this.subserviceId = subserviceId;
    }

    public static SubscribedCompaniesFragment newInstance(int id) {
        return new SubscribedCompaniesFragment(id);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.subscribed_companies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        companyRecycler=view.findViewById(R.id.Companies_Rcycler);
        subscribedCompaniesAdapter =new SubscribedCompaniesAdapter(getActivity());
        companyRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        companyRecycler.setAdapter(subscribedCompaniesAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SubscribedCompaniesViewModel.class);


        mViewModel.getSubscribedCompanies(subserviceId).observe(getActivity(), new Observer<List<CompanyModel>>() {
            @Override
            public void onChanged(List<CompanyModel> companyModels) {
                subscribedCompaniesAdapter.updateList(companyModels);
            }
        });

    }

}