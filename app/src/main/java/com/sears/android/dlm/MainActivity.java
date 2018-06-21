package com.sears.android.dlm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sears.android.dlm.Adapters.MainAdapter;
import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.Models.VerticalModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] Items={"item 0","item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8","item 9",};
    //ArrayList<View> views = new ArrayList<>();

    private ArrayList<Object> objects = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter(this,getObject()));
    }

    private ArrayList<Object> getObject() {
        objects.add(getVert().get(0));
        objects.add(getHori().get(0));
        objects.add(getVert().get(0));
        return objects;
    }

    public static ArrayList<HorizontalModel> getHori() {
        ArrayList<HorizontalModel>hori = new ArrayList<>();
        hori.add(new HorizontalModel(R.drawable.ic_launcher_background,"Shoes", "$100.00"));
        hori.add(new HorizontalModel(R.drawable.ic_launcher_background,"Shoes 2", "$300.00"));
        hori.add(new HorizontalModel(R.drawable.ic_launcher_background,"Shoes", "$100.00"));
        hori.add(new HorizontalModel(R.drawable.ic_launcher_background,"Shoes 2", "$300.00"));
        hori.add(new HorizontalModel(R.drawable.ic_launcher_background,"Shoes", "$100.00"));
        hori.add(new HorizontalModel(R.drawable.ic_launcher_background,"Shoes 2", "$300.00"));

        return hori;
    }

    public static ArrayList<VerticalModel> getVert() {
        ArrayList<VerticalModel>vert = new ArrayList<>();
        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        vert.add(new VerticalModel(R.mipmap.ic_launcher));

        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        vert.add(new VerticalModel(R.mipmap.ic_launcher));

        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        vert.add(new VerticalModel(R.mipmap.ic_launcher));
        return vert;
    }
}
