package com.example.asalassignment.photos.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.asalassignment.R;
import com.example.asalassignment.photos.CustomAdapter;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

public class PhotoFragment extends Fragment {

    private GridView simpleGrid;
    List<PhotosData> usersDataList;

    public PhotoFragment() {
    }

    @SuppressLint("ValidFragment")
    public PhotoFragment(List<PhotosData> usersData) {
        this.usersDataList=usersData;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        simpleGrid = rootView.findViewById(R.id.albums); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
      CustomAdapter customAdapter = new CustomAdapter(getActivity(), usersDataList);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
//        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//             id   // set an Intent to Another Activity
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("image", logos[position]); // put image data in Intent
//                startActivity(intent); // start Intent
//            }
//        });
        return rootView;
    }
}
