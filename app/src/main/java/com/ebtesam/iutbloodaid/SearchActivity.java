package com.ebtesam.iutbloodaid;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

/*public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    String email,password;
    String bg[];
    String bldgrp={"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};;
    Spinner bgroup;
    Button searchb;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            email=bundle.getString("email");
            password=bundle.getString("pass");
        }
        bg=getResources().getStringArray(R.array.blood_groups);

        bgroup=findViewById(R.id.bg);
        searchb=findViewById(R.id.searchbtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_custom,R.id.custom_spinner,bg);
        bgroup.setAdapter(adapter);

        bgroup.setOnItemSelectedListener(this);




    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bg){
            bldgrp=spinner.getSelectedItem().toString();
            search(bldgrp);
        }
    }
    /*private void search(){
        Query q=mDatabase.orderByChild("name");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren())
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })
    }
}*/
