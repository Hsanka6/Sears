package com.sears.android.dlm.Adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.sears.android.dlm.MainActivity;
import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.Models.VerticalModel;
import com.sears.android.dlm.R;
import com.synnapps.carouselview.CarouselView;

import java.util.ArrayList;
import java.util.Vector;

import static com.sears.android.dlm.MainActivity.getBannerImages;

import static com.sears.android.dlm.MainActivity.getRecommendedImages;
import static com.sears.android.dlm.MainActivity.getSponsoredImages;
import static com.sears.android.dlm.MainActivity.getVert;
import static com.sears.android.dlm.MainActivity.getVert1;

import static com.sears.android.dlm.MainActivity.getCar;
import static com.sears.android.dlm.MainActivity.getGri;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context c;
    private ArrayList<Object> items;
    private int bannerSize;
    private Vector<String> positions;
    private final int V = 1;
    private final int H = 2;
    private final int C = 4;
    private final int G = 3;
    private final int D = 5;
    private final int Re = 6;
    private final int H_1 = 7;





    public MainAdapter(Context c, ArrayList<Object> items, int bannerSize, Vector<String> positions) {
        this.c = c;
        this.bannerSize = bannerSize;
        this.items = items;
        this.positions = positions;
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
            case G:
                view = inflater.inflate(R.layout.vertical,parent,false);
                holder = new GridViewHolder(view);
                break;
            case C:
                view = inflater.inflate(R.layout.vertical,parent, false);
                holder = new CarouselViewHolder(view);
                break;
            case D:
                view = inflater.inflate(R.layout.vertical,parent, false);
                holder = new VerticalViewHolder(view);
                break;
            case Re:
                view = inflater.inflate(R.layout.vertical,parent, false);
                holder = new VerticalViewHolder(view);
                break;
            case H_1:
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
        else if(holder.getItemViewType() == C)
            carouselView((CarouselViewHolder) holder);
        else if(holder.getItemViewType() == G)
            gridView((GridViewHolder) holder);
        else if(holder.getItemViewType() == D)
            verticalView1((VerticalViewHolder) holder);
        else if(holder.getItemViewType() == Re)
            verticalView2((VerticalViewHolder) holder);
        else if(holder.getItemViewType() == H_1)
            horizontalView1((HorizontalViewHolder) holder);

    }

    private void verticalView(VerticalViewHolder holder){
        VerticalAdapter adapter = new VerticalAdapter(getVert());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void verticalView1(VerticalViewHolder holder){
        VerticalAdapter adapter = new VerticalAdapter(getVert1());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void verticalView2(VerticalViewHolder holder){
        VerticalAdapter adapter = new VerticalAdapter(getBannerImages());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void carouselView(CarouselViewHolder holder){
        CarouselAdapter adapter = new CarouselAdapter(getCar());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void gridView(GridViewHolder holder){
        GridAdapter adapter = new GridAdapter(getGri().get(0).getNameList(), getGri().get(0).getIconId());
        holder.recyclerView.setLayoutManager(new GridLayoutManager(c,3));
        holder.recyclerView.setHasFixedSize(true);
       // holder.recyclerView.setLayoutManager(new GridLayoutManager(c, LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void horizontalView1(HorizontalViewHolder holder){
        HorizontalAdapter adapter = new HorizontalAdapter(getRecommendedImages());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void horizontalView(HorizontalViewHolder holder){
        HorizontalAdapter adapter = new HorizontalAdapter(getSponsoredImages());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if((position) == 1)
        {
            return Re;
        }
        if((position) == 2)
        {
            return H_1;
        }
        if((position) == 3)
        {
            return V;
        }
        if((position) == 4)
        {
            return H;
        }
        if((position) == 0)
        {
            return C;
        }
        if((position) == 6)
        {
            return G;
        }
        if((position) == 5)
        {
            return D;
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

    public class CarouselViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public CarouselViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.innerRecylerView);
        }
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public GridViewHolder(View itemView) {
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
