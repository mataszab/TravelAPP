package com.example.travelapp;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.Format;

public class AccommodationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvAdultsCount;
    TextView tvChildrenCount;
    TextView tvRoomsCount;

    Button btnAddAdults;
    Button btnAddChildren;
    Button btnAddRooms;

    Button btnMinusAdults;
    Button btnMinusChildren;
    Button btnMinusRooms;

    EditText edCheckIn;
    EditText edCheckOut;

    Spinner spPropertyType;
    Spinner spSortBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);

        tvAdultsCount = findViewById(R.id.tvAdultsCount);
        tvChildrenCount = findViewById(R.id.tvChildrenCount);
        tvRoomsCount = findViewById(R.id.tvRoomsCount);

        btnAddAdults = findViewById(R.id.btnAddAdults);
        btnAddChildren = findViewById(R.id.btnAddChildren);
        btnAddRooms = findViewById(R.id.btnAddRooms);

        btnAddAdults.setOnClickListener(this);
        btnAddChildren.setOnClickListener(this);
        btnAddRooms.setOnClickListener(this);

        btnMinusAdults = findViewById(R.id.btnMinusAdults);
        btnMinusChildren = findViewById(R.id.btnMinusChildren);
        btnMinusRooms = findViewById(R.id.btnMinusRooms);

        btnMinusAdults.setOnClickListener(this);
        btnMinusChildren.setOnClickListener(this);
        btnMinusRooms.setOnClickListener(this);

        spPropertyType = findViewById(R.id.spPropertyType);
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this, R.array.propertyType, android.R.layout.simple_list_item_1);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPropertyType.setAdapter(spinAdapter);

        spSortBy = findViewById(R.id.spSortBy);
        ArrayAdapter<CharSequence> spinAdapterSort = ArrayAdapter.createFromResource(this, R.array.sortBy, android.R.layout.simple_list_item_1);
        spinAdapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSortBy.setAdapter(spinAdapterSort);

        edCheckIn = findViewById(R.id.edCheckIn);
        edCheckOut = findViewById(R.id.edCheckOut);

        edCheckIn.setInputType(InputType.TYPE_NULL);
        edCheckOut.setInputType(InputType.TYPE_NULL);

        edCheckIn.setSingleLine(false);
        edCheckOut.setSingleLine(false);

        edCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showDateTimeDialog(edCheckIn, AccommodationActivity.this);
            }
        });

        edCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showDateTimeDialog(edCheckOut, AccommodationActivity.this);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int count;
        switch (view.getId()) {
            case R.id.btnAddAdults:
                count = Integer.valueOf(tvAdultsCount.getText().toString());
                count++;
                tvAdultsCount.setText(String.valueOf(count));
                break;
            case R.id.btnAddChildren:
                count = Integer.valueOf(tvChildrenCount.getText().toString());
                count++;
                tvChildrenCount.setText(String.valueOf(count));
                break;
            case R.id.btnAddRooms:
                count = Integer.valueOf(tvRoomsCount.getText().toString());
                count++;
                tvRoomsCount.setText(String.valueOf(count));
                break;
            case R.id.btnMinusAdults:
                if (tvAdultsCount.getText().toString().equals("1")) {
                    //do nothing => can't be less than 1 adult
                }
                else {
                    count = Integer.valueOf(tvAdultsCount.getText().toString());
                    count--;
                    tvAdultsCount.setText(String.valueOf(count));
                }
                break;
            case R.id.btnMinusChildren:
                if (tvChildrenCount.getText().toString().equals("0")) {
                    //do nothing => can't be less than 0 children
                }
                else {
                    count = Integer.valueOf(tvChildrenCount.getText().toString());
                    count--;
                    tvChildrenCount.setText(String.valueOf(count));
                }
                break;
            case R.id.btnMinusRooms:
                if (tvRoomsCount.getText().toString().equals("1")) {
                    //do nothing => can't be less than 1 room
                }
                else {
                    count = Integer.valueOf(tvRoomsCount.getText().toString());
                    count--;
                    tvRoomsCount.setText(String.valueOf(count));
                }
                break;
            default:
                break;
        }
    }

    public void onGoBackClick(View view) {
        finish();
    }

    public void onSaveClick(View view) {
        finish();
    }
}
