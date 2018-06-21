package com.sears.android.dlm.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.Models.VerticalModel;
import com.sears.android.dlm.R;

import java.util.ArrayList;

import static com.sears.android.dlm.MainActivity.getHori;
import static com.sears.android.dlm.MainActivity.getVert;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context c;
    private ArrayList<Object> items;
    private final int V = 1;
    private final int H = 2;

    public MainAdapter(Context c, ArrayList<Object> items) {
        this.c = c;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case V:
                view = inflater.inflate(R.layout.vertical,parent,false);
                holder = new VerticalViewHolder(view);
                break;
            case H:
                view = inflater.inflate(R.layout.horizontal,parent,false);
                holder = new HorizontalViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.vertical, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == V)
            verticalView((VerticalViewHolder) holder);
        else if(holder.getItemViewType() == H)
            horizontalView((HorizontalViewHolder) holder);

    }

    private void verticalView(VerticalViewHolder holder){
        VerticalAdapter adapter = new VerticalAdapter(getVert());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setAdapter(adapter);
    }


    private void horizontalView(HorizontalViewHolder holder){
        HorizontalAdapter adapter = new HorizontalAdapter(getHori());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position) instanceof VerticalModel)
        {
            return V;
        }
        if(items.get(position) instanceof HorizontalModel)
        {
            return H;
        }
        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.innerRecylerView);
        }
    }


    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.innerRecylerView);
        }
    }
}
