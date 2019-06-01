package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends BaseAdapter {
    private List<PhotosData> photosDataResponse;
    private List<PhotosData> photosAfterFilterAccordingAlbum;
    private LayoutInflater layoutInflater;

    AlbumsAdapter(Context context, List<PhotosData> photosDataResponse) {
        this.photosDataResponse = photosDataResponse;
        photosAfterFilterAccordingAlbum = new ArrayList<>();
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
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

        view = layoutInflater.inflate(R.layout.albuim_item, null);
        ImageView albumImage = view.findViewById(R.id.album_image);


        albumImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllImagesInAlbum(i + 1);

                Intent intent = new Intent(viewGroup.getContext(), PhotosActivity.class);
                intent.putExtra("photos", (Serializable) photosAfterFilterAccordingAlbum);
                viewGroup.getContext().startActivity(intent);


            }
        });

        return view;
    }

    private void getAllImagesInAlbum(int position) {

        for (PhotosData item : photosDataResponse) {
            if (item.getAlbumId() == position) {
                photosAfterFilterAccordingAlbum.add(item);
            }
        }
    }
}