package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        ArrayList<Route> routeList = bundle.getParcelableArrayList("routeList");
        String totalTime = bundle.getString("totalTime");
        String totalPrice = bundle.getString("totalPrice");

        TextView tvTotalTime = findViewById(R.id.tvTotalTime);
        TextView tvFullPrice = findViewById(R.id.tvFullPrice);

        tvTotalTime.setText(totalTime);
        tvFullPrice.setText(totalPrice);

        recyclerView = findViewById(R.id.recyclerRouteList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecycleViewAdapter(routeList, this);
        recyclerView.setAdapter(mAdapter);
    }
}