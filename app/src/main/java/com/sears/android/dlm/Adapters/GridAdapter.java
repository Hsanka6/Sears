package com.sears.android.dlm.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sears.android.dlm.Models.GridModel;
import com.sears.android.dlm.R;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyHolder>{

     Context context;

     String[] strs;
     int[] arr;

    public GridAdapter(String[]  strings, int[] ints) {
       this.strs = strings;
       this.arr = ints;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_card,null);
        MyHolder myHolder = new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        Log.e("HELLO", "POPOPOP11");
//        for(int i = 0; i< 5;i++)
//        {
//            Log.e("HELLO", "POPOPOP");
            holder.imageView.setImageResource(arr[position]);
            holder.textView.setText(strs[position]);
       // }
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
       public MyHolder(View itemView) {
            super(itemView);

            imageView =  itemView.findViewById(R.id.ivGrid);
            textView =  itemView.findViewById(R.id.tvGrid);

        }
    }
}
