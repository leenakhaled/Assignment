package com.example.asalassignment.users.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.model.UsersListImpl;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersPresenterImpl implements UsersPresenter {
    private static final String TAG = UsersPresenterImpl.class.getSimpleName();
    private UsersListImpl usersList;

    @Override
    public void initPresenter() {
        usersList = new UsersListImpl();
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
                        Log.v(TAG, "Success");

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
