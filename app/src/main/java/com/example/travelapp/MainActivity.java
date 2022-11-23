package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Intent intentAcc;
    Button btnMain;
    Spinner spinMain;

    ArrayList list = new ArrayList();

    ImageButton imgButtRecomm;
    ImageButton imgButtCar;
    ImageButton imgButtPubTrans;
    ImageButton imgButtWalk;
    ImageButton imgButtPlane;

    EditText edDepartDate;
    EditText edReturnDate;

    AutoCompleteTextView actvFrom;
    AutoCompleteTextView actvTo;

    String totalTime = "Total time: 0h 0min";
    String totalPrice = "Total price: 0€";

    Switch swMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btnMain);
        actvFrom = findViewById(R.id.actvFrom);
        actvTo = findViewById(R.id.actvTo);

        imgButtRecomm = findViewById(R.id.imgButtRecomm);
        imgButtCar = findViewById(R.id.imgButtCar);
        imgButtPubTrans = findViewById(R.id.imgButtPubTrans);
        imgButtWalk = findViewById(R.id.imgButtWalk);
        imgButtPlane = findViewById(R.id.imgButtPlane);

        swMain = findViewById(R.id.swMain);

        edDepartDate = findViewById(R.id.edDepartDate);
        edReturnDate = findViewById(R.id.edReturnDate);

        edDepartDate.setInputType(InputType.TYPE_NULL);
        edReturnDate.setInputType(InputType.TYPE_NULL);

        edDepartDate.setSingleLine(false);
        edReturnDate.setSingleLine(false);

        imgButtRecomm.setOnClickListener(this);
        imgButtCar.setOnClickListener(this);
        imgButtPubTrans.setOnClickListener(this);
        imgButtWalk.setOnClickListener(this);
        imgButtPlane.setOnClickListener(this);

        actvFrom.setMovementMethod(new ScrollingMovementMethod());

        spinMain = findViewById(R.id.spinMain);
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this, R.array.spinnerSelection, android.R.layout.simple_list_item_1);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMain.setAdapter(spinAdapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.startingPoint));
        actvFrom.setAdapter(adapter);
        actvTo.setAdapter(adapter);

        swMain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swMain.isChecked()) {
                    intentAcc = new Intent(MainActivity.this, AccommodationActivity.class);
                    startActivity(intentAcc);
                }
                else {
                    swMain.setChecked(false);
                }
            }
        });

        edDepartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateTimeDialog(edDepartDate, MainActivity.this);
            }
        });

        edReturnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateTimeDialog(edReturnDate,MainActivity.this);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view    .getId()) {
            case R.id.imgButtRecomm:
                imgButtRecomm.setBackgroundResource(R.drawable.always_clicked);
                imgButtCar.setBackgroundResource(R.drawable.image_button_style);
                imgButtPubTrans.setBackgroundResource(R.drawable.image_button_style);
                imgButtWalk.setBackgroundResource(R.drawable.image_button_style);
                imgButtPlane.setBackgroundResource(R.drawable.image_button_style);
                break;
            case R.id.imgButtCar:
                imgButtRecomm.setBackgroundResource(R.drawable.image_button_style);
                imgButtCar.setBackgroundResource(R.drawable.always_clicked);
                imgButtPubTrans.setBackgroundResource(R.drawable.image_button_style);
                imgButtWalk.setBackgroundResource(R.drawable.image_button_style);
                imgButtPlane.setBackgroundResource(R.drawable.image_button_style);
                break;
            case R.id.imgButtPubTrans:
                imgButtRecomm.setBackgroundResource(R.drawable.image_button_style);
                imgButtCar.setBackgroundResource(R.drawable.image_button_style);
                imgButtPubTrans.setBackgroundResource(R.drawable.always_clicked);
                imgButtWalk.setBackgroundResource(R.drawable.image_button_style);
                imgButtPlane.setBackgroundResource(R.drawable.image_button_style);
                break;
            case R.id.imgButtWalk:
                imgButtRecomm.setBackgroundResource(R.drawable.image_button_style);
                imgButtCar.setBackgroundResource(R.drawable.image_button_style);
                imgButtPubTrans.setBackgroundResource(R.drawable.image_button_style);
                imgButtWalk.setBackgroundResource(R.drawable.always_clicked);
                imgButtPlane.setBackgroundResource(R.drawable.image_button_style);
                break;
            case R.id.imgButtPlane:
                imgButtRecomm.setBackgroundResource(R.drawable.image_button_style);
                imgButtCar.setBackgroundResource(R.drawable.image_button_style);
                imgButtPubTrans.setBackgroundResource(R.drawable.image_button_style);
                imgButtWalk.setBackgroundResource(R.drawable.image_button_style);
                imgButtPlane.setBackgroundResource(R.drawable.always_clicked);
                break;
            default:
                break;
        }
    }
    public void onDeleteClick (View view) {
        edDepartDate.setText(null);
        edReturnDate.setText(null);
    }

    public void onMoreClick (View view) {
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.savedRoutes) {
                    //Would do something
                    return true;
                }
                else if (menuItem.getItemId() == R.id.loginRegister) {
                    //Would do something
                    return true;
                }
                else {
                    return false;
                }
            }
        });
        popup.show();
    }

    public static void showDateTimeDialog(final EditText dateTimeIn, Context context) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd\nHH:mm");

                        dateTimeIn.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(context, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        };
        new DatePickerDialog(context, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void openActivity2() {
        intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        bundle.putString("totalTime", totalTime);
        bundle.putString("totalPrice", totalPrice);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void calculateRoute(View view) {
        String[] stringArrayElement = getResources().getStringArray(R.array.startingPoint);
        String startingPoint = actvFrom.getText().toString();
        String destination = actvTo.getText().toString();

        String spinnerText = spinMain.getSelectedItem().toString();
        String[] spinnerArrayElement = getResources().getStringArray(R.array.spinnerSelection);

        list.clear();
        totalTime = "Total time: 0h 0min";
        totalPrice = "Total price: 0€";

        if (spinnerText.equals(spinnerArrayElement[0])) {   //Cheapest
            if (startingPoint.equals(stringArrayElement[0])) {  // [0] Lithuania, Kaunas, Muitinės g. 8
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                    list.add(new RouteMapActivity(R.drawable.travel_map_lithuania_usa));

                    String travelRouteDescription1 = "Walk to BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime1 = "12:27 - 12:30  (3min)";
                    list.add(new NameTimeActivity("1.", travelRouteDescription1, travelRouteTime1));

                    String travelRouteDescription2 = "Wait at BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime2 = "12:30 - 12:33  (3min)";
                    list.add(new NameTimeActivity("2.", travelRouteDescription2, travelRouteTime2));

                    String travelRouteDescription3 = "Bus Nr.6A (From Karaliaus Mindaugo pr. - To Geležinkelio Stotis)";
                    String travelRouteTime3 = "12:33 - 12:47  (14min)";
                    String travelRoutePrice3 = "0.70€";
                    list.add(new NameTimePriceLinkActivity("3.", travelRouteDescription3, travelRouteTime3, travelRoutePrice3, "Click here to buy Bus ticket!"));

                    String travelRouteDescription4 = "Walk to the Kaunas Train Station";
                    String travelRouteTime4 = "12:47 - 12:48  (1min)";
                    list.add(new NameTimeActivity("4.", travelRouteDescription4, travelRouteTime4));

                    String travelRouteDescription5 = "Wait for Train at Kaunas Train Station";
                    String travelRouteTime5 = "12:48 - 13:20  (32min)";
                    list.add(new NameTimeActivity("5.", travelRouteDescription5, travelRouteTime5));

                    String travelRouteDescription6 = "Catch the Train To Vilnius";
                    String travelRouteTime6 = "13:20 - 14:46  (1h 26min)";
                    String travelRoutePrice6 = "7.70€";
                    list.add(new NameTimePriceLinkActivity("6.", travelRouteDescription6, travelRouteTime6, travelRoutePrice6, "Click here to buy Train ticket!"));

                    String travelRouteDescription7 = "Walk to BusStop (Stotis)";
                    String travelRouteTime7 = "14:46 - 14:48  (2min)";
                    list.add(new NameTimeActivity("7.", travelRouteDescription7, travelRouteTime7));

                    String travelRouteDescription8 = "Wait at BusStop (Stotis)";
                    String travelRouteTime8 = "14:48 - 14:51  (3min)";
                    list.add(new NameTimeActivity("8.", travelRouteDescription8, travelRouteTime8));

                    String travelRouteDescription9 = "Bus Nr.42 (From Stotis BusStop - To Naujininkai BusStop)";
                    String travelRouteTime9 = "14:51 - 15:00  (9min)";
                    String travelRoutePrice9 = "0.65€";    //BILIETO KAINA 30MIN
                    list.add(new NameTimePriceLinkActivity("9.", travelRouteDescription9, travelRouteTime9, travelRoutePrice9, "Click here to buy Bus ticket!"));

                    String travelRouteDescription10 = "Wait at BusStop (Naujininkai)";
                    String travelRouteTime10 = "15:00 - 15:06  (6min)";
                    list.add(new NameTimeActivity("10.", travelRouteDescription10, travelRouteTime10));

                    String travelRouteDescription11 = "Bus Nr.3G (From Naujininkai BusStop - To Oro Uostas BusStop)";
                    String travelRouteTime11 = "15:06 - 15:12  (6min)";
                        //PERSĖDIMAS NEPASIBAIGUS 30MIN, TODĖL NAUJO BILIETO PIRKTI NEREIKIA
                    list.add(new NameTimeActivity("11.", travelRouteDescription11, travelRouteTime11));

                    String travelRouteDescription12 = "Walk to Vilnius Air Port";
                    String travelRouteTime12 = "15:12 - 15:16  (4min)";
                    list.add(new NameTimeActivity("12.", travelRouteDescription12, travelRouteTime12));

                    String travelRouteDescription13 = "Wait at Vilnius Air Port";
                    String travelRouteTime13 = "15:16 - 16:20  (1h 4min)";
                    list.add(new NameTimeActivity("13.", travelRouteDescription13, travelRouteTime13));

                    String travelRouteDescription14 = "Flight (From Vilnius - To New York)";
                    String travelRouteTime14 = "16:20 - 22:00  (1 stop)  (12h40m, UTC-5)";
                    String travelRoutePrice14 = "215€";
                    list.add(new NameTimePriceLinkActivity("14.", travelRouteDescription14, travelRouteTime14, travelRoutePrice14, "Click here to buy Flight ticket!"));

                    String travelRouteDescription15 = "Time from landing to exiting Air Port";
                    String travelRouteTime15 = "22:00 - 22:45  (45min)";
                    list.add(new NameTimeActivity("15.", travelRouteDescription15, travelRouteTime15));

                    String travelRouteDescription16 = "Walk to JFK Terminal 8-9 (Terminal 8-9)";
                    String travelRouteTime16 = "22:45 - 23:00  (15min)";
                    list.add(new NameTimeActivity("16.", travelRouteDescription16, travelRouteTime16));

                    String travelRouteDescription17 = "Train to Jamaica Station (AirTrain)";
                    String travelRouteTime17 = "23:00 - 23:10  (10min)";
                        //FREE - TRAIN COSTS NOTHING
                    list.add(new NameTimeActivity("17.", travelRouteDescription17, travelRouteTime17));

                    String travelRouteDescription18 = "Walk to Metro Station (Sutphin Blvd - Archer Av - JFK Airport)";
                    String travelRouteTime18 = "23:10 - 23:14  (4min)";
                    list.add(new NameTimeActivity("18.", travelRouteDescription18, travelRouteTime18));

                    String travelRouteDescription19 = "Wait for Metro";
                    String travelRouteTime19 = "23:14 - 23:18  (4min)";
                    list.add(new NameTimeActivity("19.", travelRouteDescription19, travelRouteTime19));

                    String travelRouteDescription20 = "Metro (From Sutphin Blvd - Archer Av - JFK Airport - To Flushing Av)";
                    String travelRouteTime20 = "23:18 - 23:50  (32min)";
                    String  travelRoutePrice20 = "2.75€";
                    list.add(new NameTimePriceLinkActivity("20.", travelRouteDescription20, travelRouteTime20, travelRoutePrice20, "Click here to buy Metro ticket!"));

                    String travelRouteDescription21 = "Walk to NY Moorse Hostel";
                    String travelRouteTime21 = "23:50 - 23:59  (9min)";
                    list.add(new NameTimeActivity("21.", travelRouteDescription21, travelRouteTime21));

                    String travelRouteDescription22 = "Sleep at Hostel (NY Moore Hostel)";
                    String travelRoutePrice22 = "59€";
                    list.add(new NamePriceLinkActivity("22.", travelRouteDescription22, travelRoutePrice22, "Click here to book a room!"));

                    String travelRouteDescription23 = "Walk To Morgan Av (Metro) From NY Moore Hostel";
                    String travelRouteTime23 = "12:47 - 12:54  (7min)";
                    list.add(new NameTimeActivity("23.", travelRouteDescription23, travelRouteTime23));

                    String travelRouteDescription24 = "Metro (From Morgan Av - To 14 St / 6 Av)";
                    String travelRouteTime24 = "12:54 - 13:08  (14min)";
                    String travelRoutePrice24 = "2.75€";
                    list.add(new NameTimePriceLinkActivity("24.", travelRouteDescription24, travelRouteTime24, travelRoutePrice24, "Click here to buy Metro ticket!"));

                    String travelRouteDescription25 = "Walk to (Metro) 14 St";
                    String travelRouteTime25 = "13:08 - 13:12  (4min)";
                    list.add(new NameTimeActivity("25.", travelRouteDescription25, travelRouteTime25));

                    String travelRouteDescription26 = "Metro (From 14 St - To South Ferry)";
                    String travelRouteTime26 = "13:12 - 13:23  (11min)";
                    String travelRoutePrice26 = "2.75€";
                    list.add(new NameTimePriceLinkActivity("26.", travelRouteDescription26, travelRouteTime26, travelRoutePrice26, "Click here to buy Metro ticket!"));

                    String travelRouteDescription27 = "Walk to the Statue of Liberty View Point";
                    String travelRouteTime27 = "13:23 - 13:26  (3min)";
                    list.add(new NameTimeActivity("27.", travelRouteDescription27, travelRouteTime27));

                    String tvAd = "Travel now and get 240 Travel points!";
                    list.add(new TravelPointsAdActivity(R.drawable.ic_baseline_star, tvAd));

                    totalTime = "Total time: 24h 59min";
                    totalPrice = "Total price: 291.30€";
                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                    list.add(new RouteMapActivity(R.drawable.travel_map_lithuania_australia));

                    String travelRouteDescription1 = "Walk to BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime1 = "13:27 - 13:30  (3min)";
                    list.add(new NameTimeActivity("1.", travelRouteDescription1, travelRouteTime1));

                    String travelRouteDescription2 = "Wait at BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime2 = "13:30 - 13:33  (3min)";
                    list.add(new NameTimeActivity("2.", travelRouteDescription2, travelRouteTime2));

                    String travelRouteDescription3 = "Bus Nr.18 (From Karaliaus Mindaugo pr. - To Geležinkelio Stotis)";
                    String travelRouteTime3 = "13:33 - 13:51  (18min)";
                    String travelRoutePrice3 = "0.70€";
                    list.add(new NameTimePriceLinkActivity("3.", travelRouteDescription3, travelRouteTime3, travelRoutePrice3, "Click here to buy Bus ticket!"));

                    String travelRouteDescription4 = "Walk to the Kaunas Train Station";
                    String travelRouteTime4 = "13:51 - 13:52  (1min)";
                    list.add(new NameTimeActivity("4.", travelRouteDescription4, travelRouteTime4));

                    String travelRouteDescription5 = "Wait for Train at Kaunas Train Station";
                    String travelRouteTime5 = "13:52 - 14:30  (38min)";
                    list.add(new NameTimeActivity("5.", travelRouteDescription5, travelRouteTime5));

                    String travelRouteDescription6 = "Catch the Train To Vilnius";
                    String travelRouteTime6 = "14:30 - 16:47  (1 Stop)  (2h 17min)";
                    String travelRoutePrice6 = "8.50€";
                    list.add(new NameTimePriceLinkActivity("6.", travelRouteDescription6, travelRouteTime6, travelRoutePrice6, "Click here to buy Train ticket!"));

                    String travelRouteDescription7= "Walk to Vilnius Air Port";
                    String travelRouteTime7 = "16:47 - 16:49  (2min)";
                    list.add(new NameTimeActivity("7.", travelRouteDescription7, travelRouteTime7));

                    String travelRouteDescription8 = "Wait at Vilnius Air Port";
                    String travelRouteTime8 = "16:49 - 19:10  (2h 21min)";
                    list.add(new NameTimeActivity("8.", travelRouteDescription8, travelRouteTime8));

                    String travelRouteDescription9 = "Flight (From Vilnius - To Sydney)";
                    String travelRouteTime9 = "19:10 - 14:15  (3 stop)  (58h 5min, UTC+11)";
                    String travelRoutePrice9 = "855€";
                    list.add(new NameTimePriceLinkActivity("9.", travelRouteDescription9, travelRouteTime9, travelRoutePrice9, "Click here to buy Flight ticket!"));

                    String travelRouteDescription10 = "Time from landing to exiting Air Port";
                    String travelRouteTime10 = "14:15 - 15:00  (45min)";
                    list.add(new NameTimeActivity("10.", travelRouteDescription10, travelRouteTime10));

                    String travelRouteDescription11 = "Walk to Sydney Airport, Terminal 3 Domestic";
                    String travelRouteTime11 = "15:00 - 15:03  (3min)";
                    list.add(new NameTimeActivity("11.", travelRouteDescription11, travelRouteTime11));

                    String travelRouteDescription12 = "Bus Nr.350 (From Sydney Airport, Terminal 3 Domestic - To Mascot Station, Coward St, Stand A)";
                    String travelRouteTime12 = "15:03 - 15:08  (5min)";
                    String travelRoutePrice12 = "3.93€";
                    list.add(new NameTimePriceLinkActivity("12.", travelRouteDescription12, travelRouteTime12, travelRoutePrice12, "Click here to buy Bus ticket!"));

                    String travelRouteDescription13 = "Walk to BusStop (Bourke St at Church Ave)";
                    String travelRouteTime13 = "15:08 - 15:12  (4min)";
                    list.add(new NameTimeActivity("13.", travelRouteDescription13, travelRouteTime13));

                    String travelRouteDescription14 = "Wait at BusStop (Bourke St at Church Ave)";
                    String travelRouteTime14 = "15:12 - 15:16  (4min)";
                    list.add(new NameTimeActivity("14.", travelRouteDescription14, travelRouteTime14));

                    String travelRouteDescription15 = "Bus Nr.358 (From Bourke St at Church Ave - To Gardeners Rd at Dunning Ave)";
                    String travelRouteTime15 = "15:16 - 15:23  (7min)";
                    String travelRoutePrice15 = "3.20€";
                    list.add(new NameTimePriceLinkActivity("15.", travelRouteDescription15, travelRouteTime15, travelRoutePrice15, "Click here to buy Bus ticket!"));

                    String travelRouteDescription16 = "Walk to BusStop (Dunning Ave after Gardeners Rd)";
                    String travelRouteTime16 = "15:23 - 15:24  (1min)";
                    list.add(new NameTimeActivity("16.", travelRouteDescription16, travelRouteTime16));

                    String travelRouteDescription17 = "Wait at BusStop (Dunning Ave after Gardeners Rd)";
                    String travelRouteTime17 = "15:24 - 15:29  (5min)";
                    list.add(new NameTimeActivity("17.", travelRouteDescription17, travelRouteTime17));

                    String travelRouteDescription18 = "Bus Nr.343 (From Dunning Ave after Gardeners Rd - To Museum of Sydney, Phillip St)";
                    String travelRouteTime18 = "15:29 - 16:02  (33min)";
                    String travelRoutePrice18 = "5.05€";
                    list.add(new NameTimePriceLinkActivity("18.", travelRouteDescription18, travelRouteTime18, travelRoutePrice18, "Click here to buy Bus ticket!"));

                    String travelRouteDescription19 = "Walk to the Sydney Opera House";
                    String travelRouteTime19 = "16:02 - 16:12  (10min)";
                    list.add(new NameTimeActivity("19.", travelRouteDescription19, travelRouteTime19));

                    String tvAd = "Travel now and get 240 Travel points!";
                    list.add(new TravelPointsAdActivity(R.drawable.ic_baseline_star, tvAd));

                    totalTime = "Total time: 65h 45min";
                    totalPrice = "Total price: 876.38€";
                }
            }
            else if (startingPoint.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8

                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)

                }
            }
            else if (startingPoint.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8

                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)

                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
            }
            openActivity2();
        }
        else if (spinnerText.equals(spinnerArrayElement[1])) {  //Quickest
            if (startingPoint.equals(stringArrayElement[0])) {  // [0] Lithuania, Kaunas, Muitinės g. 8
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                    list.add(new RouteMapActivity(R.drawable.travel_map_lithuania_usa));

                    String travelRouteDescription1 = "Wait at Muitinės g. 8 for Bolt";
                    String travelRouteTime1 = "12:27 - 12:28  (1min)";
                    list.add(new NameTimeActivity("1.", travelRouteDescription1, travelRouteTime1));

                    String travelRouteDescription2 = "Drive with Bolt (From Muitinės g. 8 - To Vilnius Air Port";
                    String travelRouteTime2 = "12:28 - 13:40  (1h 12min)";
                    String travelRoutePrice2 = "75.40€";
                    list.add(new NameTimePriceLinkActivity("2.", travelRouteDescription2, travelRouteTime2, travelRoutePrice2, "Click here to book a Bolt!"));

                    String travelRouteDescription3 = "Walk to the Vilnius Air Port";
                    String travelRouteTime3 = "13:40 - 13:43  (3min)";
                    list.add(new NameTimeActivity("3.", travelRouteDescription3, travelRouteTime3));

                    String travelRouteDescription4 = "Wait at Vilnius Air Port";
                    String travelRouteTime4 = "13:43 - 14:50  (1h 7min)";
                    list.add(new NameTimeActivity("4.", travelRouteDescription4, travelRouteTime4));

                    String travelRouteDescription5 = "Flight (From Vilnius - To New York)";
                    String travelRouteTime5 = "14:50 - 20:25  (1 stop) (12h35m, UTC-7)";
                    String travelRoutePrice5 = "772€";
                    list.add(new NameTimePriceLinkActivity("5.", travelRouteDescription5, travelRouteTime5, travelRoutePrice5, "Click here to buy Flight ticket!"));

                    String travelRouteDescription6 = "Time from landing to exiting Air Port";
                    String travelRouteTime6 = "20:25 - 21:00  (35min)";
                    list.add(new NameTimeActivity("6.", travelRouteDescription6, travelRouteTime6));

                    String travelRouteDescription7 = "Wait for Taxi";
                    String travelRouteTime7 = "21:00 - 21:10  (10min)";
                    list.add(new NameTimeActivity("7.", travelRouteDescription7, travelRouteTime7));

                    String travelRouteDescription8 = "Take a taxi to the Statue Of Liberty View Point";
                    String travelRouteTime8 = "21:10 - 21:52  (42min)";
                    String travelRoutePrice8 = "57.82€";
                    list.add(new NameTimePriceLinkActivity("8.", travelRouteDescription8, travelRouteTime8, travelRoutePrice8, "Click here to book a Taxi!"));

                    String travelRouteDescription9 = "Walk to the Statue of Liberty View Point";
                    String travelRouteTime9 = "21:52 - 21:54  (2min)";
                    list.add(new NameTimeActivity("9.", travelRouteDescription9, travelRouteTime9));

                    String tvAd = "Travel now and get 240 Travel points!";
                    list.add(new TravelPointsAdActivity(R.drawable.ic_baseline_star, tvAd));

                    totalTime = "Total time: 9h 27min";
                    totalPrice = "Total price: 905.22€";
                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                    list.add(new RouteMapActivity(R.drawable.travel_map_lithuania_australia));

                    String travelRouteDescription1 = "Wait at Muitinės g. 8 for Bolt";
                    String travelRouteTime1 = "05:26 - 05:30  (4min)";
                    list.add(new NameTimeActivity("1.", travelRouteDescription1, travelRouteTime1));

                    String travelRouteDescription2 = "Drive with Bolt (From Muitinės g. 8 - To Vilnius Air Port";
                    String travelRouteTime2 = "05:30 - 06:47  (1h 17min)";
                    String travelRoutePrice2 = "75.40€";
                    list.add(new NameTimePriceLinkActivity("2.", travelRouteDescription2, travelRouteTime2, travelRoutePrice2, "Click here to book a Bolt!"));

                    String travelRouteDescription3 = "Walk to the Vilnius Air Port";
                    String travelRouteTime3 = "06:47 - 06:50  (3min)";
                    list.add(new NameTimeActivity("3.", travelRouteDescription3, travelRouteTime3));

                    String travelRouteDescription4 = "Wait at Vilnius Air Port";
                    String travelRouteTime4 = "06:50 - 07:50  (1h)";
                    list.add(new NameTimeActivity("4.", travelRouteDescription4, travelRouteTime4));

                    String travelRouteDescription5 = "Flight (From Vilnius - To Sydney)";
                    String travelRouteTime5 = "7:50 - 17:55  (2 stop)  (25h 5min, UTC+11)";
                    String travelRoutePrice5 = "2074€";
                    list.add(new NameTimePriceLinkActivity("5.", travelRouteDescription5, travelRouteTime5, travelRoutePrice5, "Click here to buy Flight ticket!"));

                    String travelRouteDescription6 = "Time from landing to exiting Air Port";
                    String travelRouteTime6 = "17:55 - 19:00  (1h 5min)";
                    list.add(new NameTimeActivity("6.", travelRouteDescription6, travelRouteTime6));

                    String travelRouteDescription7 = "Wait for Taxi";
                    String travelRouteTime7 = "19:00 - 19:10  (10min)";
                    list.add(new NameTimeActivity("7.", travelRouteDescription7, travelRouteTime7));

                    String travelRouteDescription8 = "Take taxi to the Sydney Opera House";
                    String travelRouteTime8 = "19:10 - 19:32  (22min)";
                    String travelRoutePrice8 = "42.75€";
                    list.add(new NameTimePriceLinkActivity("8.", travelRouteDescription8, travelRouteTime8, travelRoutePrice8, "Click here to book a Taxi!"));

                    String travelRouteDescription9 = "Walk to the Sydney Opera House";
                    String travelRouteTime9 = "19:32 - 19:37  (5min)";
                    list.add(new NameTimeActivity("9.", travelRouteDescription9, travelRouteTime9));

                    String tvAd = "Travel now and get 240 Travel points!";
                    list.add(new TravelPointsAdActivity(R.drawable.ic_baseline_star, tvAd));

                    totalTime = "Total time: 29h 11min";
                    totalPrice = "Total price: 2192.15€";
                }
            }
            else if (startingPoint.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8

                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)

                }
            }
            else if (startingPoint.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8

                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)

                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
            }
            openActivity2();
        }
    }
}