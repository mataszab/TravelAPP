package com.example.travelapp;

import android.os.Parcel;
import android.os.Parcelable;

public class TravelPointsAdActivity implements Parcelable {
    private int imgViewStar;
    private String tvAd;

    public TravelPointsAdActivity(int imgViewStar, String tvAd) {
        this.imgViewStar = imgViewStar;
        this.tvAd = tvAd;
    }

    protected TravelPointsAdActivity(Parcel in) {
        imgViewStar = in.readInt();
        tvAd = in.readString();
    }

    public static final Creator<TravelPointsAdActivity> CREATOR = new Creator<TravelPointsAdActivity>() {
        @Override
        public TravelPointsAdActivity createFromParcel(Parcel in) {
            return new TravelPointsAdActivity(in);
        }

        @Override
        public TravelPointsAdActivity[] newArray(int size) {
            return new TravelPointsAdActivity[size];
        }
    };

    public int getImgViewStar() {
        return imgViewStar;
    }

    public String getTvAd() {
        return tvAd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgViewStar);
        parcel.writeString(tvAd);
    }
}
