package com.example.asalassignment.photos.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.model.UsersListImpl;
import com.example.asalassignment.users.view.UsersView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosPresenterImpl implements PhotosPresenter {
    private static final String TAG = PhotosPresenterImpl.class.getSimpleName();
    private UsersListImpl usersList;
   // private UsersView usersView;

    @Override
    public void initPresenter(UsersView usersView) {
        usersList = new UsersListImpl();
     //   this.usersView = usersView;
        getUserData();
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
             //           usersView.initTheFragments(response.body());
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
