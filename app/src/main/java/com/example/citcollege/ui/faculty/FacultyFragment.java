package com.example.citcollege.ui.faculty;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.citcollege.AssignmentActivity;
import com.example.citcollege.AttendanceActivity;
import com.example.citcollege.MarksActivity;
import com.example.citcollege.NoticeActivity;
import com.example.citcollege.R;
import com.example.citcollege.TimeTable;


public class FacultyFragment extends Fragment {

    CardView marks,attend,syllabus,assign,table;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        marks=view.findViewById(R.id.marks);
        syllabus=view.findViewById(R.id.syllabus);
        attend=view.findViewById(R.id.Attendance);
        assign=view.findViewById(R.id.Assignment);
        table=view.findViewById(R.id.timetable);

        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksActivity.class);
                startActivity(intent);
            }
        });

        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttendanceActivity.class);
                startActivity(intent);
            }
        });

        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AssignmentActivity.class);
                startActivity(intent);
            }
        });

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimeTable.class);
                startActivity(intent);
            }
        });


        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://btu.ac.in/home/SYLLABUS-FOR-UNDERGRADUATE-PROGRAMME2021-22146");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });



        return  view;
    }



}