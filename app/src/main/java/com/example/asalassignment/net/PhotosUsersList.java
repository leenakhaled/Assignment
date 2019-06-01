package com.example.asalassignment.net;

import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;
import java.util.List;
import retrofit2.Call;


class PhotosUsersList {
    private PhotosApi photosApi;
    private UsersApi usersApi;

    PhotosUsersList() {
        photosApi = RetrofitClient.getsInstance().getRetrofit().create(PhotosApi.class);
        usersApi = RetrofitClient.getsInstance().getRetrofit().create(UsersApi.class);

    }

    Call<List<PhotosData>> getPhotosList() {
        return photosApi.getPhotosList();
    }


    Call<List<UsersData>> getUsersList() {
        return usersApi.getUsersList();
    }


}