package com.example.travelapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    private Context context;
    private List list;

    public Adapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof NameTimePriceLinkActivity) {
            return 0;
        }
        else if (list.get(position) instanceof NamePriceLinkActivity) {
            return 1;
        }
        else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i) {
            case 0:
                View view0 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.name_time_price_link_layout, viewGroup, false);
                NameTimePriceLinkActivityHolder holder0 = new NameTimePriceLinkActivityHolder(view0);
                return holder0;
            case 1:
                View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.name_price_link_layout, viewGroup, false);
                NamePriceLinkActivityHolder holder1 = new NamePriceLinkActivityHolder(view1);
                return holder1;
            case 2:
                View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.name_time_layout, viewGroup, false);
                NameTimeActivityHolder holder2 = new NameTimeActivityHolder(view2);
                return holder2;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 0) {
            NameTimePriceLinkActivity nameTimePriceLinkActivity = (NameTimePriceLinkActivity) list.get(i);
            NameTimePriceLinkActivityHolder holder0 = (NameTimePriceLinkActivityHolder) viewHolder;
            holder0.tvId1.setText(nameTimePriceLinkActivity.getId1());
            holder0.tvName1.setText(nameTimePriceLinkActivity.getName1());
            holder0.tvTime1.setText(nameTimePriceLinkActivity.getTime1());
            holder0.tvPrice1.setText(nameTimePriceLinkActivity.getPrice1());
            holder0.tvLink1.setText(nameTimePriceLinkActivity.getLink1());
        }
        else if (getItemViewType(i) == 1) {
            NamePriceLinkActivity namePriceLinkActivity = (NamePriceLinkActivity) list.get(i);
            NamePriceLinkActivityHolder holder1 = (NamePriceLinkActivityHolder) viewHolder;
            holder1.tvId2.setText(namePriceLinkActivity.getId2());
            holder1.tvName2.setText(namePriceLinkActivity.getName2());
            holder1.tvPrice2.setText(namePriceLinkActivity.getPrice2());
            holder1.tvLink2.setText(namePriceLinkActivity.getLink2());
        }
        else {
            NameTimeActivity nameTimeActivity = (NameTimeActivity) list.get(i);
            NameTimeActivityHolder holder2 = (NameTimeActivityHolder) viewHolder;
            holder2.tvId3.setText(nameTimeActivity.getId3());
            holder2.tvName3.setText(nameTimeActivity.getName3());
            holder2.tvTime3.setText(nameTimeActivity.getTime3());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class NameTimePriceLinkActivityHolder extends RecyclerView.ViewHolder {

        private TextView tvId1;
        private TextView tvName1;
        private TextView tvTime1;
        private TextView tvPrice1;
        private TextView tvLink1;

        public NameTimePriceLinkActivityHolder(@NonNull View itemView) {
            super(itemView);
            tvId1 = (TextView) itemView.findViewById(R.id.tvID1);
            tvName1 = (TextView) itemView.findViewById(R.id.tvName1);
            tvTime1 = (TextView) itemView.findViewById(R.id.tvTime1);
            tvPrice1 = (TextView) itemView.findViewById(R.id.tvPrice1);
            tvLink1 = (TextView) itemView.findViewById(R.id.tvLink1);
        }
    }

    static class NamePriceLinkActivityHolder extends RecyclerView.ViewHolder {

        private TextView tvId2;
        private TextView tvName2;
        private TextView tvPrice2;
        private TextView tvLink2;

        public NamePriceLinkActivityHolder(@NonNull View itemView) {
            super(itemView);
            tvId2 = (TextView) itemView.findViewById(R.id.tvID2);
            tvName2 = (TextView) itemView.findViewById(R.id.tvName2);
            tvPrice2 = (TextView) itemView.findViewById(R.id.tvPrice2);
            tvLink2 = (TextView) itemView.findViewById(R.id.tvLink2);
        }
    }

    static class NameTimeActivityHolder extends RecyclerView.ViewHolder {

        private TextView tvId3;
        private TextView tvName3;
        private TextView tvTime3;

        public NameTimeActivityHolder(@NonNull View itemView) {
            super(itemView);
            tvId3 = (TextView) itemView.findViewById(R.id.tvID3);
            tvName3 = (TextView) itemView.findViewById(R.id.tvName3);
            tvTime3 = (TextView) itemView.findViewById(R.id.tvTime3);
        }
    }
}
