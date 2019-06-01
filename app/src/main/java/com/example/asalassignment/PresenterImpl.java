package com.example.asalassignment;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.asalassignment.presenter.PhotosUsersList;
import com.example.asalassignment.presenter.Presenter;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterImpl implements Presenter {
    private static final String TAG = PresenterImpl.class.getSimpleName();
    private PhotosUsersList photosUsersList;
    private List<PhotosData> photosDataResponse;
    private List<UsersData> userDataResponse;
    private UsersView usersView;

    @Override
    public void initPresenter(UsersView usersView) {
        photosUsersList = new PhotosUsersList();
        photosDataResponse = new ArrayList<>();
        userDataResponse = new ArrayList<>();
        this.usersView = usersView;
        getUserData();
        getPhotosData();


    }

    private void getPhotosData() {
        Call<List<PhotosData>> call = photosUsersList.getPhotosList();
        call.enqueue(new Callback<List<PhotosData>>() {
            @Override
            public void onResponse(@NonNull Call<List<PhotosData>> call, @NonNull Response<List<PhotosData>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Log.v(TAG, "on response null");

                    } else {
                        photosDataResponse = response.body();
                        usersView.hideProgress();
                        usersView.initTheTabsInViewPager(photosDataResponse, userDataResponse);

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
        Call<List<UsersData>> call = photosUsersList.getUsersList();
        call.enqueue(new Callback<List<UsersData>>() {
            @Override
            public void onResponse(@NonNull Call<List<UsersData>> call, @NonNull Response<List<UsersData>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Log.v(TAG, "on response null");

                    } else {
                        Log.v(TAG, "Success" + response.body());
                        userDataResponse = response.body();
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
