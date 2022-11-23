package com.example.travelapp;

import android.os.Parcel;
import android.os.Parcelable;

public class NameTimeActivity implements Parcelable {
    private String id3;
    private String name3;
    private String time3;

    public NameTimeActivity(String id3, String name3, String time3) {
        this.id3 = id3;
        this.name3 = name3;
        this.time3 = time3;
    }

    protected NameTimeActivity(Parcel in) {
        id3 = in.readString();
        name3 = in.readString();
        time3 = in.readString();
    }

    public static final Creator<NameTimeActivity> CREATOR = new Creator<NameTimeActivity>() {
        @Override
        public NameTimeActivity createFromParcel(Parcel in) {
            return new NameTimeActivity(in);
        }

        @Override
        public NameTimeActivity[] newArray(int size) {
            return new NameTimeActivity[size];
        }
    };

    public String getId3() {
        return id3;
    }

    public String getName3() {
        return name3;
    }

    public String getTime3() {
        return time3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id3);
        parcel.writeString(name3);
        parcel.writeString(time3);
    }
}