package com.launchcenter.ui.fragments.myBooking;

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

public class MyBookingsFragment extends Fragment {


    private MyBookingsViewModel mViewModel;
    RecyclerView my_bookings_rv;
    MyBookinsAdapter myBookinsAdapter;




    public static MyBookingsFragment newInstance() {
        return new MyBookingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        View view= inflater.inflate(R.layout.my_bookings_fragment, container, false);

        my_bookings_rv=view.findViewById(R.id.my_bookings_rv);
        myBookinsAdapter =new MyBookinsAdapter(getActivity());
        my_bookings_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_bookings_rv.setAdapter(myBookinsAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyBookingsViewModel.class);
        // TODO: Use the ViewModel
    }

}