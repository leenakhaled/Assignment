package com.example.asalassignment.net;

import com.example.asalassignment.photos.model.PhotosData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotosApi {

    @GET("/photos")
    Call<List<PhotosData>> getPhotosList();

}
