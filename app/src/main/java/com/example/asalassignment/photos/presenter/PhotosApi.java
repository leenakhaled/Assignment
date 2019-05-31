package com.example.asalassignment.photos.presenter;

import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotosApi {

    @GET("/photos")
    Call<List<PhotosData>> getPhotosList();

}
