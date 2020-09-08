package com.launchcenter.ui.fragments.newsfeed;

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
import com.launchcenter.ui.fragments.premiumPosts.PremiumPostsAdapter;
import com.launchcenter.ui.fragments.premiumPosts.PremiumPostsViewModel;
import com.launchcenter.utilities.Constant;

public class NewsFeedFragment extends Fragment {

    private NewsFeedViewModel mViewModel;
    RecyclerView news_feed_rv;
    NewsFeedAdapter newsFeedAdapter;

    public static NewsFeedFragment newInstance() {
        return new NewsFeedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.news_feed_fragment, container, false);
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        news_feed_rv=view.findViewById(R.id.news_feed_rv);
        newsFeedAdapter =new NewsFeedAdapter(getActivity());
        news_feed_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        news_feed_rv.setAdapter(newsFeedAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewsFeedViewModel.class);
        // TODO: Use the ViewModel
    }

}