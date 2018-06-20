package com.sears.android.dlm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] Items={"item 0","item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8","item 9",};
    ArrayList<View> views = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv1 = new TextView(this);
        tv1.setText("hello");
        TextView tv2 = new TextView(this);
        tv2.setText("world");
        views.add(tv1);
        views.add(tv2);


        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this, views));

    }
}
