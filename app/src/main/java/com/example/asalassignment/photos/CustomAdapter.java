package com.example.asalassignment.photos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<PhotosData> photosData;
    private LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, List<PhotosData> logos) {
        this.photosData = logos;

        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
       // return photosData.get().size();
        return 100;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.albuims, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.imageView); // get the reference of ImageView
       //icon.setImageResource(logos.get(i).getThumbnailUrl()); // set logo images
     //   icon.setImageResource();
        return view;
    }
}