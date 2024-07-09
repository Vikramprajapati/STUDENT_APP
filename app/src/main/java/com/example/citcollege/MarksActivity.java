package com.example.citcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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

public class MarksActivity extends AppCompatActivity {
    RecyclerView showMarksRecycler;

    ArrayList<MarksData> marks;
    MarksAdapter adapter;

    DatabaseReference reference1;
    ProgressDialog pd1;
    private static final String TAG = "MarksActivity";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);

        showMarksRecycler=findViewById(R.id.showMarksRecycler);



        pd1=new ProgressDialog(this);
        reference1= FirebaseDatabase.getInstance().getReference().child("Marks");
        showMarksRecycler.setLayoutManager(new LinearLayoutManager(this));
        showMarksRecycler.setHasFixedSize(true);


        getMarks();

            }
    private void getMarks() {
        pd1.setTitle("Please wait...");
        pd1.setMessage("Marks Loading...");
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
                adapter=new MarksAdapter(MarksActivity.this,marks);
                adapter.notifyDataSetChanged();

                showMarksRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                pd1.dismiss();
                Toast.makeText(MarksActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e(TAG, "DatabaseError: " + error.getMessage());

            }
        });
    }

        }