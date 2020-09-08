package com.launchcenter.ui.fragments.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.serviceProviders.ServiceProvidersFragment;

import java.util.List;

public class HomeServicesAdapter extends RecyclerView.Adapter<HomeServicesAdapter.ViewHolder>
{
   // private List<DataItem> ItemList;
    private Context cnx;

    public HomeServicesAdapter(Context cnx)
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_service_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceProvidersFragment serviceFragment = new ServiceProvidersFragment();
            ((FragmentActivity)cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, serviceFragment,"ServiceFragment").addToBackStack(null).commit();
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
