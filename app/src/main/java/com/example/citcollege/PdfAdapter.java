package com.example.citcollege;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {

    Context context;
    List<PdfData> list;

    public PdfAdapter(Context context, List<PdfData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.pdf_item_layout,parent,false);
        return new PdfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, int position) {

        PdfData currentItem = list.get(position);

        holder.pdftitle.setText(currentItem.getpdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });

        //to download pdf

        holder.downloadPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PdfViewHolder extends RecyclerView.ViewHolder {

        TextView pdftitle;
        ImageView downloadPdf;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);

            pdftitle=itemView.findViewById(R.id.pdfTitle);
            downloadPdf=itemView.findViewById(R.id.downloadPDf);


        }
    }

}
