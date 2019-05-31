package com.example.asalassignment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.asalassignment.photos.PhotoFragment;
import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.presenter.UsersPresenter;
import com.example.asalassignment.users.presenter.UsersPresenterImpl;
import com.example.asalassignment.users.view.UsersFragment;
import com.example.asalassignment.users.view.UsersView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsersView {
    List<UsersData> usersData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsersPresenter usersPresenter = new UsersPresenterImpl();
        usersPresenter.initPresenter(this);


    }

    private void initTabLayout(ViewPager viewPager) {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private ViewPager initViewPager() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter mTabsPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mTabsPagerAdapter.addFragment(new UsersFragment(usersData), "Users");
        mTabsPagerAdapter.addFragment(new PhotoFragment(), "Photos");
        viewPager.setAdapter(mTabsPagerAdapter);
        return viewPager;
    }

    @Override
    public void initTheFragments(List<UsersData> usersData) {
        this.usersData = usersData;
        ViewPager viewPager = initViewPager();
        initTabLayout(viewPager);
    }
}
