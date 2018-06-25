package com.sears.android.dlm.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sears.android.dlm.Models.CarouselModel;
import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.MyViewHolder> {

    ArrayList<CarouselModel> d = new ArrayList<>();
    String TAG = "DLMERROR";

    public CarouselAdapter(ArrayList<CarouselModel> d) {
        this.d = d;
    }
    @Override
    public CarouselAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_view,parent,false);

        return new CarouselAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CarouselAdapter.MyViewHolder holder, int position) {
        Log.e(TAG, String.valueOf(d.get(0).getSampleImages().length));

        holder.carouselView.setPageCount((d.get(0).getSampleImages().length));
        holder.carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Log.e(TAG, String.valueOf(d.get(0).getSampleImages()[0]));
                //imageView.setImageResource(d.get(0).getSampleImages()[position]);
                //Picasso.get().load(d.get(0).getSampleImages()[position]).into(imageView);
                Glide.with(holder.carouselView).load(d.get(0).getSampleImages()[position]).into(imageView);
                //CarouselAdapter.this.notifyDataSetChanged();
            }
        });

        Log.e(TAG, "inn carousel");
    }



    @Override
    public int getItemCount() {

        return d.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       CarouselView carouselView;

        public MyViewHolder(View itemView) {
            super(itemView);
            carouselView = itemView.findViewById(R.id.carouselView);
            //carouselView.setImageListener(imageListener);

        }

        int[] sampleImages = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,};


        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Log.e("POPO", "JKJJK");
                imageView.setImageResource(sampleImages[position]);
            }
        };
    }
}
