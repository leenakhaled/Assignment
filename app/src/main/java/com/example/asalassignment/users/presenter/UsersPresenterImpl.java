package com.example.asalassignment.users.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.asalassignment.MainActivity;
import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.photos.model.PhotosListImpl;
import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.model.UsersListImpl;
import com.example.asalassignment.users.view.UsersView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersPresenterImpl implements UsersPresenter {
    private static final String TAG = UsersPresenterImpl.class.getSimpleName();
    private UsersListImpl usersList;
    private PhotosListImpl photosList;
    private List<PhotosData> photosData;
    private List<UsersData> usersData;
    private UsersView usersView;

    @Override
    public void initPresenter(UsersView usersView) {
        usersList = new UsersListImpl();
        photosList = new PhotosListImpl();
        photosData = new ArrayList<>();
        usersData = new ArrayList<>();
        this.usersView = usersView;
        getUserData();
           getPhotosData();


    }

    private void getPhotosData() {
        Call<List<PhotosData>> call = photosList.getUsersList();
        call.enqueue(new Callback<List<PhotosData>>() {
            @Override
            public void onResponse(Call<List<PhotosData>> call, Response<List<PhotosData>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Log.v(TAG, "on response null");

                    } else {
                        photosData = response.body();
                        Log.v(TAG, "*******PHOTOS**************" + response.body());
                        usersView.hideProgress();
                        usersView.initTheFragments(photosData, usersData);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<PhotosData>> call, Throwable t) {
                Log.e(TAG, "onFailure: Failed ");
                t.printStackTrace();

            }
        });

    }

    private void getUserData() {
        Call<List<UsersData>> call = usersList.getUsersList();
        call.enqueue(new Callback<List<UsersData>>() {
            @Override
            public void onResponse(@NonNull Call<List<UsersData>> call, @NonNull Response<List<UsersData>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Log.v(TAG, "on response null");

                    } else {
                        Log.v(TAG, "Success" + response.body());
                        usersData = response.body();
                        // usersView.initTheFragments(photosData, response.body());

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
