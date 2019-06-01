package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends BaseAdapter {
    private List<PhotosData> photosDataResponse;
    private List<PhotosData> photosAfterFilterAccordingAlbum;
    private LayoutInflater layoutInflater;
    private int numberOfAlbum = 0;

    AlbumsAdapter(Context context, List<PhotosData> photosDataResponse) {
        this.photosDataResponse = photosDataResponse;
        photosAfterFilterAccordingAlbum = new ArrayList<>();
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return getNumberOfAlbums();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams", "SetTextI18n"})
    @Override
    public View getView(final int position, View view, final ViewGroup viewGroup) {
        final int positionPlusOne = position + 1;

        view = layoutInflater.inflate(R.layout.albuim_item, null);

        LinearLayout album = view.findViewById(R.id.album);
        TextView albumTitle = view.findViewById(R.id.album_title);
        albumTitle.setText("Album " + positionPlusOne);


        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllImagesInAlbum(positionPlusOne);
                Intent intent = new Intent(viewGroup.getContext(), PhotosActivity.class);
                intent.putExtra("photos", (Serializable) photosAfterFilterAccordingAlbum);
                viewGroup.getContext().startActivity(intent);

            }
        });

        return view;
    }

    private void getAllImagesInAlbum(int position) {

        for (PhotosData photosData : photosDataResponse) {
            if (photosData.getAlbumId() == position) {
                photosAfterFilterAccordingAlbum.add(photosData);
            }
        }
    }

    private int getNumberOfAlbums() {
        for (PhotosData photosData : photosDataResponse) {
            if (photosData.getAlbumId() >= numberOfAlbum) {
                numberOfAlbum = photosData.getAlbumId();
            }
        }
        return numberOfAlbum;
    }
}