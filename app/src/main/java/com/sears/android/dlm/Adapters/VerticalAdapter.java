package com.sears.android.dlm.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sears.android.dlm.Models.VerticalModel;
import com.sears.android.dlm.R;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {
    private ArrayList<VerticalModel> d = new ArrayList<>();

    public VerticalAdapter(ArrayList<VerticalModel> d) {
        this.d = d;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.im.setImageResource(d.get(position).getImage());
        if(d.get(position).isNoTitle())
        {
            holder.title.setText(d.get(position).getTitle());
            holder.im.setVisibility(View.GONE);
        }
        else
        {
            holder.title.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return d.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView title;
        Boolean isTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.bannerTitle);
        }
    }
}
