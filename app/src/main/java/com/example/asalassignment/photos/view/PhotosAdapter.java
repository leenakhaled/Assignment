package com.example.asalassignment.photos.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.view.DetailsActivity;

import java.io.Serializable;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {
    private static final String TAG = com.example.asalassignment.users.view.UsersListAdapter.class.getSimpleName();
    private List<PhotosData> usersData;

    Context context;

    PhotosAdapter(List<PhotosData> usersData) {
        Log.d(TAG, "UsersListAdapter: " + usersData);
        this.usersData = usersData;
    }

    @NonNull
    @Override
    public PhotosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photos_item, viewGroup, false);
        this.context=viewGroup.getContext();
        return new PhotosAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.MyViewHolder viewHolder, int i) {
        final PhotosData movie = usersData.get(i);
        Log.d(TAG, "USER NAME: " + movie.getTitle());
        viewHolder.photoTitle.setText(movie.getTitle());
        Glide.with(context)
                .load(movie.getThumbnailUrl())
                .into(viewHolder.photoId);
      //  viewHolder.email.setText(movie.getEmail());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullPhotoActivity.class);
                intent.putExtra("imagefill", (Serializable)movie.getUrl()); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView photoTitle;
        ImageView photoId;

        MyViewHolder(View view) {
            super(view);
            photoTitle = view.findViewById(R.id.photo_title);
            photoId = view.findViewById(R.id.photo_id);
         //   email = viewInterface.findViewById(R.id.email);
        }
    }
}
