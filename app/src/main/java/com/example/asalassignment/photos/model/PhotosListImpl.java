package com.example.asalassignment.photos.model;

import com.example.asalassignment.photos.presenter.PhotosApi;
import com.example.asalassignment.users.model.UsersData;
import com.example.asalassignment.users.presenter.RetrofitClient;
import com.example.asalassignment.users.presenter.UsersApi;

import java.util.List;

import retrofit2.Call;


public class PhotosListImpl {

    private PhotosApi photosApi;

    public PhotosListImpl() {
        photosApi = RetrofitClient.getsInstance().getRetrofit().create(PhotosApi.class);
    }

    public Call <List<PhotosData>> getUsersList() {
        return photosApi.getPhotosList();
    }


}
