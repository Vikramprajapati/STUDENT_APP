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
import java.util.List;

public class PdfActivity extends AppCompatActivity {

    RecyclerView pdfrecycler;
    DatabaseReference reference;
    List<PdfData> list;
    PdfAdapter adapter;
    ProgressDialog pd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfrecycler=findViewById(R.id.PdfRecycler);
        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        pd=new ProgressDialog(this);

        getData();

    }

    private void getData() {
        pd.setTitle("Please wait...");
        pd.setMessage("Pdf Loading...");
        pd.show();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    PdfData pdfData=dataSnapshot.getValue(PdfData.class);
                    list.add(pdfData);
                }
                pd.dismiss();
                adapter=new PdfAdapter(PdfActivity.this,list);
                pdfrecycler.setLayoutManager(new LinearLayoutManager(PdfActivity.this));
                pdfrecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                pd.dismiss();
                Toast.makeText(PdfActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}