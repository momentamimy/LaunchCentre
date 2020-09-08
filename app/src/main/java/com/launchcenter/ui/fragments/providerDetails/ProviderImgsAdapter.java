package com.launchcenter.ui.fragments.providerDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.myBooking.MyBookinsAdapter;

import java.util.List;

public class ProviderImgsAdapter extends RecyclerView.Adapter<ProviderImgsAdapter.ViewHolder>
{
    // private List<DataItem> ItemList;
    private Context cnx;

    public ProviderImgsAdapter(Context cnx)
    {
        this.cnx = cnx;
    }

    public void updateList(List mList)
    {
        //  this.ItemList = mList;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.provider_images_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent intent = new Intent(cnx, ProviderDetails.class);
                //  cnx.startActivity(intent);
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
