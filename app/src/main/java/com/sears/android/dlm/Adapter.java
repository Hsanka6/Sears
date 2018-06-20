package com.sears.android.dlm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<View> items;
    public Adapter(Context context, ArrayList<View> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.costum_row, parent, false);
        Item item=new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Item)holder).view1 = items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class Item extends RecyclerView.ViewHolder {
        View view1;
        public Item(View itemView) {
            super(itemView);
            view1=itemView.findViewById(R.id.item);
        }
    }
}
