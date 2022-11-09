package com.example.travelapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Route implements Parcelable {
    private String id;
    private String name;
    private String time;
    private double price;

    public Route(String id, String name, String time, double price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    protected Route(Parcel in) {
//        id = in.readInt();
        id = in.readString();
        name = in.readString();
        time = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Route> CREATOR = new Creator<Route>() {
        @Override
        public Route createFromParcel(Parcel in) {
            return new Route(in);
        }

        @Override
        public Route[] newArray(int size) {
            return new Route[size];
        }
    };

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(time);
        parcel.writeDouble(price);
    }
}
