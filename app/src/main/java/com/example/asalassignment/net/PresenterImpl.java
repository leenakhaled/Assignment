package com.example.asalassignment.net;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.asalassignment.ViewInterface;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterImpl implements Presenter {
    private static final String TAG = PresenterImpl.class.getSimpleName();
    private PhotosUsersList mPhotosUsersList;
    private List<PhotosData> mPhotosDataResponse;
    private List<UsersData> mUserDataResponse;
    private ViewInterface mUsersView;

    @Override
    public void initPresenter(ViewInterface usersView) {
        mPhotosUsersList = new PhotosUsersList();
        mPhotosDataResponse = new ArrayList<>();
        mUserDataResponse = new ArrayList<>();
        mUsersView = usersView;
        getUserData();
        getPhotosData();


    }

    private void getPhotosData() {
        Call<List<PhotosData>> call = mPhotosUsersList.getPhotosList();
        call.enqueue(new Callback<List<PhotosData>>() {
            @Override
            public void onResponse(@NonNull Call<List<PhotosData>> call, @NonNull Response<List<PhotosData>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Log.v(TAG, "on response null");

                    } else {
                        mPhotosDataResponse = response.body();
                        mUsersView.hideProgress();
                        mUsersView.initTheTabsInViewPager(mPhotosDataResponse, mUserDataResponse);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PhotosData>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: Failed ");
                t.printStackTrace();

            }
        });

    }

    private void getUserData() {
        Call<List<UsersData>> call = mPhotosUsersList.getUsersList();
        call.enqueue(new Callback<List<UsersData>>() {
            @Override
            public void onResponse(@NonNull Call<List<UsersData>> call, @NonNull Response<List<UsersData>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Log.v(TAG, "on response null");

                    } else {
                        Log.v(TAG, "Success" + response.body());
                        mUserDataResponse = response.body();
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<UsersData>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: Failed ");
                t.printStackTrace();

            }
        });

    }
}
