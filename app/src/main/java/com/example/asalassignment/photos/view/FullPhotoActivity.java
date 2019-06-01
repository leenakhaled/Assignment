package com.example.asalassignment.photos.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asalassignment.R;

public class FullPhotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_photo);
        ImageView imageView=findViewById(R.id.imageView3);

        Glide.with(this)
                .load(getIntent().getExtras().getSerializable("imagefill"))
                .into(imageView);
   //     imageView.setImageResource( getIntent().getExtras().getString("image"));


    }
}
