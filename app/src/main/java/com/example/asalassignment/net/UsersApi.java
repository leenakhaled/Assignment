package com.example.asalassignment.net;

import com.example.asalassignment.users.model.UsersData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi {

    @GET("/users")
    Call<List<UsersData>> getUsersList();

}
