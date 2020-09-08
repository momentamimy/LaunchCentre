package com.launchcenter.ui.fragments.phoneBook;

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
import com.launchcenter.ui.fragments.myBooking.MyBookinsAdapter;
import com.launchcenter.ui.fragments.onlinePayment.OnlinePaymentFragment;

import java.util.List;

public class PhoneBookAdapter extends RecyclerView.Adapter<PhoneBookAdapter.ViewHolder>
{
    // private List<DataItem> ItemList;
    private Context cnx;

    public PhoneBookAdapter(Context cnx)
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_book_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

