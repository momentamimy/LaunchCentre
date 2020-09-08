package com.launchcenter.ui.fragments.premiumPosts;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.home.HomeServicesAdapter;
import com.launchcenter.utilities.Constant;

public class PremiumPostsFragment extends Fragment {

    private PremiumPostsViewModel mViewModel;
    RecyclerView premium_posts_rv;
    PremiumPostsAdapter premiumPostsAdapter;

    public static PremiumPostsFragment newInstance() {
        return new PremiumPostsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
       View view = inflater.inflate(R.layout.premium_posts_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        premium_posts_rv=view.findViewById(R.id.premium_posts_rv);
        premiumPostsAdapter =new PremiumPostsAdapter(getActivity());
        premium_posts_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        premium_posts_rv.setAdapter(premiumPostsAdapter);
     return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PremiumPostsViewModel.class);
        // TODO: Use the ViewModel
    }

}