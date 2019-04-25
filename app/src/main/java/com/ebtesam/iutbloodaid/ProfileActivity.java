package com.ebtesam.iutbloodaid;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDateTime;
import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView lastdate, eligibile;
    private Button date;
    private EditText d, m, yy;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference donorReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilr);
        d = findViewById(R.id.dd);
        m = findViewById(R.id.mm);
        yy = findViewById(R.id.yyyy);
        lastdate = findViewById(R.id.lastd);
        eligibile = findViewById(R.id.eligiblity);
        date = findViewById(R.id.button);
        date.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            lastDonation();
        }

    }

    private void lastDonation() {
        Calendar.getInstance().getTime();
        String dayy = d.getText().toString();
        int day = Integer.parseInt(dayy);
        String monthh = m.getText().toString();
        int month = Integer.parseInt(monthh);
        String yearr = yy.getText().toString();
        int year = Integer.parseInt(yearr);

        long time = System.currentTimeMillis();
        LocalDateTime now = LocalDateTime.now();
        int cyear = now.getYear();
        int cmonth = now.getMonthValue();
        int cday = now.getDayOfMonth();
        long ctime = cyear * 365 + cmonth * 30 + cday;

        long ldod = year * 365 + month * 30 + day;
        long elig = ctime - ldod;
        long wp = 56;
        String eligg = Long.toString(elig);
        int x;
        if (elig < wp) {
            x=0;
            setEligibility(x);
            eligibile.setText("You are not eligible to donate");
        } else {
            x=1;
            setEligibility(x);
            eligibile.setText("You are eligible to donate");
        }
        lastdate.setText("Last Donated On " + dayy + "/" + monthh + "/" + yearr);

    }

    private void setEligibility(int e){
        final int ed=e;
        mAuth = FirebaseAuth.getInstance();
        String userId = user.getUid();
        donorReference = FirebaseDatabase.getInstance().getReference().child("Donors/A+");
        donorReference.orderByChild("userId").equalTo(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.d("User key", child.getKey());
                    String key=child.getKey();

                    Log.d("User ID",key);
                    DatabaseReference updateData = FirebaseDatabase.getInstance().getReference("Donors/A+/").child(key);
                    if(ed==0)
                    updateData.child("eligibility").setValue("not eligible");
                    else if(ed==1)
                        updateData.child("eligibility").setValue("eligible");


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}