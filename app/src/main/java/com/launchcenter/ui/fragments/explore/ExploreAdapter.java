package com.launchcenter.ui.fragments.explore;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.launchcenter.R;

import java.util.ArrayList;
import java.util.Random;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private static final String TAG = "StaggeredRecyclerViewAd";

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private Context mContext;

    private Random randomGenerator;
    private ArrayList<Integer> imageSizes;

    public ExploreAdapter(Context context, ArrayList<Integer> imageUrls) {
        mImageUrls = imageUrls;
        mContext = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        holder.image.requestLayout();
        holder.image.setMaxHeight(750);
               holder.image.setImageDrawable(mContext.getResources().getDrawable(mImageUrls.get(position)));





    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageview_widget);
        }
    }
}