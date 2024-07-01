package com.example.citcollege.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.citcollege.ImageData;
import com.example.citcollege.R;
import com.squareup.picasso.Picasso;

import  android.content.Context;

import java.security.AccessControlContext;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter> {

Context context;
    List<ImageData> list;


    public GalleryAdapter(Context context, List<ImageData> list) {
        this.context = context;
        this.list = list;
    }

    public GalleryAdapter() {
    }

    @NonNull
    @Override
    public GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.gallery_images,parent,false);

        return new GalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdapter holder, int position) {
       ImageData item=list.get(position);
        try {
            Picasso.get().load(item.getImageUrl()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class GalleryViewAdapter extends RecyclerView.ViewHolder {

        ImageView imageView;

        public GalleryViewAdapter(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
        }
    }

}
