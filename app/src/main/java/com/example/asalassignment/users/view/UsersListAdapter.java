package com.example.asalassignment.users.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.asalassignment.R;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.MyViewHolder> {
    private List<UsersData> usersData;
    private Context context;

    UsersListAdapter(List<UsersData> usersData) {
        this.usersData = usersData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.users_recycle_view, viewGroup, false);
        this.context = viewGroup.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        UsersData usersData = this.usersData.get(i);
        viewHolder.usersName.setText(usersData.getName());
        viewHolder.email.setText(usersData.getEmail());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                fillTheDataInIntent(intent, i);
                context.startActivity(intent);
            }
        });
    }

    private void fillTheDataInIntent(Intent intent, @SuppressLint("RecyclerView") int i) {
        intent.putExtra("email", UsersListAdapter.this.usersData.get(i).getEmail());
        intent.putExtra("phone", UsersListAdapter.this.usersData.get(i).getPhone());
        intent.putExtra("name", UsersListAdapter.this.usersData.get(i).getName());
        intent.putExtra("userName", UsersListAdapter.this.usersData.get(i).getUsername());
        intent.putExtra("website", UsersListAdapter.this.usersData.get(i).getWebsite());
        intent.putExtra("city", UsersListAdapter.this.usersData.get(i).getAddress().getCity());
        intent.putExtra("street", UsersListAdapter.this.usersData.get(i).getAddress().getStreet());
        intent.putExtra("suite", UsersListAdapter.this.usersData.get(i).getAddress().getSuite());
        intent.putExtra("lat", UsersListAdapter.this.usersData.get(i).getAddress().getGeo().getLat());
        intent.putExtra("lng", UsersListAdapter.this.usersData.get(i).getAddress().getGeo().getLng());
        intent.putExtra("companyName", UsersListAdapter.this.usersData.get(i).getCompany().getName());
        intent.putExtra("companyCatchPhrase", UsersListAdapter.this.usersData.get(i).getCompany().getCatchPhrase());
        intent.putExtra("companyBs", UsersListAdapter.this.usersData.get(i).getCompany().getBs());
    }

    @Override
    public int getItemCount() {
        return usersData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView usersName, email;
        ImageView userImage;

        MyViewHolder(View view) {
            super(view);
            usersName = view.findViewById(R.id.user_name);
            userImage = view.findViewById(R.id.user_image);
            email = view.findViewById(R.id.email);
        }
    }
}
