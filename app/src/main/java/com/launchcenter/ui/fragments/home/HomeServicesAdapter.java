package com.launchcenter.ui.fragments.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.models.ServiceModel;
import com.launchcenter.ui.fragments.serviceProviders.ServiceProvidersFragment;
import com.launchcenter.utilities.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeServicesAdapter extends RecyclerView.Adapter<HomeServicesAdapter.ViewHolder>
{
    private List<ServiceModel> itemList=new ArrayList<>();
    private Context cnx;

    public HomeServicesAdapter(Context cnx)
    {
        this.cnx = cnx;
    }

    public void updateList(List mList)
    {
        this.itemList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_service_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {
        ServiceModel item = itemList.get(listPosition);
        holder.serviceTV.setText(item.getName());
        Picasso.with(cnx).load(Constant.IMAGE_BASE_URL+item.getLogo()).into(holder.serviceImage);
        holder.itemView.setOnClickListener(view -> {
            ServiceProvidersFragment serviceFragment = new ServiceProvidersFragment();
            serviceFragment.setServiceModel(item);
        ((FragmentActivity)cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, serviceFragment,"ServiceFragment").addToBackStack(null).commit();
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView serviceTV;
        AppCompatImageView serviceImage;

        ViewHolder(View itemView)
        {
            super(itemView);
            serviceTV=itemView.findViewById(R.id.filmNameTV);
            serviceImage=itemView.findViewById(R.id.ProductsOfSubSubCategory_product_iv);
        }
    }
}
