package com.ebtesam.iutbloodaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView lastdate,eligibile;
    private Button date;
    private EditText d,m,yy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilr);
        d=findViewById(R.id.dd);
        m=findViewById(R.id.mm);
        yy=findViewById(R.id.yyyy);
        lastdate=findViewById(R.id.lastd);
        eligibile=findViewById(R.id.eligiblity);
        date=findViewById(R.id.button);
        date.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            lastDonation();
        }

    }

    private void lastDonation(){
        Calendar.getInstance().getTime();
        String dayy=d.getText().toString();
        int day=Integer.parseInt(dayy);
        String monthh=m.getText().toString();
        int month=Integer.parseInt(monthh);
        String yearr=yy.getText().toString();
        int year=Integer.parseInt(yearr);

        long time= System.currentTimeMillis();

        long ldod=year*365+month*30+day;
        long ldodms=86400000*ldod;
        long elig=time-ldodms;
        long wp=56*86400000;
        if(elig<wp){
            eligibile.setText("You are not eligible to donate");
        }
        else{
            eligibile.setText("You are eligible to donate");
        }
        lastdate.setText("Last Donated On"+d+"/"+m+"/"+yy);

    }
}
