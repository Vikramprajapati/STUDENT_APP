package com.example.citcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {


    RecyclerView showNoticeRecycler;

    ArrayList<NoticeData> list;
    NoticeAdapter adapter;

    DatabaseReference reference;
    ProgressDialog pd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);



        showNoticeRecycler=findViewById(R.id.showNoticeRecycler);

        pd=new ProgressDialog(this);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");

        showNoticeRecycler.setLayoutManager(new LinearLayoutManager(this));
        showNoticeRecycler.setHasFixedSize(true);

        getNotice();
    }

    private void getNotice() {
        pd.setTitle("Please wait...");
        pd.setMessage("Notice Loading...");
        pd.show();
        reference.addValueEventListener(new ValueEventListener() {


            //add data into list
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot dataSnapshot :snapshot.getChildren()){
                    NoticeData data=dataSnapshot.getValue(NoticeData.class);
                    list.add(0,data);
                }
                pd.dismiss();
                adapter=new NoticeAdapter(NoticeActivity.this,list);
                adapter.notifyDataSetChanged();



                showNoticeRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                pd.dismiss();
                Toast.makeText(NoticeActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}