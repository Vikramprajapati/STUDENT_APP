package com.example.citcollege;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Attendance> attendanceList;
    private boolean isTakingAttendance;

    public AttendanceAdapter(Context context, ArrayList<Attendance> attendanceList, boolean isTakingAttendance) {
        this.context = context;
        this.attendanceList = attendanceList;
        this.isTakingAttendance = isTakingAttendance;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.attendance_table_row, parent, false);
            return new AttendanceViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Attendance attendance = attendanceList.get(position);
            ((AttendanceViewHolder) holder).bind(attendance);
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }
    public void setTakingAttendance(boolean takingAttendance) {
        isTakingAttendance = takingAttendance;
        notifyDataSetChanged(); // Refresh the RecyclerView
    }

    public static class AttendanceViewHolder extends RecyclerView.ViewHolder {

        TextView textViewRollNo;
        TextView textViewName;
//        TextView textViewDate;
        TextView textViewSubject;
        TextView textViewStatus;



        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRollNo = itemView.findViewById(R.id.textViewRollNo);
            textViewName = itemView.findViewById(R.id.textViewName);
//            textViewDate = itemView.findViewById(R.id.textViewDate);
//            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
        }

            public void bind (Attendance attendance){
                textViewRollNo.setText(attendance.getRollNo());
                textViewName.setText(attendance.getName());
//                textViewDate.setText(attendance.getDate());
//                textViewSubject.setText(attendance.getSubject());
                textViewStatus.setText(attendance.getStatus());
            }
        }


}

