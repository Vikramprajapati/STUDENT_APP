package com.example.citcollege;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MarksImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_image_view);
        ImageView imageView = findViewById(R.id.imageView3);

        String imageUrl = getIntent().getStringExtra("imageUrl");
        if (imageUrl != null) {
            Glide.with(this)
                    .load(imageUrl)
                    .into(imageView);
        }

    }
}