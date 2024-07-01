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
     //   getTarunyaImage();
       // getLakshyaImage();
      //  getIndependenecImage();
      //  getRepublicImage();
      //  getCampusImage();
      //  getOtherImage();


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