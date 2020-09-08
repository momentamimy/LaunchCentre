package com.launchcenter.ui.fragments.settings;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.launchcenter.R;
import com.launchcenter.ui.activities.main.MainActivity;
import com.launchcenter.ui.fragments.about.AboutFragment;
import com.launchcenter.ui.fragments.editAccount.EditAccountFragment;
import com.launchcenter.ui.fragments.help.HelpFragment;
import com.launchcenter.ui.fragments.launchPremium.LaunchPremiumFragment;
import com.launchcenter.ui.fragments.newsfeed.NewsFeedFragment;
import com.launchcenter.ui.fragments.notificationSettings.NotificationSettingsFragment;
import com.launchcenter.ui.fragments.payments.PaymentsFragment;
import com.launchcenter.ui.fragments.premiumPosts.PremiumPostsFragment;
import com.launchcenter.ui.fragments.previewSettings.PreviewSettingsFragment;
import com.launchcenter.ui.fragments.profile.ProfileFragment;
import com.launchcenter.ui.fragments.report.ReportFragment;
import com.launchcenter.ui.fragments.securitySettings.SecuritySettingsFragment;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private SettingsViewModel mViewModel;
    TextView accountTV, profileTV, notificationsTV, previewTV, securityTV, aboutTv;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);


        accountTV=view.findViewById(R.id.accountTV);
        profileTV=view.findViewById(R.id.profileTV);
        notificationsTV=view.findViewById(R.id.notificationsTV);
        previewTV=view.findViewById(R.id.previewTV);
        securityTV=view.findViewById(R.id.securityTV);
        aboutTv=view.findViewById(R.id.aboutTv);


        accountTV.setOnClickListener(this);
        profileTV.setOnClickListener(this);
        notificationsTV.setOnClickListener(this);
        previewTV.setOnClickListener(this);
        securityTV.setOnClickListener(this);
        aboutTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;

        switch (v.getId()) {
            case R.id.accountTV:
                fragment = new EditAccountFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, "EditAccountFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.profileTV:
                fragment = new ProfileFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, "ProfileFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.notificationsTV:
                fragment = new NotificationSettingsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, "NotificationSettingsFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.previewTV:
                fragment = new PreviewSettingsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, "PreviewSettingsFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.securityTV:
                fragment = new SecuritySettingsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, "SecuritySettingsFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.aboutTv:
                fragment = new AboutFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, "AboutFragment")
                        .addToBackStack(null)
                        .commit();
                break;


            default:
                break;
        }

    }

}