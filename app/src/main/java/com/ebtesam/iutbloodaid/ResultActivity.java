package com.ebtesam.iutbloodaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private DatabaseReference donorReference;
    ArrayList<Donor> listOfDonors;

    private RecyclerView recyclerView;
    private EditText editText;
    private DonorAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listOfDonors = new ArrayList<Donor>();
        editText = findViewById(R.id.editText);
        editText.setText("");
        recyclerView = findViewById(R.id.result_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        String bgp = getIntent().getStringExtra("bloodgp");

        donorReference = FirebaseDatabase.getInstance().getReference().child("Donors").child(bgp);
        donorReference.keepSynced(true);
        donorReference
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Donor donor = snapshot.getValue(Donor.class);
                            editText.setText(donor.getName() + " " + editText.getText());
                            listOfDonors.add(donor);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

        recyclerView.setAdapter(new DonorAdapter(getApplicationContext(), listOfDonors));
    }
}