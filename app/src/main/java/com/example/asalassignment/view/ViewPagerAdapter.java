package com.example.asalassignment.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asalassignment.photos.PhotoFragment;
import com.example.asalassignment.users.UsersFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = {"TAB 1","TAB 2","TAB 3"};

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new UsersFragment();
            case 1:
                return new PhotoFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }
}