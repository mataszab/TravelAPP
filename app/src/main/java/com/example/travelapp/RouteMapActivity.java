package com.example.travelapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class RouteMapActivity implements Parcelable {
    private int imgViewMap;

    public RouteMapActivity(int imgViewMap) {
        this.imgViewMap = imgViewMap;
    }

    protected RouteMapActivity(Parcel in) {
        imgViewMap = in.readInt();
    }

    public static final Creator<RouteMapActivity> CREATOR = new Creator<RouteMapActivity>() {
        @Override
        public RouteMapActivity createFromParcel(Parcel in) {
            return new RouteMapActivity(in);
        }

        @Override
        public RouteMapActivity[] newArray(int size) {
            return new RouteMapActivity[size];
        }
    };

    public int getImgViewMap() {
        return imgViewMap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgViewMap);
    }
}
