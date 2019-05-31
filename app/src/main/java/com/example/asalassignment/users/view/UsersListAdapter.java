package com.example.asalassignment.users.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asalassignment.R;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.MyViewHolder> {
    private static final String TAG = UsersListAdapter.class.getSimpleName();
    private List<UsersData> usersData;

    UsersListAdapter(List<UsersData> usersData) {
        Log.d(TAG, "UsersListAdapter: " + usersData);
        this.usersData = usersData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.users_recycle_view, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        UsersData movie = usersData.get(i);
        Log.d(TAG, "USER NAME: " + movie.getUsername());
        viewHolder.usersName.setText(movie.getUsername());
        viewHolder.email.setText(movie.getEmail());

    }

    @Override
    public int getItemCount() {
        return usersData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView usersName, email;
        ImageView imageView;

        MyViewHolder(View view) {
            super(view);
            usersName = view.findViewById(R.id.user_name);
            imageView = view.findViewById(R.id.user_image);
            email = view.findViewById(R.id.email);
        }
    }
}