package com.example.citcollege.ui.admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citcollege.FacultiesActivity;
import com.example.citcollege.GalleryActivity;
import com.example.citcollege.NoticeActivity;
import com.example.citcollege.PdfActivity;
import com.example.citcollege.R;




public class AdminFragment extends Fragment {


    CardView notice,gallery,faculties,pdf;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_admin, container, false);

        notice=view.findViewById(R.id.Notices);
        gallery=view.findViewById(R.id.Gallery);
        faculties=view.findViewById(R.id.faculty12);
        pdf=view.findViewById(R.id.pdf);



        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GalleryActivity.class);
                startActivity(intent);
            }
        });

        faculties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FacultiesActivity.class);
                startActivity(intent);
            }
        });

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PdfActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}