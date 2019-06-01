package com.example.asalassignment.users.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.asalassignment.R;

@SuppressLint("Registered")
public class DetailsActivity extends AppCompatActivity {
    TextView userName, email, website, city, street, suite, zipCode,lng,lat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        userName = findViewById(R.id.user_name);
        email = findViewById(R.id.email);
        website = findViewById(R.id.website);
        street = findViewById(R.id.street);
        suite = findViewById(R.id.suite);
        city = findViewById(R.id.city);
      lng = findViewById(R.id.lng);
      lat = findViewById(R.id.lat);

        userName.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
       // zipCode.setText(getIntent().getStringExtra("zipCode"));
        website.setText(getIntent().getStringExtra("website"));
        city.setText(getIntent().getStringExtra("city"));
        street.setText(getIntent().getStringExtra("street"));
        suite.setText(getIntent().getStringExtra("suite"));
        lng.setText(getIntent().getStringExtra("lng"));
       lat.setText(getIntent().getStringExtra("lat"));


    }


}
