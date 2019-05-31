package com.example.asalassignment.users.view;

import android.annotation.SuppressLint;
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
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

@SuppressLint("ValidFragment")
public class UsersFragment extends Fragment {
    List<UsersData> usersDataList;

    public UsersFragment() {

    }

    public UsersFragment(List<UsersData> body) {
        usersDataList = body;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users, container, false);

        inflater.inflate(R.layout.fragment_users, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.users_recycle_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        if (getContext() != null) {
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        }
        UsersListAdapter usersListAdapter = new UsersListAdapter(usersDataList);
        recyclerView.setAdapter(usersListAdapter);
        return rootView;
    }

}
