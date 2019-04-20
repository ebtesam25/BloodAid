package com.ebtesam.iutbloodaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WaitApproval extends AppCompatActivity implements View.OnClickListener {
    String email,password;
    ImageButton imgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_approval);
        this.setTitle("Terms and Conditions");
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            email=bundle.getString("email");
            password=bundle.getString("pass");
        }
        imgButton=findViewById(R.id.okay);

        imgButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.okay){
            Intent intent = new Intent(getApplicationContext(),DonorReg.class);
            intent.putExtra("email",email);
            intent.putExtra("pass",password);
            startActivity(intent);

        }
    }
}
