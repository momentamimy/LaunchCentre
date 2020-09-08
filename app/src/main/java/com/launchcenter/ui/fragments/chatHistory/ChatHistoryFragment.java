package com.launchcenter.ui.fragments.chatHistory;

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
import android.widget.ImageView;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.phoneBook.PhoneBookFragment;
import com.launchcenter.utilities.Constant;

public class ChatHistoryFragment extends Fragment {

    private ChatHistoryViewModel mViewModel;

    RecyclerView chat_history_rv;
    ChatHistoryAdapter chatHistoryAdapter;

    ImageView phoneBookBtn;

    public static ChatHistoryFragment newInstance() {
        return new ChatHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.chat_history_fragment, container, false);

       getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);

        chat_history_rv=view.findViewById(R.id.chat_history_rv);
        chatHistoryAdapter =new ChatHistoryAdapter(getActivity());
        chat_history_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        chat_history_rv.setAdapter(chatHistoryAdapter);


        phoneBookBtn=view.findViewById(R.id.phoneBookBtn);
        phoneBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneBookFragment phoneBookFragment= new PhoneBookFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, phoneBookFragment, "PhoneBookFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChatHistoryViewModel.class);
        // TODO: Use the ViewModel
    }

}