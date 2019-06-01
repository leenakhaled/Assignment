package com.example.asalassignment.photos.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import java.io.Serializable;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {
    private List<PhotosData> photosData;
    private Context context;

    PhotosAdapter(List<PhotosData> usersData) {
        this.photosData = usersData;
    }

    @NonNull
    @Override
    public PhotosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photos_recycle_view, viewGroup, false);
        this.context = viewGroup.getContext();
        return new PhotosAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.MyViewHolder viewHolder, int position) {
        final PhotosData photosData = this.photosData.get(position);

        viewHolder.photoTitle.setText(photosData.getTitle());
        Glide.with(context).load(photosData.getThumbnailUrl()).into(viewHolder.photo);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullPhotoActivity.class);
                intent.putExtra("imagefill", (Serializable) photosData.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photosData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView photoTitle;
        ImageView photo;

        MyViewHolder(View view) {
            super(view);
            photoTitle = view.findViewById(R.id.photo_title);
            photo = view.findViewById(R.id.photo);
        }
    }
}
