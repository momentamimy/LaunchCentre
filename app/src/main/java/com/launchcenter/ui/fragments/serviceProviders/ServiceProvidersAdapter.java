package com.launchcenter.ui.fragments.serviceProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.models.ServiceModel;
import com.launchcenter.ui.fragments.providerDetails.ProviderDetailsFragment;
import com.launchcenter.ui.fragments.subscribedCompanies.SubscribedCompaniesFragment;
import com.launchcenter.utilities.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ServiceProvidersAdapter extends RecyclerView.Adapter<ServiceProvidersAdapter.ViewHolder>
{
    private List<ServiceModel> itemList=new ArrayList<>();
    private Context cnx;

    public ServiceProvidersAdapter(Context cnx)
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_providers_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {
        ServiceModel item=itemList.get(listPosition);
        holder.SubServiceName.setText(item.getName());
        Picasso.with(cnx).load(Constant.IMAGE_BASE_URL+item.getLogo()).into(holder.SubServiceCircleImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SubscribedCompaniesFragment subscribedCompaniesFragment= SubscribedCompaniesFragment.newInstance(item.getId());
                ((FragmentActivity)cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, subscribedCompaniesFragment,"SubscribedCompaniesFragment").addToBackStack(null).commit();
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView SubServiceName;
        CircleImageView SubServiceCircleImage;

        ViewHolder(View itemView)
        {
            super(itemView);
            SubServiceName=itemView.findViewById(R.id.SubServiceTV);
            SubServiceCircleImage=itemView.findViewById(R.id.SubServiceImageView);
        }

    }

}
