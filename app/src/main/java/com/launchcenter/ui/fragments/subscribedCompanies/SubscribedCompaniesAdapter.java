package com.launchcenter.ui.fragments.subscribedCompanies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.models.company.CompanyModel;
import com.launchcenter.ui.fragments.providerDetails.ProviderDetailsFragment;
import com.launchcenter.utilities.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SubscribedCompaniesAdapter extends RecyclerView.Adapter<SubscribedCompaniesAdapter.ViewHolder>
{
    private List<CompanyModel> itemList=new ArrayList<>();
    private Context cnx;

    public SubscribedCompaniesAdapter(Context cnx)
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscribed_companies_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {
        CompanyModel item=itemList.get(listPosition);

        holder.companyNameTv.setText(item.getCompany().getName());
        Picasso.with(cnx).load(Constant.IMAGE_BASE_URL+item.getCompany().getProfilePicture()).into(holder.companyImageView);

        holder.visitorsNumTV.setText(String.valueOf(item.getCompany().getVisitors()));
        holder.priceTV.setText(String.valueOf(item.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               ProviderDetailsFragment providerDetailsFragment= new ProviderDetailsFragment();
  //              ((FragmentActivity)cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, providerDetailsFragment,"ProviderDetailsFragment").addToBackStack(null).commit();
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView companyImageView;
        TextView companyNameTv;
        TextView visitorsNumTV;
        TextView priceTV;
        AppCompatRatingBar workerDetailsWorkerRate;
        Button bookingButton;

        ViewHolder(View itemView)
        {
            super(itemView);
            companyImageView = itemView.findViewById(R.id.Company_ImageView);
            companyNameTv = itemView.findViewById(R.id.CompanyNameTV);
            visitorsNumTV = itemView.findViewById(R.id.visitorsNumberTV);
            priceTV = itemView.findViewById(R.id.servicePriceTV);
            workerDetailsWorkerRate = itemView.findViewById(R.id.worker_details_worker_rate);
            bookingButton = itemView.findViewById(R.id.booking_button);
        }

    }

}
