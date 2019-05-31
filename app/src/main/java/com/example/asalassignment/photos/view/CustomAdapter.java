package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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
    FragmentManager fragmentManager;

    public CustomAdapter(Context applicationContext, FragmentManager fragmentManager, List<PhotosData> logos) {
        this.photosData = logos;
        this.fragmentManager=fragmentManager;
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
        icon.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
//              Log.v("lorfr", " click");
//                PhotosFragment newGamefragment = new PhotosFragment();
//                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.albums_fragment, newGamefragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();


            }
        });
     //   icon.setImageResource();
        return view;
    }
}