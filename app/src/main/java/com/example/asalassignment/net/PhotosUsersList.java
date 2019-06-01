package com.example.asalassignment.net;

import com.example.asalassignment.photos.model.PhotosData;
import com.example.asalassignment.users.model.UsersData;
import java.util.List;
import retrofit2.Call;


class PhotosUsersList {
    private PhotosApi mPhotosApi;
    private UsersApi mUsersApi;

    PhotosUsersList() {
        mPhotosApi = RetrofitClient.getsInstance().getRetrofit().create(PhotosApi.class);
        mUsersApi = RetrofitClient.getsInstance().getRetrofit().create(UsersApi.class);

    }

    Call<List<PhotosData>> getPhotosList() {
        return mPhotosApi.getPhotosList();
    }


    Call<List<UsersData>> getUsersList() {
        return mUsersApi.getUsersList();
    }


}
