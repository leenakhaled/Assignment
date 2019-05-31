package com.example.asalassignment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asalassignment.photos.PhotoFragment;
import com.example.asalassignment.users.view.UsersFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = {"Users", "Photos"};
    private static final int USER_TAB = 0;
    private static final int PHOTO_TAB = 1;
    private static final int NUMBERS_OF_TABS = 2;

    ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case USER_TAB:
                return new UsersFragment();
            case PHOTO_TAB:
                return new PhotoFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return NUMBERS_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}