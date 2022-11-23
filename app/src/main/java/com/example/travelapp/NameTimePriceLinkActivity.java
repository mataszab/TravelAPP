package com.example.travelapp;

import android.os.Parcel;
import android.os.Parcelable;

public class NameTimePriceLinkActivity implements Parcelable {
    private String id1;
    private String name1;
    private String time1;
    private String price1;
    private String link1;

    public NameTimePriceLinkActivity(String id1, String name1, String time1, String price1, String link1) {
        this.id1 = id1;
        this.name1 = name1;
        this.time1 = time1;
        this.price1 = price1;
        this.link1 = link1;
    }

    protected NameTimePriceLinkActivity(Parcel in) {
        id1 = in.readString();
        name1 = in.readString();
        time1 = in.readString();
        price1 = in.readString();
        link1 = in.readString();
    }

    public static final Creator<NameTimePriceLinkActivity> CREATOR = new Creator<NameTimePriceLinkActivity>() {
        @Override
        public NameTimePriceLinkActivity createFromParcel(Parcel in) {
            return new NameTimePriceLinkActivity(in);
        }

        @Override
        public NameTimePriceLinkActivity[] newArray(int size) {
            return new NameTimePriceLinkActivity[size];
        }
    };

    public String getId1() {
        return id1;
    }

    public String getName1() {
        return name1;
    }

    public String getTime1() {
        return time1;
    }

    public String getPrice1() {
        return price1;
    }

    public String getLink1() {
        return link1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id1);
        parcel.writeString(name1);
        parcel.writeString(time1);
        parcel.writeString(price1);
        parcel.writeString(link1);
    }
}
