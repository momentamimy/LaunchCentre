package com.launchcenter.ui.fragments.myBooking;

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
import com.launchcenter.ui.fragments.onlinePayment.OnlinePaymentFragment;
import com.launchcenter.ui.fragments.providerBookDetails.ProviderBookingDetailsFragment;
import com.launchcenter.ui.fragments.providerLiveService.ProviderLiveServiceFragment;

import java.util.List;

public class MyBookinsAdapter extends RecyclerView.Adapter<MyBookinsAdapter.ViewHolder>
{
    private Context cnx;

    public MyBookinsAdapter(Context cnx)
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_bookings_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition)
    {


        if(listPosition==0){
            holder.status_icon.setImageDrawable(cnx.getResources().getDrawable(R.drawable.green_check));
        }else if(listPosition==1){
            holder.status_icon.setImageDrawable(cnx.getResources().getDrawable(R.drawable.red_x_icon));
        }else if(listPosition==2){
            holder.status_icon.setImageDrawable(cnx.getResources().getDrawable(R.drawable.clock_2_icon));
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listPosition==0) {
                    OnlinePaymentFragment onlinePaymentFragment = new OnlinePaymentFragment();
                    ((FragmentActivity) cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, onlinePaymentFragment, "OnlinePaymentFragment").addToBackStack(null).commit();
                }else if(listPosition==1){
                    ProviderBookingDetailsFragment providerBookingDetailsFragment = new ProviderBookingDetailsFragment();
                    ((FragmentActivity) cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, providerBookingDetailsFragment, "ProviderBookingDetailsFragment").addToBackStack(null).commit();
                }else if(listPosition==2){
                    ProviderLiveServiceFragment providerLiveServiceFragment = new ProviderLiveServiceFragment();
                    ((FragmentActivity) cnx).getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, providerLiveServiceFragment, "ProviderLiveServiceFragment").addToBackStack(null).commit();
                }
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
