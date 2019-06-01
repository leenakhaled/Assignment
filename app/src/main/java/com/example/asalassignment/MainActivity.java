package com.example.asalassignment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.photos.view.AlbumFragment;
import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.net.Presenter;
import com.example.asalassignment.users.view.UsersFragment;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsersView {
    List<UsersData> userDataResponse; // To send it to users fragment
    private List<PhotosData> photosDataResponse;// To send it to photos fragment
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Presenter presenter = new PresenterImpl();
        presenter.initPresenter(this);

        initProgress();
    }

    private void initProgress() {
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setIndeterminate(true);
    }
    private ViewPager initViewPager() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new UsersFragment(userDataResponse), "Users");
        viewPagerAdapter.addFragment(new AlbumFragment(photosDataResponse), "Photos");
        viewPager.setAdapter(viewPagerAdapter);
        return viewPager;
    }

    private void initTabLayout(ViewPager viewPager) {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void initTheTabsInViewPager(List<PhotosData> photosData, List<UsersData> usersData) {
        this.userDataResponse = usersData;
        this.photosDataResponse =photosData;
        ViewPager viewPager = initViewPager();
        initTabLayout(viewPager);
    }

    @Override
    public void hideProgress() {
mProgressBar.setVisibility(View.GONE);
    }
}
