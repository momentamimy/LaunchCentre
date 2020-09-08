package com.launchcenter.ui.fragments.phoneBook;

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
import com.launchcenter.ui.fragments.chatHistory.ChatHistoryAdapter;
import com.launchcenter.utilities.Constant;

public class PhoneBookFragment extends Fragment {

    private PhoneBookViewModel mViewModel;

    RecyclerView phone_book_rv;
    PhoneBookAdapter phoneBookAdapter;

    public static PhoneBookFragment newInstance() {
        return new PhoneBookFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        View view = inflater.inflate(R.layout.phone_book_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        phone_book_rv=view.findViewById(R.id.phone_book_rv);
        phoneBookAdapter =new PhoneBookAdapter(getActivity());
        phone_book_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        phone_book_rv.setAdapter(phoneBookAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PhoneBookViewModel.class);
        // TODO: Use the ViewModel
    }

}