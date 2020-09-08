package com.launchcenter.ui.fragments.explore;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.launchcenter.R;

import java.util.ArrayList;

public class ExploreFragment extends Fragment {

    private ExploreViewModel mViewModel;
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();


    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        View view= inflater.inflate(R.layout.explore_fragment, container, false);


        mImageUrls.add(R.drawable.explore_1);
        mImageUrls.add(R.drawable.explore_2);
        mImageUrls.add(R.drawable.explore_3);
        mImageUrls.add(R.drawable.explore_4);
        mImageUrls.add(R.drawable.explore_5);

        mImageUrls.add(R.drawable.explore_2);
        mImageUrls.add(R.drawable.explore_1);
        mImageUrls.add(R.drawable.explore_4);
        mImageUrls.add(R.drawable.explore_3);
        mImageUrls.add(R.drawable.explore_5);


        mImageUrls.add(R.drawable.explore_3);
        mImageUrls.add(R.drawable.explore_1);
        mImageUrls.add(R.drawable.explore_2);
        mImageUrls.add(R.drawable.explore_2);
        mImageUrls.add(R.drawable.explore_4);
        mImageUrls.add(R.drawable.explore_5);



        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        ExploreAdapter exploreAdapter =
                new ExploreAdapter(getActivity(), mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(exploreAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ExploreViewModel.class);
        // TODO: Use the ViewModel
    }

}