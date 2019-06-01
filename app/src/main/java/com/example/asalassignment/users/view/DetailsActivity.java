package com.example.asalassignment.users.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.asalassignment.R;

@SuppressLint("Registered")
public class DetailsActivity extends AppCompatActivity {
    TextView name, email, website, city, street, suite, companyName, companyBs, CompanycatchPhrase, lng, lat;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        fillTheDataInTextView();

    }

    private void initView() {
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        website = findViewById(R.id.website);
        street = findViewById(R.id.street);
        suite = findViewById(R.id.suite);
        city = findViewById(R.id.city);
        lng = findViewById(R.id.lng);
        lat = findViewById(R.id.lat);
        CompanycatchPhrase = findViewById(R.id.companyCathPhrase);
        companyBs = findViewById(R.id.companyBs);
        companyName = findViewById(R.id.companyName);
    }

    @SuppressLint("SetTextI18n")
    private void fillTheDataInTextView() {
        name.setText("" + getIntent().getStringExtra("name") + "(" + getIntent().getStringExtra("userName") + " )");
        email.setText(getIntent().getStringExtra("email"));
        website.setText(getIntent().getStringExtra("website"));
        city.setText(getIntent().getStringExtra("city"));
        street.setText(getIntent().getStringExtra("street"));
        suite.setText(getIntent().getStringExtra("suite"));
        lng.setText(getIntent().getStringExtra("lng"));
        lat.setText(getIntent().getStringExtra("lat"));
        companyName.setText(getIntent().getStringExtra("companyName"));
        companyBs.setText(getIntent().getStringExtra("companyBs"));
        CompanycatchPhrase.setText(getIntent().getStringExtra("companyCatchPhrase"));
    }


}
