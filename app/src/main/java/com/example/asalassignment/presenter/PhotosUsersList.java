package com.example.asalassignment.presenter;

import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

import retrofit2.Call;


public class PhotosUsersList {

    private PhotosApi photosApi;
    private UsersApi usersApi;

    public PhotosUsersList() {
        photosApi = RetrofitClient.getsInstance().getRetrofit().create(PhotosApi.class);
        usersApi = RetrofitClient.getsInstance().getRetrofit().create(UsersApi.class);

    }

    public Call<List<PhotosData>> getPhotosList() {
        return photosApi.getPhotosList();
    }


    public Call<List<UsersData>> getUsersList() {
        return usersApi.getUsersList();
    }


}
