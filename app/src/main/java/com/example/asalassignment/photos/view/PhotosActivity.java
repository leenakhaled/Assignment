package com.example.asalassignment.photos.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.asalassignment.R;
import com.example.asalassignment.photos.model.PhotosData;
import java.util.List;

public class PhotosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_photos);
        RecyclerView recyclerView = findViewById(R.id.photos_recycle_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            PhotosAdapter usersListAdapter = new PhotosAdapter((List<PhotosData>) getIntent().getExtras().getSerializable("photos"));
            recyclerView.setAdapter(usersListAdapter);
        }


    }
}
