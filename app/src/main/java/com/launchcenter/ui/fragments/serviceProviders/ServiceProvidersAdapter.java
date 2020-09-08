package com.launchcenter.ui.fragments.serviceProviders;

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
import com.launchcenter.ui.fragments.bookProvider.BookProviderFragment;
import com.launchcenter.ui.fragments.providerDetails.ProviderDetailsFragment;

import java.util.List;

public class ServiceProvidersAdapter extends RecyclerView.Adapter<ServiceProvidersAdapter.ViewHolder>
{
    // private List<DataItem> ItemList;
    private Context cnx;

    public ServiceProvidersAdapter(Context cnx)
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_providers_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ProviderDetailsFragment providerDetailsFragment= new ProviderDetailsFragment();
                ((FragmentActivity)cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, providerDetailsFragment,"ProviderDetailsFragment").addToBackStack(null).commit();
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView status_icon;

        ViewHolder(View itemView)
        {
            super(itemView);
            status_icon=itemView.findViewById(R.id.status_icon);
        }

    }

}
