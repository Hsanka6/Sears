package com.sears.android.dlm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sears.android.dlm.Adapters.GridAdapter;
import com.sears.android.dlm.Adapters.MainAdapter;
import com.sears.android.dlm.Models.CarouselModel;
import com.sears.android.dlm.Models.HorizontalModel;
import com.sears.android.dlm.Models.VerticalModel;
import com.sears.android.dlm.Models.GridModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CarouselView carouselView;
    GridView gridView;
    //ArrayList<View> views = new ArrayList<>();
    static String a = "http://i.imgur.com/DvpvklR.png";
    static String[] sampleImages = {a, a, a};
    ImageView iv;


    private ArrayList<Object> objects = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter(this,getObject()));
//        gridLayoutManager =new GridLayoutManager(MainActivity.this,3);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        GridAdapter gridAdapter =new GridAdapter(MainActivity.this,iconId, nameList);
//        recyclerView.setAdapter(gridAdapter);
//        gridView =findViewById(R.id.gridView);
//        gridView.setNumColumns(3);
//        gridView.setColumnWidth(GridView.AUTO_FIT);
//        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);

    }



    private ArrayList<Object> getObject() {
        objects.add(getCar().get(0));
        objects.add(getVert().get(0));
        objects.add(getHori().get(0));
        objects.add(getVert1().get(0));
        objects.add(getGri().get(0));
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

    static String[] values = {
            "Java",
            "C883",
            "Android",
            "jQuery",
            "PHP",
            "MySpace",
            "HTML5",
            "Javascript",
            "MySQL",
//            "Python",
//            "Swift",
//            "WordPress",
//            "Facebook",
//            "Youtube",
//            "Twitter"
    };
    static int[] images = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
//            R.drawable.ic_launcher_foreground,
//            R.drawable.ic_launcher_background,
//            R.drawable.ic_launcher_foreground,
//            R.drawable.ic_launcher_background,
//            R.drawable.ic_launcher_foreground,
//            R.drawable.ic_launcher_background,
    };


    public static ArrayList<GridModel> getGri() {
        ArrayList<GridModel>grid = new ArrayList<>();
        grid.add(new GridModel(images,values));



        return grid;
    }

    public static ArrayList<CarouselModel> getCar() {
        ArrayList<CarouselModel>car = new ArrayList<>();
        car.add(new CarouselModel(sampleImages));
        return car;
    }
    public static ArrayList<VerticalModel> getVert() {
        ArrayList<VerticalModel>vert = new ArrayList<>();
        vert.add(new VerticalModel(R.mipmap.ic_launcher,"", false));
        vert.add(new VerticalModel(R.mipmap.ic_launcher,"", false));
        vert.add(new VerticalModel(R.mipmap.ic_launcher,"Sponsored", true));

        return vert;
    }

    public static ArrayList<VerticalModel> getVert1() {
        ArrayList<VerticalModel>vert = new ArrayList<>();
        vert.add(new VerticalModel(R.mipmap.ic_launcher,"", false));
        vert.add(new VerticalModel(R.mipmap.ic_launcher,"", false));
        vert.add(new VerticalModel(R.mipmap.ic_launcher,"Department", true));

        return vert;
    }
}
