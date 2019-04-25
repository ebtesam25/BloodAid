package com.ebtesam.iutbloodaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton findDonor,donorProfile,regDonor;
    public static String dacc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

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
               /* Intent intent = new Intent(getApplicationContext(),ChooseActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("name",name);
                startActivity(intent);*/

                break;

            case R.id.donorProfile:

            Intent profileIntent=new Intent(ChooseActivity.this,ProfileActivity.class);
            startActivity(profileIntent);
                break;

            case R.id.regDonor:
              //  Toast.makeText(ChooseActivity.this,"And crash!",Toast.LENGTH_LONG).show();

                        Toast.makeText(ChooseActivity.this,"You have already registered",Toast.LENGTH_LONG).show();

                        Intent intent2 = new Intent(ChooseActivity.this, DonorReg.class);
                        startActivity(intent2);





                break;



        }



    }
}
