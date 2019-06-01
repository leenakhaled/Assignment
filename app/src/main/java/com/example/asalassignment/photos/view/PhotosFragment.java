package com.example.asalassignment.photos.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asalassignment.R;
import com.example.asalassignment.users.view.UsersListAdapter;

public class PhotosFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //     inflater.inflate(R.layout.fragment_albums, container, false);

        return inflater.inflate(R.layout.photos_recycle_view, container, false);
    }
}
