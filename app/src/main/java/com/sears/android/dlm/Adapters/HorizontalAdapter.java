package com.sears.android.dlm.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.R;
import com.sears.android.dlmlibrary.DlmProductView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    ArrayList<HorizontalModel>d = new ArrayList<>();

    public HorizontalAdapter(ArrayList<HorizontalModel> d) {
        this.d = d;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_card,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.title.setText(d.get(position).getTitle());
//        holder.price.setText(d.get(position).getPrice());
//        holder.im.setImageResource(d.get(position).getImage());
        holder.dlm.setProductText(d.get(position).getTitle());
        holder.dlm.setImageString(d.get(position).getImage());
        holder.dlm.setPrices(d.get(position).getPrice(),d.get(position).isReduced(),d.get(position).getReducedPrice() );

    }

    @Override
    public int getItemCount() {
        return d.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView title,price;
//        ImageView im;
        DlmProductView dlm;

        public MyViewHolder(View itemView) {
            super(itemView);
//            title = itemView.findViewById(R.id.titleText);
//            price = itemView.findViewById(R.id.priceText);
//            im = itemView.findViewById(R.id.productImage);
            dlm = itemView.findViewById(R.id.product);
        }
    }
}
