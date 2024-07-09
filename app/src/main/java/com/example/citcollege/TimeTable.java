package com.example.citcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TimeTable extends AppCompatActivity {
    RecyclerView showTimeTableRecycler;

    ArrayList<MarksData> marks;
    MarksAdapter adapter;

    DatabaseReference reference1;
    ProgressDialog pd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        showTimeTableRecycler=findViewById(R.id.showTimeTableRecycler);



        pd1=new ProgressDialog(this);
        reference1= FirebaseDatabase.getInstance().getReference().child("Time-Table");
        showTimeTableRecycler.setLayoutManager(new LinearLayoutManager(this));
        showTimeTableRecycler.setHasFixedSize(true);


        getTimeTable();
    }
    private void getTimeTable() {
        pd1.setTitle("Please wait...");
        pd1.setMessage("Time Table Loading...");
        pd1.show();
        reference1.addValueEventListener(new ValueEventListener() {


            //add data into list
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                marks=new ArrayList<>();
                for(DataSnapshot dataSnapshot :snapshot.getChildren()){
                    MarksData data=dataSnapshot.getValue(MarksData.class);
                    marks.add(0, data);

                }
                pd1.dismiss();
                adapter=new MarksAdapter(TimeTable.this,marks);
                adapter.notifyDataSetChanged();

                showTimeTableRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                pd1.dismiss();
                Toast.makeText(TimeTable.this,error.getMessage(),Toast.LENGTH_SHORT).show();
//                Log.e(TAG, "DatabaseError: " + error.getMessage());

            }
        });
    }
}