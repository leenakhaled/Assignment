package com.example.asalassignment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.asalassignment.users.presenter.UsersPresenter;
import com.example.asalassignment.users.presenter.UsersPresenterImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = initViewPager();
        initTabLayout(viewPager);

        UsersPresenter usersPresenter = new UsersPresenterImpl();
        usersPresenter.initPresenter();
    }

    private void initTabLayout(ViewPager viewPager) {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private ViewPager initViewPager() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        return viewPager;
    }
}
