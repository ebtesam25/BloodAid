package com.ebtesam.iutbloodaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class DonorReg extends AppCompatActivity implements View.OnClickListener {
    String email,password;
    String bg[];
    EditText sidText,nameText,contactText;
    ImageButton img;
    Spinner spinner;
    String name,sid,phone,bldgrp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_reg);
        this.setTitle("Donor Registration");
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            email=bundle.getString("email");
            password=bundle.getString("pass");
        }
        bg=getResources().getStringArray(R.array.blood_groups);

        spinner=findViewById(R.id.bg);
        sidText=findViewById(R.id.sid);
        nameText=findViewById(R.id.name);
        contactText=findViewById(R.id.phone);
        img=findViewById(R.id.imageButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_custom,R.id.custom_spinner,bg);
        spinner.setAdapter(adapter);

        spinner.setOnClickListener(this);
        sidText.setOnClickListener(this);
        nameText.setOnClickListener(this);
        contactText.setOnClickListener(this);
        img.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageButton){
            name=nameText.getText().toString();
            sid=sidText.getText().toString();
            phone=contactText.getText().toString();
            bldgrp=spinner.getSelectedItem().toString();

            if(name.isEmpty()){
                nameText.setError("Enter your name");
                nameText.requestFocus();
                return;
            }
            if(sid.isEmpty()){
                sidText.setError("Enter your IUT student ID");
                sidText.requestFocus();
                return;
            }
            if(phone.isEmpty()){
                contactText.setError("Enter your contact number");
                contactText.requestFocus();
                return;
            }



            Intent intent2 = new Intent(getApplicationContext(),ChooseActivity.class);
            intent2.putExtra("email",email);
            intent2.putExtra("pass",password);
            startActivity(intent2);


        }
    }
}
