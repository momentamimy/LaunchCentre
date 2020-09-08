package com.launchcenter.ui.fragments.premiumPosts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;
import com.launchcenter.ui.fragments.home.HomeServicesAdapter;

import java.util.List;

public class PremiumPostsAdapter extends RecyclerView.Adapter<PremiumPostsAdapter.ViewHolder>
{
    // private List<DataItem> ItemList;
    private Context cnx;

    public PremiumPostsAdapter(Context cnx)
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
        return 13;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_post_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int listPosition)
    {

        if(listPosition==0){
            holder.status_icon.setImageDrawable(cnx.getResources().getDrawable(R.drawable.green_check));
        }else if(listPosition==1){
            holder.status_icon.setImageDrawable(cnx.getResources().getDrawable(R.drawable.clock_2_icon));
        }


        holder.drop_down_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              holder.premium_posts_layout.setVisibility(View.GONE);
              holder.drop_down_layout.setVisibility(View.VISIBLE);
            }
        });




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent intent = new Intent(cnx, ProviderDetails.class);
                //  cnx.startActivity(intent);

                if(holder.drop_down_layout.getVisibility() == View.VISIBLE){
                    holder.premium_posts_layout.setVisibility(View.VISIBLE);
                    holder.drop_down_layout.setVisibility(View.GONE);
                }


            }
        });




    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView status_icon,drop_down_img;
        LinearLayout drop_down_layout,premium_posts_layout;

        ViewHolder(View itemView)
        {
            super(itemView);
            status_icon=itemView.findViewById(R.id.status_icon);
            drop_down_img=itemView.findViewById(R.id.drop_down_img);

            premium_posts_layout=itemView.findViewById(R.id.premium_posts_layout);
            drop_down_layout=itemView.findViewById(R.id.drop_down_layout);
        }
    }

}
