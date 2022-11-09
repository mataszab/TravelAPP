package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    Button btnMain;
    Spinner spinMain;
    ArrayList<Route> routeList = new ArrayList<Route>();

    ImageButton imgButtRecomm;
    ImageButton imgButtCar;
    ImageButton imgButtPubTrans;
    ImageButton imgButtWalk;
    ImageButton imgButtPlane;

    AutoCompleteTextView actvFrom;
    AutoCompleteTextView actvTo;

    String totalTime;
    String totalPrice;

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

    public void openActivity2() {
        intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("routeList", routeList);
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

        routeList.clear();

        if (spinnerText.equals(spinnerArrayElement[0])) {   //Cheapest
            if (startingPoint.equals(stringArrayElement[0])) {  // [0] Lithuania, Kaunas, Muitinės g. 8
                if (destination.equals(stringArrayElement[0])) { // [0] Lithuania, Kaunas, Muitinės g. 8
                    // STARTING POINT AND DESTINATION IS THE SAME!
                }
                else if (destination.equals(stringArrayElement[1])) { // [1] USA, New York, Battery Park Underpass (Statue of Liberty View Point)
                    String travelRouteDescription1 = "Walk to BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime1 = "12:27 - 12:30";
                    double travelRoutePrice1 = 0;
                    Route r1 = new Route("1.", travelRouteDescription1, travelRouteTime1, travelRoutePrice1);

                    String travelRouteDescription2 = "Wait at BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime2 = "12:30 - 12:33";
                    double travelRoutePrice2 = 0;
                    Route r2 = new Route("2.", travelRouteDescription2, travelRouteTime2, travelRoutePrice2);

                    String travelRouteDescription3 = "Bus Nr.6A (From Karaliaus Mindaugo pr. - To Gelezinkelio Stotis)";
                    String travelRouteTime3 = "12:33 - 12:47";
                    double travelRoutePrice3 = 0.70;
                    Route r3 = new Route("3.", travelRouteDescription3, travelRouteTime3, travelRoutePrice3);

                    String travelRouteDescription4 = "Walk to the Kaunas Train Station";
                    String travelRouteTime4 = "12:47 - 12:48";
                    double travelRoutePrice4 = 0;
                    Route r4 = new Route("4.", travelRouteDescription4, travelRouteTime4, travelRoutePrice4);

                    String travelRouteDescription5 = "Wait for Train at Kaunas Train Station";
                    String travelRouteTime5 = "12:48 - 13:20";
                    double travelRoutePrice5 = 0;
                    Route r5 = new Route("5.", travelRouteDescription5, travelRouteTime5, travelRoutePrice5);

                    String travelRouteDescription6 = "Take the Train";
                    String travelRouteTime6 = "13:20 - 14:46";
                    double travelRoutePrice6 = 7.70;
                    Route r6 = new Route("6.", travelRouteDescription6, travelRouteTime6, travelRoutePrice6);

                    String travelRouteDescription7 = "Walk to BusStop (Stotis)";
                    String travelRouteTime7 = "14:46 - 14:48";
                    double travelRoutePrice7 = 0;
                    Route r7 = new Route("7.", travelRouteDescription7, travelRouteTime7, travelRoutePrice7);

                    String travelRouteDescription8 = "Wait at BusStop (Stotis)";
                    String travelRouteTime8 = "14:48 - 14:51";
                    double travelRoutePrice8 = 0;
                    Route r8 = new Route("8.", travelRouteDescription8, travelRouteTime8, travelRoutePrice8);

                    String travelRouteDescription9 = "Bus Nr.42 (From Stotis BusStop - To Naujininkai BusStop)";
                    String travelRouteTime9 = "14:51 - 15:00";
                    double travelRoutePrice9 = 0.65;    //BILIETO KAINA 30MIN
                    Route r9 = new Route("9.", travelRouteDescription9, travelRouteTime9, travelRoutePrice9);

                    String travelRouteDescription10 = "Wait at BusStop (Naujininkai)";
                    String travelRouteTime10 = "15:00 - 15:06";
                    double travelRoutePrice10 = 0;
                    Route r10 = new Route("10.", travelRouteDescription10, travelRouteTime10, travelRoutePrice10);

                    String travelRouteDescription11 = "Bus Nr.3G (From Naujininkai BusStop - To Oro Uostas BusStop)";
                    String travelRouteTime11 = "15:06 - 15:12";
                    double travelRoutePrice11 = 0;     //PERSĖDIMAS NEPASIBAIGUS 30MIN, TODĖL NAUJO BILIETO PIRKTI NEREIKIA
                    Route r11 = new Route("11.", travelRouteDescription11, travelRouteTime11, travelRoutePrice11);

                    String travelRouteDescription12 = "Walk to Vilnius Air Port";
                    String travelRouteTime12 = "15:12 - 15:16";
                    double travelRoutePrice12 = 0;
                    //https://goo.gl/maps/ypquq579AosmJvJN8
                    Route r12 = new Route("12.", travelRouteDescription12, travelRouteTime12, travelRoutePrice12);

                    String travelRouteDescription13 = "Wait at Vilnius Air Port";
                    String travelRouteTime13 = "15:16 - 16:20";
                    double travelRoutePrice13 = 0;
                    Route r13 = new Route("13.", travelRouteDescription13, travelRouteTime13, travelRoutePrice13);

                    String travelRouteDescription14 = "Flight";
                    String travelRouteTime14 = "4:20pm - 10:00pm (1 stop) (12h40m)";
                    double travelRoutePrice14 = 215;
                    //https://kay.ac/SGWzU3
                    Route r14 = new Route("14.", travelRouteDescription14, travelRouteTime14, travelRoutePrice14);

                    String travelRouteDescription15 = "Time from landing to exiting Air Port";
                    String travelRouteTime15 = "22:00 - 22:45";
                    double travelRoutePrice15 = 0;
                    Route r15 = new Route("15.", travelRouteDescription15, travelRouteTime15, travelRoutePrice15);

                    String travelRouteDescription16 = "Walk to JFK Terminal 8-9 (Terminal 8-9)";
                    String travelRouteTime16 = "22:45 - 23:00";
                    double travelRoutePrice16 = 0;
                    Route r16 = new Route("16.", travelRouteDescription16, travelRouteTime16, travelRoutePrice16);

                    String travelRouteDescription17 = "Train to Jamaica Station (AirTrain)";
                    String travelRouteTime17 = "23:00 - 23:10";
                    double travelRoutePrice17 = 0; //FREE
                    Route r17 = new Route("17.", travelRouteDescription17, travelRouteTime17, travelRoutePrice17);

                    String travelRouteDescription18 = "Walk to Metro Station (Sutphin Blvd - Archer Av - JFK Airport)";
                    String travelRouteTime18 = "23:10 - 23:14";
                    double travelRoutePrice18 = 0;
                    Route r18 = new Route("18.", travelRouteDescription18, travelRouteTime18, travelRoutePrice18);

                    String travelRouteDescription19 = "Wait for Metro";
                    String travelRouteTime19 = "23:14 - 23:18";
                    double travelRoutePrice19 = 0;
                    Route r19 = new Route("19.", travelRouteDescription19, travelRouteTime19, travelRoutePrice19);

                    String travelRouteDescription20 = "Metro (Sutphin Blvd - Archer Av - JFK Airport - Flushing Av)";
                    String travelRouteTime20 = "23:18 - 23:50";
                    double travelRoutePrice20 = 2.75;  //dollar
                    Route r20 = new Route("20.", travelRouteDescription20, travelRouteTime20, travelRoutePrice20);

                    String travelRouteDescription21 = "Walk to NY Moorse Hostel";
                    String travelRouteTime21 = "23:50 - 23:59";
                    double travelRoutePrice21 = 0;
                    //https://goo.gl/maps/M4B8DRv2p36webcKA
                    Route r21 = new Route("21.", travelRouteDescription21, travelRouteTime21, travelRoutePrice21);

                    String travelRouteDescription22 = "Sleep at Hostel (NY Moore Hostel)";
                    String travelRouteTime22 = "";
                    double travelRoutePrice22 = 59;
                    //https://www.google.com/travel/hotels/s/rTypDXXWxdKH4ZHK8
                    Route r22 = new Route("22.", travelRouteDescription22, travelRouteTime22, travelRoutePrice22);

                    String travelRouteDescription23 = "Walk to Morgan Av (METRO) from NY Moore Hostel";
                    String travelRouteTime23 = "12:47 - 12:54";
                    double travelRoutePrice23 = 0;
                    Route r23 = new Route("23.", travelRouteDescription23, travelRouteTime23, travelRoutePrice23);

                    String travelRouteDescription24 = "Metro (Morgan Av - 14 St / 6 Av)";
                    String travelRouteTime24 = "12:54 - 13:08";
                    double travelRoutePrice24 = 2.75;
                    Route r24 = new Route("24.", travelRouteDescription24, travelRouteTime24, travelRoutePrice24);

                    String travelRouteDescription25 = "Walk to (Metro) 14 St";
                    String travelRouteTime25 = "13:08 - 13:12";
                    double travelRoutePrice25 = 0;
                    Route r25 = new Route("25.", travelRouteDescription25, travelRouteTime25, travelRoutePrice25);

                    String travelRouteDescription26 = "Metro (14 St - South Ferry)";
                    String travelRouteTime26 = "13:12 - 13:23";
                    double travelRoutePrice26 = 2.75;
                    Route r26 = new Route("26.", travelRouteDescription26, travelRouteTime26, travelRoutePrice26);

                    String travelRouteDescription27 = "Walk to Statue of Liberty View Point from (South Ferry Terminal)";
                    String travelRouteTime27 = "13:23 - 13:26";
                    double travelRoutePrice27 = 0;
                    //https://goo.gl/maps/xVWr2vqzXNJAfBb76
                    Route r27 = new Route("27.", travelRouteDescription27, travelRouteTime27, travelRoutePrice27);

                    totalTime = "Total time: 24h 59min";
                    totalPrice = "Total price: 291.30€";
                    routeList.addAll(Arrays.asList(new Route[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27}));
                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                    String travelRouteDescription1 = "Walk to BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime1 = "13:27 - 13:30";
                    double travelRoutePrice1 = 0;
                    Route r1 = new Route("1.", travelRouteDescription1, travelRouteTime1, travelRoutePrice1);

                    String travelRouteDescription2 = "Wait at BusStop (Karaliaus Mindaugo pr.)";
                    String travelRouteTime2 = "13:30 - 13:33";
                    double travelRoutePrice2 = 0;
                    Route r2 = new Route("2.", travelRouteDescription2, travelRouteTime2, travelRoutePrice2);

                    String travelRouteDescription3 = "Bus Nr.18 (From Karaliaus Mindaugo pr. - To Gelezinkelio Stotis)";
                    String travelRouteTime3 = "13:33 - 13:51";
                    double travelRoutePrice3 = 0.70;
                    Route r3 = new Route("3.", travelRouteDescription3, travelRouteTime3, travelRoutePrice3);

                    String travelRouteDescription4 = "Walk to the Kaunas Train Station";
                    String travelRouteTime4 = "13:51 - 13:52";
                    double travelRoutePrice4 = 0;
                    Route r4 = new Route("4.", travelRouteDescription4, travelRouteTime4, travelRoutePrice4);

                    String travelRouteDescription5 = "Wait for Train at Kaunas Train Station";
                    String travelRouteTime5 = "13:52 - 14:30";
                    double travelRoutePrice5 = 0;
                    Route r5 = new Route("5.", travelRouteDescription5, travelRouteTime5, travelRoutePrice5);

                    String travelRouteDescription6 = "Take the Train";
                    String travelRouteTime6 = "14:30 - 16:47 (1 Stop)";
                    double travelRoutePrice6 = 8.50;
                    Route r6 = new Route("6.", travelRouteDescription6, travelRouteTime6, travelRoutePrice6);

                    String travelRouteDescription7= "Walk to Vilnius Air Port";
                    String travelRouteTime7 = "16:47 - 16:49";
                    double travelRoutePrice7 = 0;
                    //https://goo.gl/maps/ypquq579AosmJvJN8
                    Route r7 = new Route("7.", travelRouteDescription7, travelRouteTime7, travelRoutePrice7);

                    String travelRouteDescription8 = "Wait at Vilnius Air Port";
                    String travelRouteTime8 = "16:49 - 19:10";
                    double travelRoutePrice8 = 0;
                    Route r8 = new Route("8.", travelRouteDescription8, travelRouteTime8, travelRoutePrice8);

                    String travelRouteDescription9 = "Flight";
                    String travelRouteTime9 = "7:10pm - 2:15pm (3 stop) (58h05m)";
                    double travelRoutePrice9 = 855;
                    //https://kay.ac/Cm5drt
                    Route r9 = new Route("9.", travelRouteDescription9, travelRouteTime9, travelRoutePrice9);

                    String travelRouteDescription10 = "Time from landing to exiting Air Port";
                    String travelRouteTime10 = "14:15 - 15:00";
                    double travelRoutePrice10 = 0;
                    Route r10 = new Route("10.", travelRouteDescription10, travelRouteTime10, travelRoutePrice10);
                    //https://goo.gl/maps/arAcixeNx1kDL5t6A

                    String travelRouteDescription11 = "Walk to Sydney Airport, Terminal 3 Domestic";
                    String travelRouteTime11 = "15:00 - 15:03";
                    double travelRoutePrice11 = 0;
                    Route r11 = new Route("11.", travelRouteDescription11, travelRouteTime11, travelRoutePrice11);

                    String travelRouteDescription12 = "Bus Nr.350 (From Sydney Airport, Terminal 3 Domestic - To Mascot Station, Coward St, Stand A)";
                    String travelRouteTime12 = "15:03 - 15:08";
                    double travelRoutePrice12 = 3.93;
                    Route r12 = new Route("12.", travelRouteDescription12, travelRouteTime12, travelRoutePrice12);

                    String travelRouteDescription13 = "Walk to BusStop (Bourke St at Church Ave)";
                    String travelRouteTime13 = "15:08 - 15:12";
                    double travelRoutePrice13 = 0;
                    Route r13 = new Route("13.", travelRouteDescription13, travelRouteTime13, travelRoutePrice13);

                    String travelRouteDescription14 = "Wait at BusStop (Bourke St at Church Ave)";
                    String travelRouteTime14 = "15:12 - 15:16";
                    double travelRoutePrice14 = 0;
                    Route r14 = new Route("14.", travelRouteDescription14, travelRouteTime14, travelRoutePrice14);

                    String travelRouteDescription15 = "Bus Nr.358 (From Bourke St at Church Ave - To Gardeners Rd at Dunning Ave)";
                    String travelRouteTime15 = "15:16 - 15:23";
                    double travelRoutePrice15 = 3.20;
                    Route r15 = new Route("15.", travelRouteDescription15, travelRouteTime15, travelRoutePrice15);

                    String travelRouteDescription16 = "Walk to BusStop (Dunning Ave after Gardeners Rd)";
                    String travelRouteTime16 = "15:23 - 15:24";
                    double travelRoutePrice16 = 0;
                    //https://goo.gl/maps/M4B8DRv2p36webcKA
                    Route r16 = new Route("16.", travelRouteDescription16, travelRouteTime16, travelRoutePrice16);

                    String travelRouteDescription17 = "Wait at BusStop (Dunning Ave after Gardeners Rd)";
                    String travelRouteTime17 = "15:24 - 15:29";
                    double travelRoutePrice17 = 0;
                    //https://www.google.com/travel/hotels/s/rTypDXXWxdKH4ZHK8
                    Route r17 = new Route("17.", travelRouteDescription17, travelRouteTime17, travelRoutePrice17);

                    String travelRouteDescription18 = "Bus Nr.343 (From Dunning Ave after Gardeners Rd - To Museum of Sydney, Phillip St)";
                    String travelRouteTime18 = "15:29 - 16:02";
                    double travelRoutePrice18 = 5.05;
                    Route r18 = new Route("18.", travelRouteDescription18, travelRouteTime18, travelRoutePrice18);

                    String travelRouteDescription19 = "Walk to Sydney Opera House";
                    String travelRouteTime19 = "16:02 - 16:12";
                    double travelRoutePrice19 = 0;
                    Route r19 = new Route("19.", travelRouteDescription19, travelRouteTime19, travelRoutePrice19);

                    totalTime = "Total time: 65h 45min";
                    totalPrice = "Total price: 876.38€";
                    routeList.addAll(Arrays.asList(new Route[]{ r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19 }));
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
                    String travelRouteDescription1 = "Wait at Muitinės g. 8 for Bolt";
                    String travelRouteTime1 = "12:27 - 12:28";
                    double travelRoutePrice1 = 0;
                    Route r1 = new Route("1.", travelRouteDescription1, travelRouteTime1, travelRoutePrice1);

                    String travelRouteDescription2 = "Drive with Bolt from Muitines g. 8 - to Vilnius Air Port";
                    String travelRouteTime2 = "12:28 - 13:40";
                    double travelRoutePrice2 = 75.40;
                    Route r2 = new Route("2.", travelRouteDescription2, travelRouteTime2, travelRoutePrice2);

                    String travelRouteDescription3 = "Walk to the Vilnius Air Port";
                    String travelRouteTime3 = "13:40 - 13:43";
                    double travelRoutePrice3 = 0;
                    Route r3 = new Route("3.", travelRouteDescription3, travelRouteTime3, travelRoutePrice3);

                    String travelRouteDescription4 = "Wait at Vilnius Air Port";
                    String travelRouteTime4 = "13:43 - 14:50";
                    double travelRoutePrice4 = 0;
                    Route r4 = new Route("4.", travelRouteDescription4, travelRouteTime4, travelRoutePrice4);

                    String travelRouteDescription5 = "Flight";
                    String travelRouteTime5 = "2:50pm - 8:25pm (1 stop) (12h35m)";
                    double travelRoutePrice5 = 772;
                    //https://kay.ac/XlaKux
                    Route r5 = new Route("5.", travelRouteDescription5, travelRouteTime5, travelRoutePrice5);

                    String travelRouteDescription6 = "Time from landing to exiting Air Port";
                    String travelRouteTime6 = "20:25 - 21:00";
                    double travelRoutePrice6 = 0;
                    Route r6 = new Route("6.", travelRouteDescription6, travelRouteTime6, travelRoutePrice6);

                    String travelRouteDescription7 = "Wait for Taxi";
                    String travelRouteTime7 = "21:00 - 21:10";
                    double travelRoutePrice7 = 0;
                    Route r7 = new Route("7.", travelRouteDescription7, travelRouteTime7, travelRoutePrice7);

                    String travelRouteDescription8 = "Take taxi to Statue Of Liberty View Point";
                    String travelRouteTime8 = "21:10 - 21:52";
                    double travelRoutePrice8 = 57.82;
                    Route r8 = new Route("8.", travelRouteDescription8, travelRouteTime8, travelRoutePrice8);

                    String travelRouteDescription9 = "Walk to Statue of Liberty View Point";
                    String travelRouteTime9 = "21:52 - 21:54";
                    double travelRoutePrice9 = 0;
                    //https://goo.gl/maps/xVWr2vqzXNJAfBb76
                    Route r9 = new Route("9.", travelRouteDescription9, travelRouteTime9, travelRoutePrice9);

                    totalTime = "Total time: 9h 27min";
                    totalPrice = "Total price: 905.22€";
                    routeList.addAll(Arrays.asList(new Route[]{ r1, r2, r3, r4, r5, r6, r7, r8, r9 }));
                }
                else if (destination.equals(stringArrayElement[2])) { // [2] Australia, Sydney, Bennelong Point (Sydney Opera House)
                    String travelRouteDescription1 = "Wait at Muitinės g. 8 for Bolt";
                    String travelRouteTime1 = "05:26 - 05:30";
                    double travelRoutePrice1 = 0;
                    Route r1 = new Route("1.", travelRouteDescription1, travelRouteTime1, travelRoutePrice1);

                    String travelRouteDescription2 = "Drive with Bolt from Muitines g. 8 - to Vilnius Air Port";
                    String travelRouteTime2 = "05:30 - 06:47";
                    double travelRoutePrice2 = 75.40;
                    Route r2 = new Route("2.", travelRouteDescription2, travelRouteTime2, travelRoutePrice2);

                    String travelRouteDescription3 = "Walk to the Vilnius Air Port";
                    String travelRouteTime3 = "06:47 - 06:50";
                    double travelRoutePrice3 = 0;
                    Route r3 = new Route("3.", travelRouteDescription3, travelRouteTime3, travelRoutePrice3);

                    String travelRouteDescription4 = "Wait at Vilnius Air Port";
                    String travelRouteTime4 = "06:50 - 07:50";
                    double travelRoutePrice4 = 0;
                    Route r4 = new Route("4.", travelRouteDescription4, travelRouteTime4, travelRoutePrice4);

                    String travelRouteDescription5 = "Flight";
                    String travelRouteTime5 = "7:50am - 5:55pm (2 stop) (25h05m)";
                    double travelRoutePrice5 = 2074;
                    //https://kay.ac/LQ6jed
                    Route r5 = new Route("5.", travelRouteDescription5, travelRouteTime5, travelRoutePrice5);

                    String travelRouteDescription6 = "Time from landing to exiting Air Port";
                    String travelRouteTime6 = "17:55 - 19:00";
                    double travelRoutePrice6 = 0;
                    Route r6 = new Route("6.", travelRouteDescription6, travelRouteTime6, travelRoutePrice6);
                    //https://goo.gl/maps/arAcixeNx1kDL5t6A

                    String travelRouteDescription7 = "Wait for Taxi";
                    String travelRouteTime7 = "19:00 - 19:10";
                    double travelRoutePrice7 = 0;
                    Route r7 = new Route("7.", travelRouteDescription7, travelRouteTime7, travelRoutePrice7);

                    String travelRouteDescription8 = "Take taxi to Sydney Opera House";
                    String travelRouteTime8 = "19:10 - 19:32";
                    double travelRoutePrice8 = 42.75;
                    Route r8 = new Route("8.", travelRouteDescription8, travelRouteTime8, travelRoutePrice8);

                    String travelRouteDescription9 = "Walk to Sydney Opera House";
                    String travelRouteTime9 = "19:32 - 19:37";
                    double travelRoutePrice9 = 0;
                    Route r9 = new Route("9.", travelRouteDescription9, travelRouteTime9, travelRoutePrice9);

                    totalTime = "Total time: 29h 11min";
                    totalPrice = "Total price: 2192.15€";
                    routeList.addAll(Arrays.asList(new Route[]{ r1, r2, r3, r4, r5, r6, r7, r8, r9 }));
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