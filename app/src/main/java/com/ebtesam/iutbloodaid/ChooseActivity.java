package com.ebtesam.iutbloodaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {
    String email,password,name;
    ImageButton findDonor,donorProfile,regDonor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        this.setTitle("Choose Your Action");
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            email=bundle.getString("email");
            name=bundle.getString("name");
            password=bundle.getString("pass");
        }
        findDonor=findViewById(R.id.findDonor);
        donorProfile=findViewById(R.id.donorProfile);
        regDonor=findViewById(R.id.regDonor);


        findDonor.setOnClickListener(this);
        donorProfile.setOnClickListener(this);
        regDonor.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findDonor:
                Intent intent = new Intent(getApplicationContext(),ChooseActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("name",name);
                startActivity(intent);

                break;

            case R.id.donorProfile:


                break;

            case R.id.regDonor:
                Intent intent2 = new Intent(getApplicationContext(),DonorReg.class);
                intent2.putExtra("email",email);
                intent2.putExtra("pass",password);
                startActivity(intent2);

                break;



        }



    }
}
