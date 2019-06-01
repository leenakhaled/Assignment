package com.example.asalassignment;

import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

public interface ViewInterface {
    void initTheTabsInViewPager(List<PhotosData> photosData, List<UsersData> body);
    void hideProgress();
}
