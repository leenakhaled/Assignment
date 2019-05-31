package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;

import java.util.List;

public class AlbumFragment extends Fragment {

    private GridView simpleGrid;
    List<PhotosData> usersDataList;

    public AlbumFragment() {
    }

    @SuppressLint("ValidFragment")
    public AlbumFragment(List<PhotosData> usersData) {
        this.usersDataList=usersData;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        simpleGrid = rootView.findViewById(R.id.albums); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
      CustomAdapter customAdapter = new CustomAdapter(getActivity(),getFragmentManager(), usersDataList);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView

        return rootView;
    }
}
