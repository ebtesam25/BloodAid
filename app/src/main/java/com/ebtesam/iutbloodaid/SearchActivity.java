package com.ebtesam.iutbloodaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    String email,password;
    String bg[];
    String bldgrp;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.setTitle("Search For Blood");
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            email=bundle.getString("email");
            password=bundle.getString("pass");
        }
        bg=getResources().getStringArray(R.array.blood_groups);

        spinner=findViewById(R.id.bg);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_custom,R.id.custom_spinner,bg);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);




    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bg){
            bldgrp=spinner.getSelectedItem().toString();
        }
    }
}
