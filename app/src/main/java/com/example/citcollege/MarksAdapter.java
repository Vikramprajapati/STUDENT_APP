package com.example.citcollege;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.citcollege.MarksData;

import java.util.ArrayList;

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.MyViewHolder> {
    Context context;
    ArrayList<MarksData> list;

    public MarksAdapter(Context context, ArrayList<MarksData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.marksitemlayout,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MarksData marksData=list.get(position);
        holder.title.setText(marksData.getMarksTitle());
        holder.year.setText(marksData.getMarksYear());
        holder.branch.setText(marksData.getMarksBranch());
        holder.sem.setText(marksData.getMarksSem());
        Glide.with(context)
                .load(marksData.getImageUrl())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(v -> {
            // Handle image click to view or download
            Intent intent = new Intent(context, MarksImageViewActivity.class);
            intent.putExtra("imageUrl", marksData.getImageUrl());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,year,branch,sem;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.marksTITLE);
            year=itemView.findViewById(R.id.yearTITLE);
            branch=itemView.findViewById(R.id.branchTITLE);
            sem=itemView.findViewById(R.id.semTITLE);
            imageView=itemView.findViewById(R.id.marksImageView);

        }

    }
}
