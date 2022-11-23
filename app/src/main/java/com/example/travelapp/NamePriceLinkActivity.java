package com.example.travelapp;

import android.os.Parcel;
import android.os.Parcelable;

public class NamePriceLinkActivity implements Parcelable {
    private String id2;
    private String name2;
    private String price2;
    private String link2;

    public NamePriceLinkActivity(String id2, String name2, String price2, String link2) {
        this.id2 = id2;
        this.name2 = name2;
        this.price2 = price2;
        this.link2 = link2;
    }

    protected NamePriceLinkActivity(Parcel in) {
        id2 = in.readString();
        name2 = in.readString();
        price2 = in.readString();
        link2 = in.readString();
    }

    public static final Creator<NamePriceLinkActivity> CREATOR = new Creator<NamePriceLinkActivity>() {
        @Override
        public NamePriceLinkActivity createFromParcel(Parcel in) {
            return new NamePriceLinkActivity(in);
        }

        @Override
        public NamePriceLinkActivity[] newArray(int size) {
            return new NamePriceLinkActivity[size];
        }
    };

    public String getId2() {
        return id2;
    }

    public String getName2() {
        return name2;
    }

    public String getPrice2() {
        return price2;
    }

    public String getLink2() {
        return link2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id2);
        parcel.writeString(name2);
        parcel.writeString(price2);
        parcel.writeString(link2);
    }
}
