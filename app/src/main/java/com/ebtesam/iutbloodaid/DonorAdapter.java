package com.ebtesam.iutbloodaid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorHolder> {
    private Context context;
    private ArrayList<Donor> donors;

    public static class DonorHolder extends RecyclerView.ViewHolder {

        TextView name, bgp;

        public DonorHolder(View itemView) {
            super(itemView);
            bgp = (TextView) itemView.findViewById(R.id.receive_single_bloodgp);
            name = (TextView) itemView.findViewById(R.id.receive_single_name);
        }
    }
    public DonorAdapter(Context context, ArrayList<Donor> donors) {
        this.donors = donors;
        this.context = context;
    }

    @Override
    public DonorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_donor_adapter, parent, false);

        //     view.setOnClickListener(MainActivity.myOnClickListener);

        DonorHolder myViewHolder = new DonorHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final DonorHolder myViewHolder, final int listPosition) {

        TextView bloodgpView = myViewHolder.bgp;
        TextView nameView = myViewHolder.name;



        String nameofdonor = donors.get(listPosition).getName();
        String blood = donors.get(listPosition).getBg();


        bloodgpView.setText(blood);
        nameView.setText(nameofdonor);

    }
    @Override
    public int getItemCount() {
        return donors.size();
    }
}
