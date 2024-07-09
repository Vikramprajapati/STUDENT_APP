package com.example.citcollege;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.MarksViewAdapter> {
    private Context context;
    private ArrayList<MarksData> list;
    private static final String TAG = "MarksActivity";

    public MarksAdapter(Context context, ArrayList<MarksData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MarksViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.marks_item_layout, parent, false);
        return new MarksViewAdapter(view);
    }


    //get marks data from firebase
    @Override
    public void onBindViewHolder(@NonNull MarksViewAdapter holder, int position) {

        MarksData currentMarks = list.get(position);
        Log.d(TAG, "Branch: " + currentMarks.getBranch());
        Log.d(TAG, "Semester: " + currentMarks.getSemester());

        holder.marksTitle.setText(currentMarks.getTitle());
        holder.marksDate.setText(currentMarks.getDate());
        holder.marksTime.setText(currentMarks.getTime());
        holder.marksBranch.setText(currentMarks.getBranch());
        holder.marksSem.setText(currentMarks.getSemester());
        holder.marksYear.setText(currentMarks.getYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getUrl()));
                context.startActivity(intent);
            }
        });

// to download file
        holder.marksImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(list.get(position).getUrl());
                DownloadManager.Request request = new DownloadManager.Request(uri);

                String fileName = uri.getLastPathSegment();

                request.setTitle("Downloading File");
                request.setDescription("Downloading " + fileName);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

                downloadManager.enqueue(request);
            }
        });






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MarksViewAdapter extends RecyclerView.ViewHolder {


        TextView marksTitle, marksDate, marksTime, marksYear, marksBranch, marksSem;
        ImageView marksImage;


        public MarksViewAdapter(@NonNull View itemView) {
            super(itemView);

            marksTitle = itemView.findViewById(R.id.title);
            marksImage = itemView.findViewById(R.id.marksImage);
            marksTime = itemView.findViewById(R.id.marksTime);
            marksDate = itemView.findViewById(R.id.marksDate);
            marksBranch =itemView.findViewById(R.id.marksBranch);
            marksYear =itemView.findViewById(R.id.marksYear);
            marksSem =itemView.findViewById(R.id.marksSem);

        }
    }
}
