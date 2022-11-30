package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    TextView tvTotalTime;
    TextView tvFullPrice;

    ArrayList list = new ArrayList();
    String totalTime;
    String totalPrice;

    Bundle bundle;
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTotalTime = findViewById(R.id.tvTotalTime);
        tvFullPrice = findViewById(R.id.tvFullPrice);

        bundle = getIntent().getExtras();
        list = bundle.getParcelableArrayList("list");
        totalTime = bundle.getString("totalTime");
        totalPrice = bundle.getString("totalPrice");

        tvTotalTime.setText(totalTime);
        tvFullPrice.setText(totalPrice);

        recyclerView = findViewById(R.id.recyclerRouteList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    public void onGoBackClick(View view) {
        finish();
    }
    public void onSaveClick(View view) {
        finish();
    }
    public void onCheckOutClick(View view) {
        // Opens a cart to verify and complete checkout.
    }
}