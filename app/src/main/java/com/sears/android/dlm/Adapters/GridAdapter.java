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
import com.sears.android.dlmlibrary.DlmDepartmentView;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyHolder>{

     Context context;

     String[] strs;
     String[] arr;

    public GridAdapter(String[]  strings, String[] imgs) {
       this.strs = strings;
       this.arr = imgs;
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
            holder.dep.setImageString(arr[position]);
            holder.dep.setProductText(strs[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
       DlmDepartmentView dep;
       public MyHolder(View itemView) {
            super(itemView);

           dep = itemView.findViewById(R.id.department);

        }
    }
}
