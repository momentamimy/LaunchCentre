package com.launchcenter.ui.fragments.chat;

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

public class ChatFragment extends Fragment {

    private ChatViewModel mViewModel;

    RecyclerView chat_rv;
    ChatAdapter chatAdapter;

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
       View view = inflater.inflate(R.layout.chat_fragment, container, false);


        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.GONE);
        chat_rv=view.findViewById(R.id.chat_rv);
        chatAdapter =new ChatAdapter(getActivity());
        chat_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        chat_rv.setAdapter(chatAdapter);
        chat_rv.scrollToPosition(9);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChatViewModel.class);
        // TODO: Use the ViewModel
    }

}