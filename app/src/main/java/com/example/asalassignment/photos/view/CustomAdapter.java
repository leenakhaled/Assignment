package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.view.DetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<PhotosData> photosData;
    private List<PhotosData> photosDataFilterd;

    private LayoutInflater inflter;
    FragmentManager fragmentManager;

    public CustomAdapter(Context applicationContext, FragmentManager fragmentManager, List<PhotosData> logos) {
        this.photosData = logos;
        photosDataFilterd = new ArrayList<>();
        this.fragmentManager = fragmentManager;
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
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.albuims, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.imageView); // get the reference of ImageView
        //icon.setImageResource(logos.get(i).getThumbnailUrl()); // set logo images
//        Glide.with(viewGroup.getContext())
//                .load(photosData.get(0)
//                .into(icon);
        icon.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                getAllImagesInAlbum(i + 1);

//              Log.v("lorfr", " click");
                Intent intent = new Intent(viewGroup.getContext(), PhotosActivity.class);
                //intent.putExtra("image", logos[position]); // put image data in Intent
                // intent.putExtra("photos", photosDataFilterd); // put image data in Intent
                // intent.putParcelableArrayListExtra("data",(ArrayList) dataList);
                intent.putExtra("photos", (Serializable) photosDataFilterd);
              //  intent.putExtra("", photosDataFilterd)
                viewGroup.getContext().startActivity(intent); // start Intent
                Log.d("click******************", "onClick: " + i);

            }
        });
        //   icon.setImageResource();
        return view;
    }

    private void getAllImagesInAlbum(int i) {

        for (PhotosData item : photosData) {
            if (item.getAlbumId() == i) {
                photosDataFilterd.add(item);
            }
        }
    }
}