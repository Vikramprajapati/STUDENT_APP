package com.example.citcollege;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.example.citcollege.ui.GalleryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {


    RecyclerView convoRecycler,tarunyaRecycler,lakshyaRecycler,inRecycler,republicRecycler,campusRecycler,othersRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    List<ImageData> list1,list2,list3,list4,list5,list6,list7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        convoRecycler=findViewById(R.id.convoRecycler);
        tarunyaRecycler=findViewById(R.id.tarunyaRecycler);
        lakshyaRecycler=findViewById(R.id.lakshyaRecycler);
        inRecycler=findViewById(R.id.inRecycler);
        republicRecycler=findViewById(R.id.republicRecycler);
        campusRecycler=findViewById(R.id.campusRecycler);
        othersRecycler=findViewById(R.id.othersRecycler);


        reference= FirebaseDatabase.getInstance().getReference().child("Gallery");


        getConvoImage();
        getTarunyaImage();
        getLakshyaImage();
        getIndependenecImage();
        getRepublicImage();
        getCampusImage();
        getOtherImage();


    }

    private void getOtherImage() {

        reference.child("Others");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list1.add(data);
                }
                othersRecycler.setHasFixedSize(true);
                othersRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list1);
                othersRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCampusImage() {
        reference.child("CIT Campus");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list2.add(data);
                }
                campusRecycler.setHasFixedSize(true);
                campusRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list2);
                campusRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getRepublicImage() {
        reference.child("Republic Day");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list3.add(data);
                }
                republicRecycler.setHasFixedSize(true);
                republicRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list3);
                republicRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getIndependenecImage() {
        reference.child("Independence Day");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list4.add(data);
                }
                inRecycler.setHasFixedSize(true);
                inRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list4);
                inRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getLakshyaImage() {
        reference.child("Lakshya");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list5.add(data);
                }
                lakshyaRecycler.setHasFixedSize(true);
                lakshyaRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list5);
                lakshyaRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getTarunyaImage() {
        reference.child("Tarunya");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list6.add(data);
                }
                tarunyaRecycler.setHasFixedSize(true);
                tarunyaRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list6);
                tarunyaRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getConvoImage() {
        reference.child("Convocation");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ImageData data = dataSnapshot.getValue(ImageData.class);
                    list7.add(data);
                }
                convoRecycler.setHasFixedSize(true);
                convoRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this,3));
                adapter=new GalleryAdapter(GalleryActivity.this,list7);
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GalleryActivity.this,"Something Went Wron",Toast.LENGTH_SHORT).show();
            }
        });

    }
}