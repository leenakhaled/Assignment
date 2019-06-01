package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import java.util.List;

public class AlbumsFragment extends Fragment {

    List<PhotosData> mPhotosResponse;

    public AlbumsFragment() {
    }

    @SuppressLint("ValidFragment")
    public AlbumsFragment(List<PhotosData> photosResponse) {
        mPhotosResponse = photosResponse;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_albums, viewGroup, false);
        GridView albumGridView = view.findViewById(R.id.album);

        AlbumsAdapter albumsAdapter = new AlbumsAdapter(getActivity(), mPhotosResponse);
        albumGridView.setAdapter(albumsAdapter);

        return view;
    }
}
