package com.launchcenter.ui.fragments.bookProvider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.home.HomeFragment;
import com.launchcenter.ui.fragments.providerDetails.ProviderDetailsFragment;

public class BookProviderFragment extends Fragment {

    private BookViewModel mViewModel;
    Button sendRequestBtn,dialog_home,dialog_back;
    Dialog confirmDialog;


    public static BookProviderFragment newInstance() {
        return new BookProviderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }
        View view= inflater.inflate(R.layout.book_fragment, container, false);
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        getActivity().findViewById(R.id.newsFeedBtn).setVisibility(View.GONE);


        View dialogView = ((AppCompatActivity) getActivity()).getLayoutInflater().inflate(R.layout.booking_confirm_dialog, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setView(dialogView);
        alert.setCancelable(false);

        confirmDialog = alert.create();


        dialog_home=dialogView.findViewById(R.id.dialog_home);
        dialog_back=dialogView.findViewById(R.id.dialog_back);


        sendRequestBtn=view.findViewById(R.id.sendRequestBtn);
        sendRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog.show();
            }
        });


        dialog_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog.dismiss();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                    fm.popBackStack();
                }
                HomeFragment homeFragment= new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment,"HomeFragment").commit();
            }
        });

        dialog_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog.dismiss();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.popBackStack();
                    fm.popBackStack();
                ProviderDetailsFragment providerDetailsFragment= new ProviderDetailsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, providerDetailsFragment,"ProviderDetailsFragment").addToBackStack(null).commit();
            }
        });


        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        // TODO: Use the ViewModel
    }

}