package com.launchcenter.ui.fragments.chatHistory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.chat.ChatFragment;
import com.launchcenter.ui.fragments.myBooking.MyBookinsAdapter;
import com.launchcenter.ui.fragments.providerDetails.ProviderDetailsFragment;

import java.util.List;

public class ChatHistoryAdapter  extends RecyclerView.Adapter<ChatHistoryAdapter.ViewHolder>
{
    // private List<DataItem> ItemList;
    private Context cnx;

    public ChatHistoryAdapter(Context cnx)
    {
        this.cnx = cnx;
    }

    public void updateList(List mList)
    {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {
        return 10;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_history_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatFragment chatFragment= new ChatFragment();
                ((FragmentActivity)cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, chatFragment,"ChatFragment").addToBackStack(null).commit();
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        ViewHolder(View itemView)
        {
            super(itemView);
        }

    }

}
